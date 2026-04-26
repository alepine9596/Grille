import java.io.*;
import java.net.*;
import java.util.*;

public class Sudoku {

    private static final java.util.regex.Pattern ESPACES = java.util.regex.Pattern.compile("\\s+");
    // Exception personnalisée
    static class SudokuInvalideException extends Exception {
        public SudokuInvalideException(String message) {
            super(message);
        }
    }
    // Chargement des données 
    static int[][] chargerGrille(Reader reader, String source)
            throws IOException, SudokuInvalideException {

        int[][] grille = new int[9][9];

        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String ligne;
        while ((ligne = br.readLine()) != null) {
            sb.append(ligne).append(" ");
        }
        String[] tokens = ESPACES.split(sb.toString().trim());


        if (tokens.length == 0) {
            throw new SudokuInvalideException("Erreur : Fichier vide ou aucun triplet trouvé");
        }

        boolean suiteTriplet = tokens[0].length() == 3;
        int compte = 0;

        if (suiteTriplet) {
            // FORMAT COMPACT (xyz)
            for (String token : tokens) {
                if (token.length() != 3)
                    throw new SudokuInvalideException("Suite triplet invalide : " + token);

                int x = Character.getNumericValue(token.charAt(0));
                int y = Character.getNumericValue(token.charAt(1));
                int z = Character.getNumericValue(token.charAt(2));

                if (x < 0 || x > 8 || y < 0 || y > 8)
                    throw new SudokuInvalideException("Coordonnées hors limite dans : " + token);

                if (z < 1 || z > 9)
                    throw new SudokuInvalideException("Valeur hors limites dans : " + token);

                if (grille[x][y] != 0)
                    throw new SudokuInvalideException("Position (" + x + "," + y + ") déjà définie");

                grille[x][y] = z;
                compte++;
            }

        } else {
            // FORMAT SEPARE (x y z)
            if (tokens.length % 3 != 0)
                throw new SudokuInvalideException("Nombre de valeurs non multiple de 3");

            for (int i = 0; i < tokens.length; i += 3) {

                int x = Integer.parseInt(tokens[i]);
                int y = Integer.parseInt(tokens[i + 1]);
                int z = Integer.parseInt(tokens[i + 2]); // 

                if (x < 1 || x > 9 || y < 1 || y > 9)
                    throw new SudokuInvalideException("Coordonnées hors limite dans : " + x + " " + y);
                if (z < 1 || z > 9)
                    throw new SudokuInvalideException("Valeur hors limites : " + z);
                if (grille[x - 1][y - 1] != 0) 
                    throw new SudokuInvalideException("Position (" + x + "," + y + ") déjà définie");
                grille[x - 1][y - 1] = z;
                compte++;
            }
        }
        System.out.println("Format détecté : " + (suiteTriplet ? "triplet (xyz)" : "séparé (x y z)"));
        return grille;
    }
    // Chargement depuis un fichier
    static int[][] chargerFichier(String chemin)
            throws IOException, SudokuInvalideException {
        try (FileReader fr = new FileReader(chemin)) {
            return chargerGrille(fr, chemin);
        }
    }
    // Chargement depuis une URL
    static int[][] chargerURL(String urlStr)
            throws IOException, SudokuInvalideException {
        URL url = URI.create(urlStr).toURL();
        try (InputStreamReader isr = new InputStreamReader(url.openStream())) {
            return chargerGrille(isr, urlStr);
        }
    }
    // Chargement depuis stdin
    static int[][] chargerStdin()
            throws IOException, SudokuInvalideException {
        return chargerGrille(new InputStreamReader(System.in), "stdin");
    }

    // Validation de la grille 

