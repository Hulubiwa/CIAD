package BancPoissons;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

import BancPoissons.Poisson;
import BancPoissons.ZoneAEviter;

// L'ocean de lequel nos poissons nagent
public class Ocean {

	//Attributs
	protected Poisson[] poissons;
	protected ArrayList<ZoneAEviter> obstacles;
	protected Random generateur;
	protected double largeur;
	protected double hauteur;
	protected PropertyChangeSupport support;
	private int compteur;
	
	//Constructeur
	public Ocean(int nbPoissons, double Largeur, double Hauteur) {
		support = new PropertyChangeSupport(this);
		compteur = 0;
		largeur = Largeur;
		hauteur = Hauteur;
		generateur = new Random();
		obstacles = new ArrayList();
		poissons = new Poisson[nbPoissons];
		
		for(int i = 0; i<nbPoissons; i++) {
			poissons[i] = new Poisson(generateur.nextDouble() * largeur, generateur.nextDouble() * hauteur, generateur.nextDouble() * 2 * Math.PI);
		}
	}
	
	//Methodes
	public void AjouterChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void EnleverPropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void AjouterObstacle(double PosX, double PosY, double rayon) {
		obstacles.add(new ZoneAEviter(PosX, PosY, rayon));
	}
	
	protected void MiseAJourObstacles() {
		
		for(ZoneAEviter obstacle : obstacles) {
			obstacle.MiseAJour();
		}
		obstacles.removeIf(o -> o.estMort());
	}
	
	protected void MiseAJourPoissons() {
		
		for(Poisson p : poissons) {
			p.MiseAJour(poissons, obstacles, largeur, hauteur);
		}
		obstacles.removeIf(o -> o.estMort());
	}
	
	public void MiseAJourOcean() {
		MiseAJourObstacles();
		MiseAJourPoissons();
		support.firePropertyChange("Changed", this.compteur, this.compteur + 1);
		this.compteur ++;
	}

	
	//Accesseurs
	public Poisson[] getPoissons() {
		return poissons;
	}

	public ArrayList<ZoneAEviter> getObstacles() {
		return obstacles;
	}
	
}
