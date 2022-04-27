package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.EventObject;
import java.util.Objects;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Button Anmeldung;


    /*@FXML
    private TextField BenutzerName = new TextField();

    @FXML
    private PasswordField Passwort = new PasswordField();

    @FXML
    private Button Anmeldung;*/

    @FXML
    public void onAnmeldungButtonClick(ActionEvent event) throws Exception{
        //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page1.fxml")));
        root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //change the page

    }

}
