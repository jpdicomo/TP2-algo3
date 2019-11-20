package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class SoldadoTest {
	
	/*
	 * NOTA: Los test de batallon estan en TableroTest.
	 */

	
	@Test
	public void test00SoldadoApenasCreadoTiene100DeVida() {
		
		Bando bandoJose = new Bando();
		Soldado soldado = new Soldado(bandoJose);

		Assert.assertEquals(100, soldado.getVida());
	}
	

	@Test
	public void test01SoldadoAliadoAtacaASoldadoEnemigoYLeRestaCorrectamenteLaVida() {
		
		Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();

    	Soldado soldado1 = new Soldado(bandoJose);
    	Soldado soldado2 = new Soldado(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		
		casillero1.agregarNuevaUnidad(soldado1);
		casillero2.agregarNuevaUnidad(soldado2);
		
		soldado1.interactuarCon(casillero2);
		
		Assert.assertEquals(90, soldado2.getVida());
	}
	
	
	@Test (expected = DistanciaInvalidaException.class)
	public void test02SoldadoAtacaASoldadoEnemigoMuyLejosYTiraError() {
		
		Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();

    	Soldado soldado1 = new Soldado(bandoJose);
    	Soldado soldado2 = new Soldado(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 3, bandoJuan);
		
		casillero1.agregarNuevaUnidad(soldado1);
		casillero2.agregarNuevaUnidad(soldado2);
		
		soldado1.interactuarCon(casillero2);
	}

	
	@Test (expected = MismoBandoException.class)
	public void test03SoldadoAtacaASoldadoAliadoTiraError() {
		
		Bando bandoJose = new Bando();

    	Soldado soldado1 = new Soldado(bandoJose);
    	Soldado soldado2 = new Soldado(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);
		
		casillero1.agregarNuevaUnidad(soldado1);
		casillero2.agregarNuevaUnidad(soldado2);
		
		soldado1.interactuarCon(casillero2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test04UnSoldadoSeAtacaASiMismoYTiraError() {

		Bando bandoJose = new Bando();

    	Soldado soldado = new Soldado(bandoJose);
		Casillero casillero = new Casillero(0, 0, bandoJose);
		
		casillero.agregarNuevaUnidad(soldado);
		
		soldado.interactuarCon(casillero);
	}

}
