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

	/*  
	 * POST: Crea un tablero listo para la partida
	 * 
	 * NOTA: Falta implementar en Casillero alguna manera de que reconozca a que
	 * 		 jugador "pertenece". Lo que hice ahora a modo de arreglo rapido es 
	 * 		 colocar un atributo "bando" en cada casillero que referencia al jugador.
	 */
	public Tablero(Jugador jugador1, Jugador jugador2) {

		this.casilleros = new Casillero[20][20];

		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 10; j++) {

				this.casilleros[j][i] = new Casillero(j, i, new Aliada());
			}

			for (int k = 10; k < 20; k++) {

				this.casilleros[k][i] = new Casillero(k, i, new Enemiga());
			}
		}
	}

	
	/*
	 * PRE:  El jugador ya ha elegido que unidad colocar.
	 * POST: Se coloca una unidad en el tablero.
	 * 
	 * NOTA: falta implementar en Casillero que reconozca cuando quieren colocar
	 * 		 una pieza en el, que el jugador es del mismo bando o no.
	 */
	public void colocarEntidad(Unidad unidad, Jugador jugador){
		
		boolean entidadNoColocada = true;

		do {

			int[] ubicacion = jugador.elegirCasillero();
			int x = ubicacion[0];
			int y = ubicacion[1];
			Casillero casillero = this.casilleros[x][y];
			
			entidadNoColocada = casillero.agregarEntidad(unidad);
			
		} while(entidadNoColocada);
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
