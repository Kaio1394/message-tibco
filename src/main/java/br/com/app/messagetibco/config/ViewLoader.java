package br.com.app.messagetibco.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ViewLoader {

    private ViewLoader() {}

    public static Parent load(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    ViewLoader.class.getResource(fxml),
                    I18n.getBundle()
            );
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

