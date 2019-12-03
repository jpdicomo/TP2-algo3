package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaCasilleroOcupado;
import fiuba.AlgoChess.Controlador.Alertas.AlertaDistintoBandoAlColocarUnidad;
import fiuba.AlgoChess.Controlador.Alertas.AlertaPiezaNoSeleccionada;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Errores.NoTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import fiuba.AlgoChess.Vista.Tablero.VistaCasillero;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ClickParaColocarUnidad implements EventHandler<ActionEvent> {

	private VistaUnidadSeleccionada unidad;
	private Tablero tablero;
	private VistaCasillero vistaCasillero;
	private VistaTablero vistaTablero;

	public ClickParaColocarUnidad(VistaUnidadSeleccionada unidad, Tablero tablero, VistaCasillero vistaCasillero,
			VistaTablero vistaTablero) {

		this.unidad = unidad;
		this.tablero = tablero;
		this.vistaCasillero = vistaCasillero;
		this.vistaTablero = vistaTablero;
	}

	
	@Override
	public void handle(ActionEvent event) {

		try {

			Unidad unidad = this.unidad.getUnidad();
			Posicion posicion = vistaCasillero.getPosicion();
			
			this.tablero.agregarNuevaUnidad(unidad, posicion);
			this.unidad.quitarUnidad();

		} catch (CasilleroOcupadoException e) {

			Alert alertaCasilleroOcupado = new AlertaCasilleroOcupado();
			alertaCasilleroOcupado.showAndWait();

		} catch (DistintoBandoException e) {

			Alert alertaDistintoBando = new AlertaDistintoBandoAlColocarUnidad();
			alertaDistintoBando.showAndWait();
		
		} catch (NoTieneUnaUnidadSeleccionadaException e) {
			
			Alert alertaPiezaNoSeleccionada = new AlertaPiezaNoSeleccionada();
			alertaPiezaNoSeleccionada.showAndWait();

		} finally {

			vistaTablero.actualizarTablero();
			vistaTablero.compartamientoColocarUnidades(unidad);
		}
	}
}
