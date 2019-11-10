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
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
    public void agregarEntidad(Unidad unidad, Casillero casillero){

        throw new CasilleroOcupadoException();
    }

	/*
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
	public Unidad quitarEntidad() {
		
		return this.unidad;
	}
}

