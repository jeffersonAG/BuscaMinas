package com.example.proyectobuscaminas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
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

        //boton que lleva la informacion del modo de juego original
        Circle circle8 = new Circle(50, 50, 25);
        circle8.setFill(Color.GREEN);
        Button boton8 = new Button(" Modo Solitario");
        boton8.setTranslateX(-30);
        boton8.setTranslateY(-95);
        boton8.setGraphic(circle8);
        boton8.setFont(Font.font("Times New Roman", 14));
        root.getChildren().add(boton8); // Agregamos el botón a la escena root2
        boton8.setOnAction(e -> {
            Solitario solitario = new Solitario();
            solitario.start(new Stage());
        });



        //boton que lleva la informacion del modo de juego original
        Circle circle9 = new Circle(50, 50, 25);
        circle9.setFill(Color.BLUE);
        Button boton9 = new Button(" Modo Dummy");
        boton9.setTranslateX(-30);
        boton9.setTranslateY(-25);
        boton9.setGraphic(circle9);
        boton9.setFont(Font.font("Times New Roman", 14));
        root.getChildren().add(boton9); // Agregamos el botón a la escena root2
        boton9.setOnAction(e -> {
            Dummy dummy = new Dummy();
            dummy.start(new Stage());
        });



        //boton que lleva la informacion del modo de juego original
        Circle circle10 = new Circle(50, 50, 25);
        circle10.setFill(Color.RED);
        Button boton10 = new Button(" Modo Advance ");
        boton10.setTranslateX(-30);
        boton10.setTranslateY(45);
        boton10.setGraphic(circle10);
        boton10.setFont(Font.font("Times New Roman", 14));
        root.getChildren().add(boton10); // Agregamos el botón a la escena root2
        boton10.setOnAction(e -> {
            BuscaMinas buscaMinas = new BuscaMinas();
            buscaMinas.start(new Stage());
        });
    }
}
