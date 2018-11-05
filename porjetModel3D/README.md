Groupe O4 : Canonne Theo, Danglot Clement, Breviere Lucas, Bauvin Raphael
https://git-iut.univ-lille1.fr/canonnet/Modelisation.git

Generalisations des taches realisees :
Theo : Realisation du ReadFichier et des calculs mathematiques
Lucas : Realisation du Modele et des Tests
Raphael : Realisation de l'afficgae et des controlleurs
Clement : Realistions des faces, points et de la JavaDoc


Le Model3D.jar doit etre placer avec le dossier "data" contenant les modeles .ply pour fonctinner.

Au lancement, le modele corner.ply est charge. 
- Le modele est ensuite changeable grace a la liste de modele disponible sur le panel de controle � droite. 
- Les boutons permettent de r�aliser les rotations, translations, zoom/dezoom et les sliders changent la marge du movement.
- Les checkBox traits/faces permettent de cacher les traits ou faces.
- L'appli prend en charge les modeles avec couleur comme "skull.ply".
- On peut realiser une translation grace au clique droit de la souris.
- On peut realiser une rotation grace au clique gauche de la sours.
- Maintenir la touche ctrl pour une rotation seulement horizontal.
- Maintenir la touche shift pour une rotation seulement vertical.
- La molette permet le zoom et dezoom.


Autres :

Class executable pour lancer le projet : Appli > AppliModel3D

M -> Modele > class Modele
V-> Vue > class Affichage
C -> Controlleur > class GestionAffichage ( fait aussi partie de la vue )
 
