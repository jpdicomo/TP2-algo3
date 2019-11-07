package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Tablero.Casillero;

import static org.mockito.Mockito.mock;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaEntidadSiTienePuntos(){


        Jugador jugador = new Aliado("Jose");
        Casillero casillero = new Casillero(1,1);
        Jinete jinete = new Jinete(casillero);


        Assert.assertEquals(true, jugador.colocarEntidad(jinete));
    }


    @Test
    public void Test02JugadorNoPuedeColocarUnaEntidadSiNoTienePuntos(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Aliado("Jose");

        jugador.setPuntos(5);

        Jinete jinete = new Jinete(mock(Casillero.class));
        Jinete otroJinete = new Jinete(mock(Casillero.class));

        jugador.colocarEntidad(jinete);
        jugador.colocarEntidad(otroJinete);

        Assert.assertEquals(false, jugador.colocarEntidad(jinete));
    }
    @Test
    public void Test03JugadorPierdeSiSeQuedaSinEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Aliado("Fede");

        Assert.assertEquals(false, jugador.sigueJugando());

    }
    @Test
    public void Test04JugadorSigueJugandoSiTieneEntidades(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Aliado("Fede");
        Jinete jinete = mock(Jinete.class);
        jugador.colocarEntidad(jinete);

        Assert.assertEquals(true, jugador.sigueJugando());

    }

}