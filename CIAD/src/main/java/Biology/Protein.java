/*
 * nom         : Protein
 * 
 * description : Cette classe représente la une proteine et fonctionne indépendamment de reste du porgramme
 *               grâce à son extension de la classe thread
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Biology;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import BaseDeDonnees.SQLiteDBManager;
import Geometry.Position;
import Geometry.Quadtree;
import Geometry.Vector;

public class Protein extends Thread {
	
	// Attributes
	private String nom;
	private Position position;
	private Vector Vecteur;
	private volatile boolean Ok;
	private Color couleur;
	private Cellule Cellule;
	private double diametre; 
	private ArrayList<Protein> Listecollisions;
	private boolean Run;
	
	//Constructor
	public Protein(String n, Cellule cellule) {
		this.nom = n;
		this.setOk(true);
		double direction = Math.random();
		this.Vecteur = new Vector( Math.cos(direction),Math.sin(direction));
		this.couleur = CouleurAleatoire();
		this.Cellule = cellule;
		this.position = new Position();
		this.diametre = 10;
		this.Cellule.AjouterProtein(this);
		this.Listecollisions = new ArrayList<>();
		this.Run = true;
		
		initialisationPosition();
		
	}
	
	/*
     * Constructeur Copie
     */
	public Protein(Protein other) {
	    // Copie des valeurs des propriétés de l'objet Protein other vers l'objet en cours de construction
	    this.nom = other.nom;
	    this.Ok = other.isOk();
	    this.Vecteur = new Vector(other.Vecteur.getX(), other.Vecteur.getY());
	    this.couleur = other.couleur;
	    this.Cellule = other.Cellule;
	    this.position = new Position(other.position.getX(), other.position.getY());
	    this.diametre = other.diametre;
	    this.Run = other.Run;
	    
	    // Copie en profondeur de Listecollisions (contenant des Protein)
	    this.Listecollisions = new ArrayList<>();
	}

	
	// Get and Set
	public void Pause() {
		this.Run = false;
	}
	
	public void Resume() {
		this.Run = true;
		
	}
	
	public Position getPos() {
		return position;
	}
	
	public void setPos( double x,  double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public  double getX() {
		return position.getX();
	}

	public void setX( double x) {
		this.position.setX(x);
	}
	
	public  double getY() {
		return position.getY();
	}

	public void setY( double y) {
		this.position.setY(y);
	}

	public Vector getVect() {
		return Vecteur;
	}

	public void setVect( double x,  double y) {
		this.Vecteur.setX(x);
		this.Vecteur.setY(y);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nm) {
		this.nom = nm;
	}
	
	public Color getCol() {
		return couleur;
	}

	public void setCol(Color col) {
		couleur = col;
	}

	public boolean isOk() {
		return Ok;
	}

	public void setOk(boolean ok) {
		Ok = ok;
	}

	public Cellule getCellule() {
		return Cellule;
	}

	public void setCellule(Cellule cellule) {
		Cellule = cellule;
	}

	public double getDiametre() {
		return diametre;
	}

	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}

	// Methods
	
	/*
     * Cette fonction simule le déplacement d'une protéine
     */
	public void Deplacement() {
		boolean Verifie = true;
		
		while(Verifie) {
			//Détection d'obstacles
			if(DetectionMembrane()) {
				ChangeDirectionMembrane();
			}
			
			if(DetectionProteine()) {
				
				ChangementDirectionProteine();
			}
			
			if(this.Cellule.EstDedans(getX()+Vecteur.getX(), getY()+Vecteur.getY())) {
				Verifie = false;
			}
		}
		
		this.position.setX(
				position.getX()+Vecteur.getX());
		this.position.setY(
				position.getY()+Vecteur.getY());
		
		this.Cellule.getIllustration().repaint();
	}
	
	/*
     * Cette fonction détecte s'il y a une collision avec d'autres protéines et si oui, on récupère les protéines avec lesquelles 
     * la protéine est entrée en collision
     */
	public boolean DetectionProteine() {
		
		Quadtree quadtree = this.Cellule.getQuadtree();
		
		this.Listecollisions = quadtree.ListeCollision(this);
		
		return !this.Listecollisions.isEmpty();
	}
	
	
	/*
     * Cette fonction gère les collision de la protéines avec d'autre protéines ou la membrane 
     */
    public void ChangementDirectionProteine() {
        Vector resultantVelocity = new Vector(0, 0);
        ArrayList<String> Donnee;
        ArrayList<Protein> collisionListCopy = new ArrayList<>(Listecollisions);
        

        for (Protein otherProtein : collisionListCopy) {
            if (this.equals(otherProtein)) continue;
			
            // Recherche dans la base de donnée les effets de la collisions
            Donnee = new ArrayList<>(SQLiteDBManager.getCollision(this.getNom(), otherProtein.getNom()));
            

            if(Donnee.size() == 1 && !Donnee.get(0).equals("None")) {
            	//La valeur de la Collision renvoie un tableau avec une seule protéine
            	// Il s'agit d'une Fusion
            	
            	this.Cellule.Fusion(this, otherProtein, Donnee.get(0));
            }
            
            if(Donnee.size() >1) {
            	// le tableau de la collision possède plus de 1 éléments
            	// Il s'agit d'une division
            	
            	//Identification de la Proteine qui doit exploser
            	Iterator<String> iterator = Donnee.iterator();
            	while (iterator.hasNext()) {
            	    String Nom = iterator.next();
            	    if (this.nom.equals(Nom)) {
            	        // this est la protéine qui a divisé, donc otherProtein est la protéine qui explose
            	    	
            	    	iterator.remove();
            	        this.Cellule.Division(this, otherProtein, Donnee);
            	    }

            	    if (otherProtein.nom.equals(Nom)) {
            	        // otherProtein est la protéine qui a divisé, donc this est la protéine qui explose
            	    	
            	        iterator.remove();
            	        this.Cellule.Division(otherProtein, this, Donnee);
            	    }
            	}
            }
          
        	 // Calcul du vecteur de collision entre this et otherProtein
            Vector collisionVector = new Vector(otherProtein.getX() - this.getX(), otherProtein.getY() - this.getY());

            // Normalisation du vecteur de collision
            collisionVector.Normaliser();


            // Mise à jour du vecteur vitesse résultant
            Vector reflectedVelocity = this.getVect().Redirection(collisionVector);
            resultantVelocity = resultantVelocity.Soustraction(reflectedVelocity);
        
			
           
        }
        
        // Vérifie si la protéine ne ce trouve pas au bord de la membrane de la cellule
        if(!this.Cellule.EstDedans(resultantVelocity.getX(), resultantVelocity.getY())) {
        	// Réaffecte le vecteur vitesse résultant à la protéine this
            this.setVect(resultantVelocity.getX(), resultantVelocity.getY()); 

            // Normalise le vecteur vitesse après la réflexion
            this.getVect().Normaliser();
        }

        
    }
	
	@Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Protein protein = (Protein) other;
        
        return this.getId() == protein.getId();
    }
	
	/*
     * Cette fonction détecte la collision entre la protéine et la membrane de la cellule
     */
	public boolean DetectionMembrane() {
		//Prédiction du 15e futur déplacement
		double x = position.getX() + Vecteur.getX() *15; 
		double y = position.getY() + Vecteur.getY() *15;
		
		return (!this.Cellule.EstDedans(x, y));
		
	}
	
	/*
     * Cette fonction effectue une rotation de 60° du vecteur vitesse de la protéine à chaque fois 
     * que l'on détecte la membrane
     */
	public void ChangeDirectionMembrane() {
		double vitesseX = this.Vecteur.getX();
		double vitesseY = this.Vecteur.getY();
		int x = (int)(Math.random() * 5 + 2);
		
		
		this.Vecteur.setX(
				vitesseX  * Math.cos(Math.PI /x) - (vitesseY) * Math.sin(Math.PI /x)) ;
		this.Vecteur.setY(
				vitesseX  * Math.sin(Math.PI /x) + (vitesseY ) * Math.cos(Math.PI /x));
		
		this.Vecteur.Normaliser();
	}
	
	public void Rotation(double angle, Vector vecteur) {
		//On effectue une rotation en radiant équivalent à la valeur donnée en paramètre
		double vitesseX = vecteur.getX();
		double vitesseY = vecteur.getY();
		
		this.Vecteur.setX(
				vitesseX  * Math.cos(angle) - (vitesseY) * Math.sin(angle)) ;
		this.Vecteur.setY(
				vitesseX  * Math.sin(angle) + (vitesseY ) * Math.cos(angle));
		
		this.Vecteur.Normaliser();
	}
	

	/*
     * Cette fonction initialise la position d'une protéine lors de sa création. La position est aléaatoire 
     * et à l'intérieur de la cellule
     */
	public void initialisationPosition() {
		double hauteur = this.Cellule.getHauteur();
		double largeur = this.Cellule.getLargeur();
		boolean Ok = true;
		
		double intervalle1a = this.Cellule.getCentreX() - (largeur/2);
		double intervalle1b = this.Cellule.getCentreX() + (largeur/2);
		
		double intervalle2a = this.Cellule.getCentreY() - (hauteur/2);
		double intervalle2b = this.Cellule.getCentreY() + (hauteur/2);
		
		Random random = new Random();
		
		while (Ok) {
	        int newX = (int) (random.nextDouble() * (intervalle1b - intervalle1a) + intervalle1a);
	        int newY = (int) (random.nextDouble() * (intervalle2b - intervalle2a) + intervalle2a);

	        if (this.Cellule.EstDedans(newX, newY)) {
	            Ok = false;
	            this.position.setX(newX);
	            this.position.setY(newY);
	        }
	    }
		
	}
	
	/*
     * Cette fonction initialise une couleur aléatoire pour la protéine
     */
	public static Color CouleurAleatoire() {
        Random random = new Random();

        // Génère des valeurs aléatoires pour les composantes RVB (rouge, vert, bleu)
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Crée une couleur à partir des valeurs aléatoires générées
        Color randomColor = new Color(red, green, blue);

        return randomColor;
    }
	
	/*
     * Cette fonction stop la protéine
     */
	public void stopProteine() {
		Ok = false;
	}
	
	
	// RUN
	@SuppressWarnings("static-access")
	public void run() {
		
		while (Ok) {
			
			if(this.Run) {
				Deplacement();
			}
			
			
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
		
	}
	
}
