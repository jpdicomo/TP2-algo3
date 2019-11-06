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



        Assert.assertEquals(true, casillero.agregarEntidad(jinete));
    }

    @Test
    public void Test02NoSeColocaEntidadEnCasilleroOcupado() {

        Casillero casillero = new Casillero(1,1);
        Jinete jinete = new Jinete(casillero);
        casillero.agregarEntidad(jinete);

        Jinete otroJinete = new Jinete(casillero);
        
        Assert.assertEquals(false, casillero.agregarEntidad(otroJinete));
    }

}