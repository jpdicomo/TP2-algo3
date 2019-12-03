package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaUnidadYaMovida extends Alert {

	public AlertaUnidadYaMovida() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
		this.setHeaderText("¡OPCION INVALIDA!");
		this.setContentText("¡Ya moviste una unidad en este turno!");
	}

}
