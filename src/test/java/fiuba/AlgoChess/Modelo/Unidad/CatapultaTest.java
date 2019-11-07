package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatapultaTest {

    @Test
    public void test00CatapultaRecienCreadaTieneTodaLaVida(){
        Catapulta catapulta = new Catapulta(mock(Casillero.class));

        assertEquals(50,catapulta.getVida());
    }

    @Test
    public void test01CatapultaAtacaAUnSoldadoYLehaceDaño(){
        Catapulta catapulta = new Catapulta(mock(Casillero.class));
        Soldado soldado = new Soldado(mock(Casillero.class));

        catapulta.atacarA(soldado);
        assertEquals(100-20,soldado.getVida());
    }

}

