package com.hatice.fahrkurs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Aktion2Controller {
    @FXML
    private Button delete;

    @FXML
    private TextField tc;

    public void DeleteSchueler(){
        db.deleteSchueler(tc.getText());
    }
}
