
package fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class SoldadoDeInfanteria extends Entidad{

    private int vida = 100;
    private int danioCuerpoACuerpo = 10;
    private int danioADistancia = 0;


    public SoldadoDeInfanteria(Casillero casillero) {
        super(casillero);
    }



}

