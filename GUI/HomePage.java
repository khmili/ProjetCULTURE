///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.connexion4se3.gui;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//
///**
// *
// * @author mega pc
// */
//public class HomePage extends Application {
//    
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("culture.fxml"));
////      Parent root = FXMLLoader.load(getClass().getResource("FXMLcategory.fxml"));
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//       
//        launch(args);
//        
//        
//        
//        
//      
//       
//    }
//
//}


//package edu.connexion4se3.gui;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.scene.control.Button;
//import javafx.event.ActionEvent;
//import javafx.scene.layout.StackPane;
//
//public class HomePage extends Application {
//
//    private Stage primaryStage;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        primaryStage = stage;
//
//        // Load the initial scene (culture.fxml)
//        loadPage("culture.fxml");
//
//        // Create buttons for navigation
//        Button cultureButton = new Button("Culture Page");
//        Button categoryButton = new Button("Category Page");
//
//        // Set actions for the navigation buttons
//        cultureButton.setOnAction(event -> loadPage("culture.fxml"));
//        categoryButton.setOnAction(event -> loadPage("FXMLcategory.fxml"));
//
//        // Create a layout to place the buttons
//        StackPane buttonLayout = new StackPane();
//        buttonLayout.getChildren().addAll(cultureButton, categoryButton);
//
//        // Create a layout for the entire scene
//        StackPane rootLayout = new StackPane();
//        rootLayout.getChildren().add(buttonLayout);
//
//        // Set the initial scene to culture.fxml
//        Scene scene = new Scene(rootLayout, 400, 300);
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.show();
//    }
//
//    // Load FXML file and set it as the scene
//    private void loadPage(String fxmlFileName) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
//            Scene scene = new Scene(root);
//            primaryStage.setScene(scene);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


package edu.connexion4se3.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class HomePage extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
//        Parent root = FXMLLoader.load(getClass().getResource("culture.fxml"));
////      Parent root = FXMLLoader.load(getClass().getResource("FXMLcategory.fxml"));
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    
        // Load the initial scene (culture.fxml)
        loadPage("culture.fxml");

        // Create buttons for navigation
        Button cultureButton = new Button("Culture Page");
        Button categoryButton = new Button("Category Page");

        // Set actions for the navigation buttons
        cultureButton.setOnAction(event -> loadPage("culture.fxml"));
        categoryButton.setOnAction(event -> loadPage("FXMLcategory.fxml"));

        // Create a layout to place the buttons
        StackPane buttonLayout = new StackPane();
        buttonLayout.getChildren().addAll(cultureButton, categoryButton);

        // Create a layout for the entire scene
        StackPane rootLayout = new StackPane();
        rootLayout.getChildren().add(buttonLayout);

        // Set the initial scene to culture.fxml
        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Load FXML file and set it as the scene
    private void loadPage(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
