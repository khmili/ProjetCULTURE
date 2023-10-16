/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import edu.connexion4se3.entities.category;
import edu.connexion4se3.entities.Culture;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import edu.connexion4se3.services.ServiceCategory;
import edu.connexion4se3.services.ServiceCulture;

/**
 * FXML Controller class
 *
 * @author 21692
 */
public class FXMLcategoryController implements Initializable {

    
    @FXML
    private TextField tfType;
    
        @FXML
    private TableView<category> tvCategory;
    
        @FXML
    private TableColumn<category, Integer> colId;
    @FXML
    private TableColumn<category, String> colType;
    
      @FXML
    private Button btnlogout;
        
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    
    
      @FXML
    private void handleMouseClicked(MouseEvent event) {
    }
                ServiceCategory se = new ServiceCategory();
             
    @FXML
    private Button btnclear;
    @FXML
    private Button imprimer;
        @FXML
    private TextField filterField;
    
    public FXMLcategoryController(){
        
    }
    
    
        public void show()
    {
    ObservableList<category> data = FXCollections.observableArrayList(se.getAll());
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colType.setCellValueFactory(new PropertyValueFactory("type"));
     //recherche avancée
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<category> filteredData = new FilteredList<>(data, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(category -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (category.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                    
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<category> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tvCategory.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tvCategory.setItems(sortedData);   
     
    }
        
              private void clear() {
        tvCategory.getSelectionModel().clearSelection();
        tfType.clear();
        btnInsert.setDisable(false);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
    }
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
                     tvCategory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (tvCategory.getSelectionModel().getSelectedItem() != null) {
                    category e = (category) tvCategory.getSelectionModel().getSelectedItem();
                    tfType.setText(e.getType());
                    btnInsert.setDisable(true);

                }
            }
        });
    }    
    
    
        @FXML
    private void Ajout(ActionEvent event) {

               if (tfType.getText() == null || tfType.getText().trim().isEmpty()) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez remplir le champ de type s'il vous plait!");
            dialogW.showAndWait();
        } else {
            
            category e = new category(tfType.getText());
            se.ajouter(e);
        }

       show();
        clear();
     Notification("category","Ajout avec success");   
        
        
        
        
    }
    
    
        public void Notification(String header,String msg){
	Platform.runLater(new Runnable() {
		@Override
		public void run() {
			Notifications notify = Notifications.create().title(header)
					.text(msg)
					.hideAfter(javafx.util.Duration.seconds(4))
					.position(Pos.BOTTOM_RIGHT);
			notify.darkStyle();
			notify.showInformation();
		}
	}); 


}
        
        
            @FXML
    private void Modifier(ActionEvent event) {
        if (tvCategory.getSelectionModel().getSelectedItem() != null) {
                        category e = new category(tvCategory.getSelectionModel().getSelectedItem().getId(),tfType.getText());

            se.modifier(e);
            
          ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setContentText("Voulez vous modifier cet category !!!");
        dialog.getDialogPane().getButtonTypes().add(okButtonType);
        dialog.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            if (tvCategory.getSelectionModel().getSelectedItem() != null) {
                JOptionPane.showMessageDialog(null, "Category modifiee");
               
             }
             
 
            
            
            show();
            }
        
            clear();
           
          } else {
            System.out.println("Cancel");
        }  
            
            
            Notification("category","modif avec success");   

        }
    
        @FXML
    private void Delete(ActionEvent event) {
        ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setContentText("Voulez vous supprimé cet category !!!");
        dialog.getDialogPane().getButtonTypes().add(okButtonType);
        dialog.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            if (tvCategory.getSelectionModel().getSelectedItem() != null) {
                JOptionPane.showMessageDialog(null, "Evenement Supprimee");
                se.supprimer(tvCategory.getSelectionModel().getSelectedItem().getId());
              show();
            }
            clear();
        } else {
            System.out.println("Cancel");
        }
    }
    
        @FXML
    private void Clear(ActionEvent event) {
        clear();
    }
    @FXML
    private void OnClickedPrint(ActionEvent event) {
          
       PrinterJob job = PrinterJob.createPrinterJob();
       
       Node root= this.tvCategory;
       
       
     if(job != null){
         


        job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage

    Printer printer = job.getPrinter();
    PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
        
    }
   
     }
   
    }
    
}
