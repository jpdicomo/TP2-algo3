package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Ocupado extends Estado {
	
	// Atributos.
	
	private Entidad entidad;
	
	// Metodos.

	/*
	 * POST: ...
	 */
    public Ocupado(Entidad entidad) {

    	this.entidad = entidad;
	}

    /*
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
    public void agregarEntidad(Entidad entidad, Casillero casillero){

        throw new CasilleroOcupadoException();
    }

	/*
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
	public Entidad quitarEntidad() {
		
		return this.entidad;
	}
}

