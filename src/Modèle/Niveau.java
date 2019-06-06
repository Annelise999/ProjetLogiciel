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
public class Niveau {
    private int id;
    private String nom;
    
    
    public Niveau( int i, String s)
    {
    id= i;
    nom=s;
    }
    
    public int getId (){
    return id;
    }
    
    public String getNom (){
    return nom;
    }
           
}

