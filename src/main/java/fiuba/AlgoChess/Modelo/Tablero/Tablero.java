package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Errores.PosicionInvalidaException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Batallon;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Tablero {

	// Atributos

	private Casillero[][] casilleros;

	
	// Metodos

	/* 
	 * POST: Crea un tablero listo para la partida con todos sus casilleros
	 * 		 desocupados.
	 */
	public Tablero(Bando bando1, Bando bando2) {

		this.casilleros = new Casillero[20][20];
		this.crearCasilleros(bando1, bando2);
//		this.conectarCasilleros();
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
	
	
	/*
	 * POST: Devuelve un casillero del Tablero a partir de una Posicion valida.
	 */
	private Casillero obtenerCasillero(Posicion posicion) {
		
		Casillero casillero;
		
		try {
			
			casillero = posicion.obtenerCasillero(this.casilleros);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			throw new PosicionInvalidaException();
		}
		
		return casillero;
	}
	
//	NO BORRAR ESTO, PODEMOS NECESITARLO MAS ADELANTE
//	
//	private void conectarCasilleros() {
//		
//		for (int i = 0; i < 20; i++) {
//			for (int j = 0; j < 20; j++) {
//				
//				Casillero casillero = this.casilleros[i][j];
//				
//				casillero.agregarVecino("Arriba", this.buscarVecino(i,j+1));
//				casillero.agregarVecino("ArribaDerecha", this.buscarVecino(i+1,j+1));
//				casillero.agregarVecino("Derecha", this.buscarVecino(i+1,j));
//				casillero.agregarVecino("AbajoDerecha", this.buscarVecino(i+1,j-1));
//				casillero.agregarVecino("Abajo", this.buscarVecino(i,j-1));
//				casillero.agregarVecino("AbajoIzquierda", this.buscarVecino(i-1,j-1));
//				casillero.agregarVecino("Izquierda", this.buscarVecino(i-1,j));
//				casillero.agregarVecino("ArribaIzquierda", this.buscarVecino(i-1,j+1));
//			}
//		}
//	}
//
//
//	private Casillero buscarVecino(int i, int j) {
//
//		Casillero casillero;
//		
//		try {
//			casillero = this.casilleros[i][j];
//		} catch (ArrayIndexOutOfBoundsException e) {
//			casillero = null;
//		}
//		return casillero;
//	}
	
	
	/*
	 * PRE:  La ubicación elegida esta vacia.
	 * POST: Se coloca una nueva Unidad en el tablero.
	 */
	public void agregarNuevaUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarNuevaUnidad(unaUnidad);
	}
	
	
	/*
	 * Este metodo coloca una Unidad en un casillero del tablero
	 * verificar si la misma pertenece al mismo bando que el casillero
	 * destino.
	 * 
	 * PRE:  La ubicación elegida esta vacia.
	 * POST: Se coloca una Unidad en el tablero.
	 */
	private void agregarUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarUnidad(unaUnidad);
	}
	
	
	/*
	 * PRE:  Hay una Unidad en la Posicion indicada.
	 * POST: Quita una Unidad del tablero.
	 */
	public void quitarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.quitarEntidad();
	}
	

	/* 
	 * PRE:  La Posicion recibida esta ocupada por una Unidad.
	 * POST: Devuelve la Unidad.
	 */
	public Unidad seleccionarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		
		return casillero.getUnidad();
	}
	
	/*
	 * --------------------------------------------------------
	 * ----------- HASTA ACA TODO MAS O MENOS BIEN. -----------
	 * --------------------------------------------------------
	 */
	
	/*
	 * PRE:  La direccion hacia la que hay que moverse pertenece a un
	 * 		 Casillero valido (no me salgo del tablero) el cual esta vacio.
	 * POST: Mueve una Unidad de un casillero a otro.
	 */
	public void moverUnidad(Posicion posicion, Direccion direccion) {
		
		Posicion posicionInicial = posicion;
		Posicion posicionFinal = posicion.moveteHacia(direccion);
		
		Unidad unidadAMover = this.seleccionarUnidad(posicionInicial);
		Batallon batallon = this.hayUnBatallonEn(posicionInicial);

		if(batallon.hayBatallon()) {
			
			this.moverBatallon(batallon, direccion);
			
		} else {
			
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

	
	/*
	 * POST: Indica si hay un batallon formando una vertical en
	 * 		 la posicion recibida.
	 */
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

	
	/*
	 * POST: Indica si hay un batallon formando una horizontal en
	 * 		 la posicion recibida.
	 */
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

	
	/*
	 * POST: Indica si hay un batallon formando una diagonal creciente en
	 * 		 la posicion recibida.
	 */
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

	
	/*
	 * POST: Indica si hay un batallon formando una diagonal decreciente en
	 * 		 la posicion recibida.
	 */
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
