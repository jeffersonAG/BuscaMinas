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

/**
 * The type Tutorial.
 */
public class Tutorial extends Application {

        @Override
    public void start(Stage primaryStage) {
        // Creamos un contenedor para los elementos de la ventana
        StackPane root = new StackPane();


        // Creamos una imagen de fondo
        Image imagenFondo = new Image(new File("src/main/resources/com/example/proyectobuscaminas/IMAGENES/Ventana.png").toURI().toString());
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

            // Creamos un botón para la explicacion de la seleccion de bandera
            Circle circle1 = new Circle(50, 50, 25);
            circle1.setFill(Color.CYAN);
            Button boton1 = new Button("Seleccion de Casilla ");
            boton1.setTranslateX(-250);
            boton1.setTranslateY(-10);
            boton1.setGraphic(circle1);
            boton1.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton1);
            boton1.setOnAction(e -> {

            // Crear nueva ventana
            Stage informacion = new Stage();
            informacion.setTitle("Información");

            // Configurar la escena de la nueva ventana
            Group root1 = new Group();
            Scene nuevaEscena = new Scene(root1, 800, 650);
            nuevaEscena.setFill(Color.BLACK);
            Label etiqueta = new Label( "Para poder selecionar una casillas donde usted crea que no hay una mina " +
                    "lo que tiene que es darle click izquierdo a su mouse o al botón del control y esta se abrirá  ");

            etiqueta.setFont(Font.font("Times New Roman", 16));
            etiqueta.setMaxWidth(700);
            etiqueta.setWrapText(true);
            etiqueta.setTextFill(Color.GREENYELLOW);
            etiqueta.setTranslateX(50);
            etiqueta.setTranslateY(80);
            root1.getChildren().add(etiqueta);

            informacion.setScene(nuevaEscena);
            informacion.show();
            });

