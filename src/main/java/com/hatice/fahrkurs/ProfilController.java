package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfilController {
    @FXML
    private TextField Name, Nachname, Mail, Telefon, Land, Dorf, Tür_no, Stadt, Strasse, Postleitzahl;

    @FXML
    private Label UserName;

    @FXML
    private Button zurueck;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setUserName(String s){
        UserName.setText(s);
    }

    public void switchToPage1 (ActionEvent event) throws Exception{
        String name= UserName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page1.fxml"));

        root = FXMLLoader.load(page1Controller.class.getResource("page1.fxml"));

        root = loader.load();
        page1Controller page1Controller = loader.getController();
        page1Controller.setUserName(name);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
