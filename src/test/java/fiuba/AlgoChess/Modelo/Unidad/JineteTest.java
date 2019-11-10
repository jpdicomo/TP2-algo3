package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class JineteTest {
    @Test
    public void test00JineteApenasCreadoTiene100Vida(){
        Jinete jinete = new Jinete(mock(Casillero.class));

        assertEquals(100,jinete.getVida());
    }

    @Test
    public void test01JineteAliadoAtacaAJineteEnemigoYLeRestaCorrectamenteLaVida(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        jinete1.setBandoAliado();
        Jinete jinete2 = new Jinete(mock(Casillero.class));
        jinete2.setBandoEnemigo();

        jinete1.atacarA(jinete2);
        assertEquals(100-5,jinete2.getVida());
    }
    @Test
    public void test02JineteAliadoAtacaAJineteAliadoTiraError(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        jinete1.setBandoAliado();
        Jinete jinete2 = new Jinete(mock(Casillero.class));
        jinete2.setBandoAliado();
        assertFalse(jinete1.atacarA(jinete2));

    }
    @Test
    public void test03JineteEnemigoAtacaAJineteAliadoYLeRestaCorrectamenteLaVida(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        jinete1.setBandoEnemigo();
        Jinete jinete2 = new Jinete(mock(Casillero.class));
        jinete2.setBandoAliado();
        jinete1.atacarA(jinete2);
        assertEquals(100-5,jinete2.getVida());
    }
    @Test
    public void test04JineteEnemigoAtacaAJineteEnemigoTiraError(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        jinete1.setBandoEnemigo();
        Jinete jinete2 = new Jinete(mock(Casillero.class));
        jinete2.setBandoEnemigo();
        assertFalse(jinete1.atacarA(jinete2));
    }
    @Test
    public void test05UnJineteAliadoNoPuedeAtacarseASiMismo(){
        Jinete jinete = new Jinete(mock(Casillero.class));
        jinete.setBandoAliado();
        assertFalse(jinete.atacarA(jinete));
    }
    @Test
    public void test06UnJineteEnemigoNoPuedeAtacarseASiMismo(){
        Jinete jinete = new Jinete(mock(Casillero.class));
        jinete.setBandoEnemigo();
        assertFalse(jinete.atacarA(jinete));
    }
}

