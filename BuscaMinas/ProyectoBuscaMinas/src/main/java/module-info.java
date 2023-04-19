module com.example.proyectobuscaminas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.proyectobuscaminas to javafx.fxml;
    exports com.example.proyectobuscaminas;
}