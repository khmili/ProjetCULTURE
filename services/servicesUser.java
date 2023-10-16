package edu.connexion4se3.services;
import edu.connexion4se3.entities.Culture;
import edu.connexion4se3.entities.Personne;
import edu.connexion4se3.entities.User;
import edu.connexion4se3.interfaces.InterfaceCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.connexion4se3.utils.MyConnection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class servicesUser {
       Connection cnx ;

     public void ajouterEntitee(User p) {
        try {
            String requete = "INSERT INTO user ( cin, nom, prenom, mdp, mail, adresse, numtel, role) VALUES ( '09948040', 'souelmi1', 'thamer', 'azerty', 'thamer@esprit.tn', 'ariana', 50378582, 'admin');";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);


//            Statement st = new MyConnection().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("done ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
