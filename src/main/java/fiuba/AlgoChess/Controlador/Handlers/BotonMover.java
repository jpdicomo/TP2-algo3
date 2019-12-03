package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaMovimientoACasilleroOcupado;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonMover implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private Direccion direccion;
	private VistaTablero tablero;
	private VistaDatosUnidad unidadElegida;
	
	
	public BotonMover(Posicion posicion, Direccion direccion, VistaTablero tablero, VistaDatosUnidad unidadElegida) {
		
		this.posicion = posicion;
		this.direccion = direccion;
		this.tablero = tablero;
		this.unidadElegida = unidadElegida;
	}
	
	
	@Override
	public void handle(ActionEvent event) {

		try {

			this.tablero.getTablero().moverUnidad(this.posicion, this.direccion);
			this.unidadElegida.apagarBotonMover();
		
		} catch (DesplazamientoInvalidoExcepcion e) {
			
			Alert alertaMovimientoInvalido = new AlertaMovimientoACasilleroOcupado();
			alertaMovimientoInvalido.showAndWait();
			
			
			// Agregar una excepcion que tiene que saltar si ya se movio alguien antes.
			
		} finally {
			
			this.tablero.actualizarTablero();
		}
	}
	
	

}
