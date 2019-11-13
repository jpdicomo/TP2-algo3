package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class JineteTest {

	
	@Test
	public void test00JineteApenasCreadoTiene100DeVida() {
		
		Jugador jose = new Jugador("Jose");
		Jinete jinete = new Jinete(jose.getBando());

		Assert.assertEquals(100, jinete.getVida());
	}

	
	@Test
	public void test01JineteAtacaAJineteEnemigoYLeRestaCorrectamenteLaVida() {
		
		Jugador jose = new Jugador("Jose");
		Jinete jinete1 = new Jinete(jose.getBando());
		
		Jugador juan = new Jugador("Juan");
		Jinete jinete2 = new Jinete(juan.getBando());

		jinete1.realizarAccionSobre(jinete2);
		
		Assert.assertEquals(95, jinete2.getVida());
	}

	
	@Test (expected = MismoBandoException.class)
	public void test02JineteAtacaAJineteAliadoTiraError() {
		
		Jugador jose = new Jugador("Jose");
		
		Jinete jinete1 = new Jinete(jose.getBando());
		Jinete jinete2 = new Jinete(jose.getBando());

		jinete1.realizarAccionSobre(jinete2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test03UnJineteNoPuedeAtacarseASiMismo() {
		
		Jugador jose = new Jugador("Jose");
		
		Jinete jinete1 = new Jinete(jose.getBando());
		
		jinete1.realizarAccionSobre(jinete1);
	}
}
