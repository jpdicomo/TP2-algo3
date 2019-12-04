package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaDistintoBandoAlElegirUnidad extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaDistintoBandoAlElegirUnidad() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡SELECCIÓN INVALIDA!");
        this.setContentText("¡La unidad elegida no te pertenece, elige otra!");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
