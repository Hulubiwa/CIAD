/*
 * nom         : Logiciel
 * 
 * description : Cette classe hérite de la classe JFrame, il s'agit de la classe
 * 				 que l'utilisateur lance pour démarrer l'application
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Display;

import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import Biology.Cellule;

public class Logiciel extends javax.swing.JFrame {
	
	// Attributs
	protected javax.swing.JButton Ajout;
    protected javax.swing.JLabel Proteine1;
    protected javax.swing.JLabel Proteine2;
    protected javax.swing.JButton RUN;
    protected javax.swing.JButton Select;
    protected javax.swing.JButton VS;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JPanel jPanel6;
    protected javax.swing.JPanel jPanel7;
    protected javax.swing.JPanel jPanel8;
    
    private Cellule cellule;
    private String[] ProteinesChoisies;

    
    
    
    // Constructeur
    public Logiciel() {
        initComponents();
        this.cellule = new Cellule(0,0,0,0);
        this.ProteinesChoisies = new String[2];
    }
   
    // Accesseurs
    public Cellule getCellule() {
		return cellule;
	}



	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}



	public String[] getProteinesChoisies() {
		return ProteinesChoisies;
	}



	public void setProteinesChoisies(String[] proteinesChoisies) {
		ProteinesChoisies = proteinesChoisies;
	}
	
	//Méthodes
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Ajout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        RUN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Select = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Proteine1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        VS = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        Proteine2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(3, 1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Protein-Simulator-26-07-2023.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 5, new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 5, new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        Ajout.setBackground(new java.awt.Color(242, 242, 242));
        Ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ajouter-removebg-preview.png"))); // NOI18N
        Ajout.setBorder(null);
        Ajout.setBorderPainted(false);
        Ajout.setContentAreaFilled(false);
        Ajout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AjoutEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AjoutExited(evt);
            }
        });
        Ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add-protein.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(Ajout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Ajout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel1);

        RUN.setBackground(new java.awt.Color(242, 242, 242));
        RUN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Play5-removebg-preview.png"))); // NOI18N
        RUN.setBorder(null);
        RUN.setBorderPainted(false);
        RUN.setContentAreaFilled(false);
        RUN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RUN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RUNEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RUNExited(evt);
            }
        });
        RUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUNActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RUN.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(RUN)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(73, 73, 73))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RUN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );

        jPanel4.add(jPanel2);

        Select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Selection.png"))); // NOI18N
        Select.setBorder(null);
        Select.setBorderPainted(false);
        Select.setContentAreaFilled(false);
        Select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SelectEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SelectExited(evt);
            }
        });
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Select-Proteins.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Select)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3);

        getContentPane().add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new java.awt.GridLayout(1, 3));

        Proteine1.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        Proteine1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Proteine1.setText("Aucun");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Proteine1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Proteine1)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6);

        VS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VS.png"))); // NOI18N
        VS.setBorder(null);
        VS.setBorderPainted(false);
        VS.setContentAreaFilled(false);
        VS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Nezuko(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NezukoOut(evt);
            }
        });
        VS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(VS, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(VS)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);

        Proteine2.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        Proteine2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Proteine2.setText("Aucun");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Proteine2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(Proteine2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel5.add(jPanel8);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	
    //Evenements
    protected void VSActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                EditIllustration dialog = new EditIllustration();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.pack(); // Adjusts the size of the dialog based on its components
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
	}

	/// Effet Souris quand elle passe sur les boutons
    private void SelectEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectEntered
        // Code pour agrandir le bouton lorsqu'il est survolé
        Select.setSize(Select.getWidth() + 10, Select.getHeight() + 10);

    }//GEN-LAST:event_SelectEntered

    private void SelectExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectExited
        // Code pour restaurer la taille d'origine du bouton lorsque la souris quitte le bouton
        Select.setSize(Select.getWidth() - 10, Select.getHeight() - 10);
    }//GEN-LAST:event_SelectExited

    private void RUNEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUNEntered
        // Code pour agrandir le bouton lorsqu'il est survolé
        RUN.setSize(RUN.getWidth() + 10, RUN.getHeight() + 10);
    }//GEN-LAST:event_RUNEntered

    private void RUNExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUNExited
        // Code pour restaurer la taille d'origine du bouton lorsque la souris quitte le bouton
        RUN.setSize(RUN.getWidth() - 10, RUN.getHeight() - 10);
    }//GEN-LAST:event_RUNExited

    private void AjoutEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjoutEntered
        // Code pour agrandir le bouton lorsqu'il est survolé
        Ajout.setSize(Ajout.getWidth() + 10, Ajout.getHeight() + 10);
    }//GEN-LAST:event_AjoutEntered

    private void AjoutExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AjoutExited
        // Code pour restaurer la taille d'origine du bouton lorsque la souris quitte le bouton
        Ajout.setSize(Ajout.getWidth() - 10, Ajout.getHeight() - 10);
    }//GEN-LAST:event_AjoutExited

    private void Nezuko(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nezuko
        // Charger l'image GIF depuis la ressource
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/img/nezuko-running.gif"));

    // Redimensionner l'image à la taille souhaitée
    int width = 200; 
    int height = 150; 
    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);

    // Créer un nouvel ImageIcon avec l'image redimensionnée
    ImageIcon resizedIcon = new ImageIcon(image);

    // Définir l'icône redimensionnée dans le JButton
    VS.setIcon(resizedIcon);
    
    
    }//GEN-LAST:event_Nezuko

    private void NezukoOut(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NezukoOut
        // TODO add your handling code here:
        VS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VS.png")));
        
    }//GEN-LAST:event_NezukoOut

   
    /// Effet de clique sur les boutons
    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        // TODO add your handling code here:
    	
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                ChooseProtein dialog = new ChooseProtein(Logiciel.this);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.pack(); // Adjusts the size of the dialog based on its components
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_SelectActionPerformed

    private void RUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUNActionPerformed
        // TODO add your handling code here:
    	
    	//Vérification si la liste de protéine possède des protéines
    	boolean hasProteines = true;
    	for (String nomProteine : this.ProteinesChoisies) {
    	    if (nomProteine == null) {
    	        hasProteines = false;
    	        break; // Pas besoin de vérifier les autres éléments, sortez de la boucle
    	    }
    	}
    	
    	if (hasProteines) {
    		
    	    String[] copy = this.ProteinesChoisies.clone();
    	    Running dialog = new Running(copy);
    	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	    dialog.pack(); // Adjusts the size of the dialog based on its components

    	    // Redimension de la cellule
    	    dialog.getIllustration().initDIm(dialog.getIllustration().getWidth(), dialog.getIllustration().getHeight());
    	    dialog.getIllustration().getCellule().setHauteur(300);
    	    dialog.getIllustration().getCellule().setLargeur(300);

    	    dialog.setVisible(true);
    	    dialog.Lancer();
    	}
    	
    	
    }//GEN-LAST:event_RUNActionPerformed

    private void AjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddProteins dialog = new AddProteins();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.pack(); // Adjusts the size of the dialog based on its components
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_AjoutActionPerformed

    
    //Main
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logiciel().setVisible(true);
            }
        });
    }

    
}
