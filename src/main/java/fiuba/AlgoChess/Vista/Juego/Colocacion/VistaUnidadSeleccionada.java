package fiuba.AlgoChess.Vista.Juego.Colocacion;

import fiuba.AlgoChess.Controlador.Handlers.BotonSoltarUnidad;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Errores.NoTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Errores.YaTieneUnaUnidadSeleccionadaException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class VistaUnidadSeleccionada extends HBox {
	
	private Unidad unidad;
    private Label imagen;
    private VistaUnidadParaSeleccion vistaUnidad;
    private Button boton;

    
    public VistaUnidadSeleccionada(){
    	
        super();
        this.unidad = null;
        this.imagen = new Label();
        this.boton = new Button("Soltar Unidad");
        this.boton.setFont(Font.font("Verdana", 16));
        this.boton.setOnAction(new BotonSoltarUnidad(this));
        this.setMinHeight(110);
        this.setMaxHeight(110);
    }
    
    public void agregarUnidad(VistaUnidadParaSeleccion unidad) {
    	
    	if (this.unidad != null) {
    		
    		throw new YaTieneUnaUnidadSeleccionadaException();
    	}
    	
    	this.vistaUnidad = unidad;
    	
    	this.unidad = this.vistaUnidad.quitarUnidad();
    	this.imagen.setGraphic(unidad.getImagen(110,110));
    	
    	this.getChildren().add(this.imagen);
    	this.getChildren().add(this.boton);
    	this.setAlignment(Pos.CENTER);
    	this.setSpacing(20);
    }
    
	
	public void quitarUnidad() {
		
		if (this.unidad == null) {
    		
    		throw new NoTieneUnaUnidadSeleccionadaException();
    	}
		
		this.unidad = null;
		this.getChildren().clear();
	}
	
	
	public Unidad getUnidad() {
		if (this.unidad == null) {
    		
    		throw new NoTieneUnaUnidadSeleccionadaException();
    	}
		return this.unidad;
	}
	
	public void soltarUnidad() {
		
		if (this.unidad == null) {
    		
    		throw new NoTieneUnaUnidadSeleccionadaException();
    	}
		
		this.vistaUnidad.agregarUnidad(this.unidad);
		this.unidad = null;
		this.getChildren().clear();
	}

}
