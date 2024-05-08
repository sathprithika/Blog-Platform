package com.example.blogplatformfinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());

        stage.setTitle("Home");
        stage.setScene(firstscene);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}