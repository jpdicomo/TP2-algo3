package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Jugador.Bando;

public class Jinete extends Unidad /* implements Movible */{

	// Atributos.
	
    private TipoAtaque tipoAtaque;
    private int danioMelee = 5;

    
    // Metodos.
    
    /*
     * 
     */
    public Jinete(Bando bando){
    	
        super(bando);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
    }

    
//    /*
//     * 
//     */
//    @Override
//    public boolean atacarA(Unidad unidad) {
//        try{
//            this.bando.atacarA(unidad,tipoAtaque);
//        }catch(MismoBandoException e){
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
//    /*
//     * 
//     */
//    @Override
//    public boolean moverseA(Casillero casilleroNuevo) {
//        try{
//            casilleroNuevo.agregarUnidad(this);
//        }catch(CasilleroOcupadoException e){
//            return false;
//        }
//        this.casillero.quitarEntidad();
//        this.casillero = casilleroNuevo;
//        return true;
//    }


    @Override
	public void realizarAccionSobre(Unidad otraUnidad) {

    	super.realizarAccionSobre(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad.getBando());
		this.tipoAtaque.atacarA(otraUnidad);
	}
}