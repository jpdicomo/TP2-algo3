package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Bando;


public class CatapultaTest {

	
    @Test
    public void test00CatapultaRecienCreadaTiene50DeVida(){
    	
    	Bando bandoJose = new Bando();

        Catapulta catapulta = new Catapulta(bandoJose);

        Assert.assertEquals(50,catapulta.getVida());
    }

    
    @Test
    public void test01CatapultaAtacaACatapultaEnemigaYLeRestaCorrectamenteLaVida(){
    	
    	Bando bandoJose = new Bando();
		Catapulta catapulta1 = new Catapulta(bandoJose);

    	Bando bandoJuan = new Bando();
		Catapulta catapulta2 = new Catapulta(bandoJuan);
    	
    	catapulta1.interactuarCon(catapulta2);
		
        Assert.assertEquals(30, catapulta2.getVida());
    }
    
    
    @Test (expected = MismoBandoException.class)
    public void test02CatapultaAtacaACatapultaAliadaTiraError(){
		
    	
    	Bando bandoJose = new Bando();
    	
		Catapulta catapulta1 = new Catapulta(bandoJose);
		Catapulta catapulta2 = new Catapulta(bandoJose);

		catapulta1.interactuarCon(catapulta2);
    }
    
    
	@Test (expected = MismaUnidadException.class)
	public void test03UnaCatapultaNoPuedeAtacarseASiMismo() {

		Bando bandoJose = new Bando();
		
		Catapulta catapulta1 = new Catapulta(bandoJose);
		
		catapulta1.interactuarCon(catapulta1);
	}
}

