package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaDistintoBandoAlElegirUnidad extends Alert {

	public AlertaDistintoBandoAlElegirUnidad() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡SELECCIÓN INVALIDA!");
        this.setContentText("¡La unidad elegida no te pertenece, elige otra!");
	}
}
