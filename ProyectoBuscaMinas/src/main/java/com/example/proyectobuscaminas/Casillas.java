package com.example.proyectobuscaminas;

public class Casillas {
    private int posicionFila;
    private int posicionColumna;
    private boolean mina;
    private int MinasAlrededor;


    public Casillas(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }


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

    public int getMinasAlrededoP() {
        return MinasAlrededor;
    }

    public void setMinasAlrededor(int MinasAlrededor) {
        this.MinasAlrededor = MinasAlrededor;
    }

    public void AumentarNumeroDeMinasAlrededor() {
        this.MinasAlrededor++;


    }
}





























