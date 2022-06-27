package com.hatice.fahrkurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Aktion3Controller {
    @FXML
    private TextField TC,name,nname,gDatum,blutt,LehrerID,KursID;

    @FXML
    private Button AddStudButton;

    @FXML
    private ChoiceBox<String> students;

    @FXML
    private ChoiceBox<String> exams;

    @FXML
    private TextField Note;


    @FXML
    public void initialize() {
        students.getItems().addAll(db.ListStudents());
        exams.getItems().addAll(db.ListExams());

    }

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

    @FXML
    public void addNotes(){
        String act = (String) this.students.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");
        System.out.println(arrOfStr[3]);

        String act1 = (String) this.exams.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr1 = act1.split(" ");

        System.out.println(arrOfStr1[1]);
        //
        if(!arrOfStr[3].equals("") && !arrOfStr1[1].equals("") && !Note.getText().equals("")){
            db.addNotes(arrOfStr[3],Integer.parseInt(arrOfStr1[1]),Integer.parseInt(Note.getText()));
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ungueltige Operation!");
            alert.setHeaderText("Es gibt Luecken, die Sie ausfüllen müssen. ");
            alert.setContentText("Bitte, kontrollieren!!");
            if (alert.showAndWait().get() == ButtonType.OK) {
                //
            }
        }

    }

}
