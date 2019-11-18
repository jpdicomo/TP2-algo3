package fiuba.AlgoChess.Modelo.Ubicacion;

public class Sur extends Direccion {

	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElSur();
	}
}
