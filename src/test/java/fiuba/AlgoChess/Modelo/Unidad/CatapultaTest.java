package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class CatapultaTest {

	
    @Test
    public void test00CatapultaRecienCreadaTiene50DeVida(){
    	
    	Jugador jose = new Jugador("Jose");
        Catapulta catapulta = new Catapulta(jose.getBando());

        Assert.assertEquals(50,catapulta.getVida());
    }

    
    @Test
    public void test01CatapultaAtacaACatapultaEnemigaYLeRestaCorrectamenteLaVida(){
    	
    	Jugador jose = new Jugador("Jose");
		Catapulta catapulta1 = new Catapulta(jose.getBando());

		Jugador juan = new Jugador("Juan");
		Catapulta catapulta2 = new Catapulta(juan.getBando());
    	
    	catapulta1.realizarAccionSobre(catapulta2);
		
        Assert.assertEquals(30,catapulta2.getVida());
    }
    
    
    @Test (expected = MismoBandoException.class)
    public void test02CatapultaAtacaACatapultaAliadaTiraError(){
		
    	Jugador jose = new Jugador("Jose");
		
		Catapulta catapulta1 = new Catapulta(jose.getBando());
		Catapulta catapulta2 = new Catapulta(jose.getBando());

		catapulta1.realizarAccionSobre(catapulta2);
    }
    
    
	@Test (expected = MismaUnidadException.class)
	public void test03UnaCatapultaNoPuedeAtacarseASiMismo() {

		Jugador jose = new Jugador("Jose");
		
		Catapulta catapulta1 = new Catapulta(jose.getBando());
		
		catapulta1.realizarAccionSobre(catapulta1);
	}
}

