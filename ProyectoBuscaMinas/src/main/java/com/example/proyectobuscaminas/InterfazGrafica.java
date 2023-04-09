package com.example.proyectobuscaminas;
import javafx.application.Application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InterfazGrafica extends Application {
    int numeroFila = 10;
    int numeroColumna = 10;
    int numeroMinas = 20;

    Button[][] BotonesDeTablero; // Matriz de botones vacía
    Label tiempoLabel; // Label para mostrar el tiempo transcurrido
    int tiempoActual; // tiempo actual en segundos
    Timeline timeline; // línea de tiempo para actualizar el tiempo

    // Método start de la interfaz gráfica
    @Override
    public void start(Stage stage) throws Exception {
        CargarControles(stage); // Carga los controles del tablero en la ventana
        iniciarContadorTiempo(); // Inicia la línea de tiempo para actualizar el tiempo transcurrido
    }

    // Método constructor de la clase
    public InterfazGrafica() {
        // No es necesario agregar nada aquí, ya que todas las variables se inicializan al declararlas
    }

    // Método para crear los controles del tablero y agregarlos a la ventana
    private void CargarControles(Stage stage) {
        int posXReferencia = 25;
        int posYReferencia = 25;
        int anchoControl = 30;
        int altoControl = 30;

        VBox contenedorBotones = new VBox();
        contenedorBotones.setAlignment(Pos.CENTER); // Centra los botones verticalmente

        BotonesDeTablero = new Button[numeroFila][numeroColumna];
        for (int i = 0; i < BotonesDeTablero.length; i++) {
            HBox filaBotones = new HBox();
            filaBotones.setAlignment(Pos.CENTER); // Centra los botones horizontalmente
            for (int j = 0; j < BotonesDeTablero[i].length; j++) {
                BotonesDeTablero[i][j] = new Button();
                BotonesDeTablero[i][j].setId(i + "," + j);
                BotonesDeTablero[i][j].setBorder(null);
                BotonesDeTablero[i][j].setPrefSize(posXReferencia, posYReferencia);
                filaBotones.getChildren().add(BotonesDeTablero[i][j]);
            }
            contenedorBotones.getChildren().add(filaBotones);
        }

        // Agrega un Label para mostrar el tiempo transcurrido en la esquina
        tiempoLabel = new Label("0");
        tiempoLabel.setTextFill(Color.WHITE);
        tiempoLabel.setAlignment(Pos.CENTER);
        tiempoLabel.setPrefSize(60, 30);
        tiempoLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        BorderPane.setAlignment(tiempoLabel, Pos.TOP_LEFT); // Ubica el label en la esquina superior izquierda
        BorderPane.setMargin(tiempoLabel, new javafx.geometry.Insets(5)); // Agrega un margen al label
        BorderPane borderPane = new BorderPane(contenedorBotones);
        borderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        borderPane.setLeft(tiempoLabel); // Agrega el label al BorderPane a la izquierda del contenedor de botones
        Scene scene = new Scene(borderPane, 600, 300);
        stage.setScene(scene);
        stage.show();
    }

    // Método para iniciar el contador de tiempo
    private void iniciarContadorTiempo() {
        tiempoActual = 0;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> actualizarTiempo()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // Método para actualizar el tiempo transcurrido y mostrarlo en el Label
    private void actualizarTiempo() {
        tiempoActual++;
        tiempoLabel.setText("Tiempo: " + String.valueOf(tiempoActual));
    }
}























