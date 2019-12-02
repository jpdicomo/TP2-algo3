package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaYaTieneUnaUnidadSeleccionada extends Alert {

	public AlertaYaTieneUnaUnidadSeleccionada() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
		this.setHeaderText("¡OPCION INVALIDA!");
		this.setContentText("¡Ya tenes una unidad seleccionada, ubicala en el tablero o soltala para elegir otra!");
	}

}
