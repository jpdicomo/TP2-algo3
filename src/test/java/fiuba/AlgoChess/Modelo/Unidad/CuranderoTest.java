package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;
import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public class CuranderoTest {


	@Test
	public void test00CuranderoRecienCreadoTiene75DeVida(){

		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);

		Assert.assertEquals(75, (int)curandero.getVida());
	}


	@Test
	public void test01CuranderoCuraAAliadoNoDaniadoYLeSumaSusPuntosDeVidaMaximos(){

		Bando bandoJose = new Bando();

		Curandero curandero1 = new Curandero(bandoJose);
		Curandero curandero2 = new Curandero(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);

		casillero1.agregarNuevaUnidad(curandero1);
		casillero2.agregarNuevaUnidad(curandero2);

		curandero1.interactuarCon(casillero2);

		Assert.assertEquals(75 + 15,  (int)curandero2.getVida());
	}


	@Test
	public void test02CuranderoCuraACuranderoAliadoDaniadoSumaSusPuntosDeVida() {

		Bando bandoJose = new Bando();

		Curandero curandero1 = new Curandero(bandoJose);
		Curandero curandero2 = new Curandero(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);

		casillero1.agregarNuevaUnidad(curandero1);
		casillero2.agregarNuevaUnidad(curandero2);

		curandero2.recibirDanio(15);
		curandero1.interactuarCon(casillero2);

		Assert.assertEquals(75,  (int)curandero2.getVida());
	}


	@Test
	public void test03CuranderoCuraASoldadoAliadoDaniadoSumaSusPuntosDeVida() {

		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Soldado soldado = new Soldado(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);

		casillero1.agregarNuevaUnidad(curandero);
		casillero2.agregarNuevaUnidad(soldado);

		soldado.recibirDanio(20);
		curandero.interactuarCon(casillero2);

		Assert.assertEquals(95,  (int)soldado.getVida());
	}


	@Test
	public void test04CuranderoCuraASoldadoAliadoDaniadoQueEstaEnCasilleroEnemigoYLoCuraIgual() {

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Curandero curandero2 = new Curandero(bandoJose);
		Soldado soldado = new Soldado(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);

		casillero1.agregarUnidad(curandero);
		casillero2.agregarUnidad(curandero2);
		casillero2.recibirDanio(75);
		casillero2.quitarUnidadMuerta();
		casillero2.agregarUnidad(soldado);


		soldado.recibirDanio(40);

		curandero.interactuarCon(casillero2);

		Assert.assertEquals(75,  (int)soldado.getVida());
	}

	@Test
	public void test05CuranderoCuraAJineteAliadoDaniadoSumaSusPuntosDeVida() {

		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Jinete jinete = new Jinete(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);

		casillero1.agregarNuevaUnidad(curandero);
		casillero2.agregarNuevaUnidad(jinete);

		jinete.recibirDanio(20);
		curandero.interactuarCon(casillero2);

		Assert.assertEquals(95,  (int)jinete.getVida());
	}




	@Test (expected = DistanciaInvalidaException.class)
	public void test06CuranderoIntentaCurarAAliadoMuyLejosYTiraError() {

		Bando bandoJose = new Bando();

		Curandero curandero1 = new Curandero(bandoJose);
		Curandero curandero2 = new Curandero(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 3, bandoJose);

		casillero1.agregarNuevaUnidad(curandero1);
		casillero2.agregarNuevaUnidad(curandero2);

		curandero2.recibirDanio(15);
		curandero1.interactuarCon(casillero2);
	}


	@Test (expected = DistintoBandoException.class)
	public void test07CuranderoCuraACuranderoEnemigoTiraError(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Curandero curandero1 = new Curandero(bandoJose);
		Curandero curandero2 = new Curandero(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);

		casillero1.agregarNuevaUnidad(curandero1);
		casillero2.agregarNuevaUnidad(curandero2);

		curandero1.interactuarCon(casillero2);
	}


	@Test (expected = CatapultaNoPuedeSerCuradaException.class)
	public void test08CuranderoQuiereCurarCatapultaYTiraError(){

		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Catapulta catapulta = new Catapulta(bandoJose);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJose);

		casillero1.agregarNuevaUnidad(curandero);
		casillero2.agregarNuevaUnidad(catapulta);

		curandero.interactuarCon(casillero2);
	}


	@Test (expected = MismaUnidadException.class)
	public void test09CuranderoSeCuraASiMismoYTiraError(){

		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Casillero casillero = new Casillero(0, 0, bandoJose);

		casillero.agregarNuevaUnidad(curandero);

		curandero.interactuarCon(casillero);
	}
}
