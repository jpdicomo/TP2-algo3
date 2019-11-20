package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class AtaqueLejos extends Habilidad {

	
	public AtaqueLejos(int poder) {

		super(poder);
		this.alcance = new Alcance(6, 20);
	}


	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {

		super.usarHabilidadCon(unCasillero, distancia);
		unCasillero.recibirDanio(this.poder);
	}
}
