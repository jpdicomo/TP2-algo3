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


        Assert.assertEquals(true, jugador.colocarEntidad(jinete));
    }


    @Test
    public void Test02JugadorNoPuedeColocarUnaEntidadSiNoTienePuntos(){

        //se altera el valor del costo de la entidad para ver verificación más rápido

        Jugador jugador = new Jugador();
        Casillero casillero = new Casillero(1,1);
        Casillero otroCasillero = new Casillero(1,2);

        Jinete jinete = new Jinete(casillero);
        Jinete otroJinete = new Jinete(otroCasillero);

        jugador.colocarEntidad(jinete);
        jugador.colocarEntidad(otroJinete);

        Assert.assertEquals(false, jugador.colocarEntidad(jinete));
    }
}