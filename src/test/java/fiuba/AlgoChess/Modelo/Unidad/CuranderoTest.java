package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CuranderoTest {

    @Test
    public void test00CuranderoRecienCreadoTiene75DeVida(){
        Curandero curandero = new Curandero(mock(Casillero.class));

        assertEquals(75,curandero.getVida());
    }
    @Test
    public void test01CurarASoldadoNoDaniadoSumaSusPuntosDeVidaMaximos(){
        Curandero curandero = new Curandero(mock(Casillero.class));
        Soldado soldado = new Soldado(mock(Casillero.class));

        curandero.curarA(soldado);
        assertEquals(100 + 15,soldado.getVida());
    }
    @Test
    public void test02CurarASoldadoDaniadoSumaSusPuntosDeVida(){
        Curandero curandero = new Curandero(mock(Casillero.class));
        Soldado soldado = new Soldado(mock(Casillero.class));
        soldado.recibirDanio(15);
        curandero.curarA(soldado);
        assertEquals(100,soldado.getVida());
    }
}
