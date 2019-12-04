package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class BotonCambiarAEscenaDeCompra2 implements EventHandler<ActionEvent> {

	private Main main;
	private Media sonido;
	private MediaPlayer reproductor;
	
	public BotonCambiarAEscenaDeCompra2(Main main) {
		
		this.main = main;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {

		this.reproducirSonido();
		this.main.cambiarEscenaA(this.main.escenaCompraDeUnidades(2));
	}
	
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
