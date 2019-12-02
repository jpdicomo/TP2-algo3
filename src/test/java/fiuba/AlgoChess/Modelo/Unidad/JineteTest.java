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

		Assert.assertEquals(100, jinete.getVida());
	}

	
	@Test
	public void test01JineteAtacaAJineteEnemigoCercanoSinAliadoCercanoYLeRestaCorrectamenteLaVida() {
		
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
		
		Assert.assertEquals(100 - 5, jinete2.getVida());
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
		
		Assert.assertEquals(100 - 15, jinete2.getVida());
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
	public void test04JineteAtacaAJineteADistanciaMediaConEnemigoCercaSinAliadoCercaYTiraError() {
		
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

	@Test
	public void test07JineteAtacaAJineteEnemigoCercanoConJineteAliadoCercaYLeRestaCorrectamenteLaVida() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);
		Jinete jinete3 = new Jinete(bandoJose);
		Jinete jinete4 = new Jinete(bandoJose);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero3 = new Casillero(1, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		casillero1.agregarVecino(casillero2);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);

		jinete1.interactuarCon(casillero2);

		Assert.assertEquals(100 - 5, jinete2.getVida());
	}


	@Test (expected = DistanciaInvalidaException.class)
	public void test08JineteAtacaAJineteADistanciaMediaConEnemigoCercaYSoldadoAliadoCercaYTiraError() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete soldado = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);
		Jinete jinete3 = new Jinete(bandoJuan);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 2, bandoJuan);
		Casillero casillero3 = new Casillero(0, 4, bandoJuan);
		Casillero casillero4 = new Casillero(0, 1, bandoJose);
		casillero1.agregarVecino(casillero2);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);
		casillero4.agregarNuevaUnidad(soldado);

		jinete1.interactuarCon(casillero3);
	}



	@Test
	public void test9JineteAtacaAJineteEnemigoCercanoSinEnemigosCercaNiAliadosCercaYLeRestaCorrectamenteLaVida() {

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

		Assert.assertEquals(100 - 5, jinete2.getVida());
	}

	@Test
	public void test10JineteAtacaAJineteEnemigoCercanoConEnemigosCercaSinAliadosCercaYLeRestaCorrectamenteLaVida() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);
		Jinete jinete3 = new Jinete(bandoJuan);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		Casillero casillero3 = new Casillero(1, 0, bandoJuan);

		casillero1.agregarVecino(casillero2);
		casillero1.agregarVecino(casillero3);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);

		jinete1.interactuarCon(casillero2);

		Assert.assertEquals(100 - 5, jinete2.getVida());
	}

	@Test
	public void test10JineteAtacaAJineteEnemigoCercanoConEnemigosCercaConAliadosCercaYLeRestaCorrectamenteLaVida() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);
		Jinete jinete3 = new Jinete(bandoJuan);
		Jinete jinete5 = new Jinete(bandoJose);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero5 = new Casillero(1, 1, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);
		Casillero casillero3 = new Casillero(1, 0, bandoJuan);

		casillero1.agregarVecino(casillero2);
		casillero1.agregarVecino(casillero3);
		casillero1.agregarVecino(casillero5);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);
		casillero5.agregarNuevaUnidad(jinete5);

		jinete1.interactuarCon(casillero2);

		Assert.assertEquals(100 - 5, jinete2.getVida());
	}

	@Test
	public void test11JineteAtacaAJineteEnemigoADistanciaMediaConJineteAliadoCercanoSinEnemigosCercaYLeRestaCorrectamenteLaVida() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete jinete3 = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 4, bandoJuan);
		Casillero casillero3 = new Casillero(0, 1, bandoJose);


		casillero1.agregarVecino(casillero3);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(jinete3);

		jinete1.interactuarCon(casillero2);

		Assert.assertEquals(100 - 15, jinete2.getVida());
	}
	@Test
	public void test12JineteAtacaAJineteEnemigoADistanciaMediaConSoldadoAliadoCercanoSinEnemigosCercaYLeRestaCorrectamenteLaVida() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Jinete jinete1 = new Jinete(bandoJose);
		Jinete soldado = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJuan);

		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 4, bandoJuan);
		Casillero casillero3 = new Casillero(0, 1, bandoJose);


		casillero1.agregarVecino(casillero3);

		casillero1.agregarNuevaUnidad(jinete1);
		casillero2.agregarNuevaUnidad(jinete2);
		casillero3.agregarNuevaUnidad(soldado);

		jinete1.interactuarCon(casillero2);

		Assert.assertEquals(100 - 15, jinete2.getVida());
	}



}
