package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSoltarUnidad implements EventHandler<ActionEvent> {

	private VistaUnidadSeleccionada unidadSeleccionada;


	public BotonSoltarUnidad(VistaUnidadSeleccionada unidadSeleccionada) {

		this.unidadSeleccionada = unidadSeleccionada;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		
		this.unidadSeleccionada.soltarUnidad();
	}

}
