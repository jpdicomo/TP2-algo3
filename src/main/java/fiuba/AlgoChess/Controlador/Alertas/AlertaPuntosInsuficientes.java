package fiuba.AlgoChess.Controlador.Alertas;

import javafx.scene.control.Alert;

public class AlertaPuntosInsuficientes extends Alert {
	
	public AlertaPuntosInsuficientes() {

		super(AlertType.WARNING);
		this.setTitle("AlgoChess - Error");
        this.setHeaderText("¡PUNTOS INSUFICIENTES!");
        this.setContentText("No tienes puntos suficientes para comprar esa unidad");
	}

}
