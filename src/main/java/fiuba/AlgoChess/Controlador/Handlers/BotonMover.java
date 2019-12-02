package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMover implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private Direccion direccion;
	private VistaTablero tablero;
	
	public BotonMover(Posicion posicion, Direccion direccion, VistaTablero tablero) {
		
		this.posicion = posicion;
		this.direccion = direccion;
		this.tablero = tablero;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {

		try {

			this.tablero.moverUnidad(this.posicion, this.direccion);
		
		} catch (DesplazamientoInvalidoExcepcion e) {
			
			// Mostrar Cartel de Alerta
			
			// Agregar una excepcion que tiene que saltar si ya se movio alguien antes.
			
		} finally {
			
			this.tablero.actualizarTablero();
		}
	}
	
	

}
