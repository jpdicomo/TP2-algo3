package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Ubicacion.*;
import fiuba.AlgoChess.Modelo.Unidad.Jinete;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;


public class TableroTest {
	
    @Test
    public void Test00SeCreaUnTableroConTodosSusCasillerosVacios(){

    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        int posicionesVacias = 0;
        
        for (int fila = 0; fila < 20; fila++) {
			for (int columna = 0; columna < 20; columna++) {
				
				Posicion posicion = new Posicion(fila, columna);
				
				try {
					
					tablero.seleccionarUnidad(posicion);
				
				} catch (CasilleroLibreException e) {
					
					posicionesVacias++;
				}
			}
		}

        Assert.assertEquals(400, posicionesVacias);
    }
    
    
    @Test
    public void Test01SeColocaUnaUnidadEnElTableroEnElLadoAliado(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado = new Soldado(bandoJose);
        Posicion posicion = new Posicion(0,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicion);
        
    	Assert.assertEquals(soldado, tablero.seleccionarUnidad(posicion));
    }
    

    @Test (expected = DistintoBandoException.class)
    public void Test02SeColocaUnaUnidadEnElTableroEnElLadoEnemigoYTiraError(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado = new Soldado(bandoJose);
        Posicion posicion = new Posicion(10,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicion);
    }
    
    
    @Test
    public void Test03SeMueveUnaUnidadEnElTableroAUnaPosicionValida(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Jinete jinete = new Jinete(bandoJose);
        
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(1,0);
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(jinete, posicionInicial);
        tablero.moverUnidad(posicionInicial, direccion);
        
        Assert.assertEquals(jinete, tablero.seleccionarUnidad(posicionFinal));
    }
    
    
    @Test
    public void Test04SeMueveUnaUnidadEnElTableroAlLadoEnemigo(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Jinete jinete = new Jinete(bandoJuan);
        
        Posicion posicionInicial = new Posicion(10,0);
        Posicion posicionFinal = new Posicion(9,0);
        Direccion direccion = new Sur();
    	
        tablero.agregarNuevaUnidad(jinete, posicionInicial);
        tablero.moverUnidad(posicionInicial, direccion);

        Assert.assertEquals(jinete,tablero.seleccionarUnidad(posicionFinal));

    }
}