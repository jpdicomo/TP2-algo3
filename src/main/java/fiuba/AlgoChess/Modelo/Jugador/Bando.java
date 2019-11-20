package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Unidad;

public class Bando {

    // Metodos.

    /*
     *
     */
    public Bando() {
    	
    }


    /* Nota: Mejorar la descripcion de lo que hace este metodo.
     * 
     * POST: 
     */
    public void interactuarConUnAliado(Unidad unidadAliada) {
		
		unidadAliada.interactuarConUnAliado(this);
	}
    
    
    /*
     * 
     */
    public void interactuarConUnEnemigo(Unidad unidadEnemiga) {
		
		unidadEnemiga.interactuarConUnEnemigo(this);
	}   
}
