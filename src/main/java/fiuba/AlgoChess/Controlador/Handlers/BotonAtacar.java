package fiuba.AlgoChess.Controlador.Handlers;

import fiuba.AlgoChess.Controlador.Alertas.AlertaAtaqueAMismoBando;
import fiuba.AlgoChess.Controlador.Alertas.AlertaElijeAQuienAtacar;
import fiuba.AlgoChess.Controlador.Alertas.AlertaMovimientoACasilleroOcupado;
import fiuba.AlgoChess.Controlador.Alertas.AlertaMovimientoInvalido;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Errores.PosicionInvalidaException;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Vista.Tablero.VistaDatosUnidad;
import fiuba.AlgoChess.Vista.Tablero.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacar implements EventHandler<ActionEvent> {

	private Posicion posicion;
	private VistaTablero tablero;
	
	
	public BotonAtacar(Posicion posicion, VistaTablero tablero) {
		
		this.posicion = posicion;
		this.tablero = tablero;
	}
	
	
	@Override
	public void handle(ActionEvent event) {

		this.tablero.comportamientoDeAtaque(this.posicion);
	}
	
	

}
