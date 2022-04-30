package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfilController {
    @FXML
    private TextField Name, Nachname, Mail, Telefon, Land, Dorf, Tür_no, Stadt, Strasse, Postleitzahl;

    @FXML
    private Button zurueck;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHome (ActionEvent event) throws Exception{
        root = FXMLLoader.load(page1Controller.class.getResource("page1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
