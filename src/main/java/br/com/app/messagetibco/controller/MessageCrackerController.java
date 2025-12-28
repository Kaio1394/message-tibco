package br.com.app.messagetibco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MessageCrackerController {
    @FXML
    public TextArea textAreaMessageTibco;

    @FXML
    private void onCracker(){

    }

    @FXML
    public void onClear() {
        textAreaMessageTibco.clear();
    }
}
