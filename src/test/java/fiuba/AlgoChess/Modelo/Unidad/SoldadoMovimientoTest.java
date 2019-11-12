package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SoldadoMovimientoTest {
    @Before
        public void inicializacion(){
            Tablero tablero = new Tablero(mock(Jugador.class),mock(Jugador.class));
        }
    @Test
    public void test00MoverSoldadoALaDerecha(){
        Soldado soldado = new Soldado();

    }
}
