/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.GUI;

import com.mysql.jdbc.PerConnectionLRUFactory;
import edu.connexion4se3.entities.Personne;
import edu.connexion4se3.services.PersonneCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private Button btnsave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SavePerson(ActionEvent event) {
        try {
            String resNom = tfnom.getText();
            String resPrenom = tfprenom.getText();
            PersonneCRUD pcd=new PersonneCRUD();
            pcd.ajouterEntitee(new Personne(22, resNom, resPrenom));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsPerson.fxml"));//charger le fichier fxml
            Parent root = loader.load();
            DetailsPersonController dbc=loader.getController();//objet loader fih les donner taa fihier fxml(fark bin statement w preparedstatement check on it = )
            dbc.setDnom(resNom);
            dbc.setDprenom(resPrenom);
            tfnom.getScene().setRoot(root);//bch nbadel el page bel root hedha elli fih lpage jdida             Parent root = loader.load();

        } catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
