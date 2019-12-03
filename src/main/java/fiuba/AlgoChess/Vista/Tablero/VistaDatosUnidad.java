package fiuba.AlgoChess.Vista.Tablero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Controlador.Handlers.AbrirBotonMover;
import fiuba.AlgoChess.Controlador.Handlers.BotonMover;
import fiuba.AlgoChess.Controlador.Handlers.BotonMoverApagado;
import fiuba.AlgoChess.Modelo.Ubicacion.*;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaDatosUnidad extends VBox {

	private Unidad unidad;
	private VistaTablero tablero;
	private int numeroJugador;
	private Posicion posicion;
	
	private boolean seMovioUnaPieza;
	
	public VistaDatosUnidad() {

		super();
		this.seMovioUnaPieza = false;
	}
	
	
	public void agregarUnidad(Unidad unidad, VistaTablero tablero, int numeroJugador, Posicion posicion) {

		this.unidad = unidad;
		this.tablero = tablero;
		this.numeroJugador = numeroJugador;
		this.posicion = posicion;
		
		this.minimizarBotonera();
		this.setAlignment(Pos.CENTER);
	}

	
	private void cargarDatosUnidad() {
		
		Label nombre = new Label(unidad.getClass().getSimpleName());
		nombre.setFont(Font.font("Times New Roman", 28));
		
		Label vida = new Label("Vida: " + unidad.getVida());
		vida.setFont(Font.font("Times New Roman", 16));
		
		this.getChildren().add(nombre);
		this.getChildren().add(this.agregarImagenUnidad());
		this.getChildren().add(vida);
	}


	private ImageView agregarImagenUnidad() {
		
		
		String direccion = "./recursos/unidades/" + unidad.getClass().getSimpleName() + numeroJugador + ".png";
		Image imagenUnidad = null;

		try {

			imagenUnidad = new Image(new FileInputStream(direccion));

		} catch (FileNotFoundException e) {
		}

		ImageView imagen = new ImageView();
		imagen.setFitHeight(80);
		imagen.setFitWidth(80);
		imagen.setPreserveRatio(true);
		imagen.setImage(imagenUnidad);

		return imagen;
	}


	public void maximizarBotonera() {

		
		this.getChildren().clear();
		this.cargarDatosUnidad();
		this.cargarBotonesMaximizados();
	}
	
	
	private void minimizarBotonera() {
		
		this.getChildren().clear();
		this.cargarDatosUnidad();
		this.cargarBotonesMinimizados();
	}

	
	public void apagarBotonMover() {

		this.seMovioUnaPieza = true;
		this.minimizarBotonera();
	}
	

	private void cargarBotonesMinimizados() {

		Button mover = new Button("Mover");
		
		if(this.seMovioUnaPieza) {
			
			mover.setOnAction(new BotonMoverApagado());
			
		} else {
			
			mover.setOnAction(new AbrirBotonMover(this));
		}

		HBox botones = new HBox(mover);
		this.agregarBotonAtaque(botones);
		
		botones.setAlignment(Pos.CENTER);
		botones.setSpacing(35);
		botones.setMinSize(200, 200);
		
		this.getChildren().add(botones);
	}
	
	
	private void cargarBotonesMaximizados() {
		
		GridPane direcciones = new GridPane();
		direcciones.setVgap(5);
        direcciones.setHgap(5);
		direcciones.setAlignment(Pos.CENTER);
        
		direcciones.add(this.agregarBotonMovimiento("NO", new SurOeste()), 1, 1);
		direcciones.add(this.agregarBotonMovimiento("N", new Oeste()), 2, 1);
		direcciones.add(this.agregarBotonMovimiento("NE", new NorOeste()), 3, 1);
		
		direcciones.add(this.agregarBotonMovimiento("O", new Sur()), 1, 2);
		direcciones.add(this.agregarBotonMovimiento("E", new Norte()), 3, 2);
		
		direcciones.add(this.agregarBotonMovimiento("SO", new SurEste()), 1, 3);
		direcciones.add(this.agregarBotonMovimiento("S", new Este()), 2, 3);
		direcciones.add(this.agregarBotonMovimiento("SE", new NorEste()), 3, 3);
		
		HBox botones = new HBox(direcciones);
		this.agregarBotonAtaque(botones);
		botones.setAlignment(Pos.CENTER);
		botones.setSpacing(35);
		botones.setMinSize(200, 200);
		
		this.getChildren().add(botones);
	}
	
	
	private Button agregarBotonMovimiento(String texto, Direccion direccion) {
		
		Button nuevoBoton = new Button(texto);
		nuevoBoton.setOnAction(new BotonMover(posicion, direccion, tablero, this));
		
		return nuevoBoton;
	}
	
	
	private void agregarBotonAtaque(HBox botones) {
		
		String textoBotonAtaque = "Ataque";
		
		if("Curandero".equals(unidad.getClass().getSimpleName())) {
			textoBotonAtaque = "Curar";
		}
		
		Button botonAtacar = new Button(textoBotonAtaque);
		// Crear Handler para el boton Atacar. y pasarle la unidad y que ella sepa si ya ataco o no.
		// y al crear esta vista y pasarle la unidad que ella cambie el estado de la unidad.
		

		botones.getChildren().add(botonAtacar);
	}
}
