package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public abstract class Habilidad {

	protected double poder;
	protected Alcance alcance;

	
	public Habilidad(double poder) {

		this.poder = poder;
	}
	

	public void usarHabilidadCon(Casillero unCasillero, double distancia) {
		
		this.alcance.estaDentroDelAlcance(distancia);
	}
}
