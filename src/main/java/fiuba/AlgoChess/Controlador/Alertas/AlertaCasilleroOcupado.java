package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaCasilleroOcupado extends Alert {
	
	public AlertaCasilleroOcupado() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡CASILLERO OCUPADO!");
        this.setContentText("¡El casillero seleccionado se encuentra ocupado, elija otro!");
	}

}
