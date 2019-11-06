package fiuba.AlgoChess.Modelo.Tablero;


import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public abstract class Estado {

    public abstract void agregarEntidad(Entidad entidad, Casillero casillero);
}