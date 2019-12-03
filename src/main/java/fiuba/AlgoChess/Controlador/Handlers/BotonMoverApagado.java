package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaUnidadYaMovida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonMoverApagado implements EventHandler<ActionEvent> {
	
	
	@Override
	public void handle(ActionEvent event) {

		Alert alerta = new AlertaUnidadYaMovida();
		alerta.showAndWait();
	}
}
