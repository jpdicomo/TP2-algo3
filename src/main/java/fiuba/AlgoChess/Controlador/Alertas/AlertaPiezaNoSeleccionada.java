package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaPiezaNoSeleccionada extends Alert{

	public AlertaPiezaNoSeleccionada() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡NINGUNA UNIDAD SELECCIONADA!");
        this.setContentText("¡No ha seleccionado ninguna unidad para colocar!");
	}
}
