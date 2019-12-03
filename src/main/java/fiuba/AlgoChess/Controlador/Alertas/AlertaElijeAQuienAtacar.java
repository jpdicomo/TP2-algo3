package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaElijeAQuienAtacar extends Alert {

	public AlertaElijeAQuienAtacar() {
		
		super(AlertType.INFORMATION);
		this.setTitle("AlgoChess - Error");
        this.setContentText("¡Ahora haz click sobre la unidad que quieras usar tu poder!");
	}
}
