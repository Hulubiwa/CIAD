/*
 * nom         : Cellule
 * 
 * description : Cette classe représente une cellule
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Biology;

import java.awt.Color;
import java.util.ArrayList;

import Display.Illustration;
import Geometry.Quadtree;
import Geometry.Rectangle;

public class Cellule {
	
	//Attributes
	private double CentreX;
	private double CentreY;
	private double hauteur;
	private double largeur;
	private Quadtree quadtree;
	private int nbdivision;
	private int nbfusion;
	private Illustration illustration;
	private ArrayList<Protein> ListeProteines;
	
	
	//Constructor
	public Cellule(double Centrex, double Centrey, double Largeur, double Hauteur) {
		this.CentreX = Centrex;
		this.CentreY = Centrey;
		this.hauteur = Hauteur;
		this.largeur = Largeur;
		this.setListeProteines(new ArrayList<Protein>());
		Rectangle rectangle = new Rectangle(Centrex, Centrey, Largeur, Hauteur);
		this.quadtree = new Quadtree(rectangle, 2, this.getListeProteines());
	}
	
	

	//Get and Set
	public Illustration getIllustration() {
		return illustration;
	}

	public void setIllustration(Illustration illustration) {
		this.illustration = illustration;
	}
	
	public ArrayList<Protein> getListeProteines() {
		return ListeProteines;
	}

	public void setListeProteines(ArrayList<Protein> listeProteines) {
		ListeProteines = listeProteines;
	}
	
	public int getNbfusion() {
		return nbfusion;
	}

	public void setNbfusion() {
		this.nbfusion++;
	}

	public int getNbdivision() {
		return nbdivision;
	}

	public void setNbdivision() {
		this.nbdivision++;
	}

	public double getCentreX() {
		return CentreX;
	}

	public void setCentreX(double centreX) {
		CentreX = centreX;
		this.quadtree.getRectangle().setCentreX(centreX);
	}

	public double getCentreY() {
		return CentreY;
	}

	public void setCentreY(double centreY) {
		CentreY = centreY;
		this.quadtree.getRectangle().setCentreY(centreY);
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	public Quadtree getQuadtree() {
		return quadtree;
	}

	public void setQuadtree(Quadtree quadtree) {
		this.quadtree = quadtree;
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.CentreX, this.CentreY, this.largeur, this.hauteur);
	}

	//Method
	
	/*
     * Cette fonction Stop toutes les protéines dans la cellule
     */
	public void Arret() {
		for(Protein P : this.ListeProteines) {
			P.stopProteine();
		}
	}
	
	/*
     * Cette fonction renvoie true quand la position (x, y) désigne un point à l'intérieur de la cellule
     */
	public boolean EstDedans(double x, double y) {
		
	    double dL = largeur / 2;
	    double dH = hauteur / 2;
	    
	    double term1 = Math.pow((x - CentreX) / dL, 2);
	    double term2 = Math.pow((y - CentreY) / dH, 2);
	    double res = term1 + term2;
	    
	    return res <= 1;
	}
	
	public void SetLimiteQuadtree(double limite) {
		this.quadtree.setLimite(limite);
		this.quadtree.MiseAJour();
	}
	
	/*
     * Cette fonction ajoute une protéine dans la cellule
     */
	public void AjouterProtein(Protein P) {
		this.ListeProteines.add(P);
	}

	/*
     * Cette fonction enlève une protéine de la cellule
     */
	public void EnleverProtein(Protein P) {
	    for (Protein p : this.ListeProteines) {
	        if (p.equals(P)) {
	            p.stopProteine();
	            this.ListeProteines.remove(p);
	            break; // Ajoutez une sortie de boucle pour éviter une ConcurrentModificationException
	        }
	    }
	    
	}
	
	/*
     * Cette fonction vérifie si la présence d'une protéine dans la cellule
     */
	public synchronized boolean EstPresent(Protein proteine) {
		
		for(Protein P : this.ListeProteines) {
			
			if(P.equals(proteine)) {
				return true;
			}
			
		}
		return false;
		
	}

	
	/*
     * Cette fonction Simule la Fusion entre deux protéines
     */
	public synchronized void Fusion(Protein ProteinA, Protein ProteinB, String collisionNom) {
		if(EstPresent(ProteinA) && EstPresent(ProteinB)) { 
			Protein fusion = new Protein(collisionNom, this);
			
			fusion.setPos(ProteinA.getX(), ProteinA.getY());
			fusion.setVect(ProteinA.getVect().getX(), ProteinA.getVect().getY());
			fusion.setCol(Color.BLUE);
			
			EnleverProtein(ProteinA);
			EnleverProtein(ProteinB);
			
			setNbfusion();
			fusion.start();
			
			if(this.illustration.getRun() != null) {
				this.illustration.updateComponents();
				ArrayList<String> liste = new ArrayList<>();
				liste.add(collisionNom);
				UpdateHistorique("Fusion", liste, ProteinA.getNom(), ProteinB.getNom());
			}
		}
		
		
	}
	
	/*
     * Cette fonction met à jours l'historique du logiciel
     */
	private synchronized void UpdateHistorique(String collision, ArrayList<String> donnee, String nom2, String nom3) {
		
    	StringBuilder historyBuilder = new StringBuilder();

        // Ajouter la ligne "Division" avec l'indentation initiale
        historyBuilder.append(collision).append("\n");

        // Ajouter le nom2 et nom3 avec l'indentation appropriée
        historyBuilder.append("              ").append(nom2).append("\n");
        historyBuilder.append("              ").append(nom3).append("\n");

        // Ajouter les noms de la ArrayList avec l'indentation appropriée
        for (String nom : donnee) {
            historyBuilder.append("                      ").append(nom).append("\n");
        }

        // Mettre à jour le contenu du JTextArea (Historique)
        this.getIllustration().getRun().getHistorique().append(historyBuilder.toString());
       
	}
	
	/*
     * Cette fonction simule la division entre deux protéines
     */
	public synchronized void Division(Protein autre, Protein proteine, ArrayList<String> Collision) {
		// Deux protéines se touchent et l'une d'entre elle explose
		
		if(EstPresent(proteine)) {
			Explosion(proteine, Collision);
			EnleverProtein(proteine);
			setNbdivision();
			
			if(this.illustration.getRun() != null) {
				this.illustration.updateComponents();
				UpdateHistorique("Division", Collision, autre.getNom(), proteine.getNom());
			}
		}
		
		
	}
	
	public void Affiche() {
		System.out.println("Nombre de protéines : "+this.ListeProteines.size());
		System.out.println("Nombre de division : "+this.nbdivision);
		System.out.println("Nombre de fusion : "+this.nbfusion);
	}

	/*
     * Cette fonction simule l'explosion d'une protéine lors d'une division
     */
	private void Explosion(Protein proteine, ArrayList<String> Listeproteines) {
		
		int nombreProteine = Listeproteines.size();
		
		for(int i=0; i<nombreProteine; i++) {
			double angle = ((i * Math.PI) / (nombreProteine - 1)) - Math.PI/2;
			
			Protein newProteine = new Protein(Listeproteines.get(i), this);
			
			//Rotation du vecteur et modification de sa position d'apparition
			newProteine.Rotation(angle, proteine.getVect());
			double newX = proteine.getX() + newProteine.getVect().getX() * (proteine.getDiametre()+2);
			double newY = proteine.getY() + newProteine.getVect().getY() * (proteine.getDiametre()+2);
			
			if(EstDedans(newX, newY)) {
				newProteine.setPos(newX, newY);
			}
			else {
				newProteine.setPos(proteine.getX(), proteine.getY());
			}
			
			newProteine.setCol(Color.BLACK);
			newProteine.start();
		}
	}

}
