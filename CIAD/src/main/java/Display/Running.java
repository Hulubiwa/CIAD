/*
 * nom         : Running
 * 
 * description : Cette classe hérite de la classe JDialog, elle a pour rôle 
 * 				 de présenter la simulation dans un panel, accompagné de son 
 * 				 historique et de sa liste de protéines.
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Display;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;

import Biology.Cellule;
import Biology.Protein;
import Geometry.Vector;


public class Running extends javax.swing.JDialog {
	
	// Attributs
    private javax.swing.JLabel ProteinSimulator;
    private javax.swing.JList<String> ListeProteines;
    private javax.swing.JPanel jPanel1;
    private Illustration illustration;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea Historique;
    private String[] ListeProteine;

    //Constructeur avec une liste de protéines 
    public Running(String[] Liste) {
        initComponents();
        this.ListeProteine =Liste;
        setModal(false);
        this.illustration.setRun(this);
    }
    
    //Constructeur
    public Running() {
    	initComponents();
    	setModal(true);
    	this.illustration.setRun(this);
    }
    
    // Get and Set
    public Illustration getIllustration() {
    	return this.illustration;
    }
    
    public javax.swing.JList<String> getListeProteines() {
		return ListeProteines;
	}

	public void setListeProteines(javax.swing.JList<String> listeProteines) {
		ListeProteines = listeProteines;
	}

	public javax.swing.JTextArea getHistorique() {
		return Historique;
	}

	public void setHistorique(javax.swing.JTextArea historique) {
		Historique = historique;
	}

	public String[] getListeProteine() {
		return ListeProteine;
	}

	public void setListeProteine(String[] listeProteine) {
		ListeProteine = listeProteine;
	}

	// Methods
	
	/*
	 * Cette fonction initialise les positions et les vecteurs vitesses des deux protéines
	 * qui doivent entrer en collision. Les deux protéines doivent être suffisamment éloignées 
	 * l'une de l'autre pour percevoir le mouvement, puis elle doivent se dirrigée l'une vers 
	 * l'autre.
	 */
    public static void initialisation(ArrayList<Protein> listeProteines, Cellule cellule) {
        double centreX = cellule.getCentreX();
        double centreY = cellule.getCentreY();
        double hauteur = cellule.getHauteur();
        double largeur = cellule.getLargeur();

        if (listeProteines.size() != 2) {
            throw new IllegalArgumentException("Le nombre de protéines doit être égal à 2.");
        }

        // Placez la première protéine à une position aléatoire dans la cellule
        double newX1, newY1;
        do {
            newX1 = centreX + (Math.random() - 0.5) * largeur;
            newY1 = centreY + (Math.random() - 0.5) * hauteur;
        } while (!cellule.EstDedans(newX1, newY1));
        listeProteines.get(0).setPos(newX1, newY1);

        // Placez la deuxième protéine à l'opposé de la première
        double newX2 = centreX - (newX1 - centreX);
        double newY2 = centreY - (newY1 - centreY);
        listeProteines.get(1).setPos(newX2, newY2);

        // Calculez les vecteurs direction pour les protéines
        Vector vecteurDirection1 = new Vector(newX2 - newX1, newY2 - newY1);
        vecteurDirection1.Normaliser();
        Vector vecteurDirection2 = new Vector(newX1 - newX2, newY1 - newY2);
        vecteurDirection2.Normaliser();

        listeProteines.get(0).setVect(vecteurDirection1.getX(), vecteurDirection1.getY());
        listeProteines.get(1).setVect(vecteurDirection2.getX(), vecteurDirection2.getY());
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListeProteines = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Historique = new javax.swing.JTextArea();
        illustration = new Illustration(500,500);
        ProteinSimulator = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        ListeProteines.setBackground(new java.awt.Color(204, 204, 204));
        ListeProteines.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 0, new java.awt.Color(0, 0, 0)));
        
        jScrollPane3.setViewportView(ListeProteines);

        jPanel1.add(jScrollPane3);

        Historique.setBackground(new java.awt.Color(204, 204, 204));
        Historique.setColumns(20);
        Historique.setRows(5);
        Historique.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(Historique);

        jPanel1.add(jScrollPane4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        illustration.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout illustrationLayout = new javax.swing.GroupLayout(illustration);
        illustration.setLayout(illustrationLayout);
        illustrationLayout.setHorizontalGroup(
            illustrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        illustrationLayout.setVerticalGroup(
            illustrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        
     // Ajouter un WindowListener pour intercepter les événements de fermeture de la fenêtre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Appel de la fonction windowClosing définie précédemment
                windowClosingAction();
            }
        });

        getContentPane().add(illustration, java.awt.BorderLayout.CENTER);

        ProteinSimulator.setBackground(new java.awt.Color(204, 204, 204));
        ProteinSimulator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProteinSimulator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Protein-Simulator-26-07-2023.png"))); // NOI18N
        ProteinSimulator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        getContentPane().add(ProteinSimulator, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    
    private void windowClosingAction() {
        this.illustration.StoP();
        this.Historique.setText(""); 
        
        DefaultListModel<String> proteinesListModel = new DefaultListModel<>();
        proteinesListModel.clear();
        this.ListeProteines.setModel(proteinesListModel);
        this.dispose();
    }
    
    /*
     * Cette méthode est appelée lorsque l'on veut effectuer une simulation avec deux
     * protéines uniquement
     */
    public void Lancer() {
    	
        
        ArrayList<Protein> listeProteines = new ArrayList<>();
        
        for(String nom : this.ListeProteine) {
        	Protein P = new Protein(nom, this.illustration.getCellule());
        	listeProteines.add(P);
        }
        
        initialisation(listeProteines, this.illustration.getCellule());
        
        for(Protein proteine : listeProteines) {
        	proteine.start();
        }
        
    }
    
    /*
     * Cette méthode est appelé lorsque l'on veut effectuer une simulation
     * avec un nombre prédéfinie de protéines et avec les dimension de la cellules
     * 
     */
    public void Lancer(ArrayList<String> ListeDeProteines, int nombre) {
    	
    	String proteineAleatoire = "";
	    for(int i=0; i<nombre; i++) {
	    	
            // Créez une instance de la classe Random pour générer un index aléatoire
            Random random = new Random();

            // Obtenez un index aléatoire entre 0 et la taille de la liste - 1
            int randomIndex = random.nextInt(ListeDeProteines.size());

            // Récupérez la protéine au hasard en utilisant l'index aléatoire
            proteineAleatoire = ListeDeProteines.get(randomIndex);

	        
			Protein P0 = new Protein(proteineAleatoire,this.getIllustration().getCellule());
			P0.start();
	    }
	    
	    this.getIllustration().initDIm(this.getIllustration().getWidth(), this.getIllustration().getHeight());
    }
}
