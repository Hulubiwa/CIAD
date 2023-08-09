/*
 * nom         : Vector
 * 
 * description : représente le vecteur vitesse d'une protéine
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Geometry;

public class Vector {
	// Attributes
		private  double X;
		private  double Y;
		
	//Constructor
	public Vector( double x,  double y) {
		this.setX(x);
		this.setY(y);
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
	
	//Methods
	public void Normaliser() {
		double longueur = Math.sqrt(X * X + Y * Y);
		X /= longueur;
		Y /= longueur;
	}
	
	public double Norme() {
		return Math.sqrt(X * X + Y * Y);
	}
	
	// Calcule le produit scalaire avec un autre vecteur
    public double ProduitScalaire(Vector autre) {
        return X * autre.X + Y * autre.Y;
    }

    // Redirige le vecteur par rapport à un vecteur normalisé
    public Vector Redirection(Vector normal) {
        Vector normalScaled = normal.scale(2 * this.ProduitScalaire(normal));
        return this.Soustraction(normalScaled);
    }

    // Soustrait un autre vecteur
    public Vector Soustraction(Vector other) {
        return new Vector(X - other.getX(), Y - other.getY());
    }

    // Multiplie le vecteur par un scalaire
    public Vector scale(double factor) {
        return new Vector(X * factor, Y * factor);
    }


}
