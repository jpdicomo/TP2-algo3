package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaCuracionABandoEnemigo extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
    public AlertaCuracionABandoEnemigo() {
        super(AlertType.INFORMATION);
        this.setTitle("¡ACCIÓN INVALIDA!");
        this.setContentText("No podes curar a un enemigo");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
