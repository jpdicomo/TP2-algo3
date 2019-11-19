package fiuba.AlgoChess.Modelo.Ubicacion;

public class Este extends Direccion {
	
	@Override
	public Posicion decimeADondeMoverme(Posicion posicion) {

		return posicion.moveteHaciaElEste();
	}

}
