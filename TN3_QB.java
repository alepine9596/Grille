import java.util.Random;
public class TN3_QB{
    private int[][] grille = new int [9][9];
    private Random random = new Random ();

    public int [][] generer (){
        if (remplir (0,0)){
            return grille;
        }else{
            System.out.println("Impossible de générer la grille");
            return null;
        }
     }
     // Application des contraintes : Lignes, colonnes, blocs 3x3
     private boolean remplir (int ligne, int col){
        if (ligne ==9){
            return true;
        }
        // Calculer la prochaine case
        int nextLigne = (col == 8) ? ligne + 1 : ligne;
        int nextCol = (col + 1) % 9;
        // Création d'un tableau avec des valeurs de 1 à 9 en ordre aléatoire
        int[] chiffres = ordreAleatoire ();

        for (int nbEssai : chiffres) {
            if (isValid (ligne, col, nbEssai)){
                grille [ligne][col] = nbEssai;
                // Récursivité de la prochaine case 
                if (remplir(nextLigne, nextCol)){
                    return true;
                }
                // Réinitisalition, nbEssai ne mèene pas à une solution
                grille[ligne][col] =0;
            }
        }
        return false;
     }
     // Génération de l'ordre aléatoire avec nextInt(bound)
     private int [] ordreAleatoire(){
        int[] tab = {1,2,3,4,5,6,7,8,9};

        for (int i =0; i < 9; i++){
            int j = random.nextInt(9);
            int temp = tab [i];
            tab[i] = tab[j];
            tab[j] = temp;
        }
        return tab;
     }
     //Vérifier que les conditions suivantes soient respectés :
     //Un chiffre n'apparait pas à la même ligne
     //Un chiffre n'apparait pas à la même colonne
     //Un chiffre n'apparait pas dans le même bloc 3x3 

     private boolean isValid(int ligne, int col, int valeurs){
        // vérification de la ligne
        for (int k = 0; k < 9; k++){
            if (grille[ligne][k] == valeurs) return false;
        }
        // véfication de la colonne
        for (int k = 0; k < 9; k++) {
            if (grille[k][col]== valeurs) return false;
        }
        // Vérification du bloc 3x3 
        int blocLigne = (ligne / 3) * 3;
        int blocCol = (col / 3) * 3;

        for (int i = blocLigne; i < blocLigne + 3; i++){
            for (int j = blocCol; j < blocCol + 3; j++){
                if (grille[i][j] == valeurs) return false;
            }
        }
        return true;
     }
     // Affichage de la grille dans la console
     private void afficher (){
        System.out.println("Grille de Sudoku Générée :");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0){
                //Afficher la séparation de la grille
                System.out.println("------+-------+--------");
            }
            for (int j = 0; j < 9; j++){
                if (j % 3 == 0 && j != 0){
                    System.out.print(" | ");
                }
                System.out.print(grille [i][j] + " ");
            }
            System.out.println();
        }
     }
     // Tester la grille
     public static void main(String[] args) {
         long debut = System.currentTimeMillis();

         TN3_QB generateur = new TN3_QB();
         int[][] Sudoku = generateur.generer();
         
         if (Sudoku != null){
            generateur.afficher();
            long temps = System.currentTimeMillis() - debut;
            System.out.println("\n Temps de génération :" + temps + "ms");
         }
     }
    }