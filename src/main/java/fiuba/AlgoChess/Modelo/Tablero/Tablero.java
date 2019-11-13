package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public class Tablero {

	// Atributos

	private Casillero[][] casilleros;

	
	// Metodos

	/* Este metodo esta bien.
	 * 
	 * POST: Crea un tablero listo para la partida con todos sus casilleros
	 * 		 desocupados.
	 */
	public Tablero(Jugador jugador1, Jugador jugador2) {

		this.casilleros = new Casillero[20][20];

		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 10; j++) {

				this.casilleros[j][i] = new Casillero(j, i, jugador1.getBando());
			}

			for (int k = 10; k < 20; k++) {

				this.casilleros[k][i] = new Casillero(k, i, jugador2.getBando());
			}
		}
	}

	
	/*
	 * 
	 */
	private Casillero obtenerCasillero(Posicion posicion) {
		
		int x = posicion.getX();
		int y = posicion.getY();
		
		return this.casilleros[x][y];
	}
	
	
	
	/* Este metodo esta bien.
	 * 
	 * PRE:  La ubicación elegida esta vacia.
	 * POST: Se coloca una unidad en el tablero.
	 */
	public void agregarUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarUnidad(unaUnidad);
	}
	
	
	
	public Unidad seleccionarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		
		return casillero.getUnidad();
	}
	
	
	public void moverUnidad(Posicion posicionActual, Posicion nuevaPosicion) {
		
		if(posicionActual.medirDistanciaA(nuevaPosicion) > 1.0) {
			
			throw new DistanciaInvalidaException();
		}
		
		Casillero casilleroActual = this.obtenerCasillero(posicionActual);
		Casillero casilleroDestino = this.obtenerCasillero(nuevaPosicion);
		
		Unidad unidadAMover = this.seleccionarUnidad(posicionActual);
		
		casilleroDestino.agregarUnidad(unidadAMover);
		casilleroActual.quitarEntidad();
	}

	
	
//	// -- REVISAR LOS METODOS DE ACA PARA ABAJO --
//
//	/*
//	 *
//	 */
//	public Casillero getDerecha(Casillero casillero){
//		int[] posicion = casillero.getPosicion();
//		Casillero casilleroNuevo = casilleros[posicion[0]+1][posicion[1]];
//		return casilleroNuevo;
//
//	}
//
//
//	/*
//	 *
//	 */
//	public Casillero getIzquierda(Casillero casillero){
//		int[] posicion = casillero.getPosicion();
//		Casillero casilleroNuevo = casilleros[posicion[0]-1][posicion[1]];
//		return casilleroNuevo;
//
//
//	}
//
//
//	/*
//	 *
//	 */
//	public Casillero getArriba(Casillero casillero){
//		int[] posicion = casillero.getPosicion();
//		Casillero casilleroNuevo = casilleros[posicion[0]][posicion[1]+1];
//		return casilleroNuevo;
//
//	}
//
//
//	/*
//	 *
//	 */
//	public Casillero getAbajo(Casillero casillero){
//		int[] posicion = casillero.getPosicion();
//		Casillero casilleroNuevo = casilleros[posicion[0]][posicion[1]-1];
//		return casilleroNuevo;
//
//	}
}
