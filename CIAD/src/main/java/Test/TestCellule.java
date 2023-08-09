package Test;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import BaseDeDonnees.SQLiteDBManager;
import Biology.Protein;
import Display.Illustration;

public class TestCellule {
	
	

	public static void main(String[] args) {
		
		//Création de la fenêtre
				JFrame fenetre = new JFrame();
				fenetre.setTitle("Cellule");
				fenetre.setSize(1000, 1000);
				fenetre.setLocationRelativeTo(null);
				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				fenetre.setResizable(false);
				
				//Création du contenu
				Illustration I = new Illustration(600,600);
				I.AjoutQuadtree();
				fenetre.setContentPane(I);
				
				//Affichage
				fenetre.setVisible(true);
				
				 // Initialiser les dimensions de l'Illustration avec les dimensions de la fenêtre
		        I.initDIm(fenetre.getWidth(), fenetre.getHeight());
		        
		       
				
		        String proteineAleatoire = "";
				for(int i=0; i<200; i++) {
					
					ArrayList<String> listeproteines = SQLiteDBManager.getProteines();
					
					 // Vérifiez d'abord si la liste n'est pas vide
			        if (!listeproteines.isEmpty()) {
			            // Créez une instance de la classe Random pour générer un index aléatoire
			            Random random = new Random();

			            // Obtenez un index aléatoire entre 0 et la taille de la liste - 1
			            int randomIndex = random.nextInt(listeproteines.size());

			            // Récupérez la protéine au hasard en utilisant l'index aléatoire
			            proteineAleatoire = listeproteines.get(randomIndex);

			        }
					Protein P0 = new Protein(proteineAleatoire,I.getCellule());
					P0.start();
				}
				
	}

	
}
