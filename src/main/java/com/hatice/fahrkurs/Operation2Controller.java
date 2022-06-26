package com.hatice.fahrkurs;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Operation2Controller implements Initializable {

    @FXML
    private TableColumn<Personal, String> Nachname;

    @FXML
    private TableColumn<Personal, String> Name;

    @FXML
    private TableView<Personal> Personal;

    @FXML
    private TableColumn<Personal, Integer> PersonalNo;

    @FXML
    private TableColumn<Personal, String > Rolle;

    @FXML
    private TableColumn<Personal, String> TC;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        Name.setCellValueFactory(new PropertyValueFactory<Personal,String>("Name"));
        Nachname.setCellValueFactory(new PropertyValueFactory<Personal,String>("NachName"));
        TC.setCellValueFactory(new PropertyValueFactory<Personal,String>("TC_Nummer"));
        Rolle.setCellValueFactory(new PropertyValueFactory<Personal,String>("Rolle"));
        PersonalNo.setCellValueFactory(new PropertyValueFactory<Personal,Integer>("PersonalNummer"));

        Personal.setItems(ListPersonal());
    }

    @FXML
    public ObservableList ListPersonal(){
        ObservableList arr = db.listPersonal();
        return arr;
    }


}
