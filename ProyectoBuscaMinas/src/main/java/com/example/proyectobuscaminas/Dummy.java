package com.example.proyectobuscaminas;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
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
import javafx.util.Duration;

import java.io.File;
import java.util.Random;

/**

 La clase BuscaMinas es la implementación del popular juego "Buscaminas".

 El objetivo del juego es descubrir todas las casillas del tablero sin explotar ninguna mina.

 El usuario puede descubrir una casilla clickeándola con el botón izquierdo del ratón

 o marcar una casilla sospechosa de tener una mina con el botón derecho.
 */
public class Dummy extends Application {

    // Tamaño de las casillas en píxeles
    private static final int TAMANO_CASILLA = 30;

    // Número de filas y columnas del tablero
    private static final int NUMERO_FILAS = 8;
    private static final int NUMERO_COLUMNAS = 8;
    private  int turno = 1;
    // Número de minas que habrá en el tablero
    private static final int NUMERO_MINAS = 6;

    // Matriz que representa el estado del tablero (0 = vacío, 1 = mina)
    private int[][] tablero;

    // Matriz de botones que representan las casillas del tablero
    private Button[][] botones;

    // Tiempo transcurrido desde que se comenzó la partida (en segundos)
    private int tiempo = 0;

    @Override
    public void start(Stage primaryStage) {
        // Arreglo para almacenar el tiempo transcurrido, con el fin de poder modificarlo en un evento
        final int[] tiempo = {0};

        // Creación del objeto Group para organizar los elementos de la escena
        Group root = new Group();

        // Creación de la escena con el tamaño determinado por el número de filas, columnas y tamaño de las casillas
        Scene scene = new Scene(root, NUMERO_COLUMNAS * TAMANO_CASILLA * 3, NUMERO_FILAS * TAMANO_CASILLA * 3);
        scene.setFill(Color.BLACK); // Establecer el color de fondo de la ventana a negro

        // Inicialización del tablero y de la matriz de botones
        tablero = new int[NUMERO_FILAS][NUMERO_COLUMNAS];
        botones = new Button[NUMERO_FILAS][NUMERO_COLUMNAS];









        /**

         Crea la cuadrícula de botones y los agrega al GridPane.
         Cada botón es un objeto de la clase Button con un tamaño prefijado y un estilo de fondo y borde específico.
         También se agrega un EventHandler para manejar los clics del ratón y llamar a las funciones descubrirCasilla() y marcarCasilla().
         Se genera un tablero vacío y luego se generan aleatoriamente las minas y se actualizan los números de las casillas.
         Se crea un temporizador y se lo agrega al BorderPane.
         Actualiza el tiempo cada segundo utilizando una Timeline.
         */
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        // Crea el botón de reinicio
        Button botonReiniciar = new Button("Reiniciar");
        // Agrega el botón de reinicio al diseño
        HBox hbox = new HBox(botonReiniciar);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setPadding(new Insets(0, 150, 650, 0));
        root.getChildren().add(hbox);

        // Agrega un evento de clic para el botón de reinicio
        botonReiniciar.setOnAction(event -> {
            // Restablece el tablero y la matriz de botones
            tablero = new int[NUMERO_FILAS][NUMERO_COLUMNAS];
            botones = new Button[NUMERO_FILAS][NUMERO_COLUMNAS];
            grid.getChildren().clear();});


        for (int fila = 0; fila < NUMERO_FILAS; fila++) {
            for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {

                // Crea un botón y lo agrega al botones[][]
                botones[fila][columna] = new Button("");
                botones[fila][columna].setPrefSize(TAMANO_CASILLA, TAMANO_CASILLA);
                botones[fila][columna].setStyle("-fx-background-color: #ddd; -fx-border-color: #999;");
                grid.add(botones[fila][columna], columna, fila);

                // Agrega un EventHandler para manejar los clics del ratón en cada botón
                final int posicionFila = fila;
                final int posicionColumna = columna;
                botones[fila][columna].setOnMouseClicked(new EventHandler<MouseEvent>()
                {





                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            if (turno==1){

                                // Llama a la función descubrirCasilla() si se hace clic izquierdo
                                descubrirCasilla(posicionFila, posicionColumna);
                                contarVacias(posicionFila,posicionColumna);
                                encontrarMinas(posicionFila,posicionColumna);
                                turno=2;
                                // Reproduce el sonido de clic izquierdo
                                Media sonidoClickIzquierdo = new Media(new File("src/main/resources/com/example/proyectobuscaminas/IMAGENES/Click.mp3").toURI().toString());
                                MediaPlayer reproductorClickIzquierdo = new MediaPlayer(sonidoClickIzquierdo);
                                reproductorClickIzquierdo.play();


                            }}
                        if (event.getButton() == MouseButton.SECONDARY && turno==2) {
                            if (turno==2){
                                while (turno==2){
                                    Random random = new Random();
                                    int x = random.nextInt(8);
                                    int y = random.nextInt(8);

                                    if (botones[x][y].getText().equals("")){

                                        descubrirCasilla(x, y);
                                        turno=1;
                                    }}}}


                        else if (event.getButton() == MouseButton.SECONDARY && turno==1)
                        {
                            // Reproduce el sonido de clic derecho
                            Media sonidoClickDerecho = new Media(new File("src/main/resources/com/example/proyectobuscaminas/IMAGENES/Alerta.mp3").toURI().toString());
                            MediaPlayer reproductorClickDerecho = new MediaPlayer(sonidoClickDerecho);
                            reproductorClickDerecho.play();
                            // Llama a la función marcarCasilla() si se hace clic derecho
                            marcarCasilla(posicionFila, posicionColumna);
                        }
                        comprobarVictoria(); // Comprueba si se ha ganado el juego
                    }



                    private void marcarCasilla(int posicionFila, int posicionColumna) {
                        Button boton = botones[posicionFila][posicionColumna];

                        // Se puede marcar si no está deshabilitado y hay menos de 10 banderas
                        if (boton.getText().equals("")) {
                            // Si la casilla está vacía, la marca con una bandera
                            boton.setStyle("-fx-background-color: blue; -fx-border-color: #999;");
                            boton.setText(":v");

                        } else if (boton.getText().equals(":v")) {
                            // Si la casilla ya tiene una bandera, la desmarca
                            boton.setStyle("-fx-background-color: #ddd; -fx-border-color: #999;");
                            boton.setText("");

                        }

                    }
                    private void comprobarVictoria() {
                        // Función que se llama para comprobar si se ha ganado el juego
                    }

                });

                tablero[fila][columna] = 0; // Inicializa el tablero con ceros
            }
        }


        generarMinas(); // Genera aleatoriamente las minas en el tablero
        actualizarNumeros(); // Actualiza los números en las casillas cercanas a las minas

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);

        // Crea un temporizador y lo agrega al BorderPane en la parte superior derecha
        Label temporizador = new Label("Tiempo: 0");
        temporizador.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        temporizador.setTextFill(Color.GREENYELLOW);
        BorderPane.setAlignment(temporizador, Pos.TOP_RIGHT);
        borderPane.setTop(temporizador);

        // Crea una nueva Timeline para actualizar el tiempo cada segundo
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tiempo[0]++;
                temporizador.setText("Tiempo: " + tiempo[0] + " segundos");
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        borderPane.setCenter(grid);





        // Añade el BorderPane al grupo root, que será el contenido de la escena
        root.getChildren().add(borderPane);

        // Establece la escena en el primaryStage y muestra la ventana
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**

     Método que genera las minas en posiciones aleatorias del tablero
     */

    private void encontrarMinas(int fila, int columna){



        for (fila=0;fila<8;fila++){
            for (columna =0; columna<8;columna++){
                if(!botones[fila][columna].getText().equals("")){
                    if(botones[fila][columna].getText().equals(String.valueOf(contarVacias(fila,columna)))){
                        System.out.println("Aqui hay mina");

                    }
                }

            }
        }
    }
    public int contarVacias(int fila, int columna){

        int nMinas=0;
        System.out.println("Holaaaaaaaaa");
        for (int i=Math.max(fila-1,0);i<=Math.min(fila+1,8-1);i++){
            for (int j=Math.max(columna-1,0);j<=Math.min(columna+1,8-1);j++){
                if (botones[i][j].getText().equals("")){
                    System.out.println((j+1)+" , "+(i+1));
                    return nMinas;
                }
            }



        }
        return nMinas;
    }
    private void generarMinas() {
        Random random = new Random();
        int minasGeneradas = 0;
        while (minasGeneradas < NUMERO_MINAS) {
            int filaAleatoria = random.nextInt(NUMERO_FILAS);
            int columnaAleatoria = random.nextInt(NUMERO_COLUMNAS);

            // Si la casilla no tiene ya una mina, la asignamos y aumentamos el contador
            if (tablero[filaAleatoria][columnaAleatoria] != -1) {
                tablero[filaAleatoria][columnaAleatoria] = -1;
                minasGeneradas++;
            }
        }
    }

    /**

     Método que actualiza el valor de las casillas que no contienen una mina, indicando cuántas minas hay en las casillas adyacentes.
     */
    private void actualizarNumeros() {
        for (int fila = 0; fila < NUMERO_FILAS; fila++) {
            for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
                if (tablero[fila][columna] != -1) {
                    int minasAlrededor = 0;

                    // Comprobar las 8 casillas adyacentes (si existen)
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
        // Si la casilla es una mina, muestra todas las minas y muestra un mensaje de derrota.
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
        }
        // Si la casilla es 0 y no ha sido descubierta, descubre todas las casillas alrededor.
        else if (tablero[fila][columna] == 0 && botones[fila][columna].getText().equals("")) {

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
        }
        // Si la casilla ya ha sido descubierta, no se hace nada.
        else if (!botones[fila][columna].getText().equals("")) {
            // Casilla ya descubierta
            return;
        }
        // Si la casilla tiene un valor mayor que cero, se muestra su valor y se cambia su estilo.
        else {
            // Casilla con valor mayor que cero
            botones[fila][columna].setText(String.valueOf(tablero[fila][columna]));
            botones[fila][columna].setStyle("-fx-background-color: #ccc;");
        }}}

