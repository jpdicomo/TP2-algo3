package fiuba.AlgoChess.Modelo.Ubicacion;

import fiuba.AlgoChess.Modelo.Tablero.Posicion;

public class Derecha extends Direccion {
	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaLaDerecha();
	}

}
