/*
 * nom         : Position
 * 
 * description : Coordonnées des protéines
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Geometry;

public class Position {
	
	// Attributs
	private  double X;
	private  double Y;
	
	//Constructeur
	public Position(double x, double y) {
		super();
		X = x;
		Y = y;
	}
	
	public Position() {
		super();
	}

	// Get and Set
	public  double getX() {
		return X;
	}

	public void setX( double x) {
		X = x;
	}

	public  double getY() {
		return Y;
	}

	public void setY( double y) {
		Y = y;
	}
	

}
