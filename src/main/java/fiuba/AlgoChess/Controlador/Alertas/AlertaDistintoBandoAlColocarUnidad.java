package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaDistintoBandoAlColocarUnidad extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaDistintoBandoAlColocarUnidad() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO INVALIDO!");
        this.setContentText("¡El casillero seleccionado no te pertenece, elige otro!");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
