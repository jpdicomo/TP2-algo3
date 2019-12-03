package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaAtaqueCancelado;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonAtacar implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private VistaTablero tablero;
	
	
	public BotonAtacar(Posicion posicion, VistaTablero tablero) {
		
		this.posicion = posicion;
		this.tablero = tablero;
	}
	
	
	@Override
	public void handle(ActionEvent event) {

		if(this.tablero.consultarEstado().equals("Seleccion")) {
			
			this.tablero.comportamientoDeAtaque(this.posicion);
			
		} else {
			
		this.tablero.comportamientoSeleccionarUnidad();
		}
	}
}
