package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;

public class Bando {

    // Metodos.

    /*
     *
     */
    public Bando() {
    	
    }


    /* Nota: Mejorar la descripcion de lo que hace este metodo.
     * 
     * POST: Verifica si el Objeto (Jugador, Unidad, Casillero) esta interactuando
     * 		 con un Aliado (Alguien de su mismo bando), caso contrario, arroja una
     * 		 excepcion.
     */
    public void interactuarConUnAliado(Bando bando) {
		
		if(this != bando) {
			
			throw new DistintoBandoException();
		}
	}
    
    
    /*
     * 
     */
    public void interactuarConUnEnemigo(Bando bando) {
		
		if(this == bando) {
			
			throw new MismoBandoException();
		}
	}   
}
