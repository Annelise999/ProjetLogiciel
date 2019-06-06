package Controleur;

import Modèle.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marioyammine
 */
public class Listes {

    public ArrayList<AnneeScolaire> a_anneescolaire;
    public ArrayList<Bulletin> a_bulletin;
    public ArrayList<Classe> a_classe;
    public ArrayList<DetailBulletin> a_detailbulletin;
    public ArrayList<Discipline> a_discipline;
    public ArrayList<Enseignement> a_enseignement;
    public ArrayList<Evaluation> a_evaluation;
    public ArrayList<Inscription> a_inscription;
    public ArrayList<Niveau> a_niveaux;
    public ArrayList<Personne> a_personne;
    public ArrayList<Trimestre> a_trimestre;

    public BDD b1;
    public ArrayList<String> tmp;

    public Listes() {

        a_anneescolaire = new ArrayList();
        a_bulletin = new ArrayList();
        a_classe = new ArrayList();
        a_detailbulletin = new ArrayList();
        a_discipline = new ArrayList();
        a_enseignement = new ArrayList();
        a_evaluation = new ArrayList();
        a_inscription = new ArrayList();
        a_niveaux = new ArrayList();
        a_personne = new ArrayList();
        a_trimestre = new ArrayList();
        tmp = new ArrayList();
        b1 = new BDD();
    }

    
     public ArrayList<Personne> getPersonne ()
    {
    return a_personne;
    }
     
     public ArrayList<Classe> getClasse ()
    {
    return a_classe;
    }
    
