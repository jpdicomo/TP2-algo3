package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaDistanciaInvalida extends Alert {

	public AlertaDistanciaInvalida() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
		this.setHeaderText("¡ATAQUE INVALIDO!");
		this.setContentText("¡La unidad con la que intetas usar tu poder esta fuera de tu alcance!");
	}
}
