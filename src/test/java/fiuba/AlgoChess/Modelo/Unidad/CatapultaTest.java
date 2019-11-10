package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CatapultaTest {

    @Test
    public void test00CatapultaRecienCreadaTieneTodaLaVida(){
        Catapulta catapulta = new Catapulta(mock(Casillero.class));

        assertEquals(50,catapulta.getVida());
    }

    @Test
    public void test01CatapultaAliadaAtacaACatapultaEnemigaYLeRestaCorrectamenteLaVida(){
        Catapulta catapulta1 = new Catapulta(mock(Casillero.class));
        catapulta1.setBandoAliado();
        Catapulta catapulta2 = new Catapulta(mock(Casillero.class));
        catapulta2.setBandoEnemigo();

        catapulta1.atacarA(catapulta2);
        assertEquals(50-20,catapulta2.getVida());
    }
    @Test
    public void test02CatapultaAliadaAtacaACatapultaAliadaTiraError(){
        Catapulta catapulta1 = new Catapulta(mock(Casillero.class));
        catapulta1.setBandoAliado();
        Catapulta catapulta2 = new Catapulta(mock(Casillero.class));
        catapulta2.setBandoAliado();
        assertFalse(catapulta1.atacarA(catapulta2));

    }
    @Test
    public void test03CatapultaEnemigaAtacaACatapultaAliadaYLeRestaCorrectamenteLaVida(){
        Catapulta catapulta1 = new Catapulta(mock(Casillero.class));
        catapulta1.setBandoEnemigo();
        Catapulta catapulta2 = new Catapulta(mock(Casillero.class));
        catapulta2.setBandoAliado();
        catapulta1.atacarA(catapulta2);
        assertEquals(50-20,catapulta2.getVida());
    }
    @Test
    public void test04CatapultaEnemigaAtacaACatapultaEnemigaTiraError(){
        Catapulta catapulta1 = new Catapulta(mock(Casillero.class));
        catapulta1.setBandoEnemigo();
        Catapulta catapulta2 = new Catapulta(mock(Casillero.class));
        catapulta2.setBandoEnemigo();
        assertFalse(catapulta1.atacarA(catapulta2));
    }
    @Test
    public void test05UnaCatapultaAliadaNoPuedeAtacarseASiMismo(){
        Catapulta catapulta = new Catapulta(mock(Casillero.class));
        catapulta.setBandoAliado();
        assertFalse(catapulta.atacarA(catapulta));
    }
    @Test
    public void test06UnaCatapultaEnemigaNoPuedeAtacarseASiMismo(){
        Catapulta catapulta = new Catapulta(mock(Casillero.class));
        catapulta.setBandoEnemigo();
        assertFalse(catapulta.atacarA(catapulta));
    }
}

