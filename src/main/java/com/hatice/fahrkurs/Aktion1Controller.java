package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Aktion1Controller implements Initializable {

    @FXML
    private TableColumn<Fahrschueler, String> GeburtsDatum;

    @FXML
    private TableColumn<Fahrschueler, String> Nachname;

    @FXML
    private TableColumn<Fahrschueler, String> Name;

    @FXML
    private TableView<Fahrschueler> SchuelerList;

    @FXML
    private TableColumn<Fahrschueler, Integer> SchuelerNo;

    @FXML
    private TableColumn<Fahrschueler, String> TC;

    @FXML
    private AnchorPane aP;

    @FXML
    private Button show;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Name.setCellValueFactory(new PropertyValueFactory<Fahrschueler,String>("Name"));
        Nachname.setCellValueFactory(new PropertyValueFactory<Fahrschueler,String>("NachName"));
        TC.setCellValueFactory(new PropertyValueFactory<Fahrschueler,String>("TC_Nummer"));
        GeburtsDatum.setCellValueFactory(new PropertyValueFactory<Fahrschueler,String>("Geburtsdatum"));
        SchuelerNo.setCellValueFactory(new PropertyValueFactory<Fahrschueler,Integer>("SchuelerNummer"));

        SchuelerList.setItems(List());

    }

    @FXML
    public ObservableList List(){
        ObservableList arr = db.listSchueler();
        return arr;
    }

}
