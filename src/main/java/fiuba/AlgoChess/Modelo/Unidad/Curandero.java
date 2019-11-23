package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.Curacion;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Curandero extends Unidad {
	
	
	public Curandero(Bando bando) {
		
		super(bando);
		this.vida = 75;
		this.costo = 2;
		this.habilidad = new Curacion(15);
	}

	
	@Override
	public void interactuarCon(Casillero unCasillero) {
		
		super.interactuarCon(unCasillero);
		this.bando.interactuarConUnAliado(unCasillero.getUnidad());
		
		double distancia = this.casillero.medirDistanciaA(unCasillero);
		this.habilidad.usarHabilidadCon(unCasillero, distancia);
	}
}
