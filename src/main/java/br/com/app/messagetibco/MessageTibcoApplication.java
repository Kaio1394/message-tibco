package br.com.app.messagetibco;

import br.com.app.messagetibco.application.config.I18n;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class MessageTibcoApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource(
                        "/br/com/app/messagetibco/view/home-view.fxml"
                ),
                I18n.getBundle()
        );
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle(I18n.get("app.title"));

        stage.getIcons().add(
                new Image(
                        Objects.requireNonNull(MessageTibcoApplication.class
                                .getResourceAsStream("/br/com/app/messagetibco/ico/t-img.png"))
                )
        );
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
