package fiuba.AlgoChess.Modelo.Tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroLibreException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
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
    
    
    @Test
    public void Test05SeMueveUnSoldadoJuntoAOtroYNoActuanComoBatallon(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        
        Posicion posicionInicial1 = new Posicion(0,0);
        Posicion posicionInicial2 = new Posicion(0,1);
        
        Posicion posicionFinal1 = new Posicion(1,0);
        Posicion posicionFinal2 = posicionInicial2;
        
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(soldado1, posicionInicial1);
        tablero.agregarNuevaUnidad(soldado2, posicionInicial2);
        tablero.moverUnidad(posicionInicial1, direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(posicionFinal1));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(posicionFinal2));
    }
    
    
    @Test
    public void Test06SeMueveUnSoldadoJuntoAOtrosYActuanComoBatallon(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(0,2);
        
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        
        tablero.moverUnidad(posicion2, direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(3,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(2,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
    }
    
    
    @Test
    public void Test07SeMueveUnBatallonPeroUnoQuedaBloqueado(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,1);
        Posicion posicion3 = new Posicion(0,2);
        
        Direccion direccion = new Sur();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        
        tablero.moverUnidad(posicion2, direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(0,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(0,2)));
    }
    
    
    
    @Test (expected = DesplazamientoInvalidoExcepcion.class)
    public void Test08SeQuiereMoverUnBatallonPeroTodosEstanBloqueados(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(2,0);
        Posicion posicion2 = new Posicion(1,0);
        Posicion posicion3 = new Posicion(0,0);
        
        Direccion direccion = new Oeste();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        
        tablero.moverUnidad(posicion2, direccion);
    }
}