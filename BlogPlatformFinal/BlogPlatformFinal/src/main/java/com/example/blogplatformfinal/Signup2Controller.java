package com.example.blogplatformfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;
import java.util.Random;


public class Signup2Controller {
    public void onSignupButton2Click(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(firstscene);
        stage.show();

    }
}









