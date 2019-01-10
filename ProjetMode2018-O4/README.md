###### Groupe O4 : Canonne Theo, Danglot Clement, Breviere Lucas, Bauvin Raphael
###### https://git-iut.univ-lille1.fr/canonnet/Modelisation.git

##### /!\ Clement Danglot a arretee l'UE1 après le livrable 1 /!\

## Generalisations des taches realisees :

Theo :
 * Class ReadFichier 
 * Class Modele ( Methodes triZ, centrer, updateCentre )
 * Class et Methodes de transformations ( Rotation, Translation, Redimensionnement )
 * Controles de la souris, clique droit/gauche et molette sur l'objet ( dans class Affichage )

Lucas : 
 * Class Modele
 * Tests Unitaire
 * Class WrongNumberFace
 * Class WrongNumberOfPoint

Raphael : 
 * Class Affichae 
 * Class GestionAffichage
 * MVC ( Observer/Observable )
 * Class OtherVue > Rotation Automatique 
 * Desing pattern Singleton ( sur la Class Modele )
 * Desing pattern Strategie ( sur package Matrices )
 * README, Video, UML et Javadoc Livrable 2

Clement : 
 * Class Face
 * Class Point
 * JavaDoc livrable 1

## Description general

### /!\ Le Model3D.jar doit etre placer avec le dossier "data" contenant les modeles .ply pour fonctinner. /!\

Au lancement, le modele beethoven.ply est charge. 
- Le modele est ensuite changeable grace a la liste de modele disponible sur le panel de controle a droite. 
- Les boutons permettent de realiser les rotations, translations, zoom/dezoom et les sliders changent la marge du movement.
- Les checkBox traits/faces permettent de cacher les traits ou faces.
- L'appli prend en charge les modeles avec couleur comme "skull.ply".
- On peut realiser une translation grace au clique droit de la souris.
- Maintenir la touche ctrl pour une rotation seulement horizontal.
- Maintenir la touche shift pour une rotation seulement vertical.
- La molette permet le zoom et dezoom.
- La checkBox ombre permet d'activre l'ombre et la lumiere sur l'objet.
- Rotation automatique ouvre une nouvelle fenetre sur laquel l'objet effectue une rotation automatique tant que la fenetre est en premier plan

## Autres :

Class executable pour lancer le projet : Appli > AppliModel3D

M -> Modele > class Modele
V-> Vue > class Affichage
C -> Controlleur > class GestionAffichage ( fait aussi partie de la vue )



