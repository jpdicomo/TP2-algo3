package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Controlador.Alertas.AlertaNoTieneMasUnidades;
import fiuba.AlgoChess.Controlador.Alertas.AlertaYaTieneUnaUnidadSeleccionada;
import fiuba.AlgoChess.Vista.Errores.NoTieneMasUnidadesParaColocarException;
import fiuba.AlgoChess.Vista.Errores.YaTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadParaSeleccion;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ClickParaSeleccionarUnidadAColocar implements EventHandler<ActionEvent> {

	private VistaUnidadParaSeleccion vistaUnidad;
	private VistaUnidadSeleccionada vistaSeleccionada;
	private Media sonido;
	private MediaPlayer reproductor;

	public ClickParaSeleccionarUnidadAColocar(VistaUnidadParaSeleccion vistaUnidad,
			VistaUnidadSeleccionada vistaSeleccionada) {

		this.vistaUnidad = vistaUnidad;
		this.vistaSeleccionada = vistaSeleccionada;
	}

	@Override
	public void handle(ActionEvent event) {

		try {

			this.vistaSeleccionada.agregarUnidad(this.vistaUnidad);
			this.reproducirSonido();

		} catch (NoTieneMasUnidadesParaColocarException e) {

			AlertaNoTieneMasUnidades alertaNoTieneMasUnidades = new AlertaNoTieneMasUnidades();
			alertaNoTieneMasUnidades.mostrarAlerta();
			return;

		} catch (YaTieneUnaUnidadSeleccionadaException e) {

			AlertaYaTieneUnaUnidadSeleccionada alertaTieneUnaUnidadSeleccionada = new AlertaYaTieneUnaUnidadSeleccionada();
			alertaTieneUnaUnidadSeleccionada.mostrarAlerta();
			return;
		}
	}

	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/soltarUnidad.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}

}
