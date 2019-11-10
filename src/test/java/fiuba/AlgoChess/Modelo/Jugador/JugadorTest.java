package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Aliada;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;

import static org.mockito.Mockito.mock;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaEntidadSiTienePuntos(){


        Jugador jugador = new Jugador("Jose");
        Casillero casillero = new Casillero(1,1, new Aliada());
        Jinete jinete = new Jinete(casillero);


        Assert.assertEquals(true, jugador.agregarEntidad(jinete));
    }


    @Test
    public void Test02JugadorNoPuedeColocarUnaEntidadSiNoTienePuntos(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Jose");

        jugador.setPuntos(5);

        Jinete jinete = new Jinete(mock(Casillero.class));
        Jinete otroJinete = new Jinete(mock(Casillero.class));

        jugador.agregarEntidad(jinete);
        jugador.agregarEntidad(otroJinete);

        Assert.assertEquals(false, jugador.agregarEntidad(jinete));
    }
    @Test
    public void Test03JugadorPierdeSiSeQuedaSinEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Fede");

        Assert.assertEquals(false, jugador.sigueJugando());

    }
    @Test
    public void Test04JugadorSigueJugandoSiTieneEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador("Fede");
        Jinete jinete = mock(Jinete.class);
        jugador.agregarEntidad(jinete);

        Assert.assertEquals(true, jugador.sigueJugando());

    }

}