package fiuba.AlgoChess.Modelo.Tablero;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void Test00CreacionTablero(){
/*
        HashMap<Posicion, String > tablero = new HashMap<>();
        Posicion pos = new Posicion (1,1);
        tablero.put(pos,"hola");
        Posicion posB = new Posicion (1,1);

        Assert.assertEquals("hola", tablero.get(pos));
*/

        Tablero tablero = new Tablero();

        //ver que hay en el casillero 0,0;

        Posicion pos = new Posicion(1,1);
        Casillero casillero = tablero.getCasillero(pos);

        Assert.assertEquals(1, casillero.getBando());
                //this.casilleros[j][i] = new Casillero(j, i, new Aliada());
            }

        }


    }

}