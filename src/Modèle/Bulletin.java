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
public class Bulletin {
    private int id;
    private int idTrimestre;
    private int idInscription;
    private String appreciation;
    private float moyenne;
    
    public Bulletin (int i, int j, int l, String s, float m)
    {
    id = i;
    idTrimestre= j;
    idInscription = l;
    appreciation = s;
    moyenne = m;
    }
}