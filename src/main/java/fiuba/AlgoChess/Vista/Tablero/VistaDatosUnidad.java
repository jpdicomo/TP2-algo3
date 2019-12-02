package fiuba.AlgoChess.Vista.Tablero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Controlador.Handlers.BotonMover;
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
	
	public VistaDatosUnidad() {

		super();
	}
	
	
	public void agregarUnidad(Unidad unidad, VistaTablero tablero, int numeroJugador, Posicion posicion) {

		this.getChildren().clear();

		this.unidad = unidad;
		this.tablero = tablero;
		this.numeroJugador = numeroJugador;
		this.posicion = posicion;
		
		Label nombre = new Label(unidad.getClass().getSimpleName());
		nombre.setFont(Font.font("Times New Roman", 28));
		
		Label vida = new Label("Vida: " + unidad.getVida());
		vida.setFont(Font.font("Times New Roman", 16));
		
		this.getChildren().add(nombre);
		this.getChildren().add(this.agregarImagenUnidad());
		this.getChildren().add(vida);
		this.getChildren().add(this.agregarBotones());
		
		this.setAlignment(Pos.CENTER);
	}


	private HBox agregarBotones() {
		
		GridPane direcciones = new GridPane();
		direcciones.setVgap(5);
        direcciones.setHgap(5);
		direcciones.setAlignment(Pos.CENTER);
        
		direcciones.add(this.agregarBoton("NO", new SurOeste()), 1, 1);
		direcciones.add(this.agregarBoton("N", new Oeste()), 2, 1);
		direcciones.add(this.agregarBoton("NE", new NorOeste()), 3, 1);
		
		direcciones.add(this.agregarBoton("O", new Sur()), 1, 2);
		direcciones.add(this.agregarBoton("E", new Norte()), 3, 2);
		
		direcciones.add(this.agregarBoton("SO", new SurEste()), 1, 3);
		direcciones.add(this.agregarBoton("S", new Este()), 2, 3);
		direcciones.add(this.agregarBoton("SE", new NorEste()), 3, 3);
		
		
		String textoBotonAtaque = "Ataque";
		
		if("Curandero".equals(unidad.getClass().getSimpleName())) {
			textoBotonAtaque = "Curar";
		}
		
		Button botonAtacar = new Button(textoBotonAtaque);
		// Crear Handler para el boton Atacar.

		HBox botones = new HBox(direcciones, botonAtacar);
		botones.setAlignment(Pos.CENTER);
		botones.setSpacing(35);
		
		
		return botones;
	}
	
	
	private Button agregarBoton(String texto, Direccion direccion) {
		
		Button nuevoBoton = new Button(texto);
		nuevoBoton.setOnAction(new BotonMover(posicion, direccion, tablero));
		
		return nuevoBoton;
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
	
	
	
}
