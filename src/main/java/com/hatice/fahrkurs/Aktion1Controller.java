package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Aktion1Controller {
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

    public void List( ){
        ObservableList arr = db.listSchueler();
        SchuelerList.setItems(arr);
        /*for(int i=0;i<arr.size();i++){
            //SchuelerList.getItems().add(arr.get(i));
            SchuelerList.setItems(arr);
        }*/
    }


}
