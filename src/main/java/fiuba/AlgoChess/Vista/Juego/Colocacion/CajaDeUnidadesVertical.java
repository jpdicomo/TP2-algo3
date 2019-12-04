package fiuba.AlgoChess.Vista.Juego.Colocacion;

import java.util.ArrayList;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Catapulta;
import fiuba.AlgoChess.Modelo.Unidad.Curandero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CajaDeUnidadesVertical extends VBox {

	private Jugador jugador;
	private Bando bando;
	private VistaUnidadSeleccionada unidadSeleccionada;
	private int numeroJugador;
	private int[] unidadesDisponibles;

	public CajaDeUnidadesVertical(Main main, int numeroJugador, VistaUnidadSeleccionada unidadSeleccionada) {

		super();
		this.bando = main.getBando(numeroJugador);
		this.jugador = main.getJugador(numeroJugador);
		this.numeroJugador = numeroJugador;
		this.unidadSeleccionada = unidadSeleccionada;
		this.unidadesDisponibles = new int[4];
		this.cargarCantidadUnidades();

		this.recargarVista();
	}

	private void cargarUnidad(Unidad unidad, int numeroJugador) {

		VistaUnidadParaSeleccion vistaUnidad = new VistaUnidadParaSeleccion(unidad, numeroJugador, this,
				this.unidadSeleccionada);
		
		this.getChildren().add(vistaUnidad);
	}
	
	public void recargarVista() {
		
		this.getChildren().clear();
		
		this.cargarUnidad(new Soldado(bando), numeroJugador);
		this.cargarUnidad(new Curandero(bando), numeroJugador);
		this.cargarUnidad(new Jinete(bando), numeroJugador);
		this.cargarUnidad(new Catapulta(bando), numeroJugador);

		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
	}
	
	
	public void actualizarUnidadesDisponibles(String unidad, int cambio) {

		int tipoDeUnidad = 0;

		switch (unidad) {
		case "Soldado":
			tipoDeUnidad = 0;
			break;
		case "Curandero":
			tipoDeUnidad = 1;
			break;
		case "Jinete":
			tipoDeUnidad = 2;
			break;
		case "Catapulta":
			tipoDeUnidad = 3;
			break;
		}

		this.unidadesDisponibles[tipoDeUnidad] += cambio;
	}
	
	
	public int getUnidadesDisponibles(String unidad) {
		
		int tipoDeUnidad = 0;
		
		switch (unidad) {
		case "Soldado":
			tipoDeUnidad = 0;
			break;
		case "Curandero":
			tipoDeUnidad = 1;
			break;
		case "Jinete":
			tipoDeUnidad = 2;
			break;
		case "Catapulta":
			tipoDeUnidad = 3;
			break;
		}
		
		return this.unidadesDisponibles[tipoDeUnidad];
	}
	
	
	private void cargarCantidadUnidades() {

		ArrayList<Unidad> unidades = this.jugador.getUnidades();
		String[] clases = {"Soldado", "Curandero", "Jinete", "Catapulta"};
		int i = 0;
		
		for (String clase : clases) {
			
			for (Unidad unidad : unidades) {
	
				String claseUnidad = unidad.getClass().getSimpleName();
							
				if (clase.equals(claseUnidad)) {
	
					this.unidadesDisponibles[i]++;
				}
			}		
			i++;
		}
	}
}
