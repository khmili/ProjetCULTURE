/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion4se3.GUI;

import edu.connexion4se3.entities.category;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import edu.connexion4se3.entities.Culture; 
import edu.connexion4se3.entities.User;
import java.io.FileInputStream;
import java.io.InputStream;
import edu.connexion4se3.services.ServiceCulture;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import  javafx.print.PrinterJob ; 
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import org.apache.commons.lang3.RandomStringUtils;
import edu.connexion4se3.services.ServiceCategory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CultureController implements Initializable {

    @FXML
    private ImageView image_view;
  
    @FXML
    private TextField tfLibelle;
    @FXML
    private DatePicker tfDatePlantation;
        @FXML
    private DatePicker tfDateRecolte;
    @FXML
    private TextField tfCoutsPlantations;

    @FXML
    private TextField tfRevenuesCultures;
    
    
      @FXML
        ComboBox<category> cbType = new ComboBox<>();
    
       @FXML
    private TableView<Culture> tvCulture;

    
    @FXML
    private TableColumn<Culture, Integer> colId;
    @FXML
    private TableColumn<Culture, String> colLibelle;
    @FXML
    private TableColumn<Culture, String> colDateplantation;
        @FXML
    private TableColumn<Culture, String> colDaterecolte;

    @FXML
    private TableColumn<Culture, String> coldRevenueCultures;
    @FXML
    private TableColumn<Culture, String> colCoutsplantations;
    @FXML
    private TableColumn<Culture, String> colImage;
    
    
    
    
     @FXML
    private TableColumn<Culture, String> colType ;
    
    
    
    
    
    
    @FXML
  private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField filterField;
    @FXML
    private Button insert_image;
    @FXML
    private Label file_path;
                   @FXML
    private Label  txtUsername;
                                    @FXML
    private ImageView userImg;


   int type = 0;
    
        String pictureLink = "";

                ServiceCulture se = new ServiceCulture();
                             ServiceCategory sc = new ServiceCategory();

    @FXML
    private Button btnclear;
    @FXML
    private Button imprimer;
                   java.util.Date date = new java.util.Date();
 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @FXML
    private Button btnlogout;

    public CultureController() {
    }

    @FXML
    private Button categoryButton;  // Reference to the Category Page button

    @FXML
    private void navigateToCategory(ActionEvent event) throws IOException {
        // Load the Category page when the button is clicked
        Parent root = FXMLLoader.load(getClass().getResource("FXMLcategory.fxml"));
        Scene scene = categoryButton.getScene();
        scene.setRoot(root);
    }
 
    public void show()
    {
    ObservableList<Culture> data = FXCollections.observableArrayList(se.getALLbyIdUser(2));
    
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colLibelle.setCellValueFactory(new PropertyValueFactory("libelle"));
        colDateplantation.setCellValueFactory(new PropertyValueFactory("datePlantation"));
        colDaterecolte.setCellValueFactory(new PropertyValueFactory("dateRecolte"));
                coldRevenueCultures.setCellValueFactory(new PropertyValueFactory("revenuesCultures"));

        colCoutsplantations.setCellValueFactory(new PropertyValueFactory("coutsPlantations"));
//        colImage.setCellValueFactory(new PropertyValueFactory("image"));


         colType.setCellValueFactory(new PropertyValueFactory("category_type"));  
        tvCulture.setItems(data);
        
       
     //recherche avancée
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Culture> filteredData = new FilteredList<>(data, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(culture -> {
                // If filter text is empty, display all cultures.

                if (newValue  == null || newValue.isEmpty()) {
                    
                    return true;
                    
                }
               
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
               
                if (culture.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                    
                } else if (String.valueOf(culture.getCoutsPlantations()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                          } else if (String.valueOf(culture.getCategory_type()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                          } else if (String.valueOf(culture.getRevenuesCultures()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                          }
                          else if (culture.getDatePlantation() != null && culture.getDatePlantation().toString().contains(lowerCaseFilter)) {
                              return true;
                          } else if (culture.getDateRecolte() != null && culture.getDateRecolte().toString().contains(lowerCaseFilter)) {
                              return true;
                          }
                          
                          
                          else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Culture> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tvCulture.comparatorProperty());

//         5. Add sorted (and filtered) data to the table.
       tvCulture.setItems(sortedData);   
        
        
        
        
        
        
        
        
        
    }
      private void clear() {
        tvCulture.getSelectionModel().clearSelection();
        tfLibelle.clear();
        tfCoutsPlantations.clear();
tfDatePlantation.setValue(LocalDate.parse(formatter.format(date)));
tfDateRecolte.setValue(LocalDate.parse(formatter.format(date)));
tfRevenuesCultures.clear();
        btnInsert.setDisable(false);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
     cbType.getSelectionModel().select(-1);

    }



//
//
    public void Notification(){
	Platform.runLater(new Runnable() {
		@Override
		public void run() {
			Notifications notify = Notifications.create().title("event")
					.text("Ajout avec success")
					.hideAfter(javafx.util.Duration.seconds(4))
					.position(Pos.BOTTOM_RIGHT);
			notify.darkStyle();
			notify.showInformation();
		}
	}); 


}
//    
//    
//    
//    
//    
    
    
    
    @FXML
    private void Modifier(ActionEvent event) {
        if (tvCulture.getSelectionModel().getSelectedItem() != null) {
                        Culture e = new Culture(tvCulture.getSelectionModel().getSelectedItem().getId(),tfLibelle.getText(),Date.valueOf(tfDatePlantation.getValue()),Date.valueOf(tfDateRecolte.getValue()),type,Double.parseDouble(tfRevenuesCultures.getText()), Double.parseDouble(tfCoutsPlantations.getText()));

            se.modifier(e);
            
          ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setContentText("Voulez vous modifier cet culture !!!");
        dialog.getDialogPane().getButtonTypes().add(okButtonType);
        dialog.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            if (tvCulture.getSelectionModel().getSelectedItem() != null) {
                JOptionPane.showMessageDialog(null, "culture modifiee");
               
             }
             
 
            
            
            show();
            }
        
            clear();
           
          } else {
            System.out.println("Cancel");
        }  
            
            
            Notification1();   

        }
 
    
     public void Notification1(){
	Platform.runLater(new Runnable() {
		@Override
		public void run() {
			Notifications notify = Notifications.create().title("culture")
					.text("modif avec success")
					.hideAfter(javafx.util.Duration.seconds(4))
					.position(Pos.BOTTOM_RIGHT);
			notify.darkStyle();
			notify.showInformation();
		}
	}); 


}
       
    
    @FXML
    private void Delete(ActionEvent event) {
        ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setContentText("Voulez vous supprimé cet culture !!!");
        dialog.getDialogPane().getButtonTypes().add(okButtonType);
        dialog.getDialogPane().getButtonTypes().add(cancelButtonType);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
            if (tvCulture.getSelectionModel().getSelectedItem() != null) {
                JOptionPane.showMessageDialog(null, "culture Supprimee");
                se.supprimer(tvCulture.getSelectionModel().getSelectedItem().getId());
              show();
            }
            clear();
        } else {
            System.out.println("Cancel");
        }
    }

  
    @FXML
    private void AjouterPhoto(ActionEvent event) throws FileNotFoundException, IOException, SQLException {

   

        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
 

           image_view.setImage(image);
             Image image1 = image_view.getImage();
       this.pictureLink =ConvertFileImage(image1);
       System.err.println(this.pictureLink);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
//
//
    public static String ConvertFileImage(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:\\Users\\21692\\Desktop\\amine\\SYMFONY\\event\\public\\uploads\\");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(24), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }
//    
//    
//    
//    
//    
//    
//    
//    public void load_pic(String links) {
//
//        Image img = new Image(links);
//        image_view.setImage(img);
//
//    }
//
//

//    
//    
//    
//
    @FXML
    private void Clear(ActionEvent event) {
        clear();
    }
//
//    
    
    
        @FXML
    private void OnClickedPrint(ActionEvent event) {
          
       PrinterJob job = PrinterJob.createPrinterJob();
       
       Node root= this.tvCulture;
       
       
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
    
      @FXML
    private void handleMouseClicked(MouseEvent event) {
    }
    
        @FXML
        @Override
    public void initialize(URL url, ResourceBundle rb) {
            categoryButton.setOnAction(event -> {
        try {
            navigateToCategory(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
        
tfDatePlantation.setValue(LocalDate.parse(formatter.format(date)));
tfDateRecolte.setValue(LocalDate.parse(formatter.format(date)));

        // Assuming your ComboBox is defined as categoryComboBox
ObservableList<category> categories = FXCollections.observableArrayList(sc.getAll()); // Assuming you've called your method to get the data
cbType.setItems(categories);

// Assuming you have an event handler for the ComboBox selection
cbType.setOnAction(event -> {
    category selectedCategory = cbType.getSelectionModel().getSelectedItem();
    if (selectedCategory != null) {
        // Perform actions based on the selected category
        type = selectedCategory.getId();
    }
});
    
        show();
         
             tvCulture.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (tvCulture.getSelectionModel().getSelectedItem() != null) {
                    Culture e = (Culture) tvCulture.getSelectionModel().getSelectedItem();
                    tfLibelle.setText(e.getLibelle());
                    tfCoutsPlantations.setText(Double.toString(e.getCoutsPlantations()));
                      tfDatePlantation.setValue(e.getDatePlantation().toLocalDate());
                        tfDateRecolte.setValue(e.getDateRecolte().toLocalDate());
    // Find the corresponding category object based on the category type
    category selectedCategory = null;
    for (category c : cbType.getItems()) {
        if (c.getType().equals(e.getCategory_type())) {
            selectedCategory = c;
            break;
        }
    }

    if (selectedCategory != null) {
        cbType.getSelectionModel().select(selectedCategory);
    }

    type = e.getCategory_id();
                    tfRevenuesCultures.setText(String.valueOf(e.getRevenuesCultures()));
//                    pictureLink=e.getImage();
                    btnInsert.setDisable(true);

                }
            }
        });
    }    

    @FXML
    private void Ajout(ActionEvent event) {

               if (tfLibelle.getText() == null || tfLibelle.getText().trim().isEmpty()) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez remplir le champ de nom s'il vous plait!");
            dialogW.showAndWait();
        } else if (tfCoutsPlantations.getText() == null || tfCoutsPlantations.getText().trim().isEmpty()) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez remplir le champ de type s'il vous plait!");
            dialogW.showAndWait();
            
            
            
        } else if (tfDatePlantation.getValue() == null) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez inserer la date  s'il vous plait!");
            dialogW.showAndWait();
            
          } else if (tfDatePlantation.getValue() == null) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez inserer la date  s'il vous plait!");
            dialogW.showAndWait();
            
          }  else if (tfDateRecolte.getValue().compareTo(LocalDate.parse(formatter.format(date))) <0 ){
        
            Alert dialogW = new Alert(Alert.AlertType.ERROR);
            dialogW.setHeaderText(null);
            dialogW.setContentText("Veuillez choisir une date courante");
            dialogW.showAndWait();
        
            
       
            
            
            
        } else if (tfRevenuesCultures.getText() == null || tfRevenuesCultures.getText().trim().isEmpty()) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez remplir le champ de prix s'il vous plait!");
            dialogW.showAndWait();
        } else if (type == 0) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("veuillez choissir type de category!");
            dialogW.showAndWait();
        } else {
            User user=new User();
            user.setUser_id(2);
            System.out.println(type);
            Culture e = new Culture(tfLibelle.getText(), Double.parseDouble(tfCoutsPlantations.getText()),Double.parseDouble(tfRevenuesCultures.getText()),Date.valueOf(tfDatePlantation.getValue()),Date.valueOf(tfDateRecolte.getValue()),type);
            se.ajouter(e,user);
             clear();
                  Notification();   
                         show();


        }

       
        
        
        
        
    }

 
}
