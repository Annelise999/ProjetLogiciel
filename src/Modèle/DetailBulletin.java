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
public class DetailBulletin {
    private int id;
    private int idBulletin;
    private int idEnseignement;
    private String appreciation;
    private float moyenne;
    
    public DetailBulletin(int i, int j, int k, String s, float m)         
    {
    id= i;
    idBulletin = j;
    idEnseignement = k;
    appreciation = s;
    moyenne = m;
    }
}