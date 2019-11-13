package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Tablero.Tablero;

public class Curandero extends Unidad /*implements Movible*/{

	// Atributos.
	
	private int curacion;

	
	// Metodos.
	
    /* 
     * PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.
     */
    public Curandero(Bando bando){
    	
        super(bando);
        this.vida = 75;
        this.curacion = 15;
        this.costo = 2;
    }
    
    
    /* 
     * PRE:  La unidad no es una catapulta.
     * POST: Aumenta la vida de la unidad tanto como le permita su poder de curación.
     */
    public void curarA(Unidad unidad) {

    	unidad.serCurado(this.curacion);
    }
    
//    
//    /*
//     * 
//     */
//    @Override
//    public boolean moverseALaDerecha(Tablero tablero){
//        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
//        try{moverseA(casilleroNuevo);
//        }catch(CasilleroOcupadoException e) {
//            return false;
//        }catch(DistintoBandoException e){
//            return false;
//        }
//        return true;
//    }
//    
//    
//    /*
//     * 
//     */
//    @Override
//    public boolean moverseALaIzquierda(Tablero tablero){
//        Casillero casilleroNuevo = tablero.getDerecha(this.casillero);
//        try{moverseA(casilleroNuevo);
//        }catch(CasilleroOcupadoException e) {
//            return false;
//        }catch(DistintoBandoException e){
//            return false;
//        }
//        return true;
//    }
//    
//    
//    /*
//     * 
//     */
//    @Override
//    public boolean moverseArriba(Tablero tablero){
//        Casillero casilleroNuevo = tablero.getArriba(this.casillero);
//        try{moverseA(casilleroNuevo);
//        }catch(CasilleroOcupadoException e) {
//            return false;
//        }catch(DistintoBandoException e){
//            return false;
//        }
//        return true;
//    }
//    
//    
//    /*
//     * 
//     */
//    @Override
//    public boolean moverseAbajo(Tablero tablero){
//        Casillero casilleroNuevo = tablero.getAbajo(this.casillero);
//        try{moverseA(casilleroNuevo);
//        }catch(CasilleroOcupadoException e) {
//            return false;
//        }catch(DistintoBandoException e){
//            return false;
//        }
//        return true;
//    }
//
//    
//	/*
//	 * 
//	 */
//    @Override
//    public boolean moverseA(Casillero casilleroNuevo) {
//    	
//        try{
//        	
//            casilleroNuevo.agregarUnidad(this);
//            
//        }catch(CasilleroOcupadoException e){
//        	
//            return false;
//        }
//        
//        this.casillero.quitarEntidad();
//        this.casillero = casilleroNuevo;
//        return true;
//    }


    @Override
	public void realizarAccionSobre(Unidad otraUnidad) {

    	super.realizarAccionSobre(otraUnidad);
		this.bando.interactuarConUnAliado(otraUnidad.getBando());
		this.curarA(otraUnidad);
	}
}
