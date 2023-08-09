/*
 * nom         : Illustration
 * 
 * description : Cette classe hérite de la classe JPanel, elle a pour rôle d'afficher
 * 				 l'animation de la simulation du déplacement des protéines dans la cellule.
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */
package Display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import Biology.Cellule ;
import Biology.Protein;
import Geometry.Quadtree;
import Geometry.Rectangle;

public class Illustration extends JPanel{
	
	//Attributes
    private int ORIGIN_X;
    private int ORIGIN_Y;
    private ArrayList<Protein> ListProteines;
    private Cellule  Cellule;
    private Quadtree QUadtree;
    private Running run;
    private DefaultListModel<String> proteinesListModel;
    private boolean AfficheQuadtree;

    //Constructor
    public Illustration(int Largeur, int Hauteur) {
    	Cellule = new Cellule (0, 0, Largeur, Hauteur);
    	Cellule.setIllustration(this);
        this.ListProteines = Cellule.getListeProteines();
        this.QUadtree = Cellule.getQuadtree();
        proteinesListModel = new DefaultListModel<>();
        RetireQuadtree();
       
        if(getRun() != null) {
			updateComponents();
		}
    }

    //Get and Set
    public int getOx() {
    	return this.ORIGIN_X;
    }
    
    public int getOy() {
    	return this.ORIGIN_Y;
    }
    
    public Running getRun() {
		return run;
	}

	public void setRun(Running run) {
		this.run = run;
	}

	public Cellule  getCellule() {
    	return Cellule;
    }
    
    public void StoP() {
    	this.Cellule.Arret();
    }
    
    public void AjoutQuadtree() {
    	this.AfficheQuadtree = true;
    }
    
    public void RetireQuadtree() {
    	this.AfficheQuadtree = false;
    }
    
    //Methods
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        QUadtree.MiseAJour();
        if(AfficheQuadtree) {
            drawQuadtree(g, QUadtree);
        }
        
        drawCell(g);
        drawProteins(g); 
        
    }
	
	/*
	 * Cette fonction met à jours La liste de protéines présentes dans la cellule. 
	 * S'il y a plus de  deux protéine de la même nature, alors leur nom apparaitra
	 * qu'une seule fois.
	 */
	public synchronized void  updateComponents() {
	    // Créer une copie profonde de la liste d'origine
	    ArrayList<String> listeProteinesCopy = new ArrayList<>();
	    for (Protein P : this.ListProteines) {
	        listeProteinesCopy.add(P.getNom()); // Utilisez le constructeur de copie pour créer une copie profonde
	    }
	    
	    proteinesListModel.clear();
	    
	    HashSet<String> liste =  new HashSet<>(listeProteinesCopy);
	    
	    listeProteinesCopy = new ArrayList<>(liste);

	    // Mettre à jour la JList avec la copie modifiée
	    for (String P : listeProteinesCopy) {
	        proteinesListModel.addElement(P);
	    }
	    
	    run.getListeProteines().setModel(proteinesListModel);
	}

	
	/*
	 * Cette fonction affiche les quadtrees en temps réel
	 */
	private void drawQuadtree(Graphics g, Quadtree quadtree) {
        if (quadtree == null)
            return;

        Rectangle rect = quadtree.getRectangle();
        g.setColor(Color.BLACK);
        g.drawRect((int) rect.getCentreX() - (int) (rect.getWIDTH() / 2), (int) rect.getCentreY() - (int) (rect.getHEIGHT() / 2),
                (int) rect.getWIDTH(), (int) rect.getHEIGHT());

        drawQuadtree(g, quadtree.getNorthEast());
        drawQuadtree(g, quadtree.getNorthWest());
        drawQuadtree(g, quadtree.getSouthWest());
        drawQuadtree(g, quadtree.getSouthEast());
        
    }

	/*
	 * Cette fonction permet de mettre en pause les protéines dans la cellule
	 */
    public void Pause() {
    	ArrayList<Protein> listecopie = new ArrayList<>(this.Cellule.getListeProteines());
    	
    	for(Protein P : listecopie) {
    		P.Pause();
    	}
    }
    
    /*
     * Cette fonction pêrmet de relancer les protéines en pause dans la cellule
     */
    public void Resume() {
    	ArrayList<Protein> listecopie = new ArrayList<>(this.Cellule.getListeProteines());
    	
    	for(Protein P : listecopie) {
    		P.Resume();
    	}
    }

    /*
     * Cette fonction s'occupe de dessiner les protéines dans la cellule
     */
	private void drawProteins(Graphics g) {
	    ArrayList<Protein> copyList = new ArrayList<>(ListProteines); // Créer une copie de Lst
	    for (Protein P : copyList) { // Parcourir la copie de la liste
	        g.setColor(P.getCol());
	        double px = P.getX();
	        double py = P.getY();
	        int diametre = (int) (P.getDiametre());
	        
	        g.fillOval((int) (px - diametre / 2), (int) (py - diametre / 2), diametre, diametre);
	    }
	}

    
    public void initDIm(int w, int h) {
        this.ORIGIN_X = w / 2;
        this.ORIGIN_Y = h / 2;
        

        // Mettre à jour les coordonnées de la cellule avec les coordonnées de l'origine
        Cellule.setCentreX(ORIGIN_X);
        Cellule.setCentreY(ORIGIN_Y);
        
        repaint();
    }
    
    /*
     * Cette fonction permet de dessiner la cellule
     */
    private void drawCell(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
        int x = ORIGIN_X; // Coordonnée X du centre de l'ellipse
        int y = ORIGIN_Y; // Coordonnée Y du centre de l'ellipse
        int horizontalRadius = (int) (Cellule.getLargeur()/2 ); // Demi-largeur de l'ellipse
        int verticalRadius = (int) (Cellule.getHauteur()/2 ); // Demi-hauteur de l'ellipse

        // Sauvegarde de la configuration graphique actuelle
        Stroke previousStroke = g2d.getStroke();
        Color previousColor = g2d.getColor();

        // Dessin de l'ellipse vide
        g2d.setColor(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(5)); // Épaisseur de la ligne
        g2d.drawOval(x - horizontalRadius, y - verticalRadius, horizontalRadius * 2, verticalRadius * 2);

        // Restauration de la configuration graphique précédente
        g2d.setStroke(previousStroke);
        g2d.setColor(previousColor);
    	
        
    }
    
    /*
     * Cette fonction permet d'ajouter uner protéine dans la cellule
     */
    public void AjoutProtein(Protein P) {
    	this.Cellule.AjouterProtein(P);
    }
    
	
}
