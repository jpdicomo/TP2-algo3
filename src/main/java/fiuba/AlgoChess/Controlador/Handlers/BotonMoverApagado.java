package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaUnidadYaMovida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverApagado implements EventHandler<ActionEvent> {
	
	
	@Override
	public void handle(ActionEvent event) {

		AlertaUnidadYaMovida alerta = new AlertaUnidadYaMovida();
		alerta.mostrarAlerta();
	}
}
