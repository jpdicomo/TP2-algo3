package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueALargaDistancia extends Ataque {
	
	public AtaqueALargaDistancia(int danio) {
		
		super(danio);
	}

	
	@Override
	public void atacarA(Casillero unCasillero) {

		unCasillero.recibirAtaque(this.danio);
	}
}
