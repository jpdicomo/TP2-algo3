package fiuba.AlgoChess.Modelo.Ubicacion;

import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Posicion {
	
	private int fila;
	private int columna;


	public Casillero obtenerCasillero(Casillero[][] casilleros) {
	
		return casilleros[this.fila][this.columna];
	}
	
	
	public Posicion(int fila, int columna){
		
		this.fila = fila;
		this.columna = columna;
	}
	
	
	public Posicion moveteHacia(Direccion unaDireccion) {
		
		return unaDireccion.decimeADondeMoverme(this);
	}
	
	
	public Posicion moveteHaciaElNorte() {
		
		if(this.fila == 19) {
			
			throw new DesplazamientoInvalidoExcepcion();
			
		} else {
			
			return new Posicion(this.fila +1, this.columna);
		}
	}
	
	
	public Posicion moveteHaciaElSur() {
	
		if(this.fila == 0) {
	
			throw new DesplazamientoInvalidoExcepcion();

		} else {
			
			return new Posicion(this.fila -1, this.columna);
    	}
	}


	public Posicion moveteHaciaElOeste() {

		if (this.columna == 0) {

			throw new DesplazamientoInvalidoExcepcion();

		} else {
		
			return new Posicion(this.fila, this.columna - 1);
		}
	}


	public Posicion moveteHaciaElEste() {

		if (this.columna == 19) {
		
			throw new DesplazamientoInvalidoExcepcion();
		
		} else {
		
			return new Posicion(this.fila, this.columna + 1);
		}
	}
	
	
	public Posicion moveteHaciaElNorEste() {

		Posicion posicionDezplazadaAlNorte = this.moveteHaciaElNorte();
	
		return posicionDezplazadaAlNorte.moveteHaciaElEste();
	}

	
	public Posicion moveteHaciaElSurEste() {
		
		Posicion posicionDezplazadaAlSur = this.moveteHaciaElSur();
		
		return posicionDezplazadaAlSur.moveteHaciaElEste();
	}


	public Posicion moveteHaciaElSurOeste() {
		
		Posicion posicionDezplazadaAlSur = this.moveteHaciaElSur();

		return posicionDezplazadaAlSur.moveteHaciaElOeste();
	}

	
	public Posicion moveteHaciaElNorOeste() {
		
		Posicion posicionDezplazadaAlNorte = this.moveteHaciaElNorte();
		
		return posicionDezplazadaAlNorte.moveteHaciaElOeste();
	}

	
	public double medirDistancia(Posicion otraPosicion) {
		
		int x = Math.abs(this.columna - otraPosicion.columna);
		int y = Math.abs(this.fila - otraPosicion.fila);
		
		return Math.hypot(x, y);
	}
	
	// para debug
	public String convertirATexto() {
		
		return "fila: " + this.fila + " col: " + this.columna;
	}
	
}
