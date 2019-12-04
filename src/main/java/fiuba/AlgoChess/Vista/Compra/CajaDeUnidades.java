package fiuba.AlgoChess.Vista.Compra;

import fiuba.AlgoChess.Controlador.Handlers.BotonComprarUnidad;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.*;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class CajaDeUnidades extends HBox {
	
	private Jugador jugador;
	private int numeroJugador;
	private Label puntosJugador;
	private Bando bando;
	
	
	public CajaDeUnidades(Main main, int numeroJugador, Label puntosJugador) {
		
		super();
		this.bando = main.getBando(numeroJugador);
		this.numeroJugador = numeroJugador;
		this.puntosJugador = puntosJugador;
		this.jugador = main.getJugador(numeroJugador);
		
		this.recargarVista();
	}

	
	private void cargarUnidad(Unidad unidad) {
		
		VistaUnidad vistaUnidad = new VistaUnidad(unidad, numeroJugador);
		
		Button botonDeCompra = new Button("Comprar");
		botonDeCompra.setFont(Font.font("Verdana", 16));
		botonDeCompra.setOnAction(new BotonComprarUnidad(this.jugador, unidad, puntosJugador, this));
				
		vistaUnidad.agregarBoton(botonDeCompra);
		
		this.getChildren().add(vistaUnidad);
	}
	
	
	public void recargarVista() {

		this.getChildren().clear();

		this.cargarUnidad(new Soldado(bando));
		this.cargarUnidad(new Curandero(bando));
		this.cargarUnidad(new Jinete(bando));
		this.cargarUnidad(new Catapulta(bando));
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
	}

}
