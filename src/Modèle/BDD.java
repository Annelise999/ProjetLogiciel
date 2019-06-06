/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author anne-liseherve
 */
public class BDD {

    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String CONN_STRING = "jdbc:mysql://localhost:8889/ProjetEcole";

    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;

    public static ArrayList<String> tables = new ArrayList<>();
    public ArrayList<String> requetes = new ArrayList<>();
    public ArrayList<String> requetesMaj = new ArrayList<>();

    public BDD() {
        conn = null;
        stmt = null;
        rset = null;
        rsetMeta = null;
    }

    public ArrayList<String> getTables() {
        return tables;
    }

    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public void remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        tables.add(champs);

        // Retourner l'ArrayList
        //return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     *
     * @param requete
     * @return
     * @throws java.sql.SQLException
     */
    public void remplirChampsRequete(String requete) throws SQLException {

// récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + ",\n";

            // ajouter les champs de la ligne dans l'ArrayList
            tables.add(champs);
        }

        // Retourner l'ArrayList
        //return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     *
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {

        conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        stmt = (Statement) conn.createStatement();
        stmt.executeUpdate(requeteMaj);
    }

    public ArrayList<String> RecupTables(String requete, String table) {
        //Remplir une table depuis la BDD
        //Connection BDD
        if (tables.isEmpty() == false) {
            tables.clear();
        }

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = (Statement) conn.createStatement();

            //Remplir les champs dans un ArrayList (Segado)
            // remplirChampsTable(table);
            //Remplir les valeurs des champs dans un ArrayList (Segado)
            remplirChampsRequete(requete + table);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tables;
    }

    public ArrayList<String> RecupRequete(String requete) {
        //Remplir une table depuis la BDD
        //Connection BDD
        if (tables.isEmpty() == false) {
            tables.clear();
        }

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = (Statement) conn.createStatement();

            //Remplir les champs dans un ArrayList (Segado)
            // remplirChampsTable(table);
            //Remplir les valeurs des champs dans un ArrayList (Segado)
            remplirChampsRequete(requete);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tables;
    }

    public static void main(String args[]) {
        BDD b1 = new BDD();

        //Ajouter un Niveau
        //Connection BDD
        try {

            b1.conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            b1.stmt = (Statement) b1.conn.createStatement();

            b1.executeUpdate("INSERT INTO ProjetEcole.Niveau (nom) VALUES ('Louis')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
