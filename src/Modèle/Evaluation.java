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
public class Evaluation {
    private int id; 
    private int idDetailBulletin;
    private int note;
    private String appreciation;
    
    public Evaluation (int i, int j, int k, String s)
    {
    id= i;
    idDetailBulletin = j;
    note = k;
    appreciation = s;
    }
}
