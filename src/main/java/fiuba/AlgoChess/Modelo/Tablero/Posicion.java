package fiuba.AlgoChess.Modelo.Tablero;

public class Posicion {
	
	// Atributos.
    private int x;
    private int y;


    // Metodos.
    
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
    public int getX() {
    
    	return x;
    }
    
    
    /*
     * 
     */
    public int getY(){
    
    	return y;
    }

    
    /*
     * POST: Devuelve la distancia entre dos posiciones.
     */
    public double medirDistanciaA(Posicion otraPosicion) {
    	
    	int x = Math.abs(this.getX() - otraPosicion.getX());
    	int y = Math.abs(this.getY() - otraPosicion.getY());
    	
    	return Math.hypot(x, y);
    }
    
    
    /*
     * 
     */
    public Posicion desplazar(int desplazamientoX , int desplazamientoY) {
    	
        this.x += desplazamientoX;
        this.y += desplazamientoY;
        Posicion posNueva = new Posicion(x,y);
        return posNueva;
    }
}
