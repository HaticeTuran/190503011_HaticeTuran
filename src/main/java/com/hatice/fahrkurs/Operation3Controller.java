package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Operation3Controller {

    @FXML
    private Button Delete;

    @FXML
    private Label ErrMsg;

    @FXML
    private ChoiceBox<?> Personal;

    private Personal[] PersonalList = db.getPersonalList().toArray(new Personal[db.getPersonalList().size()]);

    @FXML
    public void initialize() {
        ObservableList a = FXCollections.observableArrayList();

        for(Personal p : PersonalList){
            a.add(p);
        }
        Personal.getItems().addAll(a);

    }

    @FXML
    void DeletePersonal(ActionEvent event) {
        String act = (String) this.Personal.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");

        System.out.println(arrOfStr[6]);

        db.deletePersonal(arrOfStr[6]);
    }

}
