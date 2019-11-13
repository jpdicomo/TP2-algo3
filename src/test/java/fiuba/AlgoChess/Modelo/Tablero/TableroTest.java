package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;


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
    
    @Test
    public void Test01SeColocaUnaUnidadEnElTableroEnElLadoAliado(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        Posicion posicion = new Posicion(0,0);
    	
        tablero.agregarUnidad(soldado, posicion);
        
    	Assert.assertEquals(soldado, tablero.seleccionarUnidad(posicion));
    }
    
}