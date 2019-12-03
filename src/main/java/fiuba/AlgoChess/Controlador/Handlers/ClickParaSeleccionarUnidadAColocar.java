package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaNoTieneMasUnidades;
import fiuba.AlgoChess.Controlador.Alertas.AlertaYaTieneUnaUnidadSeleccionada;
import fiuba.AlgoChess.Vista.Errores.NoTieneMasUnidadesParaColocarException;
import fiuba.AlgoChess.Vista.Errores.YaTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadParaSeleccion;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClickParaSeleccionarUnidadAColocar implements EventHandler<ActionEvent> {

	private VistaUnidadParaSeleccion vistaUnidad;
	private VistaUnidadSeleccionada vistaSeleccionada;

	public ClickParaSeleccionarUnidadAColocar(VistaUnidadParaSeleccion vistaUnidad,
			VistaUnidadSeleccionada vistaSeleccionada) {

		this.vistaUnidad = vistaUnidad;
		this.vistaSeleccionada = vistaSeleccionada;
	}

	@Override
	public void handle(ActionEvent event) {

		try {

			this.vistaSeleccionada.agregarUnidad(this.vistaUnidad);

		} catch (NoTieneMasUnidadesParaColocarException e) {
			
			AlertaNoTieneMasUnidades alertaNoTieneMasUnidades = new AlertaNoTieneMasUnidades();
			alertaNoTieneMasUnidades.showAndWait();
			return;
			
		} catch (YaTieneUnaUnidadSeleccionadaException e) {
			
			AlertaYaTieneUnaUnidadSeleccionada alertaTieneUnaUnidadSeleccionada = new AlertaYaTieneUnaUnidadSeleccionada();
			alertaTieneUnaUnidadSeleccionada.showAndWait();
			return;
		}
	}

}
