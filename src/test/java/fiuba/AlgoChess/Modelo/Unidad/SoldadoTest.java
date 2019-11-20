package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;


public class SoldadoTest {

	
	@Test
	public void test00SoldadoApenasCreadoTiene100DeVida() {
		
		Bando bandoJose = new Bando();
		Soldado soldado = new Soldado(bandoJose);

		Assert.assertEquals(100, soldado.getVida());
	}
	

	@Test
	public void test01SoldadoAliadoAtacaASoldadoEnemigoYLeRestaCorrectamenteLaVida() {
		
		Bando bandoJose = new Bando();
		Soldado soldado1 = new Soldado(bandoJose);

		Bando bandoJuan = new Bando();
		Soldado soldado2 = new Soldado(bandoJuan);

		soldado1.interactuarCon(soldado2);
		
		Assert.assertEquals(90, soldado2.getVida());
	}

	
	@Test (expected = MismoBandoException.class)
	public void test02SoldadoAtacaASoldadoAliadoTiraError() {
		
		Bando bandoJose = new Bando();
		
		Soldado soldado1 = new Soldado(bandoJose);
		Soldado soldado2 = new Soldado(bandoJose);

		soldado1.interactuarCon(soldado2);
	}
	

	@Test (expected = MismaUnidadException.class)
	public void test03UnSoldadoNoPuedeAtacarseASiMismo() {

		Bando bandoJose = new Bando();
		
		Soldado soldado1 = new Soldado(bandoJose);
		
		soldado1.interactuarCon(soldado1);
	}

}
