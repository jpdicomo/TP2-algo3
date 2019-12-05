package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonAtacar implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private VistaTablero tablero;
	private Media sonido;
	private MediaPlayer reproductor;
	
	
	public BotonAtacar(Posicion posicion, VistaTablero tablero) {
		
		this.posicion = posicion;
		this.tablero = tablero;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		
		this.reproducirSonido();
	
		if(this.tablero.estadoActual().equals("ataque")) {
			
			this.tablero.comportamientoSeleccionarUnidad();
		} else {
			
			this.tablero.comportamientoDeAtaque(this.posicion);
		}
	}
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
