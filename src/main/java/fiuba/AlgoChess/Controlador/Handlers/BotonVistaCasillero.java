package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonVistaCasillero implements EventHandler<ActionEvent> {

	private Casillero casillero;
    private VBox datosUnidad;
	
    
    public BotonVistaCasillero(Casillero casillero, VBox datosUnidad) {

    	this.casillero = casillero;
    	this.datosUnidad = datosUnidad;
	}
    
	@Override
	public void handle(ActionEvent event) {
		
		try {
			
			this.datosUnidad.getChildren().clear();
			Unidad unidad = this.casillero.getUnidad();
			this.datosUnidad.getChildren().add(new VistaDatosUnidad(unidad));
			
		} catch (CasilleroLibreException e) {
		}
	}

}
