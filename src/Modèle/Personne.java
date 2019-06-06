/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author Clara Sapoval
 */
public class Personne {
      private int id;
      private String nom; 
      private String prenom; 
        private String type;
   
   public Personne (int i, String n, String p, String t){
       id = i;
       nom = n;
       prenom = p;
       type = t;
   }
   
   public int getId()
   {
   return id;
   }
   
   public String getNom()
   {
   return nom;
   }
      public String getPrenom()
   {
   return prenom;
   }
      
         public String getType()
   {
   return type;
   }
}
