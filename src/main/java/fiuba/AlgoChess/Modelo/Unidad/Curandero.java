package fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;
import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Curandero extends Entidad {

    private int vida = 100;
    private int danioDistancia;
    private int danioMelee;
    private int costo = 2;

    public Curandero(Casillero casillero){
        super(casillero);
    }

    @Override
    public int getCosto() {
        return this.costo;
    }
}