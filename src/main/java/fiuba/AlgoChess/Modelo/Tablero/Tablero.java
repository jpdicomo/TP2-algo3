package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.*;
import fiuba.AlgoChess.Modelo.Unidad.*;
import fiuba.AlgoChess.Modelo.Ubicacion.*;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class Tablero {

	private Casillero[][] casilleros;
	
	
	public Tablero(Bando bando1, Bando bando2) {

		this.casilleros = new Casillero[20][20];
		this.crearCasilleros(bando1, bando2);
		this.conectarCasilleros();
	}

	
	private void crearCasilleros(Bando bando1, Bando bando2) {
		
		for (int columna = 0; columna < 20; columna++) {

			for (int fila = 0; fila < 10; fila++) {

				this.casilleros[fila][columna] = new Casillero(fila, columna, bando1);
			}

			for (int fila = 10; fila < 20; fila++) {

				this.casilleros[fila][columna] = new Casillero(fila, columna, bando2);
			}
		}
	}
	
	
	private Casillero obtenerCasillero(Posicion posicion) {
		
		Casillero casillero;
		
		try {
			
			casillero = posicion.obtenerCasillero(this.casilleros);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			throw new PosicionInvalidaException();
		}
		
		return casillero;
	}
	
	
	private void conectarCasilleros() {
		
		for (int fila = 0; fila < 20; fila++) {
			for (int columna = 0; columna < 20; columna++) {
				
				Posicion posicion = new Posicion(fila, columna);
				
				this.buscarCasilleroVecino(posicion, new Norte());
				this.buscarCasilleroVecino(posicion, new NorEste());
				this.buscarCasilleroVecino(posicion, new Este());
				this.buscarCasilleroVecino(posicion, new SurEste());
				this.buscarCasilleroVecino(posicion, new Sur());
				this.buscarCasilleroVecino(posicion, new SurOeste());
				this.buscarCasilleroVecino(posicion, new Oeste());
				this.buscarCasilleroVecino(posicion, new NorOeste());
			}
		}
	}


	private void buscarCasilleroVecino(Posicion posicion, Direccion direccion) {

		Casillero casillero = this.obtenerCasillero(posicion);
		Casillero vecino;
		
		try {
			
			vecino = this.obtenerCasillero(posicion.moveteHacia(direccion));
			casillero.agregarVecino(vecino);
			
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException e) {
			
		}
	}
	
	
	public void agregarNuevaUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarNuevaUnidad(unaUnidad);
	}
	
	
	private void agregarUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarUnidad(unaUnidad);
	}
	
	
	public void quitarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.quitarEntidad();
	}
	

	public Unidad seleccionarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		
		return casillero.getUnidad();
	}
	
	
	public Casillero getCasillero(Posicion posicion) {
		
		return this.obtenerCasillero(posicion);
	}
	
	
	public void moverUnidad(Posicion posicion, Direccion direccion) {
		
		Posicion posicionInicial = posicion;
		
		Batallon batallon = this.hayUnBatallonEn(posicionInicial);

		if(batallon.hayBatallon()) {
			
			this.moverBatallon(batallon, direccion);
			
		} else {
		
			Unidad unidadAMover = this.seleccionarUnidad(posicionInicial);
			Posicion posicionFinal = posicion.moveteHacia(direccion);
			
			this.agregarUnidad(unidadAMover, posicionFinal);
			this.quitarUnidad(posicionInicial);
		}
	}
	
	
	private void moverBatallon(Batallon batallon, Direccion direccion) {

		int fichasNoMovidas = 0;
		Posicion posicionSoldado;
		Posicion posicionFinal;
		Unidad soldado;
		
		for (int i = 0; i < 3; i++) {
			
			posicionSoldado = batallon.posicionIntegrante(i);
			soldado = this.seleccionarUnidad(posicionSoldado);
			
			try {
				
				posicionFinal = posicionSoldado.moveteHacia(direccion);
				this.agregarUnidad(soldado, posicionFinal);
				this.quitarUnidad(posicionSoldado);
				
			} catch (DesplazamientoInvalidoExcepcion | CasilleroOcupadoException e) {
				
				fichasNoMovidas++;
				if(fichasNoMovidas == 3) {
					throw new DesplazamientoInvalidoExcepcion();
				}
			}
		}
	}


	private Batallon hayUnBatallonEn(Posicion posicion) {
		
		Batallon batallon = new Batallon(false);
		Unidad unidadAMover = this.seleccionarUnidad(posicion);
		
		if(unidadAMover instanceof Soldado) {
		
			batallon = this.hayUnBatallonVerticalEn(posicion);
			
			if(!batallon.hayBatallon()) {
				
				batallon = this.hayUnBatallonHorizontalEn(posicion);	
			}
			if(!batallon.hayBatallon()) {
				
				batallon = this.hayUnBatallonDiagonalCrecienteEn(posicion);	
			}
			if(!batallon.hayBatallon()) {
				
				batallon = this.hayUnBatallonDiagonalDecrecienteEn(posicion);
			}
		}
		
		return batallon;
	}
	
	
	private Batallon hayUnBatallonVerticalEn(Posicion posicion) {
		
		Posicion posicionN;
		Posicion posicionS;
		boolean hayBatallon;
		
		try {
			
			posicionN = posicion.moveteHaciaElNorte();
			posicionS = posicion.moveteHaciaElSur();
			
			Casillero casilleroN = this.obtenerCasillero(posicionN);
			Casillero casilleroS = this.obtenerCasillero(posicionS);
			
			hayBatallon = casilleroN.getUnidad() instanceof Soldado;
			hayBatallon = hayBatallon && casilleroS.getUnidad() instanceof Soldado;
			
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException | CasilleroLibreException e) {
			
			return new Batallon(false);
		}
		
		return new Batallon(posicionN, posicion, posicionS);
	}

	
	private Batallon hayUnBatallonHorizontalEn(Posicion posicion) {
		
		Posicion posicionE;
		Posicion posicionO;
		boolean hayBatallon;
		
		try {
			
			posicionE = posicion.moveteHaciaElEste();
			posicionO = posicion.moveteHaciaElOeste();
			
			Casillero casilleroE = this.obtenerCasillero(posicionE);
			Casillero casilleroO = this.obtenerCasillero(posicionO);
			
			hayBatallon = casilleroE.getUnidad() instanceof Soldado;
			hayBatallon = hayBatallon && casilleroO.getUnidad() instanceof Soldado;
			
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException | CasilleroLibreException e) {
			
			return new Batallon(false);
		}
		
		return new Batallon(posicionE, posicion, posicionO);
	}
	
	
	private Batallon hayUnBatallonDiagonalCrecienteEn(Posicion posicion) {
		
		Posicion posicionNE;
		Posicion posicionSO;
		boolean hayBatallon;
		
		try {
			
			posicionNE = posicion.moveteHaciaElNorEste();
			posicionSO = posicion.moveteHaciaElSurOeste();
			
			Casillero casilleroNE = this.obtenerCasillero(posicionNE);
			Casillero casilleroSO = this.obtenerCasillero(posicionSO);
			
			hayBatallon = casilleroNE.getUnidad() instanceof Soldado;
			hayBatallon = hayBatallon && casilleroSO.getUnidad() instanceof Soldado;
			
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException | CasilleroLibreException e) {
			
			return new Batallon(false);
		}
		
		return new Batallon(posicionNE, posicion, posicionSO);
	}
	
	
	private Batallon hayUnBatallonDiagonalDecrecienteEn(Posicion posicion) {
		
		Posicion posicionNO;
		Posicion posicionSE;
		boolean hayBatallon;
		
		try {
			
			posicionNO = posicion.moveteHaciaElNorOeste();
			posicionSE = posicion.moveteHaciaElSurEste();
			
			Casillero casilleroNO = this.obtenerCasillero(posicionNO);
			Casillero casilleroSE = this.obtenerCasillero(posicionSE);
			
			hayBatallon = casilleroNO.getUnidad() instanceof Soldado;
			hayBatallon = hayBatallon && casilleroSE.getUnidad() instanceof Soldado;
			
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException | CasilleroLibreException e) {
			
			return new Batallon(false);
		}
		
		return new Batallon(posicionNO, posicion, posicionSE);
	}
}
