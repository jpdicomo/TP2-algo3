package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaUnidadYaAtaco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonAtacarApagado implements EventHandler<ActionEvent> {
	
	
	@Override
	public void handle(ActionEvent event) {

		Alert alerta = new AlertaUnidadYaAtaco();
		alerta.showAndWait();
	}
}
