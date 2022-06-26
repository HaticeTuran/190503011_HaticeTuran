package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Aktion3Controller {
    @FXML
    private TextField TC,name,nname,gDatum,blutt,LehrerID,KursID;

    @FXML
    private Button AddStudButton;

    @FXML
    //private ChoiceBox<String> KursID;


    /*@FXML
    public void initialize() {

        //KursID.getItems().addAll( this.FullList());

    }*/

    private String[] FullList(){
        int[] arr = new int [db.getKursesID().size()];
        String a = Arrays.toString(arr); //toString the List or Vector
        String ar[]=a.substring(1,a.length()-1).split(", ");
        //System.out.println(Arrays.toString(ar));

        return ar;
    }
    @FXML
    private Label errorMsg;

    public void addSchueler(ActionEvent event) {
        Boolean b = db.addSchueler(TC.getText(),name.getText(),nname.getText(),gDatum.getText(), parseInt(KursID.getText()),blutt.getText(),LehrerID.getText());

        if(b){
            errorMsg.setText("Einfuegen erfolgreich!");
        }else{
            errorMsg.setText("Die Schueler ist schon auf dem System befunden.");
        }
    }

}
