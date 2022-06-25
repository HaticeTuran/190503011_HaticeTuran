package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    @FXML
    private Button Login;

    @FXML
    private TextField BenutzerName;

    @FXML
    private PasswordField Passwort;

    @FXML
    private Label errMsg;

    @FXML
    public void onAnmeldungButtonClick(ActionEvent event) throws Exception{
        //System.out.println(BenutzerName.getText());
        String name= BenutzerName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page1.fxml"));

        if(db.containPersonal(BenutzerName.getText(),Passwort.getText())){
            root = FXMLLoader.load(page1Controller.class.getResource("page1.fxml"));
            root= loader.load();
            page1Controller page1Controller = loader.getController();
            page1Controller.setUserName(name);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            errMsg.setText("Benutzername oder Passwort wird falsch gegeben!");
        }
    }

}
