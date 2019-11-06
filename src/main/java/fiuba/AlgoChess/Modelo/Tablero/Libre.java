package main.java.fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Libre extends Estado {

    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero) {

        entidad.setCasillero(casillero);
    }
}
