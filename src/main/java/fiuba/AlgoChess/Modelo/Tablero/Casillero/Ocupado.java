package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Ocupado extends Estado {
	
	// Atributos.
	
	private Unidad unidad;


	// Metodos.

	/*
	 * POST: Crea un estado Ocupado para un casillero que tiene una Unidad en su interior.
	 */
    public Ocupado(Unidad unaUnidad) {

    	this.unidad = unaUnidad;
	}


	/*
	 * PRE:  El Casillero se encuentra en Estado Ocupado.
	 * POST: Se quita la Unidad del Casillero y se crea un Estado Libre.
	 */
	@Override
	public Unidad quitarUnidad() {
		
		return this.unidad;
	}


	@Override
	public Unidad getUnidad() {

		return this.unidad;
	}


	@Override
	public void recibirDanio(Bando bando, int danio) {
		
		try {
			
			this.unidad.interactuarConUnAliado(bando);
			
		} catch(DistintoBandoException e) {
			
			danio *= 1.05;
		}
		
		this.unidad.recibirDanio(danio);
	}
}