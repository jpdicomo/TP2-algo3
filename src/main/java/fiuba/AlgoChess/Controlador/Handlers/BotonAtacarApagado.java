package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaUnidadYaAtaco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarApagado implements EventHandler<ActionEvent> {
	
	
	@Override
	public void handle(ActionEvent event) {

		AlertaUnidadYaAtaco alerta = new AlertaUnidadYaAtaco();
		alerta.mostrarAlerta();
	}
}
