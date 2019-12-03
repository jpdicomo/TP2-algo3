package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaMovimientoACasilleroOcupado extends Alert {
	
	public AlertaMovimientoACasilleroOcupado() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO OCUPADO!");
        this.setContentText("¡Tu pieza no puede moverse a un casillero ocupado!");
	}

}
