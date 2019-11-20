package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import java.util.ArrayList;

import fiuba.AlgoChess.Modelo.Errores.*;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Casillero {

	// Atributos.

	private Posicion posicion;
	private Estado estado;
	private Bando bando;
	private ArrayList<Casillero> vecinos;
	

	// Metodos.

	/*
	 * Este metodo esta bien.
	 * 
	 * POST: Crea un nuevo Casillero Libre con un determinado Bando.
	 */
	public Casillero(int fila, int columna, Bando bando) {

		this.posicion = new Posicion(fila, columna);
		this.estado = new Libre();
		this.bando = bando;
		this.vecinos = new ArrayList<Casillero>();
	}
	
	
	public void agregarVecino(Casillero vecino) {
		
		this.vecinos.add(vecino);
	}
	

	/*
	 * PRE:  El Casillero se encuentra Libre. El casillero y la unidad son del mismo
	 * 		 bando.
	 * POST: Agrega una Unidad al Casillero y este pasa a estar Ocupado.
	 */
	public void agregarNuevaUnidad(Unidad unaUnidad) {

		this.estado.agregarUnidad(unaUnidad, this.bando);
		unaUnidad.asignarCasillero(this);
		this.estado = new Ocupado(unaUnidad);
	}

	/*
	 * PRE: El Casillero se encuentra Libre.
	 * POST: Agrega una Unidad al Casillero y este pasa a estar Ocupado.
	 */
	public void agregarUnidad(Unidad unaUnidad) {

		this.estado.agregarUnidad(unaUnidad);
		unaUnidad.asignarCasillero(this);
		this.estado = new Ocupado(unaUnidad);
	}

	
	/*
	 * BUSCAR COMO BORRAR ESTE METODO
	 */
	public Unidad getUnidad() {

		return this.estado.getUnidad();
	}

	
	/*
	 * PRE:  El casillero se encuentra ocupado.
	 * POST: Quita una unidad al casillero.
	 */
	public Unidad quitarEntidad() {

		Unidad unidad;

		try {

			unidad = estado.quitarUnidad();
			estado = new Libre();

		} catch (CasilleroLibreException error) {

			return null;
		}

		return unidad;
	}

	public void recibirAtaque(int danio) {
		
		this.estado.recibirAtaque(this.bando, danio);
	}
}
