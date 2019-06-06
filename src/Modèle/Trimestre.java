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
public class Trimestre {
    
        
    private int id;
    private int numero;
    private int debut; 
    private int fin;
    private int idAnneeScolaire;
    
    
    public Trimestre(int i, int n, int d, int f, int ia){
        id = i;
        numero = n;
        debut = d;
        fin = f; 
        idAnneeScolaire = ia;
    }
}