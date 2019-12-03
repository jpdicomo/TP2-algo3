package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaNombreNoCargado extends Alert {
	
	public AlertaNombreNoCargado() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡FALTA INFORMACIÓN!");
        this.setContentText("¡Un jugador olvido cargar su nombre!");
	}

}
