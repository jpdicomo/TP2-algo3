package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaMovimientoInvalido extends Alert {
	
	public AlertaMovimientoInvalido() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡MOVIMIENTO INVALIDO!");
        this.setContentText("¡Tu pieza no puede moverse en esa dirección!");
	}

}
