package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Errores.MismaUnidadException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;


public abstract class Unidad {

    // Atributos.

    protected int vida;
    protected int costo;
    protected Bando bando;


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


    /*
     *
     */
    public int getVida(){

    	return this.vida;
    }
    
    public int getCosto(){

        return this.costo;
    }
    
    
    public void realizarAccionSobre(Unidad otraUnidad) {
    	
    	if(this == otraUnidad) {
    		
    		throw new MismaUnidadException();
    	}
    }


    
//    
//    public void setBandoAliado(){
//        this.bando = new Aliada();
//    }
//    public void setBandoEnemigo(){
//        this.bando = new Enemiga();
//    }
//
//    public void serCuradoPorAliado(int curacion){
//
//        this.bando.serCuradoPorAliado(this,curacion);
//    }
//
//    public void serCuradoPorEnemigo(int curacion){
//
//        this.bando.serCuradoPorEnemigo(this,curacion);
//    }
//
//    public void serAtacadaPorAliado(TipoAtaque tipoAtaque){
//
//        this.bando.serAtacadaPorAliado(this,tipoAtaque);
//    }
//
//    public void serAtacadaPorEnemigo(TipoAtaque tipoAtaque){
//
//        this.bando.serAtacadaPorEnemigo(this,tipoAtaque);
//    }
//
//    /*
//     * Esto falla porque estas comparando objetos de direcciones distintas.
//     */
//    public boolean serColocadaEnCasilleroDeBando(Bando bando){
//
//        if(this.bando == bando){
//            return true;
//        } else {
//            throw new DistintoBandoException();
//        }
//    }


	public Bando getBando() {
		
		return this.bando;
	}
}