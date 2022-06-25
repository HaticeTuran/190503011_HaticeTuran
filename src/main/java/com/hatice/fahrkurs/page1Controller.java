package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class page1Controller  {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button EditButton;

    @FXML
    private Label myLabel;

    @FXML
    private Button OK;

    @FXML
    private Button logout;

    @FXML
    private ChoiceBox<String> AktionChoise;

    private String[] Aktionen = {"Schueler loeschen", "Schueler einfuegen", "Schueler listen"};

    @FXML
    public void initialize() {
        AktionChoise.getItems().addAll(Aktionen);
    }

    @FXML
    public void switchToProfil (ActionEvent event) throws Exception {
        String name= myLabel.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profil.fxml"));

        root = FXMLLoader.load(page1Controller.class.getResource("profil.fxml"));

        root= loader.load();
        ProfilController profilController = loader.getController();
        profilController.setUserName(name);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private AnchorPane screen;


    public void switchAktion(ActionEvent event) throws IOException {
        //String act = (String) this.AktionChoise.getValue();
        String act = (String) this.AktionChoise.getSelectionModel().getSelectedItem();

        FXMLLoader sScreen = new FXMLLoader(HelloApplication.class.getResource("Aktion2.fxml"));
        FXMLLoader sScreen3 = new FXMLLoader(HelloApplication.class.getResource("Aktion3.fxml"));
        FXMLLoader sScreen2 = new FXMLLoader(HelloApplication.class.getResource("Aktion1.fxml"));
        //screen.getChildren().removeAll();
        screen.getChildren().clear();
        //System.out.println(screen.getChildren());
        switch (act){
            case "Schueler loeschen":
                screen.getChildren().add(sScreen.load());
                break;
            case "Schueler einfuegen":
                screen.getChildren().add(sScreen3.load());
                break;
            case     "Schueler listen":
                screen.getChildren().add(sScreen2.load());
                break;
            default:
                System.out.println("No matching");
        }

/*
        if(act.equals("Schueler loeschen")){
            screen.getChildren().add(sScreen.load());
        }else if(act.equals("Schueler einfuegen")){
            screen.getChildren().add(sScreen3.load());
        }else if(act.equals("Schueler listen")){
            screen.getChildren().add(sScreen2.load());
        }*/
    }
    public void setUserName(String s){
        myLabel.setText(s);
    }

    public void logout(ActionEvent event) throws Exception{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
        alert.setHeaderText("Sie sind dabei, sich abzumelden!");
        alert.setContentText("Möchten Sie vor dem Beenden speichern?");
         if(alert.showAndWait().get() == ButtonType.OK){
             root = FXMLLoader.load(page1Controller.class.getResource("home.fxml"));

             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
         }
    }
}
