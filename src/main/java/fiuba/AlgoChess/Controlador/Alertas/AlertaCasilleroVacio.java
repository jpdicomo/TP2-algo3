package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaCasilleroVacio extends Alert {
	
	public AlertaCasilleroVacio() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO OCUPADO!");
        this.setContentText("¡El casillero seleccionado se encuentra vacio, elija otro!");
	}

}
