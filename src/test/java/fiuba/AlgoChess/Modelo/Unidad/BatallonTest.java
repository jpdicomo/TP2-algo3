package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DesplazamientoInvalidoExcepcion;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Ubicacion.Direccion;
import fiuba.AlgoChess.Modelo.Ubicacion.Norte;
import fiuba.AlgoChess.Modelo.Ubicacion.Oeste;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Ubicacion.Sur;

public class BatallonTest {
	
	@Test
    public void Test00SeMueveUnSoldadoJuntoAOtroYNoActuanComoBatallon(){
    	
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
    public void Test01SeMueveUnSoldadoJuntoAOtrosDosYActuanComoBatallon(){
    	
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
    public void Test02SeMueveUnBatallonPeroUnoQuedaBloqueado(){
    	
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
    public void Test03SeQuiereMoverUnBatallonPeroTodosEstanBloqueadosYTiraError(){
    	
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
    
    
    @Test
    public void Test04SeMueveUnSoldadoJuntoAOtrosTresYUnoNoSeMueveConElBatallon(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(0,3);
        
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);
        
        tablero.moverUnidad(posicion2, direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(new Posicion(1,1)));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
        Assert.assertEquals(soldado4, tablero.seleccionarUnidad(posicion4));
    }
    
    
    @Test
    public void Test05SeMueveUnBatallonYUnSoldadoQuedaBloqueado(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(1,1);
        
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);
        
        tablero.moverUnidad(posicion2, direccion);
        
        Assert.assertEquals(soldado1, tablero.seleccionarUnidad(new Posicion(1,0)));
        Assert.assertEquals(soldado2, tablero.seleccionarUnidad(posicion2));
        Assert.assertEquals(soldado3, tablero.seleccionarUnidad(new Posicion(1,2)));
    }
    
    
    @Test (expected = CasilleroOcupadoException.class)
    public void Test05SeMueveUnBatallonDondeUnSoldadoQuedaBloqueadoYElBatallonSeDesarma(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();
    	
        Tablero tablero = new Tablero(bandoJose, bandoJuan);
        Soldado soldado1 = new Soldado(bandoJose);
        Soldado soldado2 = new Soldado(bandoJose);
        Soldado soldado3 = new Soldado(bandoJose);
        Soldado soldado4 = new Soldado(bandoJose);
        
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(0,1);
        Posicion posicion3 = new Posicion(0,2);
        Posicion posicion4 = new Posicion(1,1);
        
        Direccion direccion = new Norte();
    	
        tablero.agregarNuevaUnidad(soldado1, posicion1);
        tablero.agregarNuevaUnidad(soldado2, posicion2);
        tablero.agregarNuevaUnidad(soldado3, posicion3);
        tablero.agregarNuevaUnidad(soldado4, posicion4);
        
        tablero.moverUnidad(posicion2, direccion);
        tablero.moverUnidad(posicion2, direccion);
        
        /*
         *  Al tratar de mover la pieza bloqueada, como ya no forma parte
         *  de un batallon (porque ya no existe un batallon) se lanza una
         *  excepcion.
         */
    }
    
}
