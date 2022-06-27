package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Operation5Controller {

    @FXML
    private Label L_id;

    @FXML
    private Label topic;

    @FXML
    private ChoiceBox<String> Topics;

    private String[] topics = {"A", "A1","A2","AM","B","BF17","BE","B96"};

    @FXML
    private ChoiceBox<?> Lehrern;

    //private Kursleiter [] LehrerList = db.getLehrerList().toArray(new Kursleiter[db.getLehrerList().size()]);
    private Personal[] PersonalList = db.getPersonalList().toArray(new Personal[db.getPersonalList().size()]);
    @FXML
    private Button add;

    @FXML
    private TextField capacity;

    @FXML
    public void initialize() {
        Topics.getItems().addAll(topics);

        ObservableList a = FXCollections.observableArrayList();
        for(Personal p : PersonalList){
            a.add(p);
        }
        Lehrern.getItems().addAll(a);
    }

    @FXML
    void addKurs(ActionEvent event) {
        String act = (String) this.Lehrern.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");
        String tc = arrOfStr[6];
        System.out.println(arrOfStr[6]);
        db.addKurs(Topics.getSelectionModel().getSelectedItem(),tc,Integer.parseInt(capacity.getText()));

    }

}
