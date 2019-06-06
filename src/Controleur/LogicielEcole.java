/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import java.text.NumberFormat;

import Modèle.*;

/**
 *
 * @author anne-liseherve
 */
public class LogicielEcole extends JFrame implements ActionListener {

    Listes l1;
    JButton AjouterEleve, SupprimerEleve, Quitter;
    JPanel aPanelEleve, aPanelProf, aPanelEval, aPanelBulletin;
    JPanel Eleve1, Eleve2;
    JLabel ajoutel1, ajoutel2, ajoutel3;
    JTextField nomEleve, prenomEleve;
    JComboBox classeEleve;
    JTabbedPane tabbedPane;
    JTable jTable1;
    JScrollPane deroule; 
    JSeparator separe;
 

    public LogicielEcole() {
        
        l1= new Listes();
        l1.MAJ();
        //Boutton:
        AjouterEleve = new JButton("Ajouter un élève");
        AjouterEleve.addActionListener(this);
        SupprimerEleve= new JButton("Supprimer un élève");
        SupprimerEleve.addActionListener(this);
        Quitter = new JButton("Quitter");
        Quitter.addActionListener(this);
        
        //Panel:
        
        aPanelEleve = new JPanel();
        aPanelProf = new JPanel();
        aPanelBulletin = new JPanel();
        aPanelEval = new JPanel();
     
       //Separator
       separe = new JSeparator();
 
        //Label:
       ajoutel1 = new JLabel("AJOUT D'UN ELEVE");
       ajoutel2 = new JLabel("Nom:");
       ajoutel3 = new JLabel("Prenom:");
        //Champ de saisi:
        nomEleve = new JTextField(20);
        prenomEleve = new JTextField(20);

        //Bar d'onglets:
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        //Combo box:
        classeEleve= new JComboBox();
        
    }

    public void Initialiser() {

        this.addWindowListener(new WindowAdapter() {
        });
        tabbedPane.addTab("Elèves", aPanelEleve);
        tabbedPane.addTab("Prof", aPanelProf);
        tabbedPane.addTab("Notes", aPanelEval);
        tabbedPane.addTab("Bulletins", aPanelBulletin);
           
         Object[][] data = new Object[l1.getPersonne().size()][2];

         int j=0;
        for (int i=0; i < l1.getPersonne().size(); i++){
            if (l1.getPersonne().get(i).getType().equals("Eleve")){
            data[j][0] = l1.getPersonne().get(i).getNom();
            data[j][1] = l1.getPersonne().get(i).getPrenom();
            ++j;}
           
        }
          
        String  title[] = {"Nom", "Prenom"};
        jTable1= new JTable(data, title);
        
           jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           deroule= new JScrollPane(jTable1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
     
        
        //PANEL ELEVES
     
        aPanelEleve.removeAll();
        aPanelEleve.add(ajoutel1);
        aPanelEleve.add(ajoutel2);
        aPanelEleve.add(ajoutel3);
        aPanelEleve.add(deroule);
        aPanelEleve.add(AjouterEleve);
        aPanelEleve.add(SupprimerEleve);
        aPanelEleve.add(Quitter);

        AjouterEleve.addActionListener(this);
        Quitter.addActionListener(this);
    
        //aPanelEleve.setLayout(new GridLayout(12, 1));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(aPanelEleve);
        aPanelEleve.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deroule, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajoutel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classeEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutel2)
                    .addComponent(AjouterEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(SupprimerEleve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Quitter)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajoutel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prenomEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ajoutel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classeEleve, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AjouterEleve)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(deroule, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupprimerEleve)
                    .addComponent(Quitter))
                .addGap(0, 32, Short.MAX_VALUE))
        );


        // et on place le panel dans la frame
        Container contentPane = this.getContentPane();
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        
        
        // affichage de la fenetre
        this.pack();
        this.setVisible(true);

    }

    public static void main(String s[]) {

        LogicielEcole e1 = new LogicielEcole();
        e1.Initialiser();

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == Quitter) {
            System.exit(0);
        }
        else if (source == SupprimerEleve)
        {
        
        }
    }

}
