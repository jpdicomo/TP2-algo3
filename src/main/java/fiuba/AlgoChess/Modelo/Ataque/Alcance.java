package fiuba.AlgoChess.Modelo.Ataque;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;

public class Alcance {
	
	// Atributos.
	
	private int distanciaMaxima;
    private int distanciaMinima;

    
    // Metodos.
    
    /*
     * 
     */
    public Alcance(int minima, int maxima){
    
    	this.distanciaMaxima = maxima;
        this.distanciaMinima = minima;
    }
    
    
    /*
     * 
     */
    public void estaDentroDelAlcance(int distancia) {

        if(distancia > this.distanciaMaxima || distancia < this.distanciaMinima){
        	
            throw new DistanciaInvalidaException();
        }
    }
}
