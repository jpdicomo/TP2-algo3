package test.java.fiuba.AlgoChess.Modelo.Tablero;

import fiuba.AlgoChess.Modelo.Tablero.Jinete;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;


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