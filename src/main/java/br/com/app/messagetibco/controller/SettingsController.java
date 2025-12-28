package br.com.app.messagetibco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SettingsController {
    @FXML
    public TextField subjectField;
    @FXML
    private TextField daemonField;

    @FXML
    private TextField serviceField;

    @FXML
    private TextField hostField;

    @FXML
    public void onSave() {
    }
}
