package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public abstract class Habilidad {

	protected int poder;
	protected Alcance alcance;

	
	public Habilidad(int poder) {

		this.poder = poder;
	}
	

	public void usarHabilidadCon(Casillero unCasillero, double distancia) {
		
		this.alcance.estaDentroDelAlcance(distancia);
	}
}
