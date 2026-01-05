package br.com.app.messagetibco.controller;

import br.com.app.messagetibco.dto.TibcoConfigSenderDto;
import br.com.app.messagetibco.model.TibcoConfigSender;
import br.com.app.messagetibco.repository.TibcoConfigRepository;
import br.com.app.messagetibco.service.TibcoConfigService;
import br.com.app.messagetibco.utils.JpaUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SenderController {
    private final TibcoConfigService service;

    @FXML
    public TextField networkField;
    @FXML
    public TextField daemonField;
    @FXML
    public TextField serviceField;
    @FXML
    public TextField subjectField;

    @FXML
    private TextArea textAreaMessageTibco;

    @FXML
    private ComboBox<TibcoConfigSenderDto> cbListSenderConfig;

    public SenderController(){
        this.service = new TibcoConfigService(new TibcoConfigRepository(JpaUtil.getEntityManager()));
    }

    @FXML
    public void initialize() {
        getListConfigSender();
        initComboListener();
    }

    private void fillFields(String daemon, String network, String service){
        daemonField.setText(daemon);
        networkField.setText(network);
        serviceField.setText(service);
    }

    private void clearFields() {
        daemonField.clear();
        networkField.clear();
        serviceField.clear();
    }
    private void initComboListener() {
        cbListSenderConfig.valueProperty().addListener((obs,
                                                        oldValue,
                                                        selected) -> {
            if (selected != null) {
                fillFields(
                        selected.getDaemon(),
                        selected.getNetwork(),
                        selected.getService()
                );
            } else {
                clearFields();
            }
        });
    }
    public void getListConfigSender(){
        var listConfigSender = this.service.getListTibcoConfig();
        cbListSenderConfig.setItems(
                FXCollections.observableArrayList(listConfigSender)
        );
    }

    public void onSenderMessage() {
    }

    public void onListening() {
    }
}
