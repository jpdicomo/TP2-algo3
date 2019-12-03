package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaAtaqueAMismoBando extends Alert {
	
    public AlertaAtaqueAMismoBando() {
        super(AlertType.INFORMATION);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("No podes atacar a un aliado");
    }
}
