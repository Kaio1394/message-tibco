package br.com.app.messagetibco.controller;

import br.com.app.messagetibco.application.config.I18n;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class HomeController {

    @FXML
    private StackPane content;

    @FXML
    private void openToolsSender(){
        loadView("/br/com/app/messagetibco/view/sender-view.fxml");
    }

    @FXML
    private void openToolsMessageCracker(){
        loadView("/br/com/app/messagetibco/view/message-cracker-view.fxml");
    }

    @FXML
    private void openSettingsTibco(){
        loadView("/br/com/app/messagetibco/view/settings-sender-view.fxml");
    }

    private void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(fxml),
                    I18n.getBundle()
            );

            Node view = loader.load();
            content.getChildren().clear();
            content.getChildren().add(view);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}