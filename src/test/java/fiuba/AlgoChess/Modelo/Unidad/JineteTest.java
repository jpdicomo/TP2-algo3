package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JineteTest {

    @Test
    public void test01JineteAtacaAOtroJineteAMeleeYLeRestaCorrectamenteLaVida(){
        Jinete jinete1 = new Jinete(mock(Casillero.class));
        Jinete jinete2 = new Jinete(mock(Casillero.class));

        jinete1.atacarA(jinete2);
        assertEquals(100-5,jinete2.getVida());
    }

}
