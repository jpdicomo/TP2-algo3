package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public interface Movible {
	
    boolean moverseA(Casillero casilleroNuevo);
    boolean moverseALaDerecha(Tablero tablero);
    boolean moverseALaIzquierda(Tablero tablero);
    boolean moverseArriba(Tablero tablero);
    boolean moverseAbajo(Tablero tablero);

}
