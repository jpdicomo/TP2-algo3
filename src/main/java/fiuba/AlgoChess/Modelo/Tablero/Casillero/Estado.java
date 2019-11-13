package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Estado {

 	// Metodos.

     /*
      * PRE:  El Casillero se encuentra en Estado Libre.
      * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
      */
     public abstract void agregarUnidad(Unidad unaUnidad, Bando bando);

     
     /*
      * PRE:  El Casillero se encuentra en Estado Ocupado.
      * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
      */
     public abstract Unidad getUnidad();
     

     /*
      * PRE:  El Casillero se encuentra en Estado Ocupado.
      * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
      */
     public abstract Unidad quitarUnidad();
     
     
     
     /* Este metodo recibe el bando del casillero y el danio
      * y si el bando de la unidad no coincide con el del casillero
      * aumenta el danio y luego se lo pasa a la unidad.
      * 
      * NOTA: implementarlo en las clases libre y ocupado
      * 
      */
     public abstract void recibirAtaque(Bando bando, int danio);

}