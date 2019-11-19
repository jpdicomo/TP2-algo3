package fiuba.AlgoChess.Modelo.Ubicacion;

import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;

public class Posicion {
	
	// Atributos.
	
    private int fila;
    private int columna;


    // Metodos.
    
    /*
     * 
     */
    public Casillero obtenerCasillero(Casillero[][] casilleros) {
    	
    	return casilleros[this.fila][this.columna];
    }
    
    
    
    /*
     * 
     */
    public Posicion(int fila, int columna){
    	
    	this.fila = fila;
        this.columna = columna;
    }
    
    
    /*
     * 
     */
    public Posicion moveteHacia(Direccion unaDireccion) {
    	
    	return unaDireccion.decimeADondeMoverme(this);
    }
    

    
    public Posicion moveteHaciaElNorte() {

    	if(this.columna == 20) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
    	} else {
    		
    		return new Posicion(this.fila, this.columna + 1);
    	}
    }


	public Posicion moveteHaciaElSur() {
		
		if(this.columna == 1) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		return new Posicion(this.fila, this.columna - 1);
    	}
	}


	public Posicion moveteHaciaElOeste() {
		
		if(this.fila == 1) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		this.fila--;
    		return new Posicion(this.fila - 1, this.columna);
    	}
	}


	public Posicion moveteHaciaElEste() {
		
		if(this.fila == 20) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		return new Posicion(this.fila + 1, this.columna);
    	}
	}
	
	
    public Posicion moveteHaciaElNorEste() {

    	Posicion posicionDezplazadaAlNorte = this.moveteHaciaElNorte();
    		
		return posicionDezplazadaAlNorte.moveteHaciaElEste();
    }

    
    public Posicion moveteHaciaElSurEste() {

    	Posicion posicionDezplazadaAlSur = this.moveteHaciaElSur();
    		
		return posicionDezplazadaAlSur.moveteHaciaElEste();
    }

    
    public Posicion moveteHaciaElSurOeste() {

    	Posicion posicionDezplazadaAlSur = this.moveteHaciaElSur();
    		
		return posicionDezplazadaAlSur.moveteHaciaElOeste();
    }

    
    public Posicion moveteHaciaElNorOeste() {

    	Posicion posicionDezplazadaAlNorte = this.moveteHaciaElNorte();
    		
		return posicionDezplazadaAlNorte.moveteHaciaElOeste();
    }

}
