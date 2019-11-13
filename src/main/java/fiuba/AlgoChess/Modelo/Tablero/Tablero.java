package fiuba.AlgoChess.Modelo.Tablero;

// Aca irian los imports.

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Aliada;
import fiuba.AlgoChess.Modelo.Unidad.Enemiga;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;


import java.util.HashMap;



public class Tablero {

	// Atributos

	//private Casillero[][] casilleros;

	HashMap<Posicion , Casillero > tablero = new HashMap<Posicion,Casillero>();

	// Metodos

	/*  
	 * POST: Crea un tablero listo para la partida
	 * 
	 * NOTA: Falta implementar en Casillero alguna manera de que reconozca a que
	 * 		 jugador "pertenece". Lo que hice ahora a modo de arreglo rapido es 
	 * 		 colocar un atributo "bando" en cada casillero que referencia al jugador.
	 */
	public Tablero() {


		for (int i = 0; i < 20; i++) {


			for (int j = 0; j < 10; j++) {


				this.tablero.put(new Posicion(j,i), new Casillero(j, i, new Aliada()));

			}

			for (int k = 10; k < 20; k++) {

				this.tablero.put(new Posicion(k,i), new Casillero(k, i, new Enemiga()));

			}
		}
	}

	/* PARA HACER TEST DE CREACION */

	public Casillero getCasillero(Posicion pos){
		return this.tablero.get(pos);
	}
	
	/*
	 * PRE:  El jugador ya ha elegido que unidad colocar.
	 * POST: Se coloca una unidad en el tablero.
	 * 
	 * NOTA: falta implementar en Casillero que reconozca cuando quieren colocar
	 * 		 una pieza en el, que el jugador es del mismo bando o no.
	 */
	public void colocarEntidad(Entidad entidad, Jugador jugador){
		
		boolean entidadColocada = false;

		do {

			int[] ubicacion = jugador.elegirCasillero();
			int x = ubicacion[0];
			int y = ubicacion[1];
			Posicion pos = new Posicion(x,y);
			Casillero casillero =  this.tablero.get(pos);

			entidadColocada = casillero.agregarEntidad(entidad);
			this.tablero.put(pos, casillero);
		} while(!entidadColocada);
	}

	public Casillero getDerecha(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		int x = posicion[0];
		int y = posicion[1];
		Posicion posDerecha = new Posicion(x+1,y);

		Casillero casilleroNuevo = this.tablero.get(posDerecha);
		return casilleroNuevo;

	}
	public Casillero getIzquierda(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		int x = posicion[0];
		int y = posicion[1];
		Posicion posIzquierda = new Posicion(x-1, y);

		Casillero casilleroNuevo = this.tablero.get(posIzquierda);
		return casilleroNuevo;


	}
	public Casillero getArriba(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		int x = posicion[0];
		int y = posicion[1];
		Posicion posArriba = new Posicion(x, y+1);

		Casillero casilleroNuevo = this.tablero.get(posArriba);
		return casilleroNuevo;

	}
	public Casillero getAbajo(Casillero casillero){
		int[] posicion = casillero.getPosicion();
		int x = posicion[0];
		int y = posicion[1];
		Posicion posAbajo = new Posicion(x, y-1);
		Casillero casilleroNuevo =this.tablero.get(posAbajo);

		return casilleroNuevo;

	}
}
