package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonSalirDelJuego implements EventHandler<ActionEvent> {
	
	private Media sonido;
	private MediaPlayer reproductor;

	@Override
	public void handle(ActionEvent event) {
		
		this.reproducirSonido();
		Platform.exit();
	}
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
