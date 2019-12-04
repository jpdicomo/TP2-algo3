package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistanciaInvalidaException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;


public class CatapultaTest {


    @Test
    public void test00CatapultaRecienCreadaTiene50DeVida(){

    	Bando bandoJose = new Bando();

        Catapulta catapulta = new Catapulta(bandoJose);

        Assert.assertEquals(50, (int) catapulta.getVida());
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

        Assert.assertEquals(30, (int) catapulta2.getVida());
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

        Assert.assertEquals(30, (int) catapulta2.getVida());
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


	@Test
	public void test05CatapultaAtacaEnAreaYHiereATodos() {

		Bando bandoJose = new Bando();
    	Bando bandoJuan = new Bando();

    	Tablero tablero = new Tablero(bandoJose, bandoJuan);

    	tablero.agregarNuevaUnidad(new Soldado(bandoJuan), new Posicion(13,9));
    	tablero.agregarNuevaUnidad(new Soldado(bandoJuan), new Posicion(14,8));
    	tablero.agregarNuevaUnidad(new Soldado(bandoJuan), new Posicion(14,9));
    	tablero.agregarNuevaUnidad(new Soldado(bandoJuan), new Posicion(14,10));
    	tablero.agregarNuevaUnidad(new Soldado(bandoJuan), new Posicion(15,9));

    	tablero.agregarNuevaUnidad(new Catapulta(bandoJose), new Posicion(4,9));

    	Unidad catapulta = tablero.seleccionarUnidad(new Posicion(4,9));
    	catapulta.interactuarCon(tablero.getCasillero(new Posicion(14,9)));

    	Assert.assertEquals(100 - 20, (int) tablero.seleccionarUnidad(new Posicion(13,9)).getVida());
    	Assert.assertEquals(100 - 20, (int) tablero.seleccionarUnidad(new Posicion(14,8)).getVida());
    	Assert.assertEquals(100 - 20, (int) tablero.seleccionarUnidad(new Posicion(14,9)).getVida());
    	Assert.assertEquals(100 - 20, (int) tablero.seleccionarUnidad(new Posicion(14,10)).getVida());
    	Assert.assertEquals(100 - 20, (int) tablero.seleccionarUnidad(new Posicion(15,9)).getVida());
	}

	@Test
	public void test06CatapultaAtacaASoldadoEnemigoYLeRestaCorrectamenteLaVida(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Soldado soldado = new Soldado(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 7, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(soldado);

		catapulta1.interactuarCon(casillero2);

		Assert.assertEquals(80,(int) soldado.getVida());
	}

	@Test
	public void test07CatapultaAtacaAUnJineteEnemigaYLeRestaCorrectamenteLaVida(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Jinete jinete = new Jinete(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 7, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(jinete);

		catapulta1.interactuarCon(casillero2);

		Assert.assertEquals(80, (int)jinete.getVida());
	}


	@Test
	public void test08CatapultaAtacaACuranderoEnemigoYLeRestaCorrectamenteLaVida(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Curandero curandero = new Curandero(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 7, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(curandero);

		catapulta1.interactuarCon(casillero2);

		Assert.assertEquals(55, (int)curandero.getVida());
	}

	@Test (expected = DistanciaInvalidaException.class)
	public void test09CatapultaAtacaASoldadoEnemigoMuyCercanoYTiraError(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Soldado soldado = new Soldado(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(soldado);

		catapulta1.interactuarCon(casillero2);

	}
	@Test (expected = DistanciaInvalidaException.class)
	public void test10CatapultaAtacaAJineteEnemigoMuyCercanoYTiraError(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Jinete jinete = new Jinete(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 1, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(jinete);

		catapulta1.interactuarCon(casillero2);

	}
	@Test (expected = DistanciaInvalidaException.class)
	public void test11CatapultaAtacaACuranderoEnemigoMuyCercanoYTiraError(){

		Bando bandoJose = new Bando();
		Bando bandoJuan = new Bando();

		Catapulta catapulta1 = new Catapulta(bandoJose);
		Curandero curandero = new Curandero(bandoJuan);
		Casillero casillero1 = new Casillero(0, 0, bandoJose);
		Casillero casillero2 = new Casillero(0, 2, bandoJuan);

		casillero1.agregarNuevaUnidad(catapulta1);
		casillero2.agregarNuevaUnidad(curandero);

		catapulta1.interactuarCon(casillero2);

	}

}




