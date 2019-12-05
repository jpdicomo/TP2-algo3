package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AbrirBotonMover implements EventHandler<ActionEvent> {

	private VistaDatosUnidad unidadElegida;
	private Media sonido;
	private MediaPlayer reproductor;
	
	public AbrirBotonMover(VistaDatosUnidad unidadElegida) {
		
		this.unidadElegida = unidadElegida;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {

		this.reproducirSonido();
		this.unidadElegida.maximizarBotonera();
	}
	
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}

}
