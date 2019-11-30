package fiuba.AlgoChess.Controlador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonComprarUnidad implements EventHandler<ActionEvent> {

	private Jugador jugador;
	private Unidad unidad;
	private Label puntosJugador;

	
	public BotonComprarUnidad(Jugador jugador, Unidad unidad, Label puntosJugador) {
		
		this.jugador = jugador;
		this.unidad = unidad;
		this.puntosJugador = puntosJugador;
	}

	
	@Override
	public void handle(ActionEvent event) {

		try {
			
			this.jugador.agregarUnidad(this.unidad);
		
		} catch (PuntosInsuficientesException e) {
		
			return;
			
		} finally {
			
			this.puntosJugador.setText("Puntos restantes: " + this.jugador.getPuntos());
		}
	}
}
