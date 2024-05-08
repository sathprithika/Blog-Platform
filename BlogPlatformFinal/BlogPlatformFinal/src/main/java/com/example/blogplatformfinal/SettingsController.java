package com.example.blogplatformfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {
    public void onSettingButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Setting");
        stage.setScene(firstscene);
        stage.show();
    }

}
