package com.hatice.fahrkurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class page1Controller implements Initializable {
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
}
