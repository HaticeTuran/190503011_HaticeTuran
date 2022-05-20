package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Aktion1Controller implements Initializable {

    @FXML
    private AnchorPane aP;

    @FXML
    private TableView SchuelerList;

    @FXML
    private TableColumn TC;

    @FXML
    private TableColumn Name;

    @FXML
    private TableColumn Nachname;

    @FXML
    private Button show;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.List();
    }

    public void List( ){
        ObservableList arr = db.listSchueler();
        SchuelerList.setItems(arr);
        /*for(int i=0;i<arr.size();i++){
            //SchuelerList.getItems().add(arr.get(i));
            SchuelerList.setItems(arr);
        }*/
    }

}
