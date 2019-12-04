package fiuba.AlgoChess.Controlador.Alertas;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AlertaMovimientoACasilleroOcupado extends Alert {

	private Media sonido;
	private MediaPlayer reproductor;
	
	public AlertaMovimientoACasilleroOcupado() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO OCUPADO!");
        this.setContentText("¡Tu pieza no puede moverse a un casillero ocupado!");
    	this.sonido = new Media(new File("./recursos/sonidos/alerta.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);
	}

	public void mostrarAlerta() {
		
		this.reproductor.stop();
		this.reproductor.play();
		this.showAndWait();
	}

}
