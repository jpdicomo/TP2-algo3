package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonCambiarAEscenaDeLucha implements EventHandler<ActionEvent> {

	private Main main;
	private int jugadorInicial;
	private Media sonido;
	private MediaPlayer reproductor;

	public BotonCambiarAEscenaDeLucha(Main main) {

		this.main = main;
		this.jugadorInicial = (int) (Math.random() * 2 + 1);
	}
	
	@Override
	public void handle(ActionEvent event) {

		this.reproducirSonido();
		this.main.cambiarEscenaA(this.main.escenaDeLucha(this.jugadorInicial));
	}

	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
