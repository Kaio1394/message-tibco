module br.com.app.messagetibco {
    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // Lombok (compilação apenas)
    requires static lombok;

    // JPA/Hibernate
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires modelmapper;

    // Abrindo pacotes para reflexão
    opens br.com.app.messagetibco to javafx.fxml; // se tiver FXML na raiz
    opens br.com.app.messagetibco.controller to javafx.fxml; // controladores
    opens br.com.app.messagetibco.model to org.hibernate.orm.core; // Hibernate callbacks/reflection

    // Exportando pacotes públicos
    exports br.com.app.messagetibco;
    exports br.com.app.messagetibco.controller;
    exports br.com.app.messagetibco.repository;
    exports br.com.app.messagetibco.model;
    exports br.com.app.messagetibco.service;

    opens br.com.app.messagetibco.dto to modelmapper;
}