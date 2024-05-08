package com.example.blogplatformfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfileController {
    public void onProfileButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Profile");
        stage.setScene(firstscene);
        stage.show();
    }
}
