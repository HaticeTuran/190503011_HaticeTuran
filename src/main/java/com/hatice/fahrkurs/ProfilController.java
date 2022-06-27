package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProfilController {
    @FXML
    private TextField Name, Nachname, Mail, Telefon, Land, Dorf, Tür_no, Stadt, Strasse, Postleitzahl,id;

    @FXML
    private Label UserName;

    @FXML
    private Button zurueck;

    @FXML
    private Button passButton;

    @FXML
    private PasswordField pass;

    @FXML
    private PasswordField altpass;

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

    public void updatePass(ActionEvent event){
        Boolean b = db.IsUpdatePasswort(UserName.getText(), altpass.getText(), pass.getText());

        if(altpass.getText().equals(pass.getText())){
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Gescheiterte Operation!");
            alert1.setHeaderText("Etwas ist schief gelaufen.");
            alert1.setContentText("Das neue Passwort darf nicht mit dem alten Passwort übereinstimmen!");
            if(alert1.showAndWait().get() == ButtonType.OK){
                //
            }
        }


        if(!b){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Gescheiterte Operation!");
            alert.setHeaderText("Etwas ist schief gelaufen.");
            alert.setContentText("Ueberpruefen Sie Ihre Transaktion!");


            if(alert.showAndWait().get() == ButtonType.OK){
                //
            }
        }
    }
    public void updateKontakInfo(){
        db.IsUpdateKontakt(id.getText(),Mail.getText(),Telefon.getText());
    }

}
