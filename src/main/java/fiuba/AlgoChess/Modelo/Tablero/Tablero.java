package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

//import java.util.HashMap;	<--- para mas adelante

/* -----------IMPORTANTE-----------------
 * 
 * NOTA: Voy a comentar la versión del tablero que usa el HashMap y dejar la de la matriz
 * hasta que podamos hacer funcionar bien el hashmap, asi no se rompen los test.
 * 
 * A las cosas que comente les puse esta marca:	<--- para mas adelante
 * 
 * -----------IMPORTANTE-----------------
 */

public class Tablero {

	// Atributos

	private Casillero[][] casilleros;
//	HashMap<Posicion , Casillero > tablero = new HashMap<Posicion,Casillero>();	<--- para mas adelante
	

	// Metodos

	/* 
	 * POST: Crea un tablero listo para la partida con todos sus casilleros
	 * 		 desocupados.
	 */
	public Tablero(Jugador jugador1, Jugador jugador2) {

		this.casilleros = new Casillero[20][20];

		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 10; j++) {

				this.casilleros[j][i] = new Casillero(j, i, jugador1.getBando());
//				this.tablero.put(new Posicion(j,i), new Casillero(j, i, jugador1.getBando()));	<--- para mas adelante
			}

			for (int k = 10; k < 20; k++) {

				this.casilleros[k][i] = new Casillero(k, i, jugador2.getBando());
//				this.tablero.put(new Posicion(k,i), new Casillero(k, i, jugador2.getBando()));	<--- para mas adelante
			}
		}
	}

	
	/* Metodo privado.
	 * 
	 * POST: Devuelve un casillero del Tablero a partir de una Posicion valida.
	 *  
	 */
	private Casillero obtenerCasillero(Posicion posicion) {
		
		int x = posicion.getX();
		int y = posicion.getY();
		
		return this.casilleros[x][y];
//		return this.tablero.get(posicion);	<--- para mas adelante
	}
	
	/*
	 * PRE:  La ubicaciÃ³n elegida esta vacia.
	 * POST: Se coloca una nueva Unidad en el tablero.
	 */
	public void agregarNuevaUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarNuevaUnidad(unaUnidad);
	}
	
	
	/* Metodo privado.
	 * 
	 * Este metodo coloca una Unidad en un casillero del tablero
	 * verificar si la misma pertenece al mismo bando que el casillero
	 * destino.
	 * 
	 * PRE:  La ubicaciÃ³n elegida esta vacia.
	 * POST: Se coloca una Unidad en el tablero.
	 */
	private void agregarUnidad(Unidad unaUnidad, Posicion posicion){
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.agregarUnidad(unaUnidad);
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
	 * PRE:  La distancia entre la posicionInicial y la posicionFinal es menor a 1.
	 * POST: Mueve una Unidad de un casillero a otro.
	 */
	public void moverUnidad(Posicion posicionInicial, Posicion posicionFinal) {
		
		if(posicionInicial.medirDistanciaA(posicionFinal) > Math.sqrt(2)) {
			
			throw new DistanciaInvalidaException();
		}
		
		Unidad unidadAMover = this.seleccionarUnidad(posicionInicial);
		
		this.agregarUnidad(unidadAMover, posicionFinal);
		this.quitarUnidad(posicionInicial);
	}
	
	
	/*
	 * PRE:  Hay una Unidad en la Posicion indicada.
	 * POST: Quita una Unidad del tablero.
	 */
	public void quitarUnidad(Posicion posicion) {
		
		Casillero casillero = this.obtenerCasillero(posicion);
		casillero.quitarEntidad();
	}
}
