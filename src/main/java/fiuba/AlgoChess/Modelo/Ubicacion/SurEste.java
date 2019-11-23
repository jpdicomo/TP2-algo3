package fiuba.AlgoChess.Modelo.Ubicacion;

public class SurEste extends Direccion {

	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElSurEste();
	}
}
