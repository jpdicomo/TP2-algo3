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

        Assert.assertEquals(75, curandero.getVida());
    }
    
    
    @Test
    public void test01CuranderoCuraAAliadoYLeSumaSusPuntosDeVidaMaximos(){
        
    	Bando bandoJose = new Bando();
    	
    	Curandero curandero1 = new Curandero(bandoJose);
    	Curandero curandero2 = new Curandero(bandoJose);
    	Casillero casillero1 = new Casillero(0, 0, bandoJose);
    	Casillero casillero2 = new Casillero(0, 1, bandoJose);    	

        casillero1.agregarNuevaUnidad(curandero1);
        casillero2.agregarNuevaUnidad(curandero2);
        
        curandero1.interactuarCon(casillero2);

        Assert.assertEquals(75 + 15, curandero2.getVida());
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

		Assert.assertEquals(75, curandero2.getVida());
	}
	
	@Test (expected = DistanciaInvalidaException.class)
	public void test03CuranderoIntentaCurarAAliadoMuyLejosYTiraError() {

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
    public void test04CuranderoCuraACuranderoEnemigoTiraError(){
    	
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
    public void test05CuranderoQuiereCurarCatapultaYTiraError(){
    	
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
    public void test06CuranderoSeCuraASiMismoYTiraError(){
    	
		Bando bandoJose = new Bando();

		Curandero curandero = new Curandero(bandoJose);
		Casillero casillero = new Casillero(0, 0, bandoJose);

		casillero.agregarNuevaUnidad(curandero);

		curandero.interactuarCon(casillero);
    }
}
