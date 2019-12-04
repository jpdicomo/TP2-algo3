package fiuba.AlgoChess.Controlador.Handlers;

import java.io.File;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonMover implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private Direccion direccion;
	private VistaTablero tablero;
	private VistaDatosUnidad unidadElegida;
	private Media sonido;
	private MediaPlayer reproductor;

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
			this.reproducirSonido();

		} catch (DesplazamientoInvalidoExcepcion | PosicionInvalidaException e) {

			AlertaMovimientoInvalido alertaMovimientoInvalido = new AlertaMovimientoInvalido();
			alertaMovimientoInvalido.mostrarAlerta();

		} catch (CasilleroOcupadoException e) {

			AlertaMovimientoACasilleroOcupado alertaMovimientoInvalido = new AlertaMovimientoACasilleroOcupado();
			alertaMovimientoInvalido.mostrarAlerta();

		} catch (CatapultaNoPuedeSerMovidaException e) {

			AlertaCatapultaNoPuedeMoverse alertaCatapultaNoPuedeSerMovida = new AlertaCatapultaNoPuedeMoverse();
			alertaCatapultaNoPuedeSerMovida.mostrarAlerta();

		} finally {

			this.tablero.actualizarTablero();
			this.tablero.comportamientoSeleccionarUnidad();
		}
	}
	
	
	private void reproducirSonido() {

		this.sonido = new Media(new File("./recursos/sonidos/moverUnidad.wav")
				.toURI().toString());
		this.reproductor = new MediaPlayer(sonido);

		this.reproductor.stop();
		this.reproductor.play();
	}
}
