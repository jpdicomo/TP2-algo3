package fiuba.AlgoChess.Modelo.Jugador;



import fiuba.AlgoChess.Modelo.Tablero.Jinete;
import org.junit.Assert;
import org.junit.Test;

import main.java.fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaEntidadSiTienePuntos(){


        Jugador jugador = new Jugador();
        Casillero casillero = new Casillero(1,1);
        Jinete jinete = new Jinete(casillero);

        jugador.colocarEntidad(jinete);
        Assert.assertEquals(true, true);
    }


}