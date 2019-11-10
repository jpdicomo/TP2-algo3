package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Libre extends Estado {

	// Metodos.
	
	/*
	 * PRE:  El casillero se encuentra libre.
	 * POST: Se agrega una unidad al casillero.
	 */
    @Override
    public void agregarEntidad(Unidad unidad, Casillero casillero) {

        unidad.setCasillero(casillero);
    }

    /*
	 * PRE:  ...
	 * POST: ...
	 */
	@Override
	public Unidad quitarEntidad() {

		throw new CasilleroLibreException();
	}
}
