package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Unidad.Aliada;
import fiuba.AlgoChess.Modelo.Unidad.Enemiga;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CasilleroTest {


    @Test
    public void Test01SeColocaEntidadEnCasilleroLibre() {

        Casillero casillero = new Casillero(1,1, new Aliada());
        Jinete jinete = mock(Jinete.class);

        Assert.assertEquals(true, casillero.agregarEntidad(jinete));
    }

    @Test
    public void Test02NoSeColocaEntidadEnCasilleroOcupado() {

        Casillero casillero = new Casillero(1,1, new Aliada());
        Jinete jinete = mock(Jinete.class);
        casillero.agregarEntidad(jinete);

        Jinete otroJinete = mock(Jinete.class);

        Assert.assertEquals(false, casillero.agregarEntidad(otroJinete));
    }

    @Test
    public void Test03NoSeColocaEntidadEnCasilleroEnemigo() {

        Casillero casillero = new Casillero(1,1, new Enemiga());
        Jinete jinete = mock(Jinete.class);
        jinete.setBandoEnemigo();
        Assert.assertEquals(false, casillero.agregarEntidad(jinete));
    }

}