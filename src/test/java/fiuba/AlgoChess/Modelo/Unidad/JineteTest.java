package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Unidad.Jinete.Jinete;


public class JineteTest {

	
	@Test
	public void test00JineteApenasCreadoTiene100DeVida() {
		
		Bando bandoJose = new Bando();
		Jinete jinete = new Jinete(bandoJose);

		Assert.assertEquals(100, jinete.getVida());
	}

	
	@Test
	public void test01JineteAtacaAJineteEnemigoYLeRestaCorrectamenteLaVida() {
		
		Bando bandoJose = new Bando();
		Jinete jinete1 = new Jinete(bandoJose);
		
		Bando bandoJuan = new Bando();
		Jinete jinete2 = new Jinete(bandoJuan);

		jinete1.interactuarCon(jinete2);
		
		Assert.assertEquals(95, jinete2.getVida());
	}

	
	@Test (expected = MismoBandoException.class)
	public void test02JineteAtacaAJineteAliadoTiraError() {
		
		Bando bandoJose = new Bando();
		
		Jinete jinete1 = new Jinete(bandoJose);
		Jinete jinete2 = new Jinete(bandoJose);

		jinete1.interactuarCon(jinete2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test03UnJineteNoPuedeAtacarseASiMismo() {
		
		Bando bandoJose = new Bando();
		
		Jinete jinete1 = new Jinete(bandoJose);
		
		jinete1.interactuarCon(jinete1);
	}
}
