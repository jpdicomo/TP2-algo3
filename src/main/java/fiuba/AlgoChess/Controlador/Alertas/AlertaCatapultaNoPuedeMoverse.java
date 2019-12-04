package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaCatapultaNoPuedeMoverse extends Alert {
	
	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaCatapultaNoPuedeMoverse() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡MOVIMIENTO INVALIDO!");
        this.setContentText("¡La catapulta no puede moverse!");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