    public void MAJ() {

        int i;

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "AnneeScolaire");
        if (a_anneescolaire.isEmpty() == false) {
            a_anneescolaire.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts = tmp.get(i).split(",");
            int id = Integer.parseInt(parts[0]);
            a_anneescolaire.add(new AnneeScolaire(id));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Bulletin");
        if (a_bulletin.isEmpty() == false) {
            a_bulletin.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts2 = tmp.get(i).split(",");
            int id2 = Integer.parseInt(parts2[0]);
            int id3 = Integer.parseInt(parts2[1]);
            int id4 = Integer.parseInt(parts2[2]);
            float id5 = Float.parseFloat(parts2[4]);
            a_bulletin.add(new Bulletin(id2, id3, id4, parts2[3], id5));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Classe");
        if (a_classe.isEmpty() == false) {
            a_classe.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts3 = tmp.get(i).split(",");
            int id5 = Integer.parseInt(parts3[0]);
            int id6 = Integer.parseInt(parts3[2]);
            int id7 = Integer.parseInt(parts3[3]);
            a_classe.add(new Classe(id5, parts3[1], id6, id7));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Niveau");
        if (a_niveaux.isEmpty() == false) {
            a_niveaux.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts4 = tmp.get(i).split(",");
            int id8 = Integer.parseInt(parts4[0]);
            a_niveaux.add(new Niveau(id8, parts4[1]));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "DetailBulletin");
        if (a_detailbulletin.isEmpty() == false) {
            a_detailbulletin.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts5 = tmp.get(i).split(",");
            int id9 = Integer.parseInt(parts5[0]);
            int id10 = Integer.parseInt(parts5[1]);
            int id11 = Integer.parseInt(parts5[2]);
            float id12 = Float.parseFloat(parts5[4]);
            a_detailbulletin.add(new DetailBulletin(id9, id10, id11, parts5[3], id12));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Discipline");
        if (a_discipline.isEmpty() == false) {
            a_discipline.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts6 = tmp.get(i).split(",");
            int id12 = Integer.parseInt(parts6[0]);
            a_discipline.add(new Discipline(id12, parts6[1]));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Enseignement");
        if (a_enseignement.isEmpty() == false) {
            a_enseignement.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts7 = tmp.get(i).split(",");
            int id13 = Integer.parseInt(parts7[0]);
            int id14 = Integer.parseInt(parts7[1]);
            int id15 = Integer.parseInt(parts7[2]);
            int id16 = Integer.parseInt(parts7[3]);
            a_enseignement.add(new Enseignement(id13, id14, id15, id16));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Evaluation");
        if (a_evaluation.isEmpty() == false) {
            a_evaluation.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts8 = tmp.get(i).split(",");
            int id17 = Integer.parseInt(parts8[0]);
            int id18 = Integer.parseInt(parts8[1]);
            int id19 = Integer.parseInt(parts8[2]);
            a_evaluation.add(new Evaluation(id17, id18, id19, parts8[3]));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "inscription");
        if (a_inscription.isEmpty() == false) {
            a_inscription.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] parts9 = tmp.get(i).split(",");
            int id20 = Integer.parseInt(parts9[0]);
            int id21 = Integer.parseInt(parts9[1]);
            int id22 = Integer.parseInt(parts9[2]);
            a_inscription.add(new Inscription(id20, id21, id22));
        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Trimestre");
        if (a_trimestre.isEmpty() == false) {
            a_trimestre.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] part1 = tmp.get(i).split(",");
            int i1 = Integer.parseInt(part1[0]);
            int i2 = Integer.parseInt(part1[1]);
            int i3 = Integer.parseInt(part1[2]);
            int i4 = Integer.parseInt(part1[3]);
            int i5 = Integer.parseInt(part1[4]);
            a_trimestre.add(new Trimestre(i1, i2, i3, i4, i5));

        }

        tmp = b1.RecupTables("SELECT * FROM ProjetEcole.", "Personne");
        if (a_personne.isEmpty() == false) {
            a_personne.clear();
        }
        for (i = 0; i < tmp.size(); i++) {
            String[] part2 = tmp.get(i).split(",");
            int i6 = Integer.parseInt(part2[0]);
            a_personne.add(new Personne(i6, part2[1], part2[2], part2[3]));

        }

    }

    public void AjouterProf(String nom, String prenom) {
        try {

            b1.executeUpdate("INSERT INTO ProjetEcole.Personne (nom,prenom,type) VALUES ('" + nom + "' , '" + prenom + "' , 'Prof' )");
            MAJ();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void AjouterEleve(String nom, String prenom, String classe) {
        try {

            b1.executeUpdate("INSERT INTO ProjetEcole.Personne (nom,prenom,type) VALUES ('" + nom + "' , '" + prenom + "' , 'Eleve' )");
            MAJ();
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]); //on récupère l'idée de la classe
            int range = a_personne.size() -1 ; 
            int idEl = a_personne.get(range).getId();
            b1.executeUpdate("INSERT INTO ProjetEcole.inscription (idClasse,idPersonne) VALUES ('" + idCl + "' , '" + idEl + "')");
            
            MAJ();
            int rangi = a_inscription.size() -1 ; 
            int idIns = a_inscription.get(rangi).getId();
            
            b1.executeUpdate("INSERT INTO ProjetEcole.Bulletin (idTrimestre, idInscription, appreciation, moyenne) VALUES ('1', '"+idIns+"', '', '0.0')");
            MAJ();
    
            int rangb = a_bulletin.size() -1 ; 
            int idBul = a_bulletin.get(rangb).getId();
            
            for(int i=1; i<6; i++){
                
                b1.executeUpdate("INSERT INTO ProjetEcole.DetailBulletin (idBulletin, idEnseignement, appreciation, moyenne) VALUES ('"+idBul+"', '"+i+"', '', '0.0')");
        
            }
            MAJ();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void SupprimerPersonne(String nom, String prenom) {
        try {
            b1.executeUpdate("DELETE FROM ProjetEcole.Personne WHERE nom = '"+nom+"' AND prenom = '"+prenom+"'");
            MAJ();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void AfficherClasse(int classe) {
        
        tmp=b1.RecupRequete("SELECT prenom,nom,idClasse FROM ProjetEcole.Personne INNER JOIN ProjetEcole.inscription ON ProjetEcole.Personne.id = inscription.idPersonne WHERE inscription.idClasse = ' "+classe+" ' ");
        for (int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i));
        }

    }
    
     public void RechercherPersonne (String nom, String prenom, String type){
    for (int i = 0; i < a_personne.size(); i++) {
        if (a_personne.get(i).getNom() == nom && a_personne.get(i).getPrenom() == prenom && a_personne.get(i).getType() == type )
        {System.out.println(a_personne.get(i).getId() + " " + a_personne.get(i).getNom() + " " + a_personne.get(i).getPrenom() + " " + a_personne.get(i).getType());}
    }
        }
    
    
    public void ModifierEleve(int id, String nom, String prenom, String classe ){
        
        try{
            b1.executeUpdate("UPDATE ProjetEcole.Personne SET nom = '"+nom+"', prenom = '"+prenom+"' WHERE Personne.id = '"+id+"' ");
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]);
            b1.executeUpdate("UPDATE ProjetEcole.inscription SET idClasse = '"+idCl+"'  WHERE idPersonne = '"+id+"' ");
        MAJ();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       
    }
    public void AjouterCoursProf(int id, String classe, String discipline){
        try{
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Discipline WHERE nom = '"+ discipline + "' ");
            String[] idDisc = tmp.get(0).split(",");
            int idDi = Integer.parseInt(idDisc[0]);
            b1.executeUpdate("INSERT INTO ProjetEcole.Enseignement (idClasse, idDiscipline, idPersonne) VALUES ('"+idCl+"', '"+idDi+"', '"+id+"')");     
        MAJ();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
   
     public void AjouterEvaluation(int idEleve, String classe, String discipline, String appreciation, int note){
         
         try{
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]);
           tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Discipline WHERE nom = '"+ discipline + "' ");
            String[] idDisc = tmp.get(0).split(",");
            int idDi = Integer.parseInt(idDisc[0]);
           tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Enseignement WHERE idClasse = '"+idCl  + "' AND idDiscipline='"+idDi+"' ");
            String[] idEns = tmp.get(0).split(",");
            int idE = Integer.parseInt(idEns[0]);
          
            
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.inscription WHERE idPersonne = '"+idEleve+ "' ");
            String[] idIns = tmp.get(0).split(",");
            int idI = Integer.parseInt(idIns[0]);
            System.out.println(idI);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Bulletin WHERE idInscription = '"+idI+ "'");
            String[] idBul = tmp.get(0).split(",");
            int idB = Integer.parseInt(idBul[0]);
            
            
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.DetailBulletin WHERE idEnseignement = '"+idE+ "' AND idBulletin = '"+idB+"'");
            String[] idDebu = tmp.get(0).split(",");
            int idDB = Integer.parseInt(idDebu[0]);
            
            b1.executeUpdate("INSERT INTO ProjetEcole.Evaluation (idDetailBulletin, note, appreciation) VALUES ('"+idDB+"', '"+note+"', '"+appreciation+"')");
          MAJ();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
     }   
    

     public void EditerBulletin(String classe, String personne, String appreciationg, float moyenneg, String appreciation1, String appreciation2 ,String appreciation3 ,String appreciation4, String appreciation5, float moyenne, String discipline){
         try{
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Personne WHERE nom = '"+ personne + "' ");
            String[] idPers = tmp.get(0).split(",");
            int idP = Integer.parseInt(idPers[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.inscription WHERE idClasse = '"+idCl  + "' AND idPersonne='"+idP+"' ");
            String[] idIns = tmp.get(0).split(",");
            int idI = Integer.parseInt(idIns[0]);
            b1.executeUpdate("UPDATE ProjetEcole.Bulletin SET appreciation = '"+appreciationg+"', moyenne = '"+moyenneg+"' WHERE idInscription = '"+idI+ "' ");
            
            /*tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Bulletin WHERE idInscription = '"+idI+ "' ");
            String[] idBul = tmp.get(0).split(",");
            int idB = Integer.parseInt(idBul[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Discipline WHERE nom = '"+ discipline + "' ");
            String[] idDisc = tmp.get(0).split(",");
            int idDi = Integer.parseInt(idDisc[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Enseignement WHERE idClasse = '"+idCl+ "' AND idDiscipline='"+idDi+"' ");
            String[] idEns = tmp.get(0).split(",");
            int idE = Integer.parseInt(idEns[0]);
            
           
            b1.executeUpdate("UPDATE ProjetEcole.DetailBulletin SET idEnseignement = '"+idE+"', appreciation= '"+appreciation1+"', moyenne = '"+moyenne+"' WHERE idBulletin = '"+idB+"' AND idDiscipline = '"+idDi+"'");*/
           
             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
     }
         
         
         public void EditDetailBulletin(String discipline, String classe, String personne, String appreciation,int idEnseignement, String appreciation, float moyenne){
             try{
                  
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Classe WHERE nom = '"+ classe + "' ");
            String[] idClasse = tmp.get(0).split(",");
            int idCl = Integer.parseInt(idClasse[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Personne WHERE nom = '"+ personne + "' ");
            String[] idPers = tmp.get(0).split(",");
            int idP = Integer.parseInt(idPers[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.inscription WHERE idClasse = '"+idCl  + "' AND idPersonne='"+idP+"' ");
            String[] idIns = tmp.get(0).split(",");
            int idI = Integer.parseInt(idIns[0]);
                 
                 
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Bulletin WHERE idInscription = '"+idI+ "' ");
            String[] idBul = tmp.get(0).split(",");
            int idB = Integer.parseInt(idBul[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Discipline WHERE nom = '"+ discipline + "' ");
            String[] idDisc = tmp.get(0).split(",");
            int idDi = Integer.parseInt(idDisc[0]);
            tmp = b1.RecupRequete("SELECT id FROM ProjetEcole.Enseignement WHERE idClasse = '"+idCl+ "' AND idDiscipline='"+idDi+"' ");
            String[] idEns = tmp.get(0).split(",");
            int idE = Integer.parseInt(idEns[0]);
                 
            b1.executeUpdate("UPDATE ProjetEcole.DetailBulletin SET idEnseignement = '"+idE+"', appreciation= '"+appreciation+"', moyenne = '"+moyenne+"' WHERE idBulletin = '"+idB+"' AND idDiscipline = '"+idDi+"'");
                 
                 
                 MAJ();
         } catch (SQLException e) {
            System.out.println(e.getMessage());
     }
}  
     
    public static void main(String[] args) {
        Listes l1 = new Listes();
        l1.MAJ();
        
       //l1.AjouterEvaluation(45,"CP1", "Mathematiques", "bien", (int) 0.5);
          l1.EditerBulletin("CP1", "Sasit", "appreciationg", 0, "appreciation1", "appreciation2", "appreciation3", "appreciation4", "appreciation5", 0, "Mathematique");
        //l1.ModifierEleve(35,"Mario", "Lito", "CE12");
        //l1.AfficherClasse(5);
        //l1.AjouterEleve("Sasit", "Sarah", "CP1");
        //l1.AjouterCoursProf(38, "CP2", "Musique");
        //l1.SupprimerPersonne("Hina", "Manolo");
        for (int i = 0; i < l1.a_personne.size(); i++) {
            System.out.println(l1.a_personne.get(i).getId() + " " + l1.a_personne.get(i).getNom() + " " + l1.a_personne.get(i).getPrenom() + " " + l1.a_personne.get(i).getType());
        }
        
        
        

    }

}
