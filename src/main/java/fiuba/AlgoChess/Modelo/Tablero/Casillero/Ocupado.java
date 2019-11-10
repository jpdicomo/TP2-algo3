package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Ocupado extends Estado {
	
	// Atributos.
	
	private Unidad unidad;


	// Metodos.

	/*
	 * POST: Crea un estado ocupado para un casillero que tiene una unidad en su interior.
	 */
    public Ocupado(Unidad unidad) {

    	this.unidad = unidad;
	}


	/*
	 * PRE:  El Casillero se encuentra en Estado Libre.
	 * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
	 */
	@Override
    public void agregarEntidad(Unidad unidad, Casillero casillero){

        throw new CasilleroOcupadoException();
    }


	/*
	 * PRE:  El Casillero se encuentra en Estado Ocupado.
	 * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
	 */
	@Override
	public Unidad quitarEntidad() {
		
		return this.unidad;
	}
}