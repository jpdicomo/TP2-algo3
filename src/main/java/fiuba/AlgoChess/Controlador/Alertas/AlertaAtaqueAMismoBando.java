package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaAtaqueAMismoBando extends Alert {
	
	private Media sonido;
	private MediaPlayer reproductor;
	
	
    public AlertaAtaqueAMismoBando() {
    	
        super(AlertType.WARNING);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("No podes atacar a un aliado");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}
}
