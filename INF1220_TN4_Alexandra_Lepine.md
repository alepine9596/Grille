## Travail noté 4 - INF 1220 
**Nom :** *Lépine*  
**Prénom :** *Alexandra*  
**Code permanent :** *LEPA18549607*  
**Date de remise :** 

### Problème

#### Analyse préliminaire 

Dans un jeu de Sudoku, il faut reconstruire une grille comprenant 9 rangées et 9 colonnes. 
Chaque rangée et colonne doit contenir tous les entiers de 1 à 9. 
Il faut créer un logiciel en java qui permet de charger des grilles de Sudoku à partir de fichier, de manipuler les grilles et reproduire de nouveau les grilles soit à l'écran ou dans des fichiers.

Les fichiers comportent une suite de triplet de chiffres séparerés par des espace, chaque triplet correspond à :

- x : numéro de la ligne

- y : numéro de la colonne

- z : valeur 

Le logiciel doit faire 3 opérations spécifiques : 

1. Charger un fichier qui contient dse données en suite de triplets de chiffres séparés par des espace.

Le fichier peut être récupéré en ligne, par l'ouverture d'un fichier sur notre disque ou par stdin.

Le code doit gérer les erreurs de lecture

2. Le  fichier correspond à un tableau de Sudoku valable avec les caractéristique suivantes :

un tableau 9 x 9 où chaque chiffre de 1 à 9 apparaît une seule fois par colonne et une par rangée. 

En cas d'erreur, le programme doit générer une exception

3. Le logiciel doit appliquer une transposition au tableau correspondant à un calcul de matrice transposée et afficher le résultat à l'écran

Il faut tester la solution avec plusieurs grille; en particulier une grille asymétrique, qui n'est pas indentique
à la transposée dans les tests. 

Il faut donner le résultat d'au moins 2 tests différents, au-delà du fichier partie1.txt. 

Il est possible d'offrir un choix à l'utilisateur pour l'affichage du résultat, il est possible d'offrir à l'utilisateur l'emplacement de l'enregistrement du fichier. 
Il est possible d'offrir à l'utilisateur comment il souhaite que les données s'affichent à l'écran. 

Il faut garder à l'esprit que ce travail requiert de lire un fichier, valider ses données selon des règles spécifiques et
afficher les résultat dans un autre format, il faut effectuer des entrées et des sorties, des chaînes de caractère et des structures de données en Java. 
Le code doit être lisible et compréhensible. 

