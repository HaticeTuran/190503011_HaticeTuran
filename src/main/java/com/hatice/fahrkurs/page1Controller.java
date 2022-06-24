package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private ChoiceBox<String> AktionChoise;

    private String[] Aktionen = {"Schueler loeschen", "Schueler einfuegen", "Schueler listen"};

    @FXML
    public void initialize() {
        AktionChoise.getItems().addAll(Aktionen);
    }

    @FXML
    public void switchToProfil (ActionEvent event) throws Exception {
        root = FXMLLoader.load(page1Controller.class.getResource("profil.fxml"));
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

        FXMLLoader sScreen2 = new FXMLLoader(HelloApplication.class.getResource("Aktion1.fxml"));
        //screen.getChildren().removeAll();
        screen.getChildren().clear();
        System.out.println(screen.getChildren());

        if(act.equals("Schueler loeschen")){
            screen.getChildren().add(sScreen.load());
        }else if(act.equals("Schueler einfuegen")){
            // do sth else
        }else if(act.equals("Schueler listen")){
            screen.getChildren().add(sScreen2.load());
        }
    }
    public void setUserName(String s){
        myLabel.setText(s);
    }
}
