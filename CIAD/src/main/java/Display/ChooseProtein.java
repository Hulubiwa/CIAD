/*
 * nom         : ChooseProtein
 * 
 * description : Cette classe hérite de la classe JDialog, elle a pour rôle de permettre 
 * 				 à l'utilisateur de choisir dans la base de données les deux protéines
 *               dont il souhaite voir la collision
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Display;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BaseDeDonnees.SQLiteDBManager;



public class ChooseProtein extends javax.swing.JDialog {

	
	// Attributs
    private javax.swing.JButton Bouton1;
    private javax.swing.JButton Bouton2;
    private javax.swing.JButton Bouton3;
    private javax.swing.JButton Bouton4;
    private javax.swing.JButton Bouton5;
    private javax.swing.JButton Bouton6;
    private javax.swing.JButton Bouton7;
    private javax.swing.JButton Bouton8;
    private javax.swing.JButton Bouton9;
    private javax.swing.JButton BoutonAll;
    private javax.swing.JLabel LabelProtein1;
    private javax.swing.JLabel LabelProtein2;
    private javax.swing.JList<String> ListeProteins1;
    private javax.swing.JList<String> ListeProteins2;
    private javax.swing.JToggleButton Next;
    private javax.swing.JToggleButton Past;
    private javax.swing.JTextField ProteineCherche;
    private javax.swing.JButton Search;
    private javax.swing.JButton Finish;
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
  
  	private Logiciel logiciel;
  	private String[] Choix;
	
    //Constructeur
    public ChooseProtein(Logiciel Log) {
        initComponents();
        this.Choix = new String[]{"Protein 1","Protein 2"};
        this.logiciel = Log;
        
    }

    //Methodes
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ProteineCherche = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        Bouton1 = new javax.swing.JButton();
        Bouton2 = new javax.swing.JButton();
        Bouton3 = new javax.swing.JButton();
        Bouton5 = new javax.swing.JButton();
        Bouton4 = new javax.swing.JButton();
        Bouton6 = new javax.swing.JButton();
        Bouton7 = new javax.swing.JButton();
        Bouton8 = new javax.swing.JButton();
        Bouton9 = new javax.swing.JButton();
        Past = new javax.swing.JToggleButton();
        Next = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeProteins1 = new javax.swing.JList<>();
        BoutonAll = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Finish = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListeProteins2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LabelProtein1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelProtein2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        ProteineCherche.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProteineCherche.setText("Search");

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        Search.setBorder(null);
        Search.setBorderPainted(false);
        Search.setContentAreaFilled(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Bouton1.setText("A");
        Bouton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton1ActionPerformed(evt);
            }
        });

        Bouton2.setText("B");
        Bouton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton2ActionPerformed(evt);
            }
        });

        Bouton3.setText("C");
        Bouton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton3ActionPerformed(evt);
            }
        });

        Bouton5.setText("E");
        Bouton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton5ActionPerformed(evt);
            }
        });

        Bouton4.setText("D");
        Bouton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton4ActionPerformed(evt);
            }
        });

        Bouton6.setText("F");
        Bouton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton6ActionPerformed(evt);
            }
        });

        Bouton7.setText("G");
        Bouton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton7ActionPerformed(evt);
            }
        });

        Bouton8.setText("H");
        Bouton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton8ActionPerformed(evt);
            }
        });

        Bouton9.setText("...");
        Bouton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Bouton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton9ActionPerformed(evt);
            }
        });

        Past.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Past.png"))); // NOI18N
        Past.setBorder(null);
        Past.setBorderPainted(false);
        Past.setContentAreaFilled(false);
        Past.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastActionPerformed(evt);
            }
        });

        Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Next.png"))); // NOI18N
        Next.setBorder(null);
        Next.setBorderPainted(false);
        Next.setContentAreaFilled(false);
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

/////// LISTE DE PROTEINES 1 
        
        jScrollPane1.setBorder(null);

        ListeProteins1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        //initialisation des listes ProteinA et ProteinB
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP1 = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP1) {
            listModel.addElement(protein);
        }
        ListeProteins1.setModel(listModel);
        
        //L'utilisateur ne peut slectionner qu'un seule élément
        ListeProteins1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListeProteins1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ChoixListe1(e);
            }
        });
        jScrollPane1.setViewportView(ListeProteins1);

        
/////// FIN LISTE DE PROTEINES 1 

        BoutonAll.setText("All");
        BoutonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAllActionPerformed(evt);
            }
        });

        Finish.setText("Finish");
        Finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	FinishActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CancelActionPerformed(evt);
            }
        });
        
/////// LISTE DE PROTEINES 2 

        jScrollPane2.setBorder(null);

        ListeProteins2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        //initialisation de la liste de ProteinA
        ListeProteins2.setModel(listModel);
        
        //L'utilisateur ne peut slectionner qu'un seule élément
        ListeProteins2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListeProteins2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ChoixListe2(e);
            }
        });
        jScrollPane2.setViewportView(ListeProteins2);


        
  /////// FIN LISTE DE PROTEINES 2 

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel1.setText("Protein 1");

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel3.setText("Protein 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ProteineCherche, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Past, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bouton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bouton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bouton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoutonAll)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Bouton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bouton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bouton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bouton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bouton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Bouton9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Finish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancel))
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProteineCherche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bouton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Past, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BoutonAll)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancel)
                        .addComponent(Finish)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        LabelProtein1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        LabelProtein1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelProtein1.setText("Protein 1");
        jPanel3.add(LabelProtein1);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VS.png"))); // NOI18N
        jPanel3.add(jLabel5);

        LabelProtein2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        LabelProtein2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
        LabelProtein2.setText("Protein 2");
        jPanel3.add(LabelProtein2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Select-Proteins.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents
   
    /*
     * Cette fonction vérifie si l'utilisateur à correctement choisi deux protéines.
     */
    private boolean ChoixValide() {
    	return !(this.Choix[0].equals("Protein 1")  || this.Choix[1].equals("Protein 2"));
    }
    
    //Evènements
    private void FinishActionPerformed(ActionEvent evt) {
    	if(ChoixValide()) {
    		this.logiciel.setProteinesChoisies(Choix);
    		this.logiciel.Proteine1.setText(Choix[0]);
    		this.logiciel.Proteine2.setText(Choix[1]);
    		
    		this.dispose();
    	}
    }
    
    private void CancelActionPerformed(ActionEvent evt) {
    	this.dispose();
    }
    
    private void SetBoutonAphabet(String code) {
    	
    	switch(code) {
    	
    	//Cas 1
    	case "I":
    		Bouton1.setText("A");
    		Bouton2.setText("B");
    		Bouton3.setText("C");
    		Bouton4.setText("D");
    		Bouton5.setText("E");
    		Bouton6.setText("F");
    		Bouton7.setText("G");
    		Bouton8.setText("H");
    		Bouton9.setText("...");
    		break;
    	
		//Cas 2
    	case "H":
    	case "P":
    		Bouton1.setText("...");
    		Bouton2.setText("I");
    		Bouton3.setText("J");
    		Bouton4.setText("K");
    		Bouton5.setText("L");
    		Bouton6.setText("M");
    		Bouton7.setText("N");
    		Bouton8.setText("O");
    		Bouton9.setText("...");
    		break;
    	
		//Cas 3
    	case "O":
    	case "W":
    		Bouton1.setText("...");
    		Bouton2.setText("P");
    		Bouton3.setText("Q");
    		Bouton4.setText("R");
    		Bouton5.setText("S");
    		Bouton6.setText("T");
    		Bouton7.setText("U");
    		Bouton8.setText("V");
    		Bouton9.setText("...");
    		Bouton6.setVisible(true);
    		Bouton7.setVisible(true);
    		Bouton8.setVisible(true);
    		Bouton9.setVisible(true);
    		Next.setVisible(true);
    		break;
    		
		//Cas 4
    	case "V":
    		Bouton1.setText("...");
    		Bouton2.setText("W");
    		Bouton3.setText("X");
    		Bouton4.setText("Y");
    		Bouton5.setText("Z");
    		Bouton6.setVisible(false);
    		Bouton7.setVisible(false);
    		Bouton8.setVisible(false);
    		Bouton9.setVisible(false);
    		Next.setVisible(false);
    		break;
    	
    	}
    	
    }

    private void BoutonAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAllActionPerformed
    	//initialisation des listes ProteinA et ProteinB
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
            listModel.addElement(protein);
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    	
    }//GEN-LAST:event_BoutonAllActionPerformed

    private void Bouton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton9ActionPerformed
        String text = Bouton9.getText();
        if(text.equals("...")) {
        	SetBoutonAphabet(Bouton8.getText());
        }
        else {
        	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
            ArrayList<String> Donnee = SQLiteDBManager.getProteines();
            String[] ListP = Donnee.toArray(new String[0]);
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String protein : ListP) {
            	if(protein.charAt(0) == text.charAt(0) || protein.charAt(0) == text.charAt(0)) {
            		listModel.addElement(protein);
            	}
            }
            ListeProteins1.setModel(listModel);
            ListeProteins2.setModel(listModel);
        }
    }//GEN-LAST:event_Bouton9ActionPerformed

    private void Bouton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton8ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton8.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton8ActionPerformed

    private void Bouton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton7ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton7.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton7ActionPerformed

    private void Bouton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton6ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton6.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton6ActionPerformed

    private void Bouton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton4ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton4.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton4ActionPerformed

    private void Bouton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton5ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton5.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton5ActionPerformed

    private void Bouton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton3ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton3.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton3ActionPerformed

    private void Bouton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton2ActionPerformed
    	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
    	String lettre = Bouton2.getText();
        ArrayList<String> Donnee = SQLiteDBManager.getProteines();
        String[] ListP = Donnee.toArray(new String[0]);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String protein : ListP) {
        	if(protein.charAt(0) == lettre.charAt(0) || protein.charAt(0) == lettre.charAt(0)) {
        		listModel.addElement(protein);
        	}
        }
        ListeProteins1.setModel(listModel);
        ListeProteins2.setModel(listModel);
    }//GEN-LAST:event_Bouton2ActionPerformed

    private void Bouton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton1ActionPerformed
    	String text = Bouton1.getText();
        if(text.equals("...")) {
        	SetBoutonAphabet(Bouton2.getText());
        }
        else {
        	//Modification des listes ProteinA et ProteinB avec Les protéines commençant par la lettre écris sur le texte du bouton
            ArrayList<String> Donnee = SQLiteDBManager.getProteines();
            String[] ListP = Donnee.toArray(new String[0]);
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String protein : ListP) {
            	if(protein.charAt(0) == text.charAt(0) || protein.charAt(0) == text.charAt(0)) {
            		listModel.addElement(protein);
            	}
            }
            ListeProteins1.setModel(listModel);
            ListeProteins2.setModel(listModel);
        }
    }//GEN-LAST:event_Bouton1ActionPerformed
    
    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        	SetBoutonAphabet(Bouton8.getText());
    }//GEN-LAST:event_NextActionPerformed
    
    private void PastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastActionPerformed
    	SetBoutonAphabet(Bouton2.getText());
    }//GEN-LAST:event_PastActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProteineChercheActionPerformed
        // Recherche d'une proteine dans la liste
    	String nom = ProteineCherche.getText();
    	if(SQLiteDBManager.SearchProtein(nom)) {
    		// Proteine trouvée
    		if(LabelProtein1.getText().equals("Protein 1")) {
    			Choix[0] = nom;
                LabelProtein1.setText(nom);
    		}
    		else {
    			Choix[1] = nom;
                LabelProtein2.setText(nom);
    		}
    		
            ProteineCherche.setText("Protéine trouvée");
    	}
    	else {
    		ProteineCherche.setText("Aucune corresponadance");
    	}
    }//GEN-LAST:event_ProteineChercheActionPerformed

	private void ChoixListe1(ListSelectionEvent evt) {
		// Choix de la Proteine1
		
		if (!evt.getValueIsAdjusting()) {
            // Obtenez le nom sélectionné dans la JList
            String selectedName = ListeProteins1.getSelectedValue();
            Choix[0] = selectedName;
            LabelProtein1.setText(selectedName);
        }
	}

    private void ChoixListe2(ListSelectionEvent evt) {
    	// Choix de la Proteine2
		
		if (!evt.getValueIsAdjusting()) {
            // Obtenez le nom sélectionné dans la JList
            String selectedName = ListeProteins2.getSelectedValue();
            Choix[1] = selectedName;
            LabelProtein2.setText(selectedName);
        }
    }

    
}
