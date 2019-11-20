package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class CatapultaTest {

	
    @Test
    public void test00CatapultaRecienCreadaTiene50DeVida(){
    	
    	Bando bandoJose = new Bando();

        Catapulta catapulta = new Catapulta(bandoJose);

        Assert.assertEquals(50,catapulta.getVida());
    }

    
    @Test
    public void test01CatapultaAtacaACatapultaEnemigaYLeRestaCorrectamenteLaVida(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();

    	Catapulta catapulta1 = new Catapulta(bandoJose);
    	Catapulta catapulta2 = new Catapulta(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 7, bandoJuan);
		
		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(catapulta2);
		
    	catapulta1.interactuarCon(casillero2);
		
        Assert.assertEquals(30, catapulta2.getVida());
    }
    
    
    @Test (expected = DistanciaInvalidaException.class)
    public void test02CatapultaAtacaACatapultaEnemigaMuyCercanaYTiraError(){
    	
    	Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();

    	Catapulta catapulta1 = new Catapulta(bandoJose);
    	Catapulta catapulta2 = new Catapulta(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		
		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(catapulta2);
		
    	catapulta1.interactuarCon(casillero2);
		
        Assert.assertEquals(30, catapulta2.getVida());
    }
    
    
    @Test (expected = MismoBandoException.class)
    public void test03CatapultaAtacaACatapultaAliadaTiraError(){
		
    	Bando bandoJose = new Bando();

    	Catapulta catapulta1 = new Catapulta(bandoJose);
    	Catapulta catapulta2 = new Catapulta(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);
		
		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(catapulta2);
		
    	catapulta1.interactuarCon(casillero2);
    }
    
    
	@Test (expected = MismaUnidadException.class)
	public void test04CatapultaSeAtacaASiMismaYTiraError() {

    	Bando bandoJose = new Bando();

    	Catapulta catapulta = new Catapulta(bandoJose);
		Casillero casillero = new Casillero(0, 0, bandoJose);
		
		casillero.agregarNuevaUnidad(catapulta);
		
		catapulta.interactuarCon(casillero);
	}
}

