package fiuba.AlgoChess.Vista.Juego.Colocacion;

import java.util.ArrayList;
import java.util.HashMap;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Catapulta;
import fiuba.AlgoChess.Modelo.Unidad.Curandero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CajaDeUnidadesVertical extends VBox {

	private Jugador jugador;
	private Bando bando;
	private VistaUnidadSeleccionada unidadSeleccionada;
	private HashMap<String, ArrayList<Unidad>> unidades;

	public CajaDeUnidadesVertical(Main main, int numeroJugador, VistaUnidadSeleccionada unidadSeleccionada) {

		super();
		this.bando = main.getBando(numeroJugador);
		this.jugador = main.getJugador(numeroJugador);
		this.unidadSeleccionada = unidadSeleccionada;
		this.cargarUnidades();

		this.cargarUnidad(new Soldado(bando), numeroJugador);
		this.cargarUnidad(new Curandero(bando), numeroJugador);
		this.cargarUnidad(new Jinete(bando), numeroJugador);
		this.cargarUnidad(new Catapulta(bando), numeroJugador);

		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
	}

	private void cargarUnidad(Unidad unidad, int numeroJugador) {

		VistaUnidadParaSeleccion vistaUnidad = new VistaUnidadParaSeleccion(unidad, numeroJugador, this,
				this.unidadSeleccionada);
		
		this.getChildren().add(vistaUnidad);
	}
	
	
	public ArrayList<Unidad> getUnidades (String clave) {
		
		return this.unidades.get(clave);
	}
	
	
	private void cargarUnidades() {
		
		this.unidades = new HashMap<String, ArrayList<Unidad>>();
		this.unidades.put("Soldado", new ArrayList<Unidad>());
		this.unidades.put("Curandero", new ArrayList<Unidad>());
		this.unidades.put("Jinete", new ArrayList<Unidad>());
		this.unidades.put("Catapulta", new ArrayList<Unidad>());
		
		for (Unidad unidad : this.jugador.getUnidades()) {
			
			switch (unidad.getClass().getSimpleName()) {
			
			case "Soldado":
				this.unidades.get("Soldado").add(unidad);
				break;
			case "Curandero":
				this.unidades.get("Curandero").add(unidad);
				break;
			case "Jinete":
				this.unidades.get("Jinete").add(unidad);
				break;
			case "Catapulta":
				this.unidades.get("Catapulta").add(unidad);
				break;
			}
		}
	}
	
	
	

}
