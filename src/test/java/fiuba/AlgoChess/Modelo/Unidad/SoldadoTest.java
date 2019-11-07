package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class SoldadoTest {
    @Test
    public void test00SoldadoApenasCreadoTiene100Vida(){
        Soldado soldado = new Soldado(mock(Casillero.class));

        assertEquals(100,soldado.getVida());
    }
    @Test
    public void test01SoldadoAliadoAtacaASoldadoEnemigoYLeRestaCorrectamenteLaVida(){
        Soldado soldado1 = new Soldado(mock(Casillero.class));
        soldado1.setBandoAliado();
        Soldado soldado2 = new Soldado(mock(Casillero.class));
        soldado2.setBandoEnemigo();

        soldado1.atacarA(soldado2);
        assertEquals(100-10,soldado2.getVida());
    }
    @Test
    public void test02SoldadoAliadoAtacaASoldadoAliadoTiraError(){
        Soldado soldado1 = new Soldado(mock(Casillero.class));
        soldado1.setBandoAliado();
        Soldado soldado2 = new Soldado(mock(Casillero.class));
        soldado2.setBandoAliado();
        assertFalse(soldado1.atacarA(soldado2));

    }
    @Test
    public void test03SoldadoEnemigoAtacaASoldadoAliadoYLeRestaCorrectamenteLaVida(){
        Soldado soldado1 = new Soldado(mock(Casillero.class));
        soldado1.setBandoEnemigo();
        Soldado soldado2 = new Soldado(mock(Casillero.class));
        soldado2.setBandoAliado();
        soldado1.atacarA(soldado2);
        assertEquals(100-10,soldado2.getVida());
    }
    @Test
    public void test04SoldadoEnemigoAtacaASoldadoEnemigoTiraError(){
        Soldado soldado1 = new Soldado(mock(Casillero.class));
        soldado1.setBandoEnemigo();
        Soldado soldado2 = new Soldado(mock(Casillero.class));
        soldado2.setBandoEnemigo();
        assertFalse(soldado1.atacarA(soldado2));
    }
    @Test
    public void test05UnSoldadoAliadoNoPuedeAtacarseASiMismo(){
        Soldado soldado = new Soldado(mock(Casillero.class));
        soldado.setBandoAliado();
        assertFalse(soldado.atacarA(soldado));
    }
    @Test
    public void test06UnSoldadoEnemigoNoPuedeAtacarseASiMismo(){
        Soldado soldado = new Soldado(mock(Casillero.class));
        soldado.setBandoEnemigo();
        assertFalse(soldado.atacarA(soldado));
    }
}

