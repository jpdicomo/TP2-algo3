package fiuba.AlgoChess.Modelo.Ubicacion;

public class Oeste extends Direccion {
	
	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElOeste();
	}
}
