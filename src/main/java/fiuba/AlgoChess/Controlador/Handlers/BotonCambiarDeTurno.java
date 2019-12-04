package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonCambiarDeTurno implements EventHandler<ActionEvent> {

	private Main main;
	private Media sonido;
	private MediaPlayer reproductor;

	public BotonCambiarDeTurno(Main main) {

		this.main = main;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		Scene escena;
		
		if(!this.main.getJugador(1).sigueJugando()) {
			
			escena = this.main.escenaFinal(2);
			
		} else if(!this.main.getJugador(2).sigueJugando()) {
			
			escena = this.main.escenaFinal(1);
			
		} else if(this.main.getNumeroJugador() == 2) {
		
			escena = this.main.escenaDeLucha(1);
		
		} else {
			
			escena = this.main.escenaDeLucha(2);
		}

		this.reproducirSonido();
		this.main.cambiarEscenaA(escena);
	}

	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
