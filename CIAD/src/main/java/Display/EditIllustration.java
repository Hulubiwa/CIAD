/*
 * nom         : EditIllustration
 * 
 * description : Cette classe hérite de la classe JDialog, elle a pour rôle de permettre 
 * 				 à l'utilisateur de choisir le nombre de protéines présentes dans la cellule
 *               et de la dimension de cette dernière. Au finalement la classe lancera une 
 *               simulation du comportement des protéines dans la cellule.
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Display;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import BaseDeDonnees.SQLiteDBManager;


public class EditIllustration extends javax.swing.JDialog {
	
	// Attribut                     
    private javax.swing.JTextField Hauteur;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Largeur;
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;                      
    
    //Constructeur
    public EditIllustration() {
        initComponents();
    }

    //Méthodes                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        OK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Largeur = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Hauteur = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Nombre = new javax.swing.JTextField();

        OK.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        OK.setText("OK");
        OK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel2.setText("largeur de protéines :");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jLabel3.setText("Dimension de la Cellule :");

        jLabel4.setText("Max 100");

        jLabel5.setText("10 ~ 600");

        jLabel6.setText("10 ~ 600");

        Largeur.setText("300");
        jScrollPane1.setViewportView(Largeur);

        Hauteur.setText("300");
        jScrollPane2.setViewportView(Hauteur);

        Nombre.setText("20");
        jScrollPane3.setViewportView(Nombre);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(OK)
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                 

    //Evenements
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {                                   
    	try {
            int largeur = Integer.parseInt(Largeur.getText());
            int hauteur = Integer.parseInt(Hauteur.getText());
            int nombre = Integer.parseInt(Nombre.getText());
            
            // Vérifier les limites imposées
            if (nombre < 0 || nombre > 100) {
                JOptionPane.showMessageDialog(this, "Le largeur de protéines doit être compris entre 0 et 300.");
                return;
            }
            
            if (hauteur < 10 || hauteur > 600) {
                JOptionPane.showMessageDialog(this, "La hauteur de la cellule doit être comprise entre 10 et 600.");
                return;
            }
            
            if (largeur < 10 || largeur > 600) {
                JOptionPane.showMessageDialog(this, "La largeur de la cellule doit être comprise entre 10 et 600.");
                return;
            }
            
            Running dialog = new Running();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            

            // Redimension de la cellule
            dialog.getIllustration().getCellule().setHauteur(hauteur);
            dialog.getIllustration().getCellule().setLargeur(largeur);

            ArrayList<String> listeproteines = new ArrayList<>(SQLiteDBManager.getProteines());
            dialog.pack(); // Adjusts the size of the dialog based on its components
    	    dialog.getIllustration().initDIm(dialog.getIllustration().getWidth(), dialog.getIllustration().getHeight());
            dialog.Lancer(listeproteines, nombre);
            
    	    dialog.setVisible(true);
            
            // Faites ce que vous devez faire avec les valeurs entrées (largeur, hauteur, largeur)...
        } catch (NumberFormatException ex) {
            // En cas d'erreur lors de la conversion des largeurs, afficher un message d'erreur
            JOptionPane.showMessageDialog(this, "Veuillez entrer uniquement des chiffres valides.");
        }
    	this.dispose();
    
    }                                  


              
}