    static void validationGrille(int[][] grille) throws SudokuInvalideException {
        // Cases vides
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grille[i][j] == 0)
                    throw new SudokuInvalideException("Case vide en (" + (i + 1) + "," + (j + 1) + ")");
        // Lignes
        for (int i = 0; i < 9; i++) {
            boolean[] vus = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int v = grille[i][j];
                if (vus[v])
                    throw new SudokuInvalideException("Doublon " + v + " dans la ligne " + (i + 1));
                vus[v] = true;
            }
        }
        // Colonnes
        for (int j = 0; j < 9; j++) {
            boolean[] vus = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int v = grille[i][j];
                if (vus[v])
                    throw new SudokuInvalideException("Doublon " + v + " dans la colonne " + (j + 1));
                vus[v] = true;
            }
        }
        // Sous-grilles 3×3
        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {
                boolean[] vus = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int v = grille[br * 3 + i][bc * 3 + j];
                        if (vus[v])
                            throw new SudokuInvalideException(
                                    "Doublon " + v + " dans la sous-grille (" + (br + 1) + "," + (bc + 1) + ")");
                        vus[v] = true;
                    }
                }
            }
        }
    }

    // Transposition de la grille

    static int[][] transposer(int[][] g) {
        int[][] t = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                t[i][j] = g[j][i];
        return t;
    }
    static boolean identiques(int[][] a, int[][] b) {
        for (int i = 0; i < 9; i++)
            if (!Arrays.equals(a[i], b[i])) return false; // <-- corrigé
        return true;
    }
    //Affichage de la grille
    static void afficherGrille(int[][] g, int format, String titre) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" " + titre);
        System.out.println("=".repeat(50));

        switch (format) {
            case 1 -> afficherTableau(g);
            case 2 -> afficherTriplets(g);
            case 3 -> afficherCompact(g);
            default -> afficherTableau(g);
        }
    }

    static void afficherTableau(int[][] g) {
        String sep = " +---------+---------+---------+ ";
        System.out.println(sep);
        for (int i = 0; i < 9; i++) { // <-- corrigé
            StringBuilder sb = new StringBuilder(" | ");
            for (int j = 0; j < 9; j++) {
                sb.append(g[i][j]);
                sb.append((j + 1) % 3 == 0 ? " | " : " ");
            }
            System.out.println(sb);
            if ((i + 1) % 3 == 0) System.out.println(sep);
        }
    }
    static void afficherTriplets(int[][] g) {
        System.out.println("Format triplets non compact (x y z) : ");
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                System.out.printf(" %d %d %d%n", i + 1, j + 1, g[i][j]);
    }
    static void afficherCompact(int[][] g) {
        System.out.println("Format compact (xyz) : ");
        for (int[] ligne : g) {
            for (int v : ligne)
                System.out.print(v + " ");
            System.out.println();
        }
    }

   // Sauvegarder la grille 

    static void sauvegarderGrille(int[][] g, String chemin) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(chemin))) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    pw.printf("%d %d %d%n", i + 1, j + 1, g[i][j]);
        }
        System.out.println("\nGrille sauvegardée dans : " + chemin);
    }
    // Interface utilisateur
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grille = null;
        String source = "";

        System.out.println("Grille de Sudoku");

        // Chargement de la grille 
        System.out.println("\n[ Chargement ]");
        System.out.println(" 1. Fichier");
        System.out.println(" 2. URL");
        System.out.println(" 3. Stdin");
        System.out.print("\nVotre choix : ");

        String choix = sc.nextLine().trim();

        try {
            switch (choix) {
                case "1" -> {
                    System.out.print("Chemin du fichier : ");
                    String chemin = sc.nextLine().trim();
                    grille = chargerFichier(chemin);
                    source = chemin;
                }
                case "2" -> {
                    System.out.print("URL : ");
                    String url = sc.nextLine().trim();
                    grille = chargerURL(url);
                    source = url;
                }
                case "3" -> {
                    System.out.println("Entrez les triplets puis CTRL + D :");
                    grille = chargerStdin();
                    source = "stdin";
                }
                default -> {
                    System.out.println("Choix invalide !");
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("\nErreur : " + e.getMessage());
            return;
        }

        System.out.println("Grille chargée depuis : " + source);

        // Validation de la grille
        System.out.println("\n[ VALIDATION ]");
        try {
            validationGrille(grille);
            System.out.println("Grille valide !");
        } catch (SudokuInvalideException e) {
            System.err.println("Grille invalide : " + e.getMessage());
            return;
        }

        // Format d'affichage 
        System.out.println("\n[ FORMAT D'AFFICHAGE ]");
        System.out.println(" 1. Tableau");
        System.out.println(" 2. Triplets non compact (x y z)");
        System.out.println(" 3. Triplet compact (xyz)");
        System.out.print("\nVotre choix : ");

        int format;
        try {
            format = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            format = 1;
        }

        afficherGrille(grille, format, "Grille originale");

        // Transposition de la grille
        int[][] t = transposer(grille);
        afficherGrille(t, format, "Grille transposée");

        System.out.println("\n[ ANALYSE ]");
        if (identiques(grille, t))
            System.out.println("La grille est symétrique !");
        else
            System.out.println("La grille est asymétrique !");

        // Sauvegarde de la grille transposée 
        System.out.print("\nVoulez-vous sauvegarder la grille transposée ? (O/N) ");
        String rep = sc.nextLine().trim().toLowerCase();

        if (rep.equals("o") || rep.equals("oui")) {
            System.out.print("Nom du fichier : ");
            String out = sc.nextLine().trim();
            try {
                sauvegarderGrille(t, out);
            } catch (IOException e) {
                System.err.println("Erreur de sauvegarde : " + e.getMessage());
            }
        }
        System.out.println("\nFin du programme !");
        sc.close();
    }
}