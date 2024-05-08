module com.example.blogplatformfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.blogplatformfinal to javafx.fxml;
    exports com.example.blogplatformfinal;
}