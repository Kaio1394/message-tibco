package br.com.app.messagetibco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class MessageTibcoApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "br.com.app.messagetibco.properties.messages"
        );
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource(
                        "/br/com/app/messagetibco/view/home-view.fxml"
                ),
                bundle
        );
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle(bundle.getString("app.title"));

        stage.getIcons().add(
                new Image(
                        MessageTibcoApplication.class
                                .getResourceAsStream("/br/com/app/messagetibco/ico/t-img.png")
                )
        );
        stage.setScene(scene);
        stage.show();
    }
}
