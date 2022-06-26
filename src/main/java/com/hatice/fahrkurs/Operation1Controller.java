package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.nio.Buffer;

public class Operation1Controller {

    @FXML
    private ChoiceBox<?> PersonList;

    private Personal[] PersonalList = db.getPersonalList().toArray(new Personal[db.getPersonalList().size()]);

    @FXML
    private Label errMsg;

    @FXML
    private Button ok;

   @FXML
    public void initialize() {
       ObservableList a = FXCollections.observableArrayList();

       for(Personal p : PersonalList){
           a.add(p);
       }
       PersonList.getItems().addAll(a);

    }

    @FXML
    public void addAdmin (ActionEvent e) {
        //
        String act = (String) this.PersonList.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");

        System.out.println(arrOfStr[3]);

        db.makeAdmin(arrOfStr[3]);
    }

}
