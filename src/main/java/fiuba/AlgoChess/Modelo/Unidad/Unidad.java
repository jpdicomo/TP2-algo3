package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ataque.Habilidad;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;


public abstract class Unidad {
	
	protected double vida;
	protected Bando bando;
	protected int costo;
	protected Habilidad habilidad;
	protected Casillero casillero;

	
	public Unidad(Bando bando) {
		
		this.bando = bando;
	}

	
	public void recibirDanio(double danio) {
		
		this.vida -= danio;
	}

	
	public void serCurado(double curacion) {
		
		this.vida += curacion;
	}

	
	public void interactuarCon(Casillero unCasillero) {
		
		if (this == unCasillero.getUnidad()) {
			
			throw new MismaUnidadException();
		}
	}

	
	public void interactuarConUnEnemigo(Bando bandoDelEnemigo) {
		
		if (this.bando == bandoDelEnemigo) {
			
			throw new MismoBandoException();
		}
	}

	
	public void interactuarConUnAliado(Bando bandoDelAliado) {
		
		if (this.bando != bandoDelAliado) {
			
			throw new DistintoBandoException();
		}
	}


	public void interactuarConUnAliado(Unidad unidadAliada){
		
		this.bando.interactuarConUnAliado(unidadAliada);
	}


	public boolean sigoViva() {

		return (this.vida > 0);
	}

	
	public boolean soyUnSoldado() {
		
		return false;
	}
	
	
	public void serMovida() {
		
	}
	
	
	public double getVida() {
		
		return this.vida;
	}

	
	public int getCosto() {
		
		return this.costo;
	}

	
	public void asignarCasillero(Casillero casillero) {
		
		this.casillero = casillero;
	}
}
