package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.AtaqueCerca;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;

public class Soldado extends Unidad {
	
	
	public Soldado(Bando bando) {
		
		super(bando);
		this.vida = 100;
		this.costo = 1;
		this.habilidad = new AtaqueCerca(10);
	}

	
	@Override
	public void interactuarCon(Casillero unCasillero) {
		
		super.interactuarCon(unCasillero);
		this.bando.interactuarConUnEnemigo(unCasillero.getUnidad());
		
		double distancia = this.casillero.medirDistanciaA(unCasillero);
		this.habilidad.usarHabilidadCon(unCasillero, distancia);
	}
}
