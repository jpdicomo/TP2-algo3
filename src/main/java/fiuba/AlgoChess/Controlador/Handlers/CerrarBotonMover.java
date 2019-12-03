package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CerrarBotonMover implements EventHandler<ActionEvent> {

	private VistaDatosUnidad unidadElegida;
	
	public CerrarBotonMover(VistaDatosUnidad unidadElegida) {
		
		this.unidadElegida = unidadElegida;
	}
	
	
	@Override
	public void handle(ActionEvent event) {

		
		this.unidadElegida.minimizarBotonera();
	}
	
	

}
