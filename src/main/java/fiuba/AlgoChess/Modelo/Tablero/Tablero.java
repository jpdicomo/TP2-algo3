package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Aliada;
import fiuba.AlgoChess.Modelo.Unidad.Enemiga;
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

	
	/* Este metodo esta bien.
	 * 
	 * PRE:  La ubicación elegida esta vacia.
	 * POST: Se coloca una unidad en el tablero.
	 */
	public void colocarUnidad(Unidad unidad, int[] ubicacion){
		
		int x = ubicacion[0];
		int y = ubicacion[1];
		Casillero casillero = this.casilleros[x][y];
		
		casillero.agregarEntidad(unidad);
	}

	// -- REVISAR LOS METODOS DE ACA PARA ABAJO --

	/*
	 *
	 */
	public Casillero getDerecha(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		Casillero casilleroNuevo = casilleros[posicion[0]+1][posicion[1]];
		return casilleroNuevo;

	}


	/*
	 *
	 */
	public Casillero getIzquierda(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		Casillero casilleroNuevo = casilleros[posicion[0]-1][posicion[1]];
		return casilleroNuevo;


	}


	/*
	 *
	 */
	public Casillero getArriba(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		Casillero casilleroNuevo = casilleros[posicion[0]][posicion[1]+1];
		return casilleroNuevo;

	}


	/*
	 *
	 */
	public Casillero getAbajo(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		Casillero casilleroNuevo = casilleros[posicion[0]][posicion[1]-1];
		return casilleroNuevo;

	}
}
