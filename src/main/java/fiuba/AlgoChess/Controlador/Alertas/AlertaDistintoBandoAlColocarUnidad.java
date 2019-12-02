package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaDistintoBandoAlColocarUnidad extends Alert {

	public AlertaDistintoBandoAlColocarUnidad() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO INVALIDO!");
        this.setContentText("¡El casillero seleccionado no te pertenece, elige otro!");
	}
}
