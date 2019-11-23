package fiuba.AlgoChess.Modelo.Ubicacion;

public class SurOeste extends Direccion {

	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElSurOeste();
	}
}
