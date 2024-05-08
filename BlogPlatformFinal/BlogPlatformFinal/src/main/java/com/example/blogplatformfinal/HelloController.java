package com.example.blogplatformfinal;

import java.lang.NullPointerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;

import java.lang.Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;


public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label loginlabel;

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;
    @FXML
    private TextField passField;

    @FXML
    private TextArea bioField;
    @FXML
    private TextField linkField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernamefield;

    @FXML
    private TextArea contentField;
    @FXML
    private TextField titleField;

    public HelloController() throws IOException {
    }


    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginpage.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(firstscene);
        stage.show();
    }
    @FXML
    public void onSignupButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signuppage.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Sign up");
        stage.setScene(firstscene);
        stage.show();
    }


    public class DatabaseConnection {
        public  Connection databaselink;
        public  Connection getConnection() throws ClassNotFoundException {
            String databaseName="loginpageschema";
            String databaseUser ="root";
            String databasePassword ="*prithiCSE4*";
            String url= "jdbc:mysql://localhost/loginpageschema" ;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaselink= DriverManager.getConnection(url,databaseUser,databasePassword);
                System.out.println("DB connection success");

            }
            catch (Exception e){
                e.printStackTrace();
            }
            return databaselink;
        }
    }

    private static DatabaseConnection connect;

    public void validateLogin(ActionEvent e) throws ClassNotFoundException,SQLException {
        connect =  new DatabaseConnection();
        Connection connectDb =connect.getConnection();

        String verifyLogin = "select count(1) from logintable where username='"+usernameField.getText()+"' and password='"+passwordField.getText()+"'";
        try {
            Statement statement = connectDb.createStatement();
            ResultSet  queryresult= statement.executeQuery(verifyLogin);
            while(queryresult.next()){

                if(queryresult.getInt( 1)==1){
                    onLoginButton2Click(e);
                    System.out.println("Login success");
                }
                else{
                    System.out.printf("Login fail");
                }
            }

        } catch (SQLException a) {
            a.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    @FXML
    public void onLoginButton2Click(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {


        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(firstscene);
        stage.show();
    }

    private static DatabaseConnection connectSignup;

    public void validateSignup(ActionEvent e) throws ClassNotFoundException, SQLException {
        connectSignup = new DatabaseConnection();
        Connection connectDb = connectSignup.getConnection();

        String verifySignup = String.format("insert into signuptable (email,password) values('%s','%s');", emailField.getText(), passField.getText());

        System.out.println(verifySignup);

        try {
            Statement statement = connectDb.createStatement();


            if (!passField.getText().isBlank() && !emailField.getText().isBlank()){
                int queryResult = statement.executeUpdate(verifySignup);

                System.out.println("QueryRes    " + queryResult);
                onSignupButton2Click(e);
            }
        } catch (SQLException | IOException a) {
            a.printStackTrace();
        }
    }

    @FXML
    public void onSignupButton2Click(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {


        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(firstscene);
        stage.show();


    }





    @FXML
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(firstscene);
        stage.show();
    }

    private static DatabaseConnection connectProfile;

    public void validateProfile(ActionEvent event) throws ClassNotFoundException, SQLException {
        connectProfile = new DatabaseConnection();
        Connection connectDb = connectProfile.getConnection();

        Random rand = new Random();

        System.out.println("Name :" + nameField.getText());
        System.out.println("Username :" + usernamefield.getText());
        System.out.println("Bio :" + bioField.getText());
        System.out.println("Link :" + linkField.getText());

        String verifyProfile = String.format("insert into profiletable(name,username,bio,link) values('%s','%s','%s','%s');", nameField.getText(), usernamefield.getText(), bioField.getText(), linkField.getText());

        System.out.println(verifyProfile);


        try {
            Statement statement = connectDb.createStatement();
            int queryResult = statement.executeUpdate(verifyProfile);

            System.out.println("QueryRes    " + queryResult);

            if (queryResult == 1) {
                System.out.println("Values inserted");
            }
            else {
                System.out.println("Profile details insertion fail");
            }


        } catch (SQLException a) {
            a.printStackTrace();
        }
    }

    @FXML
    void onCancelProfile(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!nameField.getText().isBlank() && !usernamefield.getText().isBlank() && !bioField.getText().isBlank() && !linkField.getText().isBlank()){
            validateProfile(event);
        }

    }

    @FXML
    void onSaveProfile(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!nameField.getText().isBlank() && !usernamefield.getText().isBlank() && !bioField.getText().isBlank() && !linkField.getText().isBlank()){
            validateProfile(event);
        }

    }


    public void onProfileButtonClick(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Profile");
        stage.setScene(firstscene);
        stage.show();
    }

    private static DatabaseConnection connectBlog;

    public void validateBlog(ActionEvent event) throws ClassNotFoundException, SQLException {
        connectBlog = new DatabaseConnection();
        Connection connectDb = connectBlog.getConnection();

        Random rand = new Random();

        System.out.println("Title :" + titleField.getText());
        System.out.println("Content :" + contentField.getText());


        String verifyBlog = String.format("insert into blogtable(title,content) values('%s','%s');", titleField.getText(), contentField.getText());

        System.out.println(verifyBlog);


        try {
            Statement statement = connectDb.createStatement();
            int queryResult = statement.executeUpdate(verifyBlog);

            System.out.println("QueryRes    " + queryResult);

            if (queryResult == 1) {
                System.out.println("Values inserted");
            }
            else {
                System.out.println("Blog details insertion fail");
            }


        } catch (SQLException a) {
            a.printStackTrace();
        }
    }


    @FXML
    void onpublishButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!titleField.getText().isBlank() && !contentField.getText().isBlank() ){
            validateBlog(event);
        }




    }
    public void onBlogButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("blog.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Blog");
        stage.setScene(firstscene);
        stage.show();
    }
    public void onCommentButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("comments.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Comment");
        stage.setScene(firstscene);
        stage.show();
    }
    @FXML
    public void onaccountButton(ActionEvent event){

    }
    @FXML
    public void onnotificationButton(ActionEvent event){

    }
    @FXML
    public void oncommentsButton(ActionEvent event){

    }
    @FXML
    public void onsavesettings(ActionEvent event){

    }

    @FXML
    public void oncancelsettings(ActionEvent event){

    }


    public void onSettingButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loginfxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings.fxml"));


        Scene firstscene = new Scene(loginfxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Setting");
        stage.setScene(firstscene);
        stage.show();
    }
}