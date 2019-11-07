package fiuba.AlgoChess.Modelo.Tablero;

// Acá irian los imports.

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Tablero {

	// Atribútos

	private Casillero[][] casilleros;

	
	// Métodos

	/*  
	 * POST: Crea un tablero listo para la partida
	 * 
	 * NOTA: Falta implementar en Casillero alguna manera de que reconozca a que
	 * 		 jugador "pertenece". Lo que hice ahora a modo de arreglo rapido es 
	 * 		 colocar un atributo "bando" en cada casillero que referencia al jugador.
	 */
	public Tablero(Jugador jugador1, Jugador jugador2) {

		this.casilleros = new Casillero[20][20];

		for (int i = 1; i <= 20; i++) {

			for (int j = 1; j <= 10; j++) {

				this.casilleros[j][i] = new Casillero(j, i);
			}

			for (int k = 10; k <= 20; k++) {

				this.casilleros[k][i] = new Casillero(k, i);
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
	public void colocarEntidad(Entidad entidad, Jugador jugador){
		
		boolean entidadNoColocada = true;
		
		do {

			int[] ubicacion = jugador.elegirCasillero(); // Metodo a implementar.
			int x = ubicacion[0];
			int y = ubicacion[1];
			Casillero casillero = this.casilleros[x][y];
			
			entidadNoColocada = casillero.agregarEntidad(entidad);
			
		} while(entidadNoColocada);
	}
	
	
	/*
	 * PRE:  Hay una pieza en la posicion elegida.
	 * POST: Se remueve una pieza que ha muerto del tablero.
	 */
	public Entidad quitarEntidad(Jugador jugador) {
		
		Entidad entidadQuitada = null;
		
		do {
	
			int[] ubicacion = jugador.elegirCasillero(); // Metodo a implementar.
			int x = ubicacion[0];
			int y = ubicacion[1];
			Casillero casillero = this.casilleros[x][y];
			
			entidadQuitada = casillero.quitarEntidad();
			
		} while(entidadQuitada == null);
		
		return entidadQuitada;
	}
	
	/*
	 * 
	 */
	public void moverEntidad(Jugador jugador) {
		
		Entidad entidad = this.quitarEntidad(jugador);
		this.colocarEntidad(entidad, jugador);
	}

}
