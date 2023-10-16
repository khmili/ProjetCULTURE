/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.management.relation.Role;

/**
 *
 * @author User
 */
public class ServiceCulture {
    
   Connection cnx ;
    
        public ServiceCulture() {
        cnx = MyConnection.getInstance().getInstance().getCnx();
}
    
    



 
     public List <Culture> getAll() {
ObservableList<Culture> myList = FXCollections.observableArrayList();
    String requete=null;
        try {
//            requete = "SELECT * FROM culture e inner join category c on e.category_id = c.id";
            requete = "SELECT * FROM culture e inner join category c on e.category_id = c.id inner join user u on e.user_id=u.userId;";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
            Culture e = new Culture();
            User user = new User();
            e.setId(rs.getInt("id"));
            e.setLibelle(rs.getString("libelle"));
            e.setDateRecolte(rs.getDate("dateRecolte"));
            e.setDatePlantation(rs.getDate("datePlantation"));
            e.setCategory_id(rs.getInt("category_id"));
            e.setCategory_type(rs.getString("type"));
            e.setRevenuesCultures(rs.getDouble("revenuesCultures"));
            e.setCoutsPlantations(rs.getDouble("coutsPlantations"));
            user.setUser_id(rs.getInt("user_id"));
            user.setNom(rs.getString("nom"));
user.setRole(User.Role.valueOf(rs.getString("role")));
            e.setUser(user);

            myList.add(e);
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
   
      return myList;
    }
     //////////////////////////IN PROGRESS/////////////////////////////////
          public List <Culture> getAllbyca() {
ObservableList<Culture> myList = FXCollections.observableArrayList();
    String requete=null;
        try {
            requete = "SELECT * FROM culture e inner join category c on e.category_id = c.id ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
            Culture e = new Culture();
            e.setId(rs.getInt(1));
            e.setLibelle(rs.getString("nom"));
            e.setDateRecolte(rs.getDate("dateRecolte"));
            e.setDatePlantation(rs.getDate("datePlantation"));
            
            
//            e.setZo(rs.getString("nom"));
//            e.setDate_debut(rs.getDate("date_debut"));
//            e.setDate_fin(rs.getDate("date_fin"));
//            e.setLieu(rs.getString("lieu"));
//            e.setDetails(rs.getString("details"));
//            e.setImage(rs.getString("image"));
            e.setCategory_type(rs.getString("type"));

            myList.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
   
      return myList;
    }     
          
 //////////////////////////////////////////////////////////////////////////         
    public void modifier(Culture e) {
        System.out.print(e);
try {
            String requete3 = "UPDATE `culture` SET `libelle`=?,`dateRecolte`=?,`datePlantation`=?, `category_id` =?,`revenuesCultures`=?,`coutsPlantations`=?  WHERE id=?";
            
            PreparedStatement pst = cnx.prepareStatement(requete3);
            pst.setString(1, e.getLibelle());
            pst.setDate(2, e.getDateRecolte());
            pst.setDate(3, e.getDatePlantation());
            pst.setInt(4,e.getCategory_id());
            pst.setDouble(5,e.getRevenuesCultures());
            pst.setDouble(6,e.getCoutsPlantations());
            
            pst.setInt(7,e.getId());
            pst.executeUpdate();
            System.out.println("Event updated");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }  
    }


    public void supprimer(int id) {
 try {
            String requete = "DELETE FROM culture WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
    }
    }

   
    public Culture getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ajouter(Culture e,User user) {
        System.out.println(e);
           try {
            String requete2 = "INSERT INTO `culture`( `libelle`, `datePlantation`, `dateRecolte`, `category_id`, `revenuesCultures`, `coutsPlantations`, `user_id`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete2);
            pst.setString(1, e.getLibelle());
            pst.setDate(2, e.getDateRecolte());
            pst.setDate(3, e.getDatePlantation());
            pst.setInt(4, e.getCategory_id()); 
            pst.setDouble(5, e.getRevenuesCultures());
            pst.setDouble(6, e.getCoutsPlantations());
            pst.setInt(7, user.getUser_id());

            String req="";
            pst.executeUpdate();
            System.out.println("Event added");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
        
    }
}

