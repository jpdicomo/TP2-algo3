package fiuba.AlgoChess.Vista.Compra;

import fiuba.AlgoChess.Controlador.BotonComprarUnidad;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Catapulta;
import fiuba.AlgoChess.Modelo.Unidad.Curandero;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Juego.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class CajaDeUnidades extends HBox {
	
	
	private HBox unidades;
	private Jugador jugador;
	private Bando bando;
	
	
	public CajaDeUnidades(Main main, int numeroJugador) {
		
		super();
		this.unidades = new HBox();
		this.bando = main.getBando(numeroJugador);
		this.jugador = main.getJugador(numeroJugador);
		
		this.cargarUnidad(new Soldado(bando), numeroJugador);
		this.cargarUnidad(new Curandero(bando), numeroJugador);
		this.cargarUnidad(new Catapulta(bando), numeroJugador);
		this.cargarUnidad(new Jinete(bando), numeroJugador);
	
		this.getChildren().add(this.unidades);
		this.cargarPuntosJugador();
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);
		
	}

	
	private void cargarUnidad(Unidad unidad, int numeroJugador) {
		
		VistaUnidad vistaUnidad = new VistaUnidad(unidad, numeroJugador);
		
		Button botonDeCompra = new Button("Comprar");
		botonDeCompra.setFont(Font.font("Verdana", 16));
		botonDeCompra.setOnAction(new BotonComprarUnidad(this.jugador, unidad));
				
		vistaUnidad.agregarBoton(botonDeCompra);
		
		this.unidades.getChildren().add(vistaUnidad);
	}
	
	
	private void cargarPuntosJugador() {
		
		
		Label texto = new Label("Puntos restantes: " + this.jugador.getPuntos());
		texto.setFont(Font.font("Verdana", 16));
		
		this.getChildren().add(texto);
	}
	
}
