package com.example.proyectobuscaminas;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InterfazGrafica extends Application {
    int numeroFila = 10;
    int numeroColumna = 10;
    int numeroMinas = 20;

    Button[][] BotonesDeTablero; // Matriz de botones vacía

    // Método start de la interfaz gráfica
    @Override
    public void start(Stage stage) throws Exception {
        CargarControles(stage); // Carga los controles del tablero en la ventana
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

        // Se agrega el contenedor al panel de la escena
        // Se agrega el contenedor al panel de la escena
        BorderPane borderPane = new BorderPane(contenedorBotones);
        borderPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        Scene scene = new Scene(borderPane, 600, 300);
        stage.setScene(scene);
        stage.show();

    }}

















