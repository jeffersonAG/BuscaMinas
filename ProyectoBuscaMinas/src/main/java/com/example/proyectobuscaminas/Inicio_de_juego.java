package com.example.proyectobuscaminas;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class Inicio_de_juego extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creamos un contenedor para los elementos de la ventana
        StackPane root = new StackPane();


        // Creamos una imagen de fondo
        Image imagenFondo = new Image(new File("src/main/resources/com/example/proyectobuscaminas/IMAGENES/Portada.png").toURI().toString());
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


        // Creamos un botón para el tutorial del juego
        Circle circle = new Circle(50, 50, 25);
        circle.setFill(Color.PURPLE);
        Button boton = new Button("Tutorial");
        boton.setTranslateX(-300);
        boton.setTranslateY(95);
        boton.setFont(Font.font("Times New Roman", 14));
        boton.setGraphic(circle);
        root.getChildren().add(boton);

        // Creamos un botón para el juego
        Circle circle2 = new Circle(50, 50, 25);
        circle2.setFill(Color.GREEN);
        Button boton2 = new Button("Juego");
        boton2.setTranslateX(-100);
        boton2.setTranslateY(95);
        boton2.setGraphic(circle2);
        boton2.setFont(Font.font("Times New Roman", 14));

        root.getChildren().add(boton2);

        // Creamos un botón para el juego
        Circle circle3 = new Circle(50, 50, 25);
        circle3.setFill(Color.GOLD);
        Button boton3 = new Button("Acerca del Juego ");
        boton3.setTranslateX(100);
        boton3.setTranslateY(95);
        boton3.setGraphic(circle3);
        boton3.setFont(Font.font("Times New Roman", 14));
        root.getChildren().add(boton3);
        boton3.setOnAction(e -> {

            // Crear nueva ventana
            Stage Informacion = new Stage();
            Informacion.setTitle("Informacion");

            // Configurar la escena de la nueva ventana
            Group root2 = new Group();
            Scene nuevaEscena = new Scene(root2, 800, 650);
            nuevaEscena.setFill(Color.BLACK);
            Label etiqueta = new Label("Este juego fue realizado por el estudiante" +
                    "de la carrera de Ingenieria " +
                    "en Computadores : Jefferson Arias Gutiérrez " +
                    "del Instituto Tecnologico de Costa Rica " +
                    "Este Juego es una recreacion del Popular juego BuscaMinas " +
                    "El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina. " +
                    "Algunas casillas tienen un" +
                    " número, el cual indica la cantidad de minas que hay en las casillas circundantes." +
                    " ");

            etiqueta.setFont(Font.font("Times New Roman", 16));
            etiqueta.setMaxWidth(700);
            etiqueta.setWrapText(true);
            etiqueta.setTextFill(Color.GREENYELLOW);
            etiqueta.setTranslateX(50);
            etiqueta.setTranslateY(80);
            root2.getChildren().add(etiqueta);
            

            // Mostrar la nueva ventana
            Informacion.setScene(nuevaEscena);
            Informacion.show();
        });




    }

    public static void main(String[] args) {
        launch(args);
    }
}