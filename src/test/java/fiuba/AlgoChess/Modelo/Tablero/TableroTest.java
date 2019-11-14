package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
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
    	
        tablero.agregarNuevaUnidad(soldado, posicion);
        
    	Assert.assertEquals(soldado, tablero.seleccionarUnidad(posicion));
    }
    

    @Test (expected = DistintoBandoException.class)
    public void Test02SeColocaUnaUnidadEnElTableroEnElLadoEnemigoYTiraError(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        Posicion posicion = new Posicion(10,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicion);
    }
    
    
    @Test
    public void Test03SeMueveUnaUnidadEnElTableroUnaPosicionValida(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(1,1);
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, posicionFinal);
        
        Assert.assertEquals(soldado, tablero.seleccionarUnidad(posicionFinal));
    }
    
    
    @Test (expected = DistanciaInvalidaException.class)
    public void Test04SeMueveUnaUnidadEnElTableroUnaPosicionMuyLejanaYTiraError(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(0,2);
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, posicionFinal);
    }
 
    
    @Test (expected = CasilleroOcupadoException.class)
    public void Test05SeMueveUnaUnidadEnElTableroALaMismaPosicionYTiraError(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(0,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, posicionFinal);
    }
    
    
    @Test
    public void Test06SeMueveUnaUnidadEnElTableroAliadoEnemigo(){
    	
    	Jugador jose = new Jugador("Jose");
    	Jugador juan = new Jugador("Juan");
    	
        Tablero tablero = new Tablero(jose, juan);
        Soldado soldado = new Soldado(jose.getBando());
        
        Posicion posicionInicial = new Posicion(9,0);
        Posicion posicionFinal = new Posicion(10,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, posicionFinal);

        Assert.assertEquals(soldado,tablero.seleccionarUnidad(posicionFinal));

    }


}