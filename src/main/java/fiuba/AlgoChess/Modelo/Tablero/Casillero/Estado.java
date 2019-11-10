package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Estado {

 	// Metodos.

     /*
      * PRE:  El Casillero se encuentra en Estado Libre.
      * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
      */
     public abstract void agregarEntidad(Unidad unidad, Casillero casillero);


     /*
      * PRE:  El Casillero se encuentra en Estado Ocupado.
      * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
      */
     public abstract Unidad quitarEntidad();

}