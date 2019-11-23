package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Bando {

	
	public void interactuarConUnAliado(Unidad unidadAliada) {
		
		unidadAliada.interactuarConUnAliado(this);
	}

	
	public void interactuarConUnEnemigo(Unidad unidadEnemiga) {
		
		unidadEnemiga.interactuarConUnEnemigo(this);
	}
}
