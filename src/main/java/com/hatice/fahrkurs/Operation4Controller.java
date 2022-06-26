package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class Operation4Controller {

    @FXML
    private Label errMsg;

    @FXML
    private TextField BName;

    @FXML
    private TextField GDatum;

    @FXML
    private TextField NName;

    @FXML
    private TextField Name;

    @FXML
    private PasswordField Pass;

    @FXML
    private TextField TC;

    @FXML
    private Button add;

    @FXML
    void addPersonal(ActionEvent event) {
        Boolean b = db.addPersonal(TC.getText(),Name.getText(),NName.getText(),GDatum.getText(), BName.getText(),Pass.getText());

        if(b){
            errMsg.setText("Einfuegen erfolgreich!");
        }else{
            errMsg.setText("Die Personal ist schon auf dem System befunden.");
        }

    }

}
