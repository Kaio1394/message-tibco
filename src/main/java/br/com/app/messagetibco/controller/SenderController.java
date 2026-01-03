package br.com.app.messagetibco.controller;

import br.com.app.messagetibco.dto.TibcoConfigSenderDto;
import br.com.app.messagetibco.model.TibcoConfigSender;
import br.com.app.messagetibco.repository.TibcoConfigRepository;
import br.com.app.messagetibco.service.TibcoConfigService;
import br.com.app.messagetibco.utils.JpaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SenderController {
    private final TibcoConfigService service;

    @FXML
    private TextArea textAreaMessageTibco;

    @FXML
    private ComboBox<TibcoConfigSenderDto> cbListSenderConfig;

    public SenderController(){
        this.service = new TibcoConfigService(new TibcoConfigRepository(JpaUtil.getEntityManager()));
    }



    public void getListConfigSender(){
        var listConfigSender = this.service.getListTibcoConfig();
    }
}
