package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Libre extends Estado {

	// Metodos.

	/*
	 * PRE:  El Casillero se encuentra en Estado Libre.
	 * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
	 */
    @Override
    public void agregarUnidad(Unidad unaUnidad, Bando bando) {
    	
		bando.interactuarConUnAliado(unaUnidad.getBando());
    }
    
    
    /* Sobrecarga del metodo anterior que no verifica el bando de una pieza
     * antes de que esta sea colocada en un casillero.
     * 
     * PRE:  El Casillero se encuentra en Estado Libre.
     * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
     */
    @Override
	public void agregarUnidad(Unidad unaUnidad) {
		
	}
    

	/*
	 * PRE:  El Casillero se encuentra en Estado Ocupado.
	 * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
	 */
	@Override
	public Unidad quitarUnidad() {

		throw new CasilleroLibreException();
	}


	@Override
	public Unidad getUnidad() {

		throw new CasilleroLibreException();
	}


	@Override
	public void recibirAtaque(Bando bando, int danio) {

		throw new CasilleroLibreException();
	}
}