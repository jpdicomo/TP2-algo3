package fiuba.AlgoChess.Modelo.Ubicacion;

public class Norte extends Direccion {

	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElNorte();
	}
}
