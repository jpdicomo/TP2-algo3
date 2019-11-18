package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueADistancia extends Ataque {

	
	public AtaqueADistancia(int danio) {

		super(danio);
	}

	
	@Override
	public void atacarA(Casillero unCasillero) {

		unCasillero.recibirAtaque(this.danio);
	}
}
