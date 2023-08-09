/*
 * nom         : Quadtree
 * 
 * description : Cette classe nous permet de lister nos protéines dans un objet 
 * 				 qui nous permet de d'optimiser la gestion des collisions entre protéines 
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Geometry;

import java.util.ArrayList;
import java.util.Iterator;

import Biology.Protein;

public class Quadtree {
	
	//Attributs
	private ArrayList<Protein> ListeProteines;
	private  double limite;
	private Rectangle Rect;
	private Quadtree NorthEast;
	private Quadtree NorthWest;
	private Quadtree SouthEast;
	private Quadtree SouthWest;
	
	
	//Constructeur
	public Quadtree(Rectangle rectangle,  double limite, ArrayList<Protein> Liste) {
		this.Rect = rectangle;
		this.limite = limite;
		this.ListeProteines = Liste;
		
		MiseAJour();
	}
	
	public Quadtree(double limite) {
		this.Rect = new Rectangle();
		this.limite = limite;
		this.ListeProteines = new ArrayList<Protein>();
	}
	
	
	//Get and Set
	public ArrayList<Protein> getList(){
		return this.ListeProteines;
	}
	
	public void setList(ArrayList<Protein> L) {
		this.ListeProteines = L;
	}
	
	public  double getLimite() {
		return this.limite;
	}
	
	public void setLimite( double l) {
		this.limite = l;
	}
	
	public Rectangle getRectangle() {
		return this.Rect;
	}
	
	public void setRectangle(Rectangle r) {
		this.Rect = r;
	}
	
	public Quadtree getNorthEast() {
		return NorthEast;
	}

	public void setNorthEast(Quadtree northEast) {
		NorthEast = northEast;
	}

	public Quadtree getNorthWest() {
		return NorthWest;
	}

	public void setNorthWest(Quadtree northWest) {
		NorthWest = northWest;
	}

	public Quadtree getSouthEast() {
		return SouthEast;
	}

	public void setSouthEast(Quadtree southEast) {
		SouthEast = southEast;
	}

	public Quadtree getSouthWest() {
		return SouthWest;
	}

	public void setSouthWest(Quadtree southWest) {
		SouthWest = southWest;
	}

	
	//Methodes
	public synchronized void MiseAJour() {
		/// Met à jours les quadtrees en fonctions des changements dans la liste de protéines
		
		ArrayList<Protein> lstCopy = new ArrayList<>(this.ListeProteines);
		/*System.out.println("limite : "+this.limite);
		System.out.println("nb : "+lstCopy.size());
		System.out.println("lp : "+lstCopy);
		System.out.println(lstCopy.size() > this.limite);*/
		
		
		if(lstCopy.size() > this.limite) {
			// Le nombre de protéines présente dans le rectangle est supérieur à  la limite
			
			 double centreX = this.Rect.getCentreX();
			 double centreY = this.Rect.getCentreY();
			 double largeur = this.Rect.getWIDTH();
			 double hauteur = this.Rect.getHEIGHT();
			
			//hauteur et largeur des rectangles des autres Quadtrees
			 double Largeur = largeur/2;
			 double Hauteur = hauteur/2;
			
			Rectangle Nw = new Rectangle(centreX - Largeur/2, centreY + Hauteur/2, Largeur, Hauteur);
			Rectangle Ne = new Rectangle(centreX + Largeur/2, centreY + Hauteur/2, Largeur, Hauteur);
			Rectangle Sw = new Rectangle(centreX - Largeur/2, centreY - Hauteur/2, Largeur, Hauteur);
			Rectangle Se = new Rectangle(centreX + Largeur/2, centreY - Hauteur/2, Largeur, Hauteur);
			
			Rectangle[] LstRect = {Nw, Ne, Sw, Se};
			ArrayList<Protein>[] Liste = Listes(LstRect, lstCopy);
			
		
			
			this.setNorthWest(new Quadtree(Nw, this.limite, Liste[0]));
			this.setNorthEast(new Quadtree(Ne, this.limite, Liste[1]));
			this.setSouthWest(new Quadtree(Sw, this.limite, Liste[2]));
			this.setSouthEast(new Quadtree(Se, this.limite, Liste[3]));
			
			
			
			
		}
		else {
			this.setNorthWest(new Quadtree(this.limite));
			this.setNorthEast(new Quadtree(this.limite));
			this.setSouthWest(new Quadtree(this.limite));
			this.setSouthEast(new Quadtree(this.limite));
		}
		
	}
	
	private ArrayList<Protein>[] Listes(Rectangle[] LR, ArrayList<Protein> lst){
	    // Renvoie les listes de protéines de chaque Quadtree

	    @SuppressWarnings("unchecked")
	    ArrayList<Protein>[] Liste = (ArrayList<Protein>[]) new ArrayList[4];

	    for (int i = 0; i < 4; i++) {
	        Rectangle R = LR[i];
	        ArrayList<Protein> Newliste = new ArrayList<Protein>();
	        Iterator<Protein> iterator = lst.iterator(); // Déplacer l'itérateur à l'intérieur de la boucle

	        while (iterator.hasNext()) {
	            Protein P = iterator.next();
	            double x = P.getX();
	            double y = P.getY();

	            if (R.IsPresent(x, y)) {
	                Newliste.add(P);
	                iterator.remove();
	            }
	        }

	        Liste[i] = Newliste;
	    }

	    return Liste;
	}


	public boolean EstDedant(double x, double y) {
		// Vérifie si un point est dans le rectangle
		
		return this.Rect.IsPresent(x, y);
	}

	public void AjoutProteine( Protein P) {
		this.ListeProteines.add(P);
		
		MiseAJour();
	}
	
	public void Affiche() {
		ArrayList<Protein> CopieListe = new ArrayList<>(this.ListeProteines);
		
		
		Iterator<Protein> iterator = CopieListe.iterator();

		for (int i = 0; i < CopieListe.size(); i++) {
			Protein P = iterator.next();
			System.out.println(P.getNom()+" : "+P.isOk());
			iterator.hasNext();
	    }
		
	}
	
	public Protein getProtein(Protein P) {
		///Renvoie la protéine P si elle se trouve dans la liste, sinon elle renvoie null
		
		for(Protein protein : this.ListeProteines) {
			
			if(protein.equals(P)) {
				return protein;
			}
		}
		return null;
	}
	
	public Protein getProteinByName(String nom) {
		///Renvoie la protéine dont le nom est égal à la variable nom
		
		for(Protein protein : this.ListeProteines) {
			
			if(protein.getNom() == nom) {
				return protein;
			}
		}
		return null;
	}
	
	public boolean Collision(Protein P1, Protein P2) {
		//Calcul la distance entre les centres des deux protéines
		double dx = P2.getX() - P1.getX();
		double dy = P2.getY() - P1.getY();
        double Distance = Math.sqrt(dx * dx + dy * dy);
        
        //Rayons des protéines
        double Rayon1 = P1.getDiametre() / 2;
        double Rayon2 = P2.getDiametre() / 2;
		
		return (Distance <= (Rayon1 + Rayon2));
	}
	
	public ArrayList<Protein> ListeCollision(Protein proteine){
		//Renvoie la liste des protéines qui sont en collisions avec la proteine en paramètre
		
		ArrayList<Protein> listeproteinetouche = new ArrayList<>();
		double x = proteine.getX();
		double y = proteine.getY();
		
		if(EstDedant(x, y)) {
			
			if(PossedeDesSousQuadtrees()) {
				listeproteinetouche.addAll(this.getNorthEast().ListeCollision(proteine));
				listeproteinetouche.addAll(this.getNorthWest().ListeCollision(proteine));
				listeproteinetouche.addAll(this.getSouthEast().ListeCollision(proteine));
				listeproteinetouche.addAll(this.getSouthWest().ListeCollision(proteine));
				
				return listeproteinetouche;
			}
			else{
				//On a trouver le plus petit quadtree qui contient la proteine
				for(Protein P : this.ListeProteines) {
					if(Collision(proteine, P) && !proteine.equals(P)) {
						listeproteinetouche.add(P);
					}
				}
				return listeproteinetouche;
			}
		}
		else {
			return listeproteinetouche;
		}
	}
	
	public boolean PossedeDesSousQuadtrees() {
		///Vérifie si cette instance de quadtree possède des sous quadtrees
		
		return this.ListeProteines.size() > this.limite;
	}
	
}
