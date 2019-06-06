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
public class Inscription {
    private int id;
    private int idClasse;
    private int idPersonne;
    
    public Inscription (int i, int j, int k){
    id=i;
    idClasse = j;
    idPersonne = k;

    }
    
    public int getId()
    {
        return id;
    }
    
    public int getIdClasse()
    {
        return idClasse;
    }
    
    public int getIdPersonne()
    {
        return idPersonne;
    }
}
