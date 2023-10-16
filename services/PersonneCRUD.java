/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.services;


import edu.connexion4se3.utils.MyConnection;
import edu.connexion4se3.entities.Personne;
import edu.connexion4se3.interfaces.InterfaceCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karra
 */
public class PersonneCRUD implements InterfaceCRUD<Personne>{

//    public void ajouterEntitee(Personne t) {
//        try {
//            String requete = "INSERT INTO personne(nom, prenom)"
//                    + "VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
//            Statement st = new MyConnection().getCnx().createStatement();
//            st.executeUpdate(requete);
//            System.out.println("Done!");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    public void ajouterEntitee(Personne t) {
        try {
            String requete = "INSERT INTO personne(nom, prenom)"
                    + "VALUES (?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.executeUpdate();
            System.out.println("Done!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Personne> listeDesEntites() {
         List<Personne> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM personne";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
}
