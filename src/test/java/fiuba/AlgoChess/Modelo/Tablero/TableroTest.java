package fiuba.AlgoChess.Modelo.Tablero;


import fiuba.AlgoChess.Modelo.Unidad.Aliada;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class TableroTest {

    @Test
    public void Test00CreacionTablero(){

        HashMap<Posicion, Casillero > tablero = new HashMap<>();
        Posicion pos = new Posicion (1,1);

        tablero.put(pos,new Casillero(1, 1, new Aliada()));
        Casillero c = tablero.get(pos);
        Posicion posB = new Posicion (1,1);

        Assert.assertEquals(1, c.getBando());

/*
        Tablero tablero = new Tablero();

        //ver que hay en el casillero 0,0;

        Posicion pos = new Posicion(1,1);
        Casillero casillero = tablero.getCasillero(pos);

        Assert.assertEquals(1, casillero.getBando());
                //this.casilleros[j][i] = new Casillero(j, i, new Aliada());
            }

        }
*/

    }

}