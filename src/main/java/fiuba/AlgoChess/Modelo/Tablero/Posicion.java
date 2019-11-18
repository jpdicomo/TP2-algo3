package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;

public class Posicion {
	
	// Atributos.
	
    private int x;
    private int y;


    // Metodos.
    
    /*
     * 
     */
    public Casillero obtenerCasillero(Casillero[][] casilleros) {
    	
    	return casilleros[this.x][this.y];
    }
    
    
    
    /*
     * 
     */
    public Posicion(int x, int y){
    	
    	this.x = x;
        this.y = y;
    }
    
    
    /*
     * 
     */
    public Posicion moveteHacia(Direccion unaDireccion) {
    	
    	return unaDireccion.decimeADondeMoverme(this);
    }
    

    
    public Posicion moveteHaciaElNorte() {

    	if(this.y == 20) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
    	} else {
    		
    		return new Posicion(this.x, this.y + 1);
    	}
    }


	public Posicion moveteHaciaElSur() {
		
		if(this.y == 1) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		return new Posicion(this.x, this.y - 1);
    	}
	}


	public Posicion moveteHaciaElOeste() {
		
		if(this.x == 1) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		this.x--;
    		return new Posicion(this.x - 1, this.y);
    	}
	}


	public Posicion moveteHaciaElEste() {
		
		if(this.x == 20) {
    		
    		throw new DesplazamientoInvalidoExcepcion();
    	
		} else {
    		
    		return new Posicion(this.x + 1, this.y);
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
