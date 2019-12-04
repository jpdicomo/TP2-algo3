package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonSoltarUnidad implements EventHandler<ActionEvent> {

	private VistaUnidadSeleccionada unidadSeleccionada;
	private Media sonido;
	private MediaPlayer reproductor;


	public BotonSoltarUnidad(VistaUnidadSeleccionada unidadSeleccionada) {

		this.unidadSeleccionada = unidadSeleccionada;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		
		this.unidadSeleccionada.soltarUnidad();
		this.reproducirSonido();
	}
	
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/soltarUnidad.wav")
				.toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
