package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Ubicacion.*;
import fiuba.AlgoChess.Modelo.Unidad.Soldado;


public class TableroTest {
	
    @Test
    public void Test00SeCreaUnTableroConTodosSusCasillerosVacios(){

    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
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
    public void Test03SeMueveUnaUnidadEnElTableroUnaPosicionValida(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado = new Soldado(bandoJose);
        
        Posicion posicionInicial = new Posicion(0,0);
        Posicion posicionFinal = new Posicion(0,1);
        Direccion direccion = new Arriba();
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, direccion);
        
        Assert.assertEquals(soldado, tablero.seleccionarUnidad(posicionFinal));
    }
    
    
    @Test
    public void Test04SeMueveUnaUnidadEnElTableroAliadoEnemigo(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado = new Soldado(bandoJose);
        
        Posicion posicionInicial = new Posicion(9,0);
        Direccion direccion = new Derecha();
        Posicion posicionFinal = new Posicion(10,0);
    	
        tablero.agregarNuevaUnidad(soldado, posicionInicial);
        tablero.moverUnidad(posicionInicial, direccion);

        Assert.assertEquals(soldado,tablero.seleccionarUnidad(posicionFinal));

    }
}