            // Definir variable informacion2 en un ámbito superior
            Stage informacion2 = new Stage();

// Crear botón para la explicación de la colocación de bandera
            Circle circle2 = new Circle(50, 50, 25);
            circle2.setFill(Color.BLUE);
            Button boton2 = new Button("Colocar Bandera");
            boton2.setTranslateX(-250);
            boton2.setTranslateY(-95);
            boton2.setGraphic(circle2);
            boton2.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton2);

            boton2.setOnAction(e -> {
                // Configurar la escena de la nueva ventana
                Group root2 = new Group();
                Scene nuevaEscena2 = new Scene(root2, 800, 650);
                nuevaEscena2.setFill(Color.BLACK);
                Label etiqueta2 = new Label( "Si tiene dudas o sabe donde puede haber una mina lo que debe hacer es " +
                        "selecionar una bandera , para poder colocarla lo que tiene que hacer es presionar click " +
                        "derecho del boton y esta se va a colocar , si quiere quitar la bandera lo unic que tiene que " +
                        "hacer es volverle a dar click derecho y la bandera se va a quitar del tablero ");

                etiqueta2.setFont(Font.font("Times New Roman", 16));
                etiqueta2.setMaxWidth(700);
                etiqueta2.setWrapText(true);
                etiqueta2.setTextFill(Color.GREENYELLOW);
                etiqueta2.setTranslateX(50);
                etiqueta2.setTranslateY(80);
                root2.getChildren().add(etiqueta2);

                informacion2.setScene(nuevaEscena2);
                informacion2.setTitle("Información");
                informacion2.show();
            });


            Circle circle3 = new Circle(50, 50, 25);
            circle3.setFill(Color.CRIMSON);
            Button boton3 = new Button("Explosión de Mina");
            boton3.setTranslateX(-250);
            boton3.setTranslateY(100);
            boton3.setGraphic(circle3);
            boton3.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton3); // Agregamos el botón a la escena root2
            boton3.setOnAction(e -> {

                // Crear nueva ventana
                Stage informacion3 = new Stage();
                informacion3.setTitle("Información");

                // Configurar la escena de la nueva ventana
                Group root3 = new Group();
                Scene nuevaEscena3 = new Scene(root3, 800, 650);
                nuevaEscena3.setFill(Color.BLACK);
                Label etiqueta3 = new Label( " Si la casilla selecionada es una mina la casillas se pondra roja y " +
                        "dara un mensaje de texto dando a entender que usted perdio la partida ");


                etiqueta3.setFont(Font.font("Times New Roman", 16));
                etiqueta3.setMaxWidth(700);
                etiqueta3.setWrapText(true);
                etiqueta3.setTextFill(Color.GREENYELLOW);
                etiqueta3.setTranslateX(50);
                etiqueta3.setTranslateY(80);
                root3.getChildren().add(etiqueta3);

                informacion3.setScene(nuevaEscena3);
                informacion3.show();
            });

            //boton que lleva la informacion del modo de juego original
            Circle circle4 = new Circle(50, 50, 25);
            circle4.setFill(Color.GOLD);
            Button boton4 = new Button(" Modo Solitario");
            boton4.setTranslateX(250);
            boton4.setTranslateY(-95);
            boton4.setGraphic(circle4);
            boton4.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton4); // Agregamos el botón a la escena root2
            boton4.setOnAction(e -> {

                // Crear nueva ventana
                Stage informacion4 = new Stage();
                informacion4.setTitle("Información");

                // Configurar la escena de la nueva ventana
                Group root4 = new Group();
                Scene nuevaEscena4 = new Scene(root4, 800, 650);
                nuevaEscena4.setFill(Color.BLACK);
                Label etiqueta4 = new Label(" En este modo de Juego el jugador Juega con las reglas del juego de la " +
                        " version original " );

                etiqueta4.setFont(Font.font("Times New Roman", 16));
                etiqueta4.setMaxWidth(700);
                etiqueta4.setWrapText(true);
                etiqueta4.setTextFill(Color.GREENYELLOW);
                etiqueta4.setTranslateX(50);
                etiqueta4.setTranslateY(80);
                root4.getChildren().add(etiqueta4);

                informacion4.setScene(nuevaEscena4);
                informacion4.show();
            });

            //boton que lleva la informacion del modo de juego Dummy
            Circle circle5 = new Circle(50, 50, 25);
            circle5.setFill(Color.PURPLE);
            Button boton5 = new Button(" Modo Dummy");
            boton5.setTranslateX(250);
            boton5.setTranslateY(-10);
            boton5.setGraphic(circle5);
            boton5.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton5); // Agregamos el botón a la escena root2
            boton5.setOnAction(e -> {

                // Crear nueva ventana
                Stage informacion5 = new Stage();
                informacion5.setTitle("Información");

                // Configurar la escena de la nueva ventana
                Group root5 = new Group();
                Scene nuevaEscena5 = new Scene(root5, 800, 650);
                nuevaEscena5.setFill(Color.BLACK);
                Label etiqueta5 = new Label(" En este modo de Juego el jugador Juega vs  Computadora , en este caso " +
                        "la computadora elije una casilla al azar  y el primero que toque una mina pierde " );

                etiqueta5.setFont(Font.font("Times New Roman", 16));
                etiqueta5.setMaxWidth(700);
                etiqueta5.setWrapText(true);
                etiqueta5.setTextFill(Color.GREENYELLOW);
                etiqueta5.setTranslateX(50);
                etiqueta5.setTranslateY(80);
                root5.getChildren().add(etiqueta5);

                informacion5.setScene(nuevaEscena5);
                informacion5.show();
            });
            //boton que lleva la informacion del modo de juego Dummy
            Circle circle6 = new Circle(50, 50, 25);
            circle6.setFill(Color.GREEN);
            Button boton6 = new Button(" Modo Advance ");
            boton6.setTranslateX(250);
            boton6.setTranslateY(100);
            boton6.setGraphic(circle6);
            boton6.setFont(Font.font("Times New Roman", 14));
            root.getChildren().add(boton6); // Agregamos el botón a la escena root2
            boton6.setOnAction(e -> {

                // Crear nueva ventana
                Stage informacion6 = new Stage();
                informacion6.setTitle("Información");

                // Configurar la escena de la nueva ventana
                Group root6 = new Group();
                Scene nuevaEscena6 = new Scene(root6, 800, 650);
                nuevaEscena6.setFill(Color.BLACK);
                Label etiqueta6 = new Label(" En este modo de Juego el jugador Juega vs  Computadora , en este caso " +
                        "la computadora elije una casilla pero no al azar " +
                        "si no que con algoritmo determina la posible mina " +
                        "  pero la dinamica es igual el primero que toque una mina pierde la partida " );

                etiqueta6.setFont(Font.font("Times New Roman", 16));
                etiqueta6.setMaxWidth(700);
                etiqueta6.setWrapText(true);
                etiqueta6.setTextFill(Color.GREENYELLOW);
                etiqueta6.setTranslateX(50);
                etiqueta6.setTranslateY(80);
                root6.getChildren().add(etiqueta6);

                informacion6.setScene(nuevaEscena6);
                informacion6.show();
            });






        }
}
