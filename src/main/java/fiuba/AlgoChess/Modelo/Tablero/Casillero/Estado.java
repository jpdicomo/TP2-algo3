package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Estado {

 	// Metodos.

     /*
      * PRE:  El Casillero se encuentra en Estado Libre.
      * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
      */
     public void agregarUnidad(Unidad unaUnidad, Bando bando) {
    	 
    	 this.agregarUnidad(unaUnidad);
     }
     
     
     /* Sobrecarga del metodo anterior que no verifica el bando de una pieza
      * antes de que esta sea colocada en un casillero.
      * 
      * PRE:  El Casillero se encuentra en Estado Libre.
      * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
      */
     public void agregarUnidad(Unidad unaUnidad)  {
 		
 		throw new CasilleroOcupadoException();
     }

     
     /*
      * PRE:  El Casillero se encuentra en Estado Ocupado.
      * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
      */
     public Unidad getUnidad() {

 		throw new CasilleroLibreException();
 	}
     

     /*
      * PRE:  El Casillero se encuentra en Estado Ocupado.
      * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
      */
     public Unidad quitarUnidad() {

 		throw new CasilleroLibreException();
 	}
     
     
     
     /* Este metodo recibe el bando del casillero y el danio
      * y si el bando de la unidad no coincide con el del casillero
      * aumenta el danio y luego se lo pasa a la unidad.
      * 
      * NOTA: implementarlo en las clases libre y ocupado
      * 
      */
     public void recibirDanio(Bando bando, int danio) {

 		throw new CasilleroLibreException();
 	}

}