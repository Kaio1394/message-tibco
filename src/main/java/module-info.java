module br.com.app.messagetibco {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens br.com.app.messagetibco to javafx.fxml;
    exports br.com.app.messagetibco;
    exports br.com.app.messagetibco.controller;
    opens br.com.app.messagetibco.controller to javafx.fxml;
}