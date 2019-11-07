package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CuranderoTest {

    @Test
    public void test00CuranderoRecienCreadoTiene75DeVida(){
        Curandero curandero = new Curandero(mock(Casillero.class));

        assertEquals(75,curandero.getVida());
    }
    @Test
    public void test01CuranderoAliadoCuraACuranderoAliadoNoDaniadoSumaSusPuntosDeVidaMaximos(){
        Curandero curandero1 = new Curandero(mock(Casillero.class));
        curandero1.setBandoAliado();
        Curandero curandero2 = new Curandero(mock(Casillero.class));
        curandero2.setBandoAliado();

        curandero1.curarA(curandero2);

        assertEquals(75 + 15,curandero2.getVida());
    }
    @Test
    public void test02CuranderoAliadoCuraACuranderoAliadoDaniadoSumaSusPuntosDeVida(){
        Curandero curandero1 = new Curandero(mock(Casillero.class));
        curandero1.setBandoAliado();
        Curandero curandero2 = new Curandero(mock(Casillero.class));
        curandero2.setBandoAliado();

        curandero2.recibirDanio(15);
        curandero1.curarA(curandero2);

        assertEquals(75,curandero2.getVida());
    }
    @Test
    public void test03CuranderoAliadoCuraACuranderoEnemigoTiraError(){
        Curandero curandero1 = new Curandero(mock(Casillero.class));
        curandero1.setBandoAliado();
        Curandero curandero2 = new Curandero(mock(Casillero.class));
        curandero2.setBandoEnemigo();

        assertFalse(curandero1.curarA(curandero2));
    }
    @Test
    public void test04CuranderoEnemigoCuraACuranderoAliadoTiraError(){
        Curandero curandero1 = new Curandero(mock(Casillero.class));
        curandero1.setBandoEnemigo();
        Curandero curandero2 = new Curandero(mock(Casillero.class));
        curandero2.setBandoAliado();

        assertFalse(curandero1.curarA(curandero2));
    }
    @Test
    public void test05CuranderoEnemigoCuraACuranderoEnemigoSumaSusPuntosDeVida(){
        Curandero curandero1 = new Curandero(mock(Casillero.class));
        curandero1.setBandoEnemigo();
        Curandero curandero2 = new Curandero(mock(Casillero.class));
        curandero2.setBandoEnemigo();

        curandero1.curarA(curandero2);

        assertEquals(90,curandero2.getVida());
    }

}
