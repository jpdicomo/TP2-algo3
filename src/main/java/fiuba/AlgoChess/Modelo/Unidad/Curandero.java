package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Curandero extends Entidad {

    private int vida = 100;
    private int danioDistancia;
    private int danioMelee;

    public Curandero(Casillero casillero){
        super(casillero);
    }


}