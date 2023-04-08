package com.example.proyectobuscaminas;

/*librerias importadas necesarias para la creacion del proyecto */
import java.util.List;
import java.util.LinkedList;
import java.util.function.Consumer;


public class TableroBuscaMinas { // clase donde se almacena la estructura logica (clase principal )
    /*INSTITUTO TECNOLOGICO DE COSTA RICA
       INGENIERIA EN COMPUTADORES
    AUTOR: Jefferson Arias Gutierrez
    CARNET:2021131112
    PROFESOR: Luis Diego Nogera Mena
    NOMBRE DEL PROGRAMA: BuscaMinas
    LENGUAJE DEL PROGRAMA : Java
    Version :
    DESCRIPCION DEL PROGRAMA:
    * */

    Casillas[][] casillas;  // matriz vacia

    int numeroFilas;   //parametro de cantidad de  numeros de filas
    int numeroColumnas;//parametro de cantidad de numero de columnas
    int numeroMinas;// parametro de cantidad de numero de minas


    /*constructor de la especificacion de la cantidad de filas ,  cantidad de columnas del tablero
     y cantidad de minas que va a tener el tablero
    * */
    public TableroBuscaMinas(int numeroFilas, int numeroColumnas, int numeroMinas) {
        this.numeroFilas = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        this.numeroMinas = numeroMinas;
        this.iniciarCasillas();
    }

/*se crea cada una de las instancias de la casillas */
    public void iniciarCasillas() {
        casillas = new Casillas[this.numeroFilas][this.numeroColumnas];// el tablero tiene un tamaño de la
                                                                       // cantidad de filas y columnas

        for (int i = 0; i < casillas.length; i++) {// recorrido de la cantidad de filas en el tablero

            for (int j = 0; j < casillas[i].length; j++) {// recorrido en la cantidad de columnas que esta en
                                                          // posicion i

                casillas[i][j] = new Casillas(i, j);//  una posicion i,j  extraida del recorrido de las filas
                                                    // y de las columnas
            }
        }
        GeneracionMinas();// llama al metodo GeneracionMinas
    }
/*se genera un metodo dentro de la clase principal para la generacion de minas en una coordenada aleatoria
* */
    private void GeneracionMinas() {
        int minasGeneradas = 0;
        while (minasGeneradas != numeroMinas) { // se crea un recorrido para saber si las minas generadas es diferente
                                                // al numero de minas
            int PosicionTemporalFila = (int) (Math.random() * casillas.length);// se multiplica un numero random con
                                                                               //el maximo de filas

            int PosicionTemporalColumna = (int) (Math.random() * casillas[0].length);//se multiplica un numero random con
                                                                                     //el maximo de columnas teniendo en cuenta
                                                                                     // el numero de columnas existente

            if (!casillas[PosicionTemporalFila][PosicionTemporalColumna].isMina()) {// pregunta si hay una mina en esa posicion
                casillas[PosicionTemporalFila][PosicionTemporalColumna].setMina(true);// si no hay mina estonces crea una mina
                minasGeneradas++;
            }
        }
        ActualizarNumerosDeMinas(); //llama el metodo ActualizarNumerosDeMinas


    }
/* este metodo se usa para imprimir lo que existe en el tablero */
    private void Tablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].isMina() ? "#" : "0"); /*se usa para identificar las minas de los espacios vacios
                                                                        en la terminal de IDE en este caso las minas se representa
                                                                        con # y los espacios libres con 0 */
            }
            System.out.println("");

        }

    }


/*metodo para detectar las minas alrededor de las casillas */
    private void ActualizarNumerosDeMinas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isMina()) {
                    List<Casillas> CasillasAlrededor = obtenerCasillasAlrededor(i, j);
                    CasillasAlrededor.forEach((c) -> c.AumentarNumeroDeMinasAlrededor());

                }
            }
        }
    }

    private List<Casillas> obtenerCasillasAlrededor(int posicionFila, int posicionColumna) {
        List<Casillas> listaCasillas = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            int tmpPosicionFila = posicionFila;
            int tmpPosicionColumna = posicionColumna;
            switch (i) {
                case 0:
                    tmpPosicionFila--;
                    break; //Arriba
                case 1:
                    tmpPosicionFila--;
                    tmpPosicionColumna++;
                    break; //Arriba Derecha
                case 2:
                    tmpPosicionColumna++;
                    break; //Derecha
                case 3:
                    tmpPosicionColumna++;
                    tmpPosicionFila++;
                    break; //Derecha Abajo
                case 4:
                    tmpPosicionFila++;
                    break; //Abajo
                case 5:
                    tmpPosicionFila++;
                    tmpPosicionColumna--;
                    break; //Abajo Izquierda
                case 6:
                    tmpPosicionColumna--;
                    break; //Izquierda
                case 7:
                    tmpPosicionFila--;
                    tmpPosicionColumna--;
                    break;
            }//Izquierda Arriba

            // paramatero para no se salga de la matriz deseada
            if (tmpPosicionFila >= 0 && tmpPosicionFila < this.casillas.length
                    && tmpPosicionColumna >= 0 && tmpPosicionColumna < this.casillas[0].length) {
                listaCasillas.add(this.casillas[tmpPosicionFila][tmpPosicionColumna]);
            }
        }
        return listaCasillas;


    }
    private void pistas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].getMinasAlrededor());
            }
            System.out.println("");
        }}


    public static void main(String[] args) {
        TableroBuscaMinas tablero=new TableroBuscaMinas(8, 8, 3);/*se genera el tablero del proyecto
        */
        tablero.Tablero();// llama ala funcion del tablero
        System.out.println("___");
        tablero.pistas(); // llama ala funcion de pistas para verlas en el tablero
    }

}













