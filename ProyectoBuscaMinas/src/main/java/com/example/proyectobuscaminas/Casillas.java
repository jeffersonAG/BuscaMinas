package com.example.proyectobuscaminas;
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
public class Casillas {
    private int posicionFila;
    private int posicionColumna;
    private boolean mina;
    private int MinasAlrededor;

/*se determina la posicion de la fila y de la columna en el tablero */
    public Casillas(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

/* estas son las propiedades usadas para la creacion del proyecto */
    public int getPosicionFila() {

        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {

        this.posicionFila = posicionFila;
    }

    public int getPosicionColumna() {

        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {

        this.posicionColumna = posicionColumna;
    }

    public boolean isMina() {

        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;

    }

    public int getMinasAlrededor() {
        return MinasAlrededor;
    }

    public void setMinasAlrededor(int MinasAlrededor) {

        this.MinasAlrededor = MinasAlrededor;
    }

    public void AumentarNumeroDeMinasAlrededor() {
        this.MinasAlrededor++;


    }


}





























