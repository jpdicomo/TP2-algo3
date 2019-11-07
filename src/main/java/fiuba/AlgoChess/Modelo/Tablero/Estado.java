package fiuba.AlgoChess.Modelo.Tablero;


import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public abstract class Estado {

 	// Metodos

     public abstract void agregarEntidad(Entidad entidad, Casillero casillero);
     
     public abstract Entidad quitarEntidad();
}