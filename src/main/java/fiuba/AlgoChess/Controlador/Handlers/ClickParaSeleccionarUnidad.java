package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaCasilleroVacio;
import fiuba.AlgoChess.Controlador.Alertas.AlertaDistintoBandoAlElegirUnidad;
import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.Main;
import fiuba.AlgoChess.Vista.Tablero.VistaCasillero;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ClickParaSeleccionarUnidad implements EventHandler<ActionEvent> {

	private VistaDatosUnidad unidadElegida;
	private VistaCasillero vistaCasillero;
	private VistaTablero tablero;
	private Main main;

	
	public ClickParaSeleccionarUnidad(VistaDatosUnidad unidadElegida, VistaCasillero casillero, VistaTablero tablero, Main main) {

		this.unidadElegida = unidadElegida;
		this.vistaCasillero = casillero;
		this.tablero = tablero;
		this.main = main;
	}

	
	@Override
	public void handle(ActionEvent event) {

		try {

			int numeroJugador = this.main.getNumeroJugador();
			Unidad unidad = this.vistaCasillero.getCasillero().getUnidad();
			Posicion posicion = this.vistaCasillero.getPosicion();
			
			this.main.getJugador(numeroJugador).elegirUnidad(unidad);
			this.unidadElegida.agregarUnidad(unidad, this.tablero, numeroJugador, posicion);

		} catch (CasilleroLibreException e) {

			Alert alertaCasilleroVacio = new AlertaCasilleroVacio();
			alertaCasilleroVacio.showAndWait();
			
		} catch (DistintoBandoException e) {
			
			AlertaDistintoBandoAlElegirUnidad alertaUnidadInvalida = new AlertaDistintoBandoAlElegirUnidad();
			alertaUnidadInvalida.mostrarAlerta();
		}
	}
}
