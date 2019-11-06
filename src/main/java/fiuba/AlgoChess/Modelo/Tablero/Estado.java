package main.java.fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

public abstract class Estado {

    public abstract void agregarEntidad(Entidad entidad, Casillero casillero);
}