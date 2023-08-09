package Geometry;

public class Rectangle {
	
	//Attributes
	private  double ORIGIN_X;
	private  double ORIGIN_Y;
	private  double WIDTH;
	private  double HEIGHT;
	
	//Constructor
	public Rectangle( double x,  double y,  double w,  double h) {
		this.setCentreX(x);
		this.setCentreY(y);
		this.setWIDTH(w);
		this.setHEIGHT(h);
	}
	public Rectangle() {
		this.setCentreX(0);
		this.setCentreY(0);
		this.setWIDTH(0);
		this.setHEIGHT(0);
	}

	//Get and Set
	public  double getCentreX() {
		return ORIGIN_X;
	}

	public void setCentreX( double oRIGIN_X) {
		ORIGIN_X = oRIGIN_X;
	}

	public  double getCentreY() {
		return ORIGIN_Y;
	}

	public void setCentreY( double oRIGIN_Y) {
		ORIGIN_Y = oRIGIN_Y;
	}

	public  double getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH( double wIDTH) {
		WIDTH = wIDTH;
	}

	public  double getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT( double hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
	public void setCenter( double x,  double y) {
		this.ORIGIN_X = x;
		this.ORIGIN_Y = y;
	}
	
	//Methods
	public boolean IsPresent( double x,  double y) {
		
		 double XMin = this.ORIGIN_X - this.WIDTH/2;
		 double YMin = this.ORIGIN_Y - this.HEIGHT/2;
		 double XMax = this.ORIGIN_X + this.WIDTH/2;
		 double YMax = this.ORIGIN_Y + this.WIDTH/2;
		
		return ( x>=XMin && x<=XMax && y>=YMin && y<=YMax );
		
	}

}
