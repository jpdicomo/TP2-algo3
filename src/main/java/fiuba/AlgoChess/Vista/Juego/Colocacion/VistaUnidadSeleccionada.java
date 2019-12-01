package fiuba.AlgoChess.Vista.Juego.Colocacion;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;
import fiuba.AlgoChess.Vista.Errores.NoTieneUnaUnidadSeleccionadaException;
import fiuba.AlgoChess.Vista.Errores.YaTieneUnaUnidadSeleccionadaException;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class VistaUnidadSeleccionada extends HBox {
	
	private Unidad unidad;
    private Label imagen;
    private VistaUnidadParaSeleccion vistaUnidad;

    
    public VistaUnidadSeleccionada(){
    	
        super();
        this.unidad = null;
        this.imagen = new Label();
    }
    
    public void agregarUnidad(VistaUnidadParaSeleccion unidad) {
    	
    	if (this.unidad != null) {
    		
    		throw new YaTieneUnaUnidadSeleccionadaException();
    	}
    	
    	this.vistaUnidad = unidad;
    	
    	this.unidad = this.vistaUnidad.quitarUnidad();
    	this.imagen.setGraphic(unidad.getImagen());
    	this.imagen.setPrefHeight(80);
    	this.imagen.setPrefHeight(80);
    	
    	this.getChildren().add(this.imagen);
    }
    
	
	public Unidad quitarUnidad() {
		
		if (this.unidad == null) {
    		
    		throw new NoTieneUnaUnidadSeleccionadaException();
    	}
		
		Unidad unidad = this.unidad;
		this.imagen = new Label();
		this.unidad = null;
		
		return unidad;
	}
	
	public void soltarUnidad() {
		
		if (this.unidad == null) {
    		
    		throw new NoTieneUnaUnidadSeleccionadaException();
    	}
		
		this.vistaUnidad.agregarUnidad();
		this.imagen = new Label();
		this.unidad = null;
	}

}
