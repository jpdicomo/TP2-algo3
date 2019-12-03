package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

import java.util.ArrayList;


public class Casillero {

	private Posicion posicion;
	private Estado estado;
	private Bando bando;
	private ArrayList<Casillero> vecinos;


	public Casillero(int fila, int columna, Bando bando) {

		this.posicion = new Posicion(fila, columna);
		this.estado = new Libre();
		this.bando = bando;
		this.vecinos = new ArrayList<Casillero>();
	}


	public void agregarVecino(Casillero vecino) {

		this.vecinos.add(vecino);
	}


	public void agregarNuevaUnidad(Unidad unaUnidad) {

		this.estado.agregarUnidad(unaUnidad, this.bando);
		unaUnidad.asignarCasillero(this);
		this.estado = new Ocupado(unaUnidad);
	}


	public void agregarUnidad(Unidad unaUnidad) {

		this.estado.agregarUnidad(unaUnidad);
		unaUnidad.asignarCasillero(this);
		this.estado = new Ocupado(unaUnidad);
	}


	public Unidad getUnidad() {

		return this.estado.getUnidad();
	}


	public ArrayList<Casillero> getVecinos() {

		return this.vecinos;
	}


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



	public boolean quitarUnidadMuerta() {

		try {

			if(this.estado.getUnidad().getVida() <= 0) {

				this.estado.quitarUnidad();
				return true;
			}else{
				return false;
			}


		} catch(CasilleroLibreException e ) {
			return false;
		}
	}



	public void recibirDanio(int danio) {

		this.estado.recibirDanio(this.bando, danio);
	}


	public boolean hayEnemigosCerca(Bando bando) {

		ArrayList<Unidad> unidadesVecinas = this.getUnidadesVecinas();

		for(Casillero vecino : this.vecinos) {

			unidadesVecinas.addAll(vecino.getUnidadesVecinas());
		}

		for (Unidad unidad : unidadesVecinas) {

			try {

				unidad.interactuarConUnAliado(bando);

			} catch(DistintoBandoException e) {

				return true;
			}
		}

		return false;
	}


	private ArrayList<Unidad> getUnidadesVecinas(){

		ArrayList<Unidad> unidadesVecinas = new ArrayList<Unidad>();

		for(Casillero vecino : this.vecinos) {

			try {

				unidadesVecinas.add(vecino.getUnidad());

			} catch(CasilleroLibreException e) {

			}
		}

		return unidadesVecinas;
	}


	public double medirDistanciaA(Casillero unCasillero) {

		return this.posicion.medirDistancia(unCasillero.posicion);
	}
	
	
	public Bando getBando() {
		return this.bando;
	}
}
