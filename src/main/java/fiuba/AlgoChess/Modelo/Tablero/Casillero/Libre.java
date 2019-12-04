package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Libre extends Estado {

	
	@Override
	public void agregarUnidad(Unidad unaUnidad, Bando bando) {
		
		bando.interactuarConUnAliado(unaUnidad);
	}

	
	@Override
	public void agregarUnidad(Unidad unaUnidad) {
		
	}
}
