package fiuba.AlgoChess.Modelo.Tablero;


import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Casillero {

	// Atributos.
	
	private int[] posicion;
	private Estado estado;
	private Bando bando;
	
	// Metodos.
	
	/*
	 * PRE:  ...
	 * POST: ...
	 */
	public Casillero(int x, int y, Bando bando) {
		
		this.posicion = new int [2];
		this.posicion[0] = x;
		this.posicion[1] = y;
		this.estado = new Libre();
		this.bando = bando;
	}
	
	
	/*
	 * PRE:  El casillero se encuentra vacio.
	 * POST: Agrega una unidad al casillero.
	 */
	public boolean agregarEntidad(Entidad entidad) {

		try {

			estado.agregarEntidad(entidad, this);
			entidad.serColocadaEnCasilleroDeBando(this.bando);

		} catch (CasilleroOcupadoException error) {

			return false;
		} catch (DistintoBandoException e){

			return false;
		}

		estado = new Ocupado(entidad);
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


	public int[] getPosicion() {
		return posicion;
	}
}
