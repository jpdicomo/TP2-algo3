package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JineteTest {
    @Test
    public void test00JineteApenasCreadoTiene100Vida(){
        Jinete jinete = new Jinete(mock(Casillero.class));

        assertEquals(100,jinete.getVida());
    }

    @Test
    public void test02JineteAtacaAOtroJineteAMeleeYLeRestaCorrectamenteLaVida(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        Jinete jinete2 = new Jinete(mock(Casillero.class));

        jinete1.atacarA(jinete2);
        assertEquals(100-5,jinete2.getVida());
    }
    @Test
    public void test03JineteAtacaAOtroJineteADistanciaYLeRestaCorrectamenteLaVida(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        Jinete jinete2 = new Jinete(mock(Casillero.class));
        jinete1.setAtaqueADistancia();
        jinete1.atacarA(jinete2);
        assertEquals(100-15,jinete2.getVida());

    }
}

