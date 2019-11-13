package fiuba.AlgoChess.Modelo.Tablero;

public class Posicion {
	
    private int x;
    private int y;


    public Posicion(int x, int y){
    
    	this.x = x;
        this.y = y;
    }
    
    /*
     * POST: Devuelve la distancia entre dos posiciones.
     */
    public double medirDistanciaA(Posicion otraPosicion) {
    	
    	int x = Math.abs(this.getX() - otraPosicion.getX());
    	int y = Math.abs(this.getY() - otraPosicion.getY());
    	
    	return Math.hypot(x, y);
    }
    
    
    public int getX() {
    
    	return x;
    }
    
    
    public int getY(){
    
    	return y;
    }
}