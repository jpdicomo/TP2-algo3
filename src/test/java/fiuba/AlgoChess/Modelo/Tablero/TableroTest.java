package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class TableroTest {

    @Test
    public void Test00SeCreaUnTableroConTodosSusCasillerosVacios(){

    	Jugador fede = new Jugador("Fede");
    	Jugador juampi = new Jugador("Juampi");
    	
        Tablero tablero = new Tablero(fede, juampi);
        int posicionesVacias = 0;
        
        for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				
				Posicion posicion = new Posicion(i,j);
				
				try {
					
					tablero.seleccionarUnidad(posicion);
				
				}catch (CasilleroLibreException e) {
					
					posicionesVacias++;
				}
			}
		}

        Assert.assertEquals(400, posicionesVacias);
    }
}