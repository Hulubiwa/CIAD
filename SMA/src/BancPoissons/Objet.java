package BancPoissons;

public class Objet {
	
	public double posX;
	public double posY;
	
	public Objet() {}
	public Objet(double x, double y) {
		posX = x;
		posY = y;
	}
	
	public double DistanceCarre(Objet o) {
		
		return (o.posX - posX)*(o.posX - posX) + (o.posY - posY)*(o.posY - posY);
		
	}
	
	public double Distance(Objet o) {
		return Math.sqrt(DistanceCarre(o));
	}

}
