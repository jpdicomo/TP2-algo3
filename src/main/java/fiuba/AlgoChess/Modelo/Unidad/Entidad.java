package main.java.fiuba.AlgoChess.Modelo.Unidad;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public abstract class Entidad {


    private Casillero casillero;
    private int costo;

    public Entidad(Casillero casillero, int costo) {

        this.setCasillero(casillero);
        this.setCosto(costo);
    }


    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public void setCosto(int costoEntidad){
        this.costo = costoEntidad;
    }

    public int getCosto(){
        return (this.costo);
    }



}