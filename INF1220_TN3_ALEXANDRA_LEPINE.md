## Travail noté 3 - INF 1220
**Nom :** *Lépine*  
**Prénom :** *Alexandra*  
**Code permanent :** *LEPA18549607*  
**Date de remise :** 4 avril 2026 

--- 
### Question #1

#### Analyse préliminaire 

Je dois écrire un programme Java qui calcul la somme des enombres de 1 jusqu'à 10 000, en incluant 1 et 10 000.
Toutefois, je dois omettre les nombres qui sont divisible par 3
et je dois omettre les nombres dont le chiffre de la centaine
est 2 ou 3. Puis, je dois expliquer ma solution. 

Par la suite, je dois justifier tous les qualifiant utilisée.
Si j'utilise le mot-clé "static" je dois le justifier. 

À la fin, je dois répondre à la question :
"Est-ce que la somme peut être représentée par une variable de type INT ?" 

#### Code source
[Lien du code source](https://lemire.github.io/inf1220-hugo/docs/environnement/?javacode=eyJmaWxlcyI6W3sibmFtZSI6IlROM19RMSIsInR5cGUiOiJqYXZhIiwiY29udGVudCI6InB1YmxpYyBjbGFzcyBUTjNfUTEge1xuICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluIChTdHJpbmcgW10gYXJncykge1xuICAgICAgICBsb25nIHNvbW1lID0gMDtcbiAgICAgICAgZm9yIChpbnQgaSA9IDE7IGkgPD0gMTAwMDA7IGkrKykge1xuICAgICAgICAgICAgLy8gQ29uZGl0aW9uIDEgOiBpZ25vcmVyIGxlcyBub21icmVzIGRpdmlzaWJsZSBwYXIgM1xuICAgICAgICAgICAgaWYgKGkgJSAzID09IDApIHtcbiAgICAgICAgICAgICAgICBjb250aW51ZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGludCBjZW50YWluZSA9IChpIC8gMTAwKSAlIDEwO1xuICAgICAgICAgICAgLy8gY29uZGl0aW9uIDIgOiBpZ25vcmVyIGxlcyBub21icmVzIGRvbnQgbGVzIGNoaWZmcmVzIGRlIGxhIGNlbnRhaW5lIGVzdCAyIG91IDMgXG4gICAgICAgICAgICBpZiAoY2VudGFpbmUgPT0gMiB8fCBjZW50YWluZSA9PSAzKSB7XG4gICAgICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBzb21tZSArPSBpO1xuICAgICAgICB9XG4gICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbihcIkxhIHNvbW1lIGVzdCBcIiArIHNvbW1lKTtcbiAgICB9XG59In1dfQ%3D%3D)

```java 

public class TN3_Q1 {
    public static void main (String [] args) {
        long somme = 0;
        for (int i = 1; i <= 10000; i++) {
            // Condition 1 : ignorer les nombres divisible par 3
            if (i % 3 == 0) {
                continue;
            }
            int centaine = (i / 100) % 10;
            // condition 2 : ignorer les nombres dont les chiffres de la centaine est 2 ou 3 
            if (centaine == 2 || centaine == 3) {
                continue;
            }
            somme += i;
        }
        System.out.println("La somme est " + somme);
    }
}

```

#### Sortie du programme

```
La somme est 26937467
````

#### Description du programme 

J'ai utilisé le mot-clé public, car ceci rend la classe et la méthode accessible à l'extérieur du paquet. Java a besoin que main soit public pour effectuer le démarrage. 

J'ai utilisé le mot-clé Static, car ceci signifie que la méthode appartient à la classe elle-même et non à un objet, ceci est indispensable pour main. 

J'ai utilisé void, car la méthode ne retourne à aucune valeur. Le résultat de la somme est affiché dans la console et non renvoyé à une source externe. 

J'ai utilisé le type long, car la somme calculée dépasse la capacité du type int, qui est entre -2<sup>31</sup> et 2<sup>31 -1</sup>, long a une capacité entre -2<sup>63</sup> et 2<sup>63-1</sup>, donc par sécurité advenant plusieurs additions j'ai choisi de débuté par long, car long peut contenir des nombres beaucoup plus grands. 

Pour la condition en lien avec l'omission du chiffre de la centaine 2 ou 3, j'ai utilisé le type int, car celle-ci représente un chiffre entre 0 et 9. Comme il s'agit d'un entier sans décimale et de petite taille, le type int à la capacité d'effectuer la condition.
De plus, les opérations arithmétiques / et % retournent des valeurs de type entier lorsqu'elles sont appliquées a des entiers. 

Pour revenir à la question "Est-ce que la somme peut être représentée par une variable de type int ?" 
La réponse à cette question est oui, mais ce n'est pas recommandé. La somme calculée est 26937267. Le type int peut contenir jusqu'à 2<sup>31-1</sup>, techniquement cette valeur convient au type int. Par contre, les sommes intermédiaires pendant le calcul pourraient dépasser cette limite si nous effectuons des modifications des conditions. Pour respecter les bonnes pratiques et éviter des problèmes, on utilise long qui a une valeur allant jusqu'à 2<sup>63-1</sup>. 


### Question #2

#### Analyse préliminaire

Je dois écrire un programme Java qui affiche à l'écran toutes les chaînes de 4 caractères en respectant les critères suivants : 

- Chaînes de 4 caractères en ordre lexicographique (ordre du dictionnaire)
- Doit afficher une chaîne de 4 caractères par ligne
- Seuls les caractères suivants sont permis : a,b,c,d
- Il est possible de réutiliser plus d'une fois un même caractère dans une chaîne
- Le caractère "b" doit toujours être immédiatement suivi du caractère "a"
- Une même chaîne ne peut comporter à la fois le caractère "d" et le caractère "a"
- Une fois terminer le programme affiche a l'écran le nombre de chaînes affichées
- Le programme ne reçoit aucune entrée 
- Le code ne doit pas comprendre les chaînes de caractères pré-calculés : il doit les générer lors de l'exécution
- Le programme ne doit pas contenir plus de 200 courtes lignes de code 
- Le résultat du programme doit être le même à chaque exécution

#### Code source
[Lien du code source](https://lemire.github.io/inf1220-hugo/docs/environnement/?javacode=eyJmaWxlcyI6W3sibmFtZSI6IlROM19RMiIsInR5cGUiOiJqYXZhIiwiY29udGVudCI6InB1YmxpYyBjbGFzcyBUTjNfUTJ7XG4gICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluKFN0cmluZ1tdIGFyZ3MpIHtcbiAgICAgICAgaW50IGNvdW50ID0gMDtcbiAgICAgICAgLy9Hw6luw6lyZXIgdG91dGVzIGxlcyBjaGHDrm5lcyBkZSA0IGNhcmFjdMOocmVzXG4gICAgICAgY2hhciBbXSBsZXR0ZXJzID0geydhJywgJ2InLCAnYycsICdkJ307XG4gICAgICAgIGNoYXIgW10gcyA9IG5ldyBjaGFyIFs0XTtcbiAgICAgICAgXG4gICAgICAgIGZvciAoY2hhciBjMSA6IGxldHRlcnMpIHtcbiAgICAgICAgICAgIHNbMF0gPSBjMTtcbiAgICAgICAgICAgIGZvciAoY2hhciBjMiA6IGxldHRlcnMpIHtcbiAgICAgICAgICAgICAgICBzWzFdID0gYzI7XG4gICAgICAgICAgICAgICAgZm9yIChjaGFyIGMzIDogbGV0dGVycykge1xuICAgICAgICAgICAgICAgICAgICBzWzJdID0gYzM7XG4gICAgICAgICAgICAgICAgICAgIGZvciAoY2hhciBjNCA6IGxldHRlcnMpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHNbM10gPSBjNDtcbiAgICAgICAgICAgICAgICAgICAgICAgIFxuICAgICAgICAgICAgICAgICAgICAgICAgaWYgKGlzVmFsaWQocykpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBTeXN0ZW0ub3V0LnByaW50bG4gKG5ldyBTdHJpbmcgKHMpKTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBjb3VudCsrO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgU3lzdGVtLm91dC5wcmludGxuKGNvdW50KTtcblx0fVxuXG5wcml2YXRlIHN0YXRpYyBib29sZWFuIGlzVmFsaWQoY2hhcltdIHMpIHtcbiAgICAvLyBDb25kaXRpb24gOiB1bmUgY2hhw65uZSBuZSBwZXV0IGNvbXBvcnRlciBsZSBjYXJhY3TDqHJlIFwiZFwiIGV0IGxlIGNhcmFjdMOocmUgXCJhXCJcbiAgICBib29sZWFuIGhhc0EgPSBmYWxzZTtcbiAgICBib29sZWFuIGhhc0QgPSBmYWxzZTtcbiAgICBcbiAgICBmb3IgKGludCBpID0gMDsgaTwgcy5sZW5ndGg7IGkrKykge1xuICAgICAgICBpZiAoc1tpXSA9PSAnYScpIGhhc0EgPSB0cnVlO1xuICAgICAgICBpZiAoc1tpXSA9PSAnZCcpIGhhc0QgPSB0cnVlOyBcbiAgICAgICAgLy8gQ29uZGl0aW9uIDogbGUgY2FyYWN0w6hyZSBcImJcIiBkb2l0IMOqdHJlIHN1aXZpIGltbcOpZGlhdGVtZW50IGR1IGNhcmFjdMOocmUgXCJhXCJcbiAgICAgICAgaWYgKGk8cy5sZW5ndGggLSAxICYmIHNbaV0gPT0gJ2InICYmIHNbaSArIDFdICE9ICdhJyl7XG4gICAgICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgICAgIH1cblx0fVxuICAgICAgICAgICAgcmV0dXJuICEgKGhhc0EgJiYgaGFzRCk7XG5cdH1cbn1cbiAgICAgICAgICAgICJ9XX0%3D)

```java

public class TN3_Q2{
     public static void main(String[] args) {
        int count = 0;
        //Générer toutes les chaînes de 4 caractères
       char [] letters = {'a', 'b', 'c', 'd'};
        char [] s = new char [4];
        
        for (char c1 : letters) {
            s[0] = c1;
            for (char c2 : letters) {
                s[1] = c2;
                for (char c3 : letters) {
                    s[2] = c3;
                    for (char c4 : letters) {
                        s[3] = c4;
                        
                        if (isValid(s)) {
                            System.out.println (new String (s));
                            count++;
                        }
                    }
                }
            }
        }
    System.out.println(count);
	}

private static boolean isValid(char[] s) {
    // Condition : une chaîne ne peut comporter le caractère "d" et le caractère "a"
    boolean hasA = false;
    boolean hasD = false;
    
    for (int i = 0; i< s.length; i++) {
        if (s[i] == 'a') hasA = true;
        if (s[i] == 'd') hasD = true; 
        // Condition : le caractère "b" doit être suivi immédiatement du caractère "a"
        if (i<s.length - 1 && s[i] == 'b' && s[i + 1] != 'a'){
            return false;
        }
	}
            return ! (hasA && hasD);
	}
}

````

#### Sortie du programme

```
aaaa
aaab
aaac
aaba
aaca
aacb
aacc
abaa
abab
abac
acaa
acab
acac
acba
acca
accb
accc
baaa
baab
baac
baba
baca
bacb
bacc
caaa
caab
caac
caba
caca
cacb
cacc
cbaa
cbab
cbac
ccaa
ccab
ccac
ccba
ccca
cccb
cccc
cccd
ccdb
ccdc
ccdd
cdcb
cdcc
cdcd
cddb
cddc
cddd
dccb
dccc
dccd
dcdb
dcdc
dcdd
ddcb
ddcc
ddcd
dddb
dddc
dddd
63
```
### Description du programme 

J'ai utilisé le mot-clé public, car ceci rend la classe et la méthode accessible à l'extérieur du paquet. Java a besoin que main soit public pour effectuer le démarrage. 

J'ai utilisé le mot-clé Static, car ceci signifie que la méthode appartient à la classe elle-même et non à un objet. Main doit petre static car la JVM l'appelle sans créer d'instance de la classe. De plus, isValid doit être static car elle est appelée dans main sans créer d'objets. 

J'ai utilisé int pour count, car le type int contient des données en Java qui stocke des nombres entiers et sans décimales. Il permet de compter les chaînes, les chaînes contiennent seulement des entiers. 

J'ai utilisé le mot-clé private, car celui-ci limite l'accès à la méthode à l'intérieur de la classe unique. Elle n'a pas besoin d'être accessible depuis les autres classes. 

J'ai utilisé void, car la méthode ne retourne à aucune valeur. Le résultat de la somme est affiché dans la console et non renvoyé à une source externe. 

J'ai utilisé boolean, car la méthode retourne à true or false, ce qui était essentiel pour l'application de la condition "une chaîne ne peut comporter à la fois le caractère 'd' et le caractère 'a'. 

J'ai utilisé l'opérateur de comparaison == (Égal à) pour comparer si b = a dans la chaîne de caractères. L'opérateur retourne également a true or false. 

J'ai utilisé l'opérateur logique && (Et logique), qui signifie "et" en logique booléenne.
L'opérateur logique permet de combiner plusieurs combinaisons et retourne à true si et seulement si toutes les conditions sont vraies. 

### Question-boni

#### Analyse préliminaire

Je dois écrire une classe Java qui génère automatiquement un tableau de Sudoku.
La grille de Sudoku doit respecter les critères suivants : 

- Possible d'utiliser la méthode Random.nextInt
- La grille doit avoir le type int [] []
- Le tableau doit contenir 9 rangées et 9 colonnes
- Chaque colonne doit contenir les chiffres de 1 à 9, sans répétition
- Chaque rangée doit contenir les chiffres de 1 à 9, sans répétition
- Il n'est pas requis que le code soit rapide mais doit être complété dans un délai raisonnable, max 2 minutes 

#### Code source

[Lien vers le code de la grille Sudoku](https://lemire.github.io/inf1220-hugo/docs/environnement/?javacode=eyJmaWxlcyI6W3sibmFtZSI6IlROM19RQi5qYXZhIiwidHlwZSI6ImphdmEiLCJjb250ZW50IjoiaW1wb3J0IGphdmEudXRpbC5SYW5kb207XG5wdWJsaWMgY2xhc3MgVE4zX1FCe1xuICAgIHByaXZhdGUgaW50W11bXSBncmlsbGUgPSBuZXcgaW50IFs5XVs5XTtcbiAgICBwcml2YXRlIFJhbmRvbSByYW5kb20gPSBuZXcgUmFuZG9tICgpO1xuXG4gICAgcHVibGljIGludCBbXVtdIGdlbmVyZXIgKCl7XG4gICAgICAgIGlmIChyZW1wbGlyICgwLDApKXtcbiAgICAgICAgICAgIHJldHVybiBncmlsbGU7XG4gICAgICAgIH1lbHNle1xuICAgICAgICAgICAgU3lzdGVtLm91dC5wcmludGxuKFwiSW1wb3NzaWJsZSBkZSBnw6luw6lyZXIgbGEgZ3JpbGxlXCIpO1xuICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgIH1cbiAgICAgfVxuICAgICAvLyBBcHBsaWNhdGlvbiBkZXMgY29udHJhaW50ZXMgOiBMaWduZXMsIGNvbG9ubmVzLCBibG9jcyAzeDNcbiAgICAgcHJpdmF0ZSBib29sZWFuIHJlbXBsaXIgKGludCBsaWduZSwgaW50IGNvbCl7XG4gICAgICAgIGlmIChsaWduZSA9PTkpe1xuICAgICAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICAgIH1cbiAgICAgICAgLy8gQ2FsY3VsZXIgbGEgcHJvY2hhaW5lIGNhc2VcbiAgICAgICAgaW50IG5leHRMaWduZSA9IChjb2wgPT0gOCkgPyBsaWduZSArIDEgOiBsaWduZTtcbiAgICAgICAgaW50IG5leHRDb2wgPSAoY29sICsgMSkgJSA5O1xuICAgICAgICAvLyBDcsOpYXRpb24gZCd1biB0YWJsZWF1IGF2ZWMgZGVzIHZhbGV1cnMgZGUgMSDDoCA5IGVuIG9yZHJlIGFsw6lhdG9pcmVcbiAgICAgICAgaW50W10gY2hpZmZyZXMgPSBvcmRyZUFsZWF0b2lyZSAoKTtcblxuICAgICAgICBmb3IgKGludCBuYkVzc2FpIDogY2hpZmZyZXMpIHtcbiAgICAgICAgICAgIGlmIChpc1ZhbGlkIChsaWduZSwgY29sLCBuYkVzc2FpKSl7XG4gICAgICAgICAgICAgICAgZ3JpbGxlIFtsaWduZV1bY29sXSA9IG5iRXNzYWk7XG4gICAgICAgICAgICAgICAgLy8gUsOpY3Vyc2l2aXTDqSBkZSBsYSBwcm9jaGFpbmUgY2FzZSBcbiAgICAgICAgICAgICAgICBpZiAocmVtcGxpcihuZXh0TGlnbmUsIG5leHRDb2wpKXtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIC8vIFLDqWluaXRpc2FsaXRpb24sIG5iRXNzYWkgbmUgbcOoZW5lIHBhcyDDoCB1bmUgc29sdXRpb25cbiAgICAgICAgICAgICAgICBncmlsbGVbbGlnbmVdW2NvbF0gPTA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIGZhbHNlO1xuICAgICB9XG4gICAgIC8vIEfDqW7DqXJhdGlvbiBkZSBsJ29yZHJlIGFsw6lhdG9pcmUgYXZlYyBuZXh0SW50KGJvdW5kKVxuICAgICBwcml2YXRlIGludCBbXSBvcmRyZUFsZWF0b2lyZSgpe1xuICAgICAgICBpbnRbXSB0YWIgPSB7MSwyLDMsNCw1LDYsNyw4LDl9O1xuXG4gICAgICAgIGZvciAoaW50IGkgPTA7IGkgPCA5OyBpKyspe1xuICAgICAgICAgICAgaW50IGogPSByYW5kb20ubmV4dEludCg5KTtcbiAgICAgICAgICAgIGludCB0ZW1wID0gdGFiIFtpXTtcbiAgICAgICAgICAgIHRhYltpXSA9IHRhYltqXTtcbiAgICAgICAgICAgIHRhYltqXSA9IHRlbXA7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIHRhYjtcbiAgICAgfVxuICAgICAvL1bDqXJpZmllciBxdWUgbGVzIGNvbmRpdGlvbnMgc3VpdmFudGVzIHNvaWVudCByZXNwZWN0w6lzIDpcbiAgICAgLy9VbiBjaGlmZnJlIG4nYXBwYXJhaXQgcGFzIMOgIGxhIG3Dqm1lIGxpZ25lXG4gICAgIC8vVW4gY2hpZmZyZSBuJ2FwcGFyYWl0IHBhcyDDoCBsYSBtw6ptZSBjb2xvbm5lXG4gICAgIC8vVW4gY2hpZmZyZSBuJ2FwcGFyYWl0IHBhcyBkYW5zIGxlIG3Dqm1lIGJsb2MgM3gzIFxuXG4gICAgIHByaXZhdGUgYm9vbGVhbiBpc1ZhbGlkKGludCBsaWduZSwgaW50IGNvbCwgaW50IHZhbGV1cnMpe1xuICAgICAgICAvLyB2w6lyaWZpY2F0aW9uIGRlIGxhIGxpZ25lXG4gICAgICAgIGZvciAoaW50IGsgPSAwOyBrIDwgOTsgaysrKXtcbiAgICAgICAgICAgIGlmIChncmlsbGVbbGlnbmVdW2tdID09IHZhbGV1cnMpIHJldHVybiBmYWxzZTtcbiAgICAgICAgfVxuICAgICAgICAvLyB2w6lmaWNhdGlvbiBkZSBsYSBjb2xvbm5lXG4gICAgICAgIGZvciAoaW50IGsgPSAwOyBrIDwgOTsgaysrKSB7XG4gICAgICAgICAgICBpZiAoZ3JpbGxlW2tdW2NvbF09PSB2YWxldXJzKSByZXR1cm4gZmFsc2U7XG4gICAgICAgIH1cbiAgICAgICAgLy8gVsOpcmlmaWNhdGlvbiBkdSBibG9jIDN4MyBcbiAgICAgICAgaW50IGJsb2NMaWduZSA9IChsaWduZSAvIDMpICogMztcbiAgICAgICAgaW50IGJsb2NDb2wgPSAoY29sIC8gMykgKiAzO1xuXG4gICAgICAgIGZvciAoaW50IGkgPSBibG9jTGlnbmU7IGkgPCBibG9jTGlnbmUgKyAzOyBpKyspe1xuICAgICAgICAgICAgZm9yIChpbnQgaiA9IGJsb2NDb2w7IGogPCBibG9jQ29sICsgMzsgaisrKXtcbiAgICAgICAgICAgICAgICBpZiAoZ3JpbGxlW2ldW2pdID09IHZhbGV1cnMpIHJldHVybiBmYWxzZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICAgfVxuICAgICAvLyBBZmZpY2hhZ2UgZGUgbGEgZ3JpbGxlIGRhbnMgbGEgY29uc29sZVxuICAgICBwcml2YXRlIHZvaWQgYWZmaWNoZXIgKCl7XG4gICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbihcIkdyaWxsZSBkZSBTdWRva3UgR8OpbsOpcsOpZSA6XCIpO1xuICAgICAgICBmb3IgKGludCBpID0gMDsgaSA8IDk7IGkrKykge1xuICAgICAgICAgICAgaWYgKGkgJSAzID09IDAgJiYgaSAhPSAwKXtcbiAgICAgICAgICAgICAgICAvL0FmZmljaGVyIGxhIHPDqXBhcmF0aW9uIGRlIGxhIGdyaWxsZVxuICAgICAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbihcIi0tLS0tLSstLS0tLS0tKy0tLS0tLS0tXCIpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZm9yIChpbnQgaiA9IDA7IGogPCA5OyBqKyspe1xuICAgICAgICAgICAgICAgIGlmIChqICUgMyA9PSAwICYmIGogIT0gMCl7XG4gICAgICAgICAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQoXCIgfCBcIik7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQoZ3JpbGxlIFtpXVtqXSArIFwiIFwiKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigpO1xuICAgICAgICB9XG4gICAgIH1cbiAgICAgLy8gVGVzdGVyIGxhIGdyaWxsZVxuICAgICBwdWJsaWMgc3RhdGljIHZvaWQgbWFpbihTdHJpbmdbXSBhcmdzKSB7XG4gICAgICAgICBsb25nIGRlYnV0ID0gU3lzdGVtLmN1cnJlbnRUaW1lTWlsbGlzKCk7XG5cbiAgICAgICAgIFROM19RQiBnZW5lcmF0ZXVyID0gbmV3IFROM19RQigpO1xuICAgICAgICAgaW50W11bXSBTdWRva3UgPSBnZW5lcmF0ZXVyLmdlbmVyZXIoKTtcbiAgICAgICAgIFxuICAgICAgICAgaWYgKFN1ZG9rdSAhPSBudWxsKXtcbiAgICAgICAgICAgIGdlbmVyYXRldXIuYWZmaWNoZXIoKTtcbiAgICAgICAgICAgIGxvbmcgdGVtcHMgPSBTeXN0ZW0uY3VycmVudFRpbWVNaWxsaXMoKSAtIGRlYnV0O1xuICAgICAgICAgICAgU3lzdGVtLm91dC5wcmludGxuKFwiXFxuIFRlbXBzIGRlIGfDqW7DqXJhdGlvbiA6XCIgKyB0ZW1wcyArIFwibXNcIik7XG4gICAgICAgICB9XG4gICAgIH1cbiAgICB9In1dfQ%3D%3D)

```java 
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

```
#### Sortie du programme 

Essai 1 : 
```
Grille de Sudoku Générée :
1 6 4  | 2 9 8  | 3 5 7 
5 3 8  | 1 7 6  | 9 4 2 
9 7 2  | 3 5 4  | 1 8 6 
------+-------+--------
2 9 6  | 7 8 1  | 5 3 4 
4 8 7  | 9 3 5  | 6 2 1 
3 1 5  | 6 4 2  | 8 7 9 
------+-------+--------
6 4 9  | 8 2 3  | 7 1 5 
8 2 1  | 5 6 7  | 4 9 3 
7 5 3  | 4 1 9  | 2 6 8 

 Temps de génération :1ms
 ```

Essai 2 : 
```
Grille de Sudoku Générée :
9 8 2  | 7 4 1  | 6 5 3 
3 7 4  | 2 5 6  | 8 9 1 
6 5 1  | 3 8 9  | 4 7 2 
------+-------+--------
8 2 3  | 1 9 7  | 5 4 6 
7 4 6  | 5 2 3  | 1 8 9 
5 1 9  | 8 6 4  | 2 3 7 
------+-------+--------
2 9 8  | 6 7 5  | 3 1 4 
4 3 5  | 9 1 2  | 7 6 8 
1 6 7  | 4 3 8  | 9 2 5 

 Temps de génération :3ms
 ```

 #### Description du programme

 J'ai utilisé private int[][] afin de créer la structure principale de mon code et ceci me permet de créer un tableau à deux dimensions de 9 x 9 cases, où chaque case stocker un entier. 

 Private Random random = new Random me permet de générer des nombres aléatoires pour générer à chaque fois une nouvelle grille de Sudoku. 

 La fonction générale est public int[][] generer () qui me permet de générer la grille, ceci est mon point d'entrée pour la création de ma grille de Sudoku. 

 J'ai utilisé private boolean remplir pour remplir la grille case par case et ceci permet au code d'arrêter lorsqu'il y un erreur ou lorsque la grille est pleine. 

 J'ai utilisé les boucles for if pour tester les chiffres possibles, valider si les conditions sont respectées et s'assurer de la récursivité.

 La fonction private int [] ordreAleatoire() me permet d'attribuer un chiffre de 1 à 9 aléatoire dans la grille de Sudoku.

 Pour valider les règles du Sudoku, j'ai utilisé private boolean isValid.
 Ceci me permet de valider si le chiffre n'est pas présent dans la ligne et dans la colonne et vérifie que les chiffres de 1 à 9 sont bien présents dans le bloc 3x3. 

J'ai utilisé private void afficher() pour afficher la grille proprement avec l'ajout de lignes et de séparateur. 

La fonction public static void main (String [] args) me permet de tester le programme. 

Pour calculer le temps que prend le programme pour générer la grille de Sudoku, j'ai utilisé 
long debut = System.currentTime.Millis(). 