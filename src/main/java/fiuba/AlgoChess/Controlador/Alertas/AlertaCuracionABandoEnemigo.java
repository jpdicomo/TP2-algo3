package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaCuracionABandoEnemigo extends Alert {
	
    public AlertaCuracionABandoEnemigo() {
        super(AlertType.INFORMATION);
        this.setTitle("¡ACCIÓN INVALIDA!");
        this.setContentText("No podes curar a un enemigo");
    }
}
