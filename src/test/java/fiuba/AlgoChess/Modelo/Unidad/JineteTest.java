package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class JineteTest {

	
	@Test
	public void test00JineteApenasCreadoTiene100DeVida() {
		
		Bando bandoJose = new Bando();
		
		Jinete jinete = new Jinete(bandoJose);

		Assert.assertEquals(100, (int) jinete.getVida());
	}

	
	@Test
	public void test01JineteAtacaAJineteEnemigoCercanoYLeRestaCorrectamenteLaVida() {
		
		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
    	Jinete jinete2 = new Jinete(bandoJuan);
    	
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		casillero1.agregarVecino(casillero2);
		
		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);

		jinete1.interactuarCon(casillero2);
		
		Assert.assertEquals(100 - 5, (int) jinete2.getVida());
	}
	
	
	@Test
	public void test02JineteAtacaAJineteEnemigoADistanciaMediaYLeRestaCorrectamenteLaVida() {
		
		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
    	Jinete jinete2 = new Jinete(bandoJuan);
    	
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 4, bandoJuan);
		
		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);

		jinete1.interactuarCon(casillero2);
		
		Assert.assertEquals(100 - 15, (int) jinete2.getVida());
	}
	
	
	@Test (expected = DistanciaInvalidaException.class)
	public void test03JineteAtacaAJineteEnemigoLejanoYTiraError() {
		
		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
    	Jinete jinete2 = new Jinete(bandoJuan);
    	
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 6, bandoJuan);
		
		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);

		jinete1.interactuarCon(casillero2);
	}
	
	
	@Test (expected = DistanciaInvalidaException.class)
	public void test04JineteAtacaAJineteADistanciaMediaConEnemigoCercaYTiraError() {
		
		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
    	Jinete jinete2 = new Jinete(bandoJuan);
    	Jinete jinete3 = new Jinete(bandoJuan);
    	
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 2, bandoJuan);
		Casillero casillero3 = new Casillero(0, 4, bandoJuan);
		casillero1.agregarVecino(casillero2);
		
		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);

		jinete1.interactuarCon(casillero3);
	}
	

	
	@Test (expected = MismoBandoException.class)
	public void test05JineteAtacaAJineteAliadoTiraError() {
		
		Bando bandoJose = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
    	Jinete jinete2 = new Jinete(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);
		
		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		
		jinete1.interactuarCon(casillero2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test06UnJineteSeAtacaASiMismoYTiraError() {
		
		Bando bandoJose = new Bando();

    	Jinete jinete1 = new Jinete(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		
		casillero1.agregarNuevaUnidad(jinete1);
		
		jinete1.interactuarCon(casillero1);
	}
}
