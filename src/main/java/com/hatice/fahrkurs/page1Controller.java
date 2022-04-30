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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class page1Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button EditButton;
    @FXML
    private  TextField myLabel;

    @FXML
    private ChoiceBox<String> AktionChoise;

    private String[] Aktionen = {"Schueler loeschen", "Schueler einfuegen", "Schueler listen"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
}
