package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueEnArea extends Habilidad {
	
	
	public AtaqueEnArea(int poder) {
		
		super(poder);
		this.alcance = new Alcance(6, 20);
	}


	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {

		super.usarHabilidadCon(unCasillero, distancia);
		// Buscar como extender el ataque de la catapulta.
		unCasillero.recibirDanio(this.poder);
	}
}
