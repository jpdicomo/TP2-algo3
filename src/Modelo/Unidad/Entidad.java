package Modelo.Unidad;


import Modelo.Tablero.Casillero;

public abstract class Entidad {
    protected Casillero casillero;

    public void setCasillero(Casillero casillero){
        this.casillero = casillero;
    }
}
