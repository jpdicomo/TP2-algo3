package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ClickParaColocarUnidad implements EventHandler<ActionEvent> {

	
	private VistaUnidadSeleccionada unidad;
	private Tablero tablero;
	private VistaCasillero vistaCasillero;
	private VistaTablero vistaTablero;
	private Media sonido;
	private MediaPlayer reproductor;

	
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
			this.reproducirSonido();

		} catch (CasilleroOcupadoException e) {

			AlertaCasilleroOcupado alertaCasilleroOcupado = new AlertaCasilleroOcupado();
			alertaCasilleroOcupado.mostrarAlerta();

		} catch (DistintoBandoException e) {

			AlertaDistintoBandoAlColocarUnidad alertaDistintoBando = new AlertaDistintoBandoAlColocarUnidad();
			alertaDistintoBando.mostrarAlerta();

		} catch (NoTieneUnaUnidadSeleccionadaException e) {

			AlertaPiezaNoSeleccionada alertaPiezaNoSeleccionada = new AlertaPiezaNoSeleccionada();
			alertaPiezaNoSeleccionada.mostrarAlerta();

		} finally {

			vistaTablero.actualizarTablero();
			vistaTablero.compartamientoColocarUnidades(unidad);
		}
	}

	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/colocarUnidad.wav").toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
