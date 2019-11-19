package fiuba.AlgoChess.Modelo.Ubicacion;

public class NorOeste extends Direccion {

	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElNorOeste();
	}
}
