package fiuba.AlgoChess.Vista.Compra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaUnidad extends VBox {
	
	
	private int numeroJugador;
	private String nombreClase;
	
	
	public VistaUnidad(Unidad unidad, int numeroJugador){
		
		super();
		
		this.numeroJugador = numeroJugador;
		this.nombreClase = unidad.getClass().getSimpleName();
		
        Label nombre = new Label(this.nombreClase);
        Label vida = new Label("Vida: " + unidad.getVida());
        Label costo = new Label("Precio: " + unidad.getCosto());
        
        nombre.setFont(Font.font("Verdana", 24));
        vida.setFont(Font.font("Verdana", 16));
        costo.setFont(Font.font("Verdana", 16));

        VBox datosUnidad = new VBox(vida, costo);
        datosUnidad.setAlignment(Pos.CENTER_LEFT);
        datosUnidad.setSpacing(5);
        
        this.getChildren().add(nombre);
        this.getChildren().add(this.cargarImagenUnidad(unidad));
        this.getChildren().add(datosUnidad);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
	}
	
	
	public void agregarBoton(Button botonDeCompra) {
		
		this.getChildren().add(botonDeCompra);
	}
	
	
	private ImageView cargarImagenUnidad(Unidad unidad) {
		
		String direccion = "./recursos/" + this.nombreClase + this.numeroJugador + ".png";
		Image imagenUnidad = null;
		
		try {
			
			imagenUnidad = new Image(new FileInputStream(direccion));
		
		} catch(FileNotFoundException e) {
		}
		
		ImageView imagen = new ImageView();
        imagen.setFitHeight(70);
        imagen.setFitWidth(70);
        imagen.setPreserveRatio(true);
        imagen.setImage(imagenUnidad);
		
		return imagen;
	}
	
	
}
