package fiuba.AlgoChess.Modelo.Tablero.Casillero;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Ocupado extends Estado {

	private Unidad unidad;

	
	public Ocupado(Unidad unaUnidad) {
		
		this.unidad = unaUnidad;
	}

	
	@Override
	public Unidad quitarUnidad() {
		
		return this.unidad;
	}

	
	@Override
	public Unidad getUnidad() {
		
		return this.unidad;
	}

	
	@Override
	public void recibirDanio(Bando bando, double danio) {
		
		try {
			
			this.unidad.interactuarConUnAliado(bando);
			
		} catch (DistintoBandoException e) {
			
			danio *= 1.05;
		}
		this.unidad.recibirDanio(danio);
	}
}
