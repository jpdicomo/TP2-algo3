package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaCuracionABandoEnemigo extends Alert {
	
    public AlertaCuracionABandoEnemigo() {
        super(AlertType.INFORMATION);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("No podes curar a un enemigo");
    }
}
