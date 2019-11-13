package fiuba.AlgoChess.Modelo.Tablero;

public class Posicion {
    private int x;
    private int y;


    public Posicion(int x,int y){
        x = x;
        y = y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public Posicion desplazar(int desplazamientoX , int desplazamientoY){
        this.x += desplazamientoX;
        this.y += desplazamientoY;
        Posicion posNueva = new Posicion(x,y);
        return posNueva;
    }
}
