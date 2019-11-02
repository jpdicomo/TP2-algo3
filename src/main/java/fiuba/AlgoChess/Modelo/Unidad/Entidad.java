package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public abstract class Entidad {

    private Casillero casillero;

    public Entidad(Casillero casillero) {

        this.setCasillero(casillero);
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }
}