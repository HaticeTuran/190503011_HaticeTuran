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
    private AnchorPane screen;

    @FXML
    private ChoiceBox<String> AktionChoise;

    private String[] Aktionen = {"Schueler loeschen", "Schueler einfuegen", "Schueler listen"};

    @FXML
    private ChoiceBox<String> UserChoise;

    @FXML
    private Button ChoiseOp;

    private String[] Operations = {"Admin einfuegen", "Personal listen","Personal loeschen","Personal einfuegen","Personal listen11"};
    @FXML
    public void initialize() {
        AktionChoise.getItems().addAll(Aktionen);
        UserChoise.getItems().addAll(Operations);
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



    //Switch Aktion Seite fuer Personal
    public void switchAdminSeite() throws IOException {
        System.out.println(myLabel.getText());
        if(db.containAdmin(myLabel.getText())){
            selectOp();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ungueltige Operation!");
            alert.setHeaderText("Sie sind keine Adminuser!");
            alert.setContentText("Wenden Sie sich dazu an den Administrator!");
            if(alert.showAndWait().get() == ButtonType.OK){
                //
            }
        }
    }
    public void selectOp() throws IOException {
        String act = (String) this.UserChoise.getSelectionModel().getSelectedItem();

        FXMLLoader sScreen1 = new FXMLLoader(HelloApplication.class.getResource("Operation1.fxml"));
        FXMLLoader sScreen2 = new FXMLLoader(HelloApplication.class.getResource("Operation2.fxml"));
        FXMLLoader sScreen3 = new FXMLLoader(HelloApplication.class.getResource("Operation3.fxml"));
        FXMLLoader sScreen4 = new FXMLLoader(HelloApplication.class.getResource("Operation4.fxml"));
        FXMLLoader sScreen5 = new FXMLLoader(HelloApplication.class.getResource("Operation5.fxml"));

        //screen.getChildren().removeAll();
        screen.getChildren().clear();
        //System.out.println(screen.getChildren());
        try{
            switch (act){
                case "Admin einfuegen":
                    screen.getChildren().add(sScreen1.load());
                    break;
                case"Personal listen":
                    screen.getChildren().add(sScreen2.load());
                    break;
                case "Personal loeschen":
                    screen.getChildren().add(sScreen3.load());
                    break;
                case"Personal einfuegen":
                    screen.getChildren().add(sScreen4.load());
                    break;
                case "Personal listenn":
                    screen.getChildren().add(sScreen5.load());
                    break;
                default:
                    System.out.println("No matching");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // Switch Aktion Seite fuer Schuler
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
    }
    public void setUserName(String s){
        myLabel.setText(s);
    }

    public void logout(ActionEvent event) throws Exception{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
        alert.setHeaderText("Sie sind dabei, sich abzumelden!");
        alert.setContentText("Möchten Sie sich wirklich abmelden?");
         if(alert.showAndWait().get() == ButtonType.OK){
             root = FXMLLoader.load(page1Controller.class.getResource("home.fxml"));

             stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
         }
    }
}
