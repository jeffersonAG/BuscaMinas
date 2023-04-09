package com.example.proyectobuscaminas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;

public class BuscaMinas extends Application {

    private static final int TAMANO_CASILLA = 30;
    private static final int NUMERO_FILAS = 8;
    private static final int NUMERO_COLUMNAS = 8;
    private static final int NUMERO_MINAS = 10;

    private int[][] tablero;
    private Button[][] botones;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, NUMERO_COLUMNAS * TAMANO_CASILLA * 2, NUMERO_FILAS * TAMANO_CASILLA * 2);

        tablero = new int[NUMERO_FILAS][NUMERO_COLUMNAS];
        botones = new Button[NUMERO_FILAS][NUMERO_COLUMNAS];

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Centra los botones horizontal y verticalmente
        for (int fila = 0; fila < NUMERO_FILAS; fila++) {
            for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
                botones[fila][columna] = new Button("");
                botones[fila][columna].setPrefSize(TAMANO_CASILLA, TAMANO_CASILLA);
                botones[fila][columna].setStyle("-fx-background-color: #ddd; -fx-border-color: #999;");
                grid.add(botones[fila][columna], columna, fila);

                final int posicionFila = fila;
                final int posicionColumna = columna;
                botones[fila][columna].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            descubrirCasilla(posicionFila, posicionColumna);
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            marcarCasilla(posicionFila, posicionColumna);
                        }
                        comprobarVictoria();
                    }

                    private void marcarCasilla(int posicionFila, int posicionColumna) {
                    }

                    private void comprobarVictoria() {
                    }

                });

                tablero[fila][columna] = 0;
            }
        }
        generarMinas();
        actualizarNumeros();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);


        root.getChildren().add(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generarMinas() {
        Random random = new Random();
        int minasGeneradas = 0;
        while (minasGeneradas < NUMERO_MINAS) {
            int filaAleatoria = random.nextInt(NUMERO_FILAS);
            int columnaAleatoria = random.nextInt(NUMERO_COLUMNAS);
            if (tablero[filaAleatoria][columnaAleatoria] != -1) {
                tablero[filaAleatoria][columnaAleatoria] = -1;
                minasGeneradas++;
            }
        }
    }

    private void actualizarNumeros() {
        for (int fila = 0; fila < NUMERO_FILAS; fila++) {
            for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
                if (tablero[fila][columna] != -1) {
                    int minasAlrededor = 0;
                    if (fila > 0 && columna>0) // error here
                        // Contar minas alrededor
                        if (fila > 0 && columna > 0 && tablero[fila-1][columna-1] == -1) minasAlrededor++; // arriba-izquierda
                    if (fila > 0 && tablero[fila-1][columna] == -1) minasAlrededor++; // arriba
                    if (fila > 0 && columna < NUMERO_COLUMNAS-1 && tablero[fila-1][columna+1] == -1) minasAlrededor++; // arriba-derecha
                    if (columna > 0 && tablero[fila][columna-1] == -1) minasAlrededor++; // izquierda
                    if (columna < NUMERO_COLUMNAS-1 && tablero[fila][columna+1] == -1) minasAlrededor++; // derecha
                    if (fila < NUMERO_FILAS-1 && columna > 0 && tablero[fila+1][columna-1] == -1) minasAlrededor++; // abajo-izquierda
                    if (fila < NUMERO_FILAS-1 && tablero[fila+1][columna] == -1) minasAlrededor++; // abajo
                    if (fila < NUMERO_FILAS-1 && columna < NUMERO_COLUMNAS-1 && tablero[fila+1][columna+1] == -1) minasAlrededor++; // abajo-derecha

                    tablero[fila][columna] = minasAlrededor;
                }
            }
        }
    }

    private void descubrirCasilla(int fila, int columna) {
        if (tablero[fila][columna] == -1) {
            // Mostrar todas las minas
            for (int i = 0; i < NUMERO_FILAS; i++) {
                for (int j = 0; j < NUMERO_COLUMNAS; j++) {
                    if (tablero[i][j] == -1) {
                        botones[i][j].setStyle("-fx-background-color: #f00;");
                    }
                }
            }
            // Mostrar mensaje de derrota
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("¡Has perdido!");
            alert.setHeaderText(null);
            alert.setContentText("Has detonado una mina. ¡Mejor suerte la próxima vez!");
            alert.showAndWait();
        } else if (tablero[fila][columna] == 0 && botones[fila][columna].getText().equals("")) {
            // Descubrir todas las casillas alrededor
            botones[fila][columna].setText(String.valueOf(tablero[fila][columna]));
            botones[fila][columna].setStyle("-fx-background-color: #ccc;");
            if (fila > 0 && columna > 0) descubrirCasilla(fila-1, columna-1); // arriba-izquierda
            if (fila > 0) descubrirCasilla(fila-1, columna); // arriba
            if (fila > 0 && columna < NUMERO_COLUMNAS-1) descubrirCasilla(fila-1, columna+1); // arriba-derecha
            if (columna > 0) descubrirCasilla(fila, columna-1); // izquierda
            if (columna < NUMERO_COLUMNAS-1) descubrirCasilla(fila, columna+1); // derecha
            if (fila < NUMERO_FILAS-1 && columna > 0) descubrirCasilla(fila+1, columna-1); // abajo-izquierda
            if (fila < NUMERO_FILAS-1) descubrirCasilla(fila+1, columna); // abajo
            if (fila < NUMERO_FILAS-1 && columna < NUMERO_COLUMNAS-1) descubrirCasilla(fila+1, columna+1); // abajo-derecha
        } else if (!botones[fila][columna].getText().equals("")) {
// Casilla ya descubierta
            return;
        } else {
// Casilla con valor mayor que cero
            botones[fila][columna].setText(String.valueOf(tablero[fila][columna]));
            botones[fila][columna].setStyle("-fx-background-color: #ccc;");
        }
    }}

