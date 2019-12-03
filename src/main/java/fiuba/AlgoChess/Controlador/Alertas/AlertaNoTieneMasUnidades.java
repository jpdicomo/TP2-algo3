package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaNoTieneMasUnidades extends Alert {

	
	public AlertaNoTieneMasUnidades() {
		
		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡OPCION INVALIDA!");
        this.setContentText("¡Ya no te quedan mas unidades de este tipo!");
	}
}
