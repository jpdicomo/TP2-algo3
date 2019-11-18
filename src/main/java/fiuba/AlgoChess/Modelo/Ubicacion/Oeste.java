package fiuba.AlgoChess.Modelo.Ubicacion;

import fiuba.AlgoChess.Modelo.Tablero.Posicion;

public class Izquierda extends Direccion {
	
	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaLaIzquierda();
	}

}
