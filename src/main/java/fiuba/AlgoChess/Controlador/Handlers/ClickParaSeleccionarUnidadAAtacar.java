package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.*;
import fiuba.AlgoChess.Modelo.Errores.*;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Tablero.VistaCasillero;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ClickParaSeleccionarUnidadAAtacar implements EventHandler<ActionEvent> {

	private VistaDatosUnidad unidadElegida;
	private Posicion posicionAtacante;
	private VistaTablero tablero;
	private VistaCasillero casillero;

	public ClickParaSeleccionarUnidadAAtacar(VistaDatosUnidad unidadElegida, Posicion posicion, VistaTablero tablero,
			VistaCasillero casillero) {

		this.unidadElegida = unidadElegida;
		this.posicionAtacante = posicion;
		this.tablero = tablero;
		this.casillero = casillero;
	}

	@Override
	public void handle(ActionEvent event) {
		
		boolean fallo = true;

		try {
			
			Unidad unidadAtacante = this.tablero.getTablero().seleccionarUnidad(this.posicionAtacante);
			unidadAtacante.interactuarCon(this.casillero.getCasillero());
			this.unidadElegida.agregarAtacante();
			fallo = false;
			
		} catch (MismaUnidadException e) {

			Alert alertaNoPoderUsarTuPoderConVos = new AlertaNoPoderUsarTuPoderConVos();
			alertaNoPoderUsarTuPoderConVos.showAndWait();
			
		} catch (MismoBandoException e) {
			
			Alert alertaAtaqueAAliado = new AlertaAtaqueAMismoBando();
			alertaAtaqueAAliado.showAndWait();
			
		} catch (DistintoBandoException e) {
			
			Alert alertaIntentoCurarAEnemigo = new AlertaCuracionABandoEnemigo();
			alertaIntentoCurarAEnemigo.showAndWait();
			
		} catch (CasilleroLibreException e) {
			
			Alert alertaCasilleroLibre = new AlertaCasilleroVacio();
			alertaCasilleroLibre.showAndWait();
			
		} catch (DistanciaInvalidaException e) {
			
			Alert alertaDistanciaInvalida = new AlertaDistanciaInvalida();
			alertaDistanciaInvalida.showAndWait();
			
		} finally {
			
			this.tablero.actualizarTablero();

			if(fallo) {
				this.tablero.comportamientoDeAtaque(this.posicionAtacante);
			} else {
				this.tablero.comportamientoSeleccionarUnidad();
			}
		}
	}
}
