package com.example.proyectobuscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class SeleccionJuego extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Creamos un contenedor para los elementos de la ventana
        StackPane root = new StackPane();


        // Creamos una imagen de fondo
        Image imagenFondo = new Image(new File("src/main/resources/com/example/proyectobuscaminas/IMAGENES/VentanaModo.png").toURI().toString());
        BackgroundImage fondo = new BackgroundImage(imagenFondo,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(fondo));
        // Creamos una escena y le asignamos el contenedor
        Scene scene = new Scene(root, 800, 650);
        scene.setFill(Color.BLACK);

        // Asignamos la escena a la ventana
        primaryStage.setScene(scene);

        // Asignamos un título a la ventana
        primaryStage.setTitle("BUSCA MINAS");

        // Mostramos la ventana
        primaryStage.show();
    }
}
