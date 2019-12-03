package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaAtaqueCancelado extends Alert {
	
    public AlertaAtaqueCancelado() {
    	
        super(AlertType.INFORMATION);
        this.setTitle("¡ATAQUE INVALIDO!");
        this.setContentText("Haz cancelado tu ataque");
    }
}
