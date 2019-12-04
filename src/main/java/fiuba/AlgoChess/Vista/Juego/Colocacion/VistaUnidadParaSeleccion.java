package fiuba.AlgoChess.Vista.Juego.Colocacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fiuba.AlgoChess.Controlador.Handlers.ClickParaSeleccionarUnidadAColocar;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Errores.NoTieneMasUnidadesParaColocarException;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaUnidadParaSeleccion extends HBox {

	private CajaDeUnidadesVertical cajaDeUnidades;
	private Unidad unidad;
	private int numeroJugador;
	private String nombreClase;
	private Label labelCantidad;
	private VistaUnidadSeleccionada unidadSeleccionada;

	public VistaUnidadParaSeleccion(Unidad unidad, int numeroJugador, CajaDeUnidadesVertical cajaDeUnidades,
			VistaUnidadSeleccionada unidadSeleccionada) {

		super();
		this.cajaDeUnidades = cajaDeUnidades;
		this.numeroJugador = numeroJugador;
		this.unidad = unidad;
		this.nombreClase = unidad.getClass().getSimpleName();
		this.unidadSeleccionada = unidadSeleccionada;

		this.cargarCantidadUnidades();
		Label nombre = new Label(this.nombreClase);

		nombre.setFont(Font.font("Times New Roman", 20));
		labelCantidad.setFont(Font.font("Times New Roman", 16));

		VBox datosUnidad = new VBox(nombre, labelCantidad);
		datosUnidad.setAlignment(Pos.CENTER_LEFT);
		datosUnidad.setSpacing(10);

		this.getChildren().add(this.cargarImagenUnidad());
		this.getChildren().add(datosUnidad);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);
	}

	private ToggleButton cargarImagenUnidad() {

		ToggleButton botonImagen = new ToggleButton("", this.generarImagenUnidad());
		botonImagen.setOnAction(new ClickParaSeleccionarUnidadAColocar(this, this.unidadSeleccionada));

		return botonImagen;
	}
	
	private ImageView generarImagenUnidad() {
		
		return this.generarImagenUnidad(80, 80);
	}
	
	private ImageView generarImagenUnidad(int alto, int ancho) {
		
		String direccion = "./recursos/unidades/" + this.nombreClase + this.numeroJugador + ".png";
		Image imagenUnidad = null;

		try {

			imagenUnidad = new Image(new FileInputStream(direccion));

		} catch (FileNotFoundException e) {
		}

		ImageView imagen = new ImageView();
		imagen.setFitHeight(alto);
		imagen.setFitWidth(ancho);
		imagen.setPreserveRatio(true);
		imagen.setImage(imagenUnidad);

		return imagen;
		
	}

	private void cargarCantidadUnidades() {

		int cantidad = this.cajaDeUnidades.getUnidadesDisponibles(this.nombreClase);

		this.labelCantidad = new Label("Cantidad: " + cantidad);
	}

	public Unidad quitarUnidad() {

		int cantidad = this.cajaDeUnidades.getUnidadesDisponibles(this.nombreClase);
		
		if (cantidad > 0) {
			this.cajaDeUnidades.actualizarUnidadesDisponibles(this.nombreClase, -1);
			cantidad = this.cajaDeUnidades.getUnidadesDisponibles(this.nombreClase);
		} else {
			throw new NoTieneMasUnidadesParaColocarException();
		}

		this.labelCantidad.setText("Cantidad: " + cantidad);
		
		return this.unidad;
	}

	public void agregarUnidad() {

		this.cajaDeUnidades.actualizarUnidadesDisponibles(this.nombreClase, 1);
		int cantidad = this.cajaDeUnidades.getUnidadesDisponibles(this.nombreClase);
		
		this.labelCantidad.setText("Cantidad: " + cantidad);
	}

	public ImageView getImagen(int alto, int ancho) {
		
		return this.generarImagenUnidad(alto, ancho);
	}

	public void actualizarVista() {


		this.cajaDeUnidades.recargarVista();
	}

}
