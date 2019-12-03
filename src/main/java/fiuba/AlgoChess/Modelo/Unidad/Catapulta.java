package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerMovidaException;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueEnArea;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Catapulta extends Unidad {
	
	
	public Catapulta(Bando bando) {

		super(bando);
		this.vida = 50;
		this.costo = 5;
		this.habilidad = new AtaqueEnArea(20);
	}
	
	
	@Override
	public void serCurado(double curacion) {
		
		throw new CatapultaNoPuedeSerCuradaException();
	}


	@Override
	public void interactuarCon(Casillero unCasillero) {

		super.interactuarCon(unCasillero);
		this.bando.interactuarConUnEnemigo(unCasillero.getUnidad());
		
		double distancia = this.casillero.medirDistanciaA(unCasillero);
		this.habilidad.usarHabilidadCon(unCasillero, distancia);
	}
	
	
	@Override
	public void serMovida() {
		
		throw new CatapultaNoPuedeSerMovidaException();
	}
}
