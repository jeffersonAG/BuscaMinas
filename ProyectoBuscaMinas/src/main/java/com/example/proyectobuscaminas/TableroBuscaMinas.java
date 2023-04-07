package com.example.proyectobuscaminas;

public class TableroBuscaMinas {
    Casillas[][] casillas;

    int numFilas;
    int numColumnas;
    int numMinas;

    public TableroBuscaMinas(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas=numMinas;
        this.iniciarCasillas();
    }

    public void iniciarCasillas(){
        casillas=new Casillas[this.numFilas][this.numColumnas];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j]=new Casillas(i, j);
            }
        }
        GeneracionMinas();
    }

    private void GeneracionMinas(){
        int minasGeneradas=0;
        while(minasGeneradas!=numMinas){
            int PosicionTemporalFila=(int)(Math.random()*casillas.length);
            int PosicionTemporalColumna=(int)(Math.random()*casillas[0].length);
            if (!casillas[PosicionTemporalFila][PosicionTemporalColumna].isMina()){
                casillas[PosicionTemporalFila][PosicionTemporalColumna].setMina(true);
                minasGeneradas++;
            }
        }
    }

    private void Tablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j].isMina() ? "*" : "0");
            }
            System.out.println("");
        }
    }
    

    public static void main(String[] args) {
        TableroBuscaMinas tablero=new TableroBuscaMinas(600, 1000, 15 );
        tablero.Tablero();
    }
}
