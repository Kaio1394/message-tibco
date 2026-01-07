package br.com.app.messagetibco.controller;

import br.com.app.messagetibco.domain.model.MessageTibco;
import br.com.app.messagetibco.application.service.MessageCrackerService;
import br.com.app.messagetibco.application.utils.AlertUtil;
import br.com.app.messagetibco.application.utils.MessageCrackerUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.Map;

public class MessageCrackerController {
    @FXML
    public TextArea textAreaMessageTibco;

    @FXML
    public TableView tableFields;

    @FXML
    private TableColumn<Map.Entry<Integer, Object>, Integer> colKey;

    @FXML
    private TableColumn<Map.Entry<Integer, Object>, String> colValue;

    private MessageCrackerService service;

    @FXML
    public void initialize(){
        colKey.prefWidthProperty().bind(
                tableFields.widthProperty().multiply(0.5)
        );

        colValue.prefWidthProperty().bind(
                tableFields.widthProperty().multiply(0.5)
        );
        colKey.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(data.getValue().getKey())
        );

        colValue.setCellValueFactory(data ->
                new ReadOnlyStringWrapper(String.valueOf(data.getValue().getValue()))
        );
        this.service = new MessageCrackerService(new MessageCrackerUtil());
    }

    @FXML
    private void onCracker(){
        try{
            MessageTibco msg = this.service.parseMessage(
                    textAreaMessageTibco.getText()
            );
            ObservableList<Map.Entry<Object, Object>> data =
                    FXCollections.observableArrayList(msg.getFields().entrySet());
            tableFields.setItems(data);
        }catch(IllegalArgumentException e){
            AlertUtil.showError("Erro", "Erro no parse da mensagem", e.getMessage());
        }
    }

    @FXML
    public void onClear() {
        textAreaMessageTibco.clear();
        tableFields.getItems().clear();
    }
}
