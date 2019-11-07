package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Libre extends Estado {

	// Metodos.
	
	/*
	 * PRE:  ...
	 * POST: ...
	 */
    @Override
    public void agregarEntidad(Entidad entidad, Casillero casillero) {

        entidad.setCasillero(casillero);
    }

    /*
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
	public Entidad quitarEntidad() {

		throw new CasilleroLibreException();
	}
}
