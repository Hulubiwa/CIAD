/*
 * nom         : AddProteins
 * 
 * description : Cette classe hérite de la classe JDialog, elle a pour rôle d'ajouter une 
 *               protéine à la base de données.
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package Display;

import java.awt.event.ActionEvent;

import BaseDeDonnees.SQLiteDBManager;


public class AddProteins extends javax.swing.JDialog {
	
	
	// Attributs
    private javax.swing.JButton CANCEL;
    private javax.swing.JButton FINISH;
    private javax.swing.JButton InfoDivision;
    private javax.swing.JButton InfoFusion;
    private javax.swing.JLabel LabelAddProtein;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelDivision;
    private javax.swing.JLabel LabelFusion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField DivisionText;
    private javax.swing.JTextField FusionText;
    
    //Constructeur
    public AddProteins() {
        initComponents(); 
    }
    
    //Méthodes
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LabelName = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        LabelDivision = new javax.swing.JLabel();
        DivisionText = new javax.swing.JTextField();
        LabelFusion = new javax.swing.JLabel();
        FusionText = new javax.swing.JTextField();
        CANCEL = new javax.swing.JButton();
        FINISH = new javax.swing.JButton();
        InfoDivision = new javax.swing.JButton();
        InfoFusion = new javax.swing.JButton();
        LabelAddProtein = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        LabelName.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        LabelName.setText("Name");

        

        LabelDivision.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        LabelDivision.setText("Division");

        LabelFusion.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        LabelFusion.setText("Fusion");

        CANCEL.setText("Cancel");
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });

        FINISH.setText("Finish");
        FINISH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINISHActionPerformed(evt);
            }
        });


        InfoDivision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Question.png"))); // NOI18N
        InfoDivision.setBorder(null);
        InfoDivision.setBorderPainted(false);
        InfoDivision.setContentAreaFilled(false);

        InfoFusion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Question.png"))); // NOI18N
        InfoFusion.setBorder(null);
        InfoFusion.setBorderPainted(false);
        InfoFusion.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FINISH)
                .addGap(18, 18, 18)
                .addComponent(CANCEL)
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelName)
                        .addGap(18, 18, 18)
                        .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelFusion)
                        .addGap(18, 18, 18)
                        .addComponent(FusionText, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InfoFusion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelDivision)
                        .addGap(18, 18, 18)
                        .addComponent(DivisionText, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InfoDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDivision)
                    .addComponent(DivisionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InfoDivision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelFusion)
                        .addComponent(FusionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(InfoFusion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CANCEL)
                    .addComponent(FINISH))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        LabelAddProtein.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelAddProtein.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add-protein.png"))); // NOI18N
        LabelAddProtein.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        getContentPane().add(LabelAddProtein, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    //Evènements
    private void FINISHActionPerformed(ActionEvent evt) {
        if (validateInputFields()) {
            String name = NameText.getText();
            String division = DivisionText.getText();
            String fusion = FusionText.getText();
            
            SQLiteDBManager.AjoutProteine(name, division, fusion);
            this.dispose();
        }
    }

    private boolean validateInputFields() {
        String name = NameText.getText();
        String division = DivisionText.getText();
        String fusion = FusionText.getText();

        if (name.isEmpty() || (division.isEmpty() && fusion.isEmpty())) {
            // Afficher un message d'erreur ou une indication à l'utilisateur
            // ex. "Veuillez remplir tous les champs obligatoires."
            return false;
        }

        return true;
    }


	private void CANCELActionPerformed(ActionEvent evt) {
		this.dispose();
	}

    

}
