package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoException;


public abstract class Unidad {

    // Atributos.

    protected int vida;
    protected Bando bando;
	protected int costo;


    // Metodos.

    /*
     * POST: Crea una nueva unidad asignada a un determinado Jugador.
     */
    public Unidad(Bando bando) {
    	
        this.bando = bando;
    }
    
    
    /*
     *
     */
    public void recibirDanio(int danio){

        this.vida -= danio;
    }
    
    
	/*
	 * 
	 */
    protected void serCurado(int curacion){

        this.vida += curacion;
    }
    
    
    public void interactuarCon(Unidad otraUnidad) {
    	
    	if(this == otraUnidad) {
    		
    		throw new MismaUnidadException();
    	}
    }
    

    public void interactuarConUnEnemigo(Bando bandoDelEnemigo) {

		if(this.bando == bandoDelEnemigo) {
			
			throw new MismoBandoException();
		}
	}
    
    public void interactuarConUnAliado(Bando bandoDelAliado) {

    	if(this.bando != bandoDelAliado) {
    		
    		throw new DistintoBandoException();
    	}
	}
    
    
    /*
    *
    */
   public int getVida(){

	   return this.vida;
   }
    
    
    public int getCosto() {
    
    	return this.costo;
    }
}