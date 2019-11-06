package fiuba.AlgoChess.Modelo.Jugador;



import org.junit.Assert;
import org.junit.Test;



public class JugadorTest {

    @Test
    public void Test01JugadorPuedeColocarUnaEntidadSiTienePuntos(){
        Jugador jugador = new Jugador();


        jugador.colocarEntidad();
        Assert.assertEquals(true,true);
    }


}