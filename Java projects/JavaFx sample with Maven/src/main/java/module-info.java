module test {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires org.kordamp.iconli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome;

    opens sample;
    opens sample.controller;
    opens sample.model;
}