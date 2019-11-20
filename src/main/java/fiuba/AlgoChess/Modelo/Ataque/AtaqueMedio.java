package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueMedio extends Habilidad {
	
	public AtaqueMedio(int poder) {

		super(poder);
		this.alcance = new Alcance(3, 5);
	}


	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {

		super.usarHabilidadCon(unCasillero, distancia);
		unCasillero.recibirDanio(this.poder);
	}
}
