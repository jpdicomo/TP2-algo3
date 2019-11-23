package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Curacion extends Habilidad {

	
	public Curacion(int poder) {
	
		super(poder);
		this.alcance = new Alcance(1, 2);
	}

	
	@Override
	public void usarHabilidadCon(Casillero unCasillero, double distancia) {

		super.usarHabilidadCon(unCasillero, distancia);
		unCasillero.getUnidad().serCurado(this.poder);
	}
}
