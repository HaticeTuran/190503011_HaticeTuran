package com.hatice.fahrkurs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Operation5Controller {

    @FXML
    private Label L_id;

    @FXML
    private Label errMsg;


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
    private ChoiceBox<String> Topics1;

    @FXML
    private ChoiceBox<Integer> KursIds;

    @FXML
    private TextField Datum;

    @FXML TextField altDatum;

    @FXML
    private Button PrufDelete;

    @FXML
    private Button PrufAk;

    private Integer[] ids = db.getKursesID().toArray(new Integer[db.getKursesID().size()]);

    //private Integer[] ids = (Integer[]) db.getKursesID().toArray();

    @FXML
    public void initialize() {
        Topics.getItems().addAll(topics);
        Topics1.getItems().addAll(topics);
        KursIds.getItems().addAll(ids);

        ObservableList a = FXCollections.observableArrayList();
        for(Personal p : PersonalList){
            a.add(p);
        }
        Lehrern.getItems().addAll(a);
    }

    @FXML
    public void addPruefung(ActionEvent event){
       if(!KursIds.getSelectionModel().getSelectedItem().equals("") && !Datum.getText().equals("") && !Topics1.getSelectionModel().getSelectedItem().equals("")){
           db.addPruefung(KursIds.getSelectionModel().getSelectedItem(),Datum.getText(),Topics1.getSelectionModel().getSelectedItem());
       }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ungueltige Operation!");
            alert.setHeaderText("Es gibt Luecken, die Sie ausfüllen müssen. ");
            alert.setContentText("Bitte, kontrollieren!!");
            if(alert.showAndWait().get() == ButtonType.OK){
                //
            }
        }
    }

    @FXML
    public void deletePruefung(ActionEvent event){
        if(!KursIds.getSelectionModel().getSelectedItem().equals("") && !Datum.getText().equals("") && !Topics1.getSelectionModel().getSelectedItem().equals("")){
            db.deletePruefung(KursIds.getSelectionModel().getSelectedItem(),Datum.getText(),Topics1.getSelectionModel().getSelectedItem());
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ungueltige Operation!");
            alert.setHeaderText("Es gibt Luecken, die Sie ausfüllen müssen. ");
            alert.setContentText("Bitte, kontrollieren!!");
            if(alert.showAndWait().get() == ButtonType.OK){
                //
            }
        }
    }
    @FXML
    public void updatePruefung(ActionEvent event) {
        if (!KursIds.getSelectionModel().getSelectedItem().equals("") && !Datum.getText().equals("") && !Topics1.getSelectionModel().getSelectedItem().equals("") && !altDatum.getText().equals("")) {
            db.updatePruefung(KursIds.getSelectionModel().getSelectedItem(), Datum.getText(), Topics1.getSelectionModel().getSelectedItem(), altDatum.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ungueltige Operation!");
            alert.setHeaderText("Es gibt Luecken, die Sie ausfüllen müssen. ");
            alert.setContentText("Bitte, kontrollieren!!");
            if (alert.showAndWait().get() == ButtonType.OK) {
                //

            }
        }
    }
    @FXML
    public void addKurs(ActionEvent event) {
        errMsg.setText("");
        String act = (String) this.Lehrern.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");
        String tc = arrOfStr[6];
        System.out.println(arrOfStr[6]);
        if(!db.containKurs(Topics.getSelectionModel().getSelectedItem(),tc)) {

            db.addKurs(Topics.getSelectionModel().getSelectedItem(), tc, Integer.parseInt(capacity.getText()));
        }else {
            errMsg.setText("Diese Kurs existiert schon!");
        }
    }

    @FXML
    public void updateKurs(ActionEvent event){
        errMsg.setText("");
        String act = (String) this.Lehrern.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");
        String tc = arrOfStr[6];
        if(db.containKurs(Topics.getSelectionModel().getSelectedItem(),tc)){
            db.updateKursCP(Topics.getSelectionModel().getSelectedItem(),tc,Integer.parseInt(capacity.getText()));
        }else{
            errMsg.setText("Diese Kurse ist nicht gefunden!");
        }
    }
    @FXML
    public void deleteKurs(ActionEvent event){
        errMsg.setText("");
        String act = (String) this.Lehrern.getSelectionModel().getSelectedItem().toString();
        String[] arrOfStr = act.split(" ");
        String tc = arrOfStr[6];
        if(db.containKurs(Topics.getSelectionModel().getSelectedItem(),tc)) {
            db.deleteKurs(Topics.getSelectionModel().getSelectedItem(), tc, Integer.parseInt(capacity.getText()));
        }else {
            errMsg.setText("Diese Kurse ist nicht gefunden! Kontrolieren Sie die Informationen!");
        }
    }

}
