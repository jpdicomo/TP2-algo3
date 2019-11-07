package fiuba.AlgoChess.Modelo.Tablero;


import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Casillero {

	// Atributos.
	
	private int[] posicion;
	private Estado estado;
	private Jugador bando;
	
	
	// Metodos.
	
	/*
	 * PRE:  ...
	 * POST: ...
	 */
	public Casillero(int x, int y, Jugador jugador) {
		
		this.posicion = new int [2];
		this.posicion[0] = x;
		this.posicion[1] = y;
		this.bando = jugador;
		this.estado = new Libre();
	}
	
	
	/*
	 * PRE:  El casillero se encuentra vacio.
	 * POST: Agrega una unidad al casillero.
	 */
	public boolean agregarEntidad(Entidad entidad) {
		
		try {

			estado.agregarEntidad(entidad, this);
			estado = new Ocupado(entidad);

		} catch (CasilleroOcupadoException error) {

			return false;
		}
		
		return true;
	}


	/*
	 * PRE:  El casillero se encuentra ocupado.
	 * POST: Quita una unidad al casillero.
	 */
	public Entidad quitarEntidad() {
		Entidad entidad;
		
		try {

			entidad = estado.quitarEntidad();
			estado = new Libre();

		} catch (CasilleroLibreException error) {

			return null;
		}

		return entidad;
	}
}
