package main.java.fiuba.AlgoChess.Modelo.Unidad;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public abstract class Entidad {


    private Casillero casillero;

    public Entidad(Casillero casillero) {

        this.setCasillero(casillero);
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public abstract <string>  getEstatus();


}