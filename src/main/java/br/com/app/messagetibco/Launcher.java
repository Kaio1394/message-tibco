package br.com.app.messagetibco;

import br.com.app.messagetibco.model.TibcoConfigSender;
import br.com.app.messagetibco.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(MessageTibcoApplication.class, args);
    }
}
