package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaUnidadYaMovida extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaUnidadYaMovida() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
		this.setHeaderText("¡OPCION INVALIDA!");
		this.setContentText("¡Ya moviste una unidad en este turno!");
		this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}

}
