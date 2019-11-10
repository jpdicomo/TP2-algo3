package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Libre extends Estado {

	// Metodos.

	/*
	 * PRE:  El Casillero se encuentra en Estado Libre.
	 * POST: Se agrega una Unidad al Casillero y se crea un Estado Ocupado.
	 */
    @Override
    public void agregarEntidad(Unidad unidad, Casillero casillero) {

        unidad.setCasillero(casillero);
    }


	/*
	 * PRE:  El Casillero se encuentra en Estado Ocupado.
	 * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
	 */
	@Override
	public Unidad quitarEntidad() {

		throw new CasilleroLibreException();
	}
}