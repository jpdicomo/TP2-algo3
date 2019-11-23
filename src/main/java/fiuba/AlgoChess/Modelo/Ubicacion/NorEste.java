package fiuba.AlgoChess.Modelo.Ubicacion;

public class NorEste extends Direccion {

	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElNorEste();
	}
}
