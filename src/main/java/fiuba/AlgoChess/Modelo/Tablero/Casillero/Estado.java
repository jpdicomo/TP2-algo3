package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;


public abstract class Estado {

	
	public void agregarUnidad(Unidad unaUnidad, Bando bando) {

		this.agregarUnidad(unaUnidad);
	}

	
	public void agregarUnidad(Unidad unaUnidad) {

		throw new CasilleroOcupadoException();
	}

	
	public Unidad getUnidad() {
		
		throw new CasilleroLibreException();
	}

	
	public Unidad quitarUnidad() {
		
		throw new CasilleroLibreException();
	}

	
	public void recibirDanio(Bando bando, int danio) {
		
		throw new CasilleroLibreException();
	}
}
