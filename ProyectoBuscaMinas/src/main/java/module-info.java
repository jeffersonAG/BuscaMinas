module com.example.proyectobuscaminas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectobuscaminas to javafx.fxml;
    exports com.example.proyectobuscaminas;
}