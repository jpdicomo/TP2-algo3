package fiuba.AlgoChess.Modelo.Unidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Jugador.Jugador;


public class CuranderoTest {

	
    @Test
    public void test00CuranderoRecienCreadoTiene75DeVida(){
    	
    	Jugador jose = new Jugador("Jose");
        Curandero curandero = new Curandero(jose.getBando());

        Assert.assertEquals(75, curandero.getVida());
    }
    
    
    @Test
    public void test01CuranderoCuraACuranderoAliadoNoDaniadoSumaSusPuntosDeVidaMaximos(){
        
    	Jugador jose = new Jugador("Jose");
    	
    	Curandero curandero1 = new Curandero(jose.getBando());
        Curandero curandero2 = new Curandero(jose.getBando());

        curandero1.realizarAccionSobre(curandero2);

        Assert.assertEquals(75 + 15,curandero2.getVida());
    }
    
    
    @Test
    public void test02CuranderoCuraACuranderoAliadoDaniadoSumaSusPuntosDeVida(){
    	
    	Jugador jose = new Jugador("Jose");
    	
    	Curandero curandero1 = new Curandero(jose.getBando());
        Curandero curandero2 = new Curandero(jose.getBando());
        
        curandero2.recibirDanio(15);
        curandero1.realizarAccionSobre(curandero2);

        Assert.assertEquals(75,curandero2.getVida());
    }
    
    
    @Test (expected = DistintoBandoException.class)
    public void test03CuranderoCuraACuranderoEnemigoTiraError(){
    	
    	Jugador jose = new Jugador("Jose");
		Curandero curandero1 = new Curandero(jose.getBando());

		Jugador juan = new Jugador("Juan");
		Curandero curandero2 = new Curandero(juan.getBando());

		curandero1.realizarAccionSobre(curandero2);
    }
}
