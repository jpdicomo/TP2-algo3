package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Estado {

 	// Metodos.

     public abstract void agregarEntidad(Unidad unidad, Casillero casillero);

     public abstract Unidad quitarEntidad();
}