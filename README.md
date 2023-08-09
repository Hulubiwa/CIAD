## PROJET FINAL (CIAD)

Ce projet a pour but d'étudier la collision binaire entre protéines au sein d'une cellule. AFIN D'ASSURER LA PARFAITE INSTALLATION ET
UTILISATION DE L'APPLICATION, JE VOUS CONSEIL DE LIRE ATTENTIVEMENT LES INSTRUCTION QUI VONT SUIVRE.

### L'installation
1. Téléchargez le répertoir CIAD
2. Installez un IDE pour Java, assurez vous que cet IDE utilise une version de Java supérieure à Java 8.
3. Installez les extension nécessaire à l'execution d'un programme en java si besoin (exemple : Java)

### Lancement de l'application
Exemple de lancement avec Visual Studio :

1. Installation des extension :

  ![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/56ed073e-f7e7-4471-82d5-af004673c136)

2. Cliquer sur le Menu "File" en haut à gauche, puis sur "Open Folder" pour ouvrir le répertoire CIAD.
3. Lancer la classe "Logiciel.java" :

![Logiciel](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/b63b70a7-670d-4248-9f6e-827403c5c6b2)


## APPLICATION

###  Ajout de protéines et fonctionnement de la base de données.

#### Base de Données

J'utilise du SQLite pour créer et stocker mes données. Ainsi ma base de données est représentée par le fichier "mydatabase" dans le 
répertoire CIAD. Au lancement de l'application, des données seront déjà inscrite dans la base de données.

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/ddc04529-dd89-4c41-9547-d3ea172068c1)

Ici j'utilise "DB Browser for SQLite" pour gérer et visualiser plus facilement l'agencement de mes données.

### IMPORTANT
Comme vous pouvez le voir sur l'image ci-dessus, j'utilise un codage spécifique pour distinguer les différentes collisions entre elles

#### Division :
Pour la ligne 1, Il s'agit d'une Collision. Soit ABC et DEF deux protéines qui entre en collision et engendre une division. On a
"ABCDEF#ABC#fdrez" qui signifie que lors de la division on aura deux nouvelles protéines "ABCDEF" et "fdrez". De plus le fait de retrouve
"ABC" dans la "ABCDEF#ABC#fdrez" désigne le fait que ABC et la protéine qui va détruire l'autre protéine durant la division.

Exemple : Si je veux ajouter à ma base de données une protéine A qui divise une seconde protéine B en deux nouvelles protéines C et D 

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/458cfff3-0e53-4ee8-acd8-9a50e0a9baf2)


![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/18b38893-fe3f-496c-8cc8-4ace637da082)

#### Fusion :
La fusion est beaucoup plus simple. Sur la ligne 2 de notre base de données on retouve la fusion entre "GHI" et JKL" qui fusionnent et donnent
"MNO".

Exemple : Je veux ajouter une fusion entre A et C qui donne une protéine E.

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/0dff30c4-4a51-4ca1-95ec-7efb5d9a9876)

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/94f5b6d7-bd8f-4265-bb78-3cfc8f3b6c81)
  

### Simulation de collision binaire 

1. Cliquez sur l'option "Select Proteins" :

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/59a1e6cf-80c4-46c7-a4ef-14880b15b15e)

2. Choisissez les deux protéines que vous voulez faire entrer en collision :

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/0efc3a01-085c-4ab0-a4af-3592f3eddd4a)

3. Lancer la simulation avec "RUN" :

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/4c26ed0b-ea5c-45eb-8525-af0a460f0d91)


Lors de la présentation de la simulation vous trouverez dans la partie gauche de la fenêtre,
un historique des collisions qui ont eu lieu ainsi qu'une liste des protéines présentes dans la cellule

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/0be5f248-af60-47e0-9237-07a25cb269e6)


### Simulation de déplacement et d'intéractions entre plusieurs protéines

1. Cliquez sur le bouton VS :

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/5b17c4f5-ce51-4a4e-886a-d6fd1f0e92e3)

2. Choisissez une dimension pour votre cellule ainsi que le nombre de protéines dans votre cellule :
#### Conseil : Si vous dépassez les 40 protéines vous risquez de vous retrouvez avec des erreurs de gestion de liste

![image](https://github.com/TheCodingHornet/StageSimulator/assets/94070078/d221e84d-65f1-44c5-a144-e63d8deaee8b)


## Avertissements 

Avant d'essayer l'option d'ajout de protéines de l'application, assurez vous de comprendre parfaitement l'encodage 
de la base de données expliqué précédemment "Application / Base de données"




## Test Quadtree

Dans mon projet CIAD il est possible de tester ma classe Quadtree qui se situe dans le package "Geometry".

1. Télécharger le projet CIAD.
2. Ouvrez le projet à l'aide d'un IDE java, exemple Eclipse ou Visual Studio
3. Allez Dans "CIAD/src/main/java/Test" puis Lancez le fichier TestCellule.java

Une fenêtre s'ouvrira où vous pourrez voir une simulation de 200 protéines et une limites de 2 protéines par quadtree.
Autrement dit, à chaque fois que le nombre de protéines dans la région du quadtree dépassera cette limite, alors 
le quadtree se divisera en sous-quadtree et ainsi de suite récursivement.


