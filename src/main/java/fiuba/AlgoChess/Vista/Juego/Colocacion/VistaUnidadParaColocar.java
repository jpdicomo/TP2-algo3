package fiuba.AlgoChess.Vista.Juego.Colocacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaUnidadParaColocar extends HBox {
	
	private int numeroJugador;
	private String nombreClase;
	
	public VistaUnidadParaColocar(Unidad unidad, int numeroJugador){
		
		super();
		
		this.numeroJugador = numeroJugador;
		this.nombreClase = unidad.getClass().getSimpleName();
		
        Label nombre = new Label(this.nombreClase);
        Label cantidad = new Label("Cantidad: " + 5); //Modificar esto
        
        nombre.setFont(Font.font("Times New Roman", 20));
        cantidad.setFont(Font.font("Times New Roman", 16));

        VBox datosUnidad = new VBox(nombre, cantidad);
        datosUnidad.setAlignment(Pos.CENTER_LEFT);
        datosUnidad.setSpacing(10);
        
        this.getChildren().add(this.cargarImagenUnidad(unidad));
        this.getChildren().add(datosUnidad);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
	}
	
	
	private ToggleButton cargarImagenUnidad(Unidad unidad) {
		
		String direccion = "./recursos/unidades/" + this.nombreClase + this.numeroJugador + ".png";
		Image imagenUnidad = null;
		
		try {
			
			imagenUnidad = new Image(new FileInputStream(direccion));
		
		} catch(FileNotFoundException e) {
		}
		
		ImageView imagen = new ImageView();
        imagen.setFitHeight(80);
        imagen.setFitWidth(80);
        imagen.setPreserveRatio(true);
        imagen.setImage(imagenUnidad);
        
        ToggleButton botonImagen = new ToggleButton("", imagen);
		
		return botonImagen;
	}
}
