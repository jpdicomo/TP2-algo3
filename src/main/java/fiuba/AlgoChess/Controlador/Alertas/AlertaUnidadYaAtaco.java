package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaUnidadYaAtaco extends Alert {
	
	public AlertaUnidadYaAtaco() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡OPCION INVALIDA!");
        this.setContentText("¡Esta unidad no puede volver a usar su poder!");
	}

}
