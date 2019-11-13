package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class SoldadoTest {

	
	@Test
	public void test00SoldadoApenasCreadoTiene100DeVida() {
		
		Jugador jose = new Jugador("Jose");
		Soldado soldado = new Soldado(jose.getBando());

		Assert.assertEquals(100, soldado.getVida());
	}
	

	@Test
	public void test01SoldadoAliadoAtacaASoldadoEnemigoYLeRestaCorrectamenteLaVida() {
		
		Jugador jose = new Jugador("Jose");
		Soldado soldado1 = new Soldado(jose.getBando());

		Jugador juan = new Jugador("Juan");
		Soldado soldado2 = new Soldado(juan.getBando());

		soldado1.realizarAccionSobre(soldado2);
		
		Assert.assertEquals(90, soldado2.getVida());
	}

	
	@Test (expected = MismoBandoException.class)
	public void test02SoldadoAtacaASoldadoAliadoTiraError() {
		
		Jugador jose = new Jugador("Jose");
		
		Soldado soldado1 = new Soldado(jose.getBando());
		Soldado soldado2 = new Soldado(jose.getBando());

		soldado1.realizarAccionSobre(soldado2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test05UnSoldadoAliadoNoPuedeAtacarseASiMismo() {

		Jugador jose = new Jugador("Jose");
		
		Soldado soldado1 = new Soldado(jose.getBando());
		
		soldado1.realizarAccionSobre(soldado1);
	}
}
