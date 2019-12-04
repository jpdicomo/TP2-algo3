package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaDistanciaInvalida extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaDistanciaInvalida() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
		this.setHeaderText("¡ATAQUE INVALIDO!");
		this.setContentText("¡La unidad con la que intetas usar tu poder esta fuera de tu alcance!");
		this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
