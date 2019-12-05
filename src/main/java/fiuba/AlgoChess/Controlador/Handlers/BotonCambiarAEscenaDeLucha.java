package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

import fiuba.AlgoChess.Controlador.Alertas.AlertaHayUnidadesSinColocar;
import fiuba.AlgoChess.Vista.Errores.NoTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Juego.Main;
import fiuba.AlgoChess.Vista.Juego.Colocacion.CajaDeUnidadesVertical;
import fiuba.AlgoChess.Vista.Juego.Colocacion.VistaUnidadSeleccionada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonCambiarAEscenaDeLucha implements EventHandler<ActionEvent> {

	private Main main;
	private int jugadorInicial;
	private Media sonido;
	private MediaPlayer reproductor;
	private CajaDeUnidadesVertical cajaUnidades;
	private VistaUnidadSeleccionada unidadSeleccionada;

	public BotonCambiarAEscenaDeLucha(Main main, CajaDeUnidadesVertical cajaUnidades,
			VistaUnidadSeleccionada unidadSeleccionada) {

		this.main = main;
		this.cajaUnidades = cajaUnidades;
		this.unidadSeleccionada = unidadSeleccionada;
		this.jugadorInicial = (int) (Math.random() * 2 + 1);
	}

	@Override
	public void handle(ActionEvent event) {

		if (this.hayUnidadesSinColocar()) {

			AlertaHayUnidadesSinColocar alertaUnidadesSinColocar = new AlertaHayUnidadesSinColocar();
			alertaUnidadesSinColocar.mostrarAlerta();

		} else {

			this.reproducirSonido();
			this.main.cambiarEscenaA(this.main.escenaDeLucha(this.jugadorInicial));
		}
	}

	private boolean hayUnidadesSinColocar() {

		String[] clasesUnidades = { "Soldado", "Curandero", "Jinete", "Catapulta" };

		for (int i = 0; i < 4; i++) {

			if (!(this.cajaUnidades.getUnidades(clasesUnidades[i]).isEmpty())) {

				return true;
			}
		}

		return this.hayUnidadSeleccionadaSinColocar();
	}

	private boolean hayUnidadSeleccionadaSinColocar() {

		try {
			this.unidadSeleccionada.getUnidad();
		} catch (NoTieneUnaUnidadSeleccionadaException e) {
			return false;
		}

		return true;
	}

	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/click.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
