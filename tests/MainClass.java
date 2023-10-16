/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.tests;


import edu.connexion4se3.utils.MyConnection;
import edu.connexion4se3.entities.Personne;
import edu.connexion4se3.entities.Culture;
import edu.connexion4se3.entities.User;
import edu.connexion4se3.entities.category;
import edu.connexion4se3.services.ServiceCulture;
import edu.connexion4se3.services.PersonneCRUD;
import edu.connexion4se3.services.ServiceCategory;
import edu.connexion4se3.services.servicesUser;
import java.util.ArrayList;
import java.util.List;

///**
// *
// * @author karra
// */
//public class MainClass {
//    public static void main(String[] args) {
//        //MyConnection mc = new MyConnection();
//        Personne p = new Personne(22, "Esprit", "Ariana");
//        PersonneCRUD pcd = new PersonneCRUD();
//        pcd.ajouterEntitee(p);
//    }
//}
/*----------------------TEST CULTURE-----------------*/
public class MainClass {
    public static void main(String[] args) {    
        /*---------------------------AJOUTER-*******************************/
         ServiceCulture cultureService = new ServiceCulture();

//   Culture nouvelAvis = new Culture();
//            category restaurant = new category();
//            User user = new User();
//        nouvelAvis.setLibelle(" ALLAH لله");
//        nouvelAvis.setDateRecolte(java.sql.Date.valueOf("2023-10-01"));
//        nouvelAvis.setDatePlantation(java.sql.Date.valueOf("2023-09-20"));
//        nouvelAvis.setCategory_id(2); // Replace with the actual category ID
//        nouvelAvis.setRevenuesCultures(12.2);
//        nouvelAvis.setCoutsPlantations(12.7);
//        user.setUser_id(1);
//            try {
//               
//                cultureService.ajouter(nouvelAvis,user);
//                  
//         
//
//        
//
//            }catch(Exception e)
//            {
//                System.out.println("err est "+e.getMessage());
//            
//            }

//   *--------------------Modify the culture*****************************/

//Culture cultureToUpdate = new Culture();
//        cultureToUpdate.setId(3); 
//        cultureToUpdate.setLibelle("allah");
//        cultureToUpdate.setDateRecolte(java.sql.Date.valueOf("2023-10-01"));
//        cultureToUpdate.setDatePlantation(java.sql.Date.valueOf("2023-09-20"));
//        cultureToUpdate.setCategory_id(1);
//        cultureService.modifier(cultureToUpdate);


/*-----------SUPPRIMER***************/
//cultureService.supprimer(2);

        
        
        
 /*---------------------GETALL-------------------*/
// ServiceCulture cultureService = new ServiceCulture();

List<Culture> cultureList = new ArrayList<Culture>();
cultureList = cultureService.getAll();
for (Culture culture : cultureList) {
    System.out.println("ID: " + culture.getId());
    System.out.println("*--------------------------------------*");
    System.out.println("Libelle: " + culture.getLibelle());
    System.out.println("*--------------------------------------*");
    System.out.println("Date Plantation: " + culture.getDatePlantation());
    System.out.println("*--------------------------------------*");
    System.out.println("Date Recolte: " + culture.getDateRecolte());
    System.out.println("*--------------------------------------*");
    System.out.println("Category ID: " + culture.getCategory_id());
    System.out.println("*--------------------------------------*");
    System.out.println("Category Type: " + culture.getCategory_type());
    System.out.println("*--------------------------------------*");
    System.out.println("Revenue Plantations: " + culture.getRevenuesCultures());
    System.out.println("*--------------------------------------*");
    System.out.println("Couts Plantations: " + culture.getCoutsPlantations());
    System.out.println("*--------------------------------------*");

    // Vérifiez si la culture a un utilisateur associé
    User user = culture.getUser();
    if (user != null) {
        System.out.println("User ID: " + user.getUser_id());
        System.out.println("User Nom: " + user.getNom());
        System.out.println("User Nom: " + user.getRole());
        
    } else {
        System.out.println("Aucun utilisateur associé à cette culture.");
    }

    System.out.println("*--------------------------------------*");
    System.out.println(); // Ajoute une ligne vide pour séparer les éléments
}


//        List<Culture> cultureList = new ArrayList<Culture>();
//        cultureList = cultureService.getAll();
//        for (Culture culture : cultureList) {
//    System.out.println("ID: " + culture.getId());
//            System.out.println("*--------------------------------------*");
//    System.out.println("Libelle: " + culture.getLibelle());
//                System.out.println("*--------------------------------------*");
//    System.out.println("Date Plantation: " + culture.getDatePlantation());
//                System.out.println("*--------------------------------------*");
//    System.out.println("Date Recolte: " + culture.getDateRecolte());
//    System.out.println("*--------------------------------------*");
//    System.out.println("Category ID: " + culture.getCategory_id());
//    System.out.println("*--------------------------------------*");
//    System.out.println("Category Type: " + culture.getCategory_type());
//    System.out.println("*--------------------------------------*");
//    System.out.println("Revenue Plantations: " + culture.getRevenuesCultures());
//    System.out.println("*--------------------------------------*");
//    System.out.println("Couts Plantations: " + culture.getCoutsPlantations());
//    System.out.println("*--------------------------------------*");
//    System.out.println("User ID: " + culture.getUser().getUser_id()+"/**/"+culture.getUser().getNom());
//    System.out.println("*--------------------------------------*");
//    System.out.println(); // Ajoute une ligne vide pour séparer les éléments
//}             

     }
}
