package BancPoissons;

public class ZoneAEviter  extends Objet{

	protected double rayon;
	

	protected int tempsRestant = 500;
	
	public ZoneAEviter(double x, double y, double r) {
		posX = x;
		posY = y;
		rayon = r;
	}
	
	public double getRayon() {
		return rayon;
	}
	
	public void MiseAJour() {
		tempsRestant --;
	}
	
	public boolean estMort() {
		return tempsRestant <= 0;
	}
	
}
