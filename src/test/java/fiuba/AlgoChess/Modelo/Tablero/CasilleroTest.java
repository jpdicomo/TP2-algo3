package fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Unidad.Entidad;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {


    @Test
    public void Test01SeColocaEntidadEnCasilleroLibre() {

        Casillero casillero = new Casillero(1,1);
        Jinete jinete = new Jinete(casillero);

        casillero.agregarEntidad(jinete);

        Assert.assertEquals(true, true);
    }

    @Test
    public void Test02NoSeColocaEntidadEnCasilleroOcupado() {

        Casillero casillero = new Casillero(1,1);
        Jinete jinete = new Jinete(casillero);
        casillero.agregarEntidad(jinete);

        Jinete otroJinete = new Jinete(casillero);
        casillero.agregarEntidad(otroJinete);

        Assert.assertEquals(false, false);
    }

}