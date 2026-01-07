package br.com.app.messagetibco.controller;

import br.com.app.messagetibco.application.dto.TibcoConfigSenderRegisterDto;
import br.com.app.messagetibco.domain.exception.TagAlreadyExistsException;
import br.com.app.messagetibco.domain.repository.TibcoConfigRepository;
import br.com.app.messagetibco.application.service.TibcoConfigService;
import br.com.app.messagetibco.application.utils.AlertUtil;
import br.com.app.messagetibco.application.utils.JpaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SettingsController {

    private TibcoConfigService service;

    @FXML
    public void initialize() {
        this.service = new TibcoConfigService(new TibcoConfigRepository(JpaUtil.getEntityManager()));
    }

    @FXML
    public TextField tagField;

    @FXML
    private TextField daemonField;

    @FXML
    private TextField serviceField;

    @FXML
    private TextField networkField;

    private boolean validFields(){
        return !daemonField.getText().isEmpty() &&
                !serviceField.getText().isEmpty() &&
                !networkField.getText().isEmpty();
    }

    @FXML
    public void onSave() {
        if (!validFields()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos obrigatórios");
            alert.setHeaderText("Preencha todos os campos");
            alert.setContentText("Daemon, Service e Network são obrigatórios.");

            alert.showAndWait();
            return;
        }
        try{
            TibcoConfigSenderRegisterDto t = new TibcoConfigSenderRegisterDto();
            t.setDaemon(daemonField.getText());
            t.setService(serviceField.getText());
            t.setNetwork(networkField.getText());
            t.setTag(tagField.getText());
            this.service.saveConfig(t);
            AlertUtil.showInfo(
                    "Sucesso",
                    "Configuração salva",
                    "Registro salvo com sucesso."
            );
        }catch(TagAlreadyExistsException ex){
            AlertUtil.showWarning(
                    "Tag já existente",
                    "Não é possível salvar",
                    ex.getMessage()
            );
        }
    }
}
