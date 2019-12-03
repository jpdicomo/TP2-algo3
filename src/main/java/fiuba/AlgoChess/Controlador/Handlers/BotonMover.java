package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaCatapultaNoPuedeMoverse;
import fiuba.AlgoChess.Controlador.Alertas.AlertaMovimientoACasilleroOcupado;
import fiuba.AlgoChess.Controlador.Alertas.AlertaMovimientoInvalido;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerMovidaException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Errores.PosicionInvalidaException;
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
		
		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException e) {
			
			Alert alertaMovimientoInvalido = new AlertaMovimientoInvalido();
			alertaMovimientoInvalido.showAndWait();
			
		} catch (CasilleroOcupadoException e) {
			
			Alert alertaMovimientoInvalido = new AlertaMovimientoACasilleroOcupado();
			alertaMovimientoInvalido.showAndWait();
			
		} catch (CatapultaNoPuedeSerMovidaException e) {
			
			Alert alertaCatapultaNoPuedeSerMovida = new AlertaCatapultaNoPuedeMoverse();
			alertaCatapultaNoPuedeSerMovida.showAndWait();
			
		} finally {
			
			this.tablero.actualizarTablero();
			this.tablero.comportamientoSeleccionarUnidad();
		}
	}
	
	

}
