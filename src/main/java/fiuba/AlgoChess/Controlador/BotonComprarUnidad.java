package fiuba.AlgoChess.Controlador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonComprarUnidad implements EventHandler<ActionEvent> {

	private Jugador jugador;
	private Unidad unidad;

	
	public BotonComprarUnidad(Jugador jugador, Unidad unidad) {
		
		this.jugador = jugador;
		this.unidad = unidad;	
	}

	
	@Override
	public void handle(ActionEvent event) {

		try {
			
			this.jugador.agregarUnidad(this.unidad);
		
		} catch (PuntosInsuficientesException e) {
		
			return;
		}
	}
}
