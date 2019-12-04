package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaPuntosInsuficientes;
import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.*;
import java.io.File;
import javafx.scene.control.Label;

public class BotonComprarUnidad implements EventHandler<ActionEvent> {

	private Jugador jugador;
	private Unidad unidad;
	private Label puntosJugador;
	private Media sonido;
	private MediaPlayer reproductor;

	
	public BotonComprarUnidad(Jugador jugador, Unidad unidad, Label puntosJugador) {
		
		this.jugador = jugador;
		this.unidad = unidad;
		this.puntosJugador = puntosJugador;
		this.sonido = new Media(new File("./recursos/sonidos/cash.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	
	@Override
	public void handle(ActionEvent event) {

		try {
			
			this.jugador.agregarUnidad(this.unidad);
			this.reproductor.stop();
			this.reproductor.play();
		
		} catch (PuntosInsuficientesException e) {
		
			AlertaPuntosInsuficientes alertaPuntosInsuficientes = new AlertaPuntosInsuficientes();
			alertaPuntosInsuficientes.mostrarAlerta();
			return;
			
		} finally {
			
			this.puntosJugador.setText("Puntos restantes: " + this.jugador.getPuntos());
		}
	}
}
