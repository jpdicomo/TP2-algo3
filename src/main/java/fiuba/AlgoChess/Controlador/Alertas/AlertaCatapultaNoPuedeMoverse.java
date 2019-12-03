package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaCatapultaNoPuedeMoverse extends Alert {
	
	public AlertaCatapultaNoPuedeMoverse() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡MOVIMIENTO INVALIDO!");
        this.setContentText("¡La catapulta no puede moverse!");
	}
}
