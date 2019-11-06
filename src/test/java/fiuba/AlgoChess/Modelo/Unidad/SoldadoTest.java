package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SoldadoTest {
    @Test
    public void test00SoldadoApenasCreadoTiene100Vida(){
        Soldado soldado = new Soldado(mock(Casillero.class));

        assertEquals(100,soldado.getVida());
    }
    @Test
    public void test01SoldadoAtacaAOtroSoldadoYRestaCorrectamenteLaVida(){
        Soldado soldado1 = new Soldado(mock(Casillero.class));
        Soldado soldado2 = new Soldado(mock(Casillero.class));

        soldado1.atacarA(soldado2);
        assertEquals(100-10,soldado2.getVida());
    }
    @Test
    public void test02SoldadoAtacaAUnJineteYRestaCorrectamenteLaVida(){
        Soldado soldado = new Soldado(mock(Casillero.class));
        Jinete jinete = new Jinete(mock(Casillero.class));

        soldado.atacarA(jinete);
        assertEquals(100-10,jinete.getVida());
    }
/*    @Test
    public void test03UnSoldadoNoPuedeAtacarseASiMismo(){
        Soldado soldado = new Soldado(mock(Casillero.class));

        soldado.atacarA(soldado);
        assertEquals(100,soldado.getVida());
    }*/
}
