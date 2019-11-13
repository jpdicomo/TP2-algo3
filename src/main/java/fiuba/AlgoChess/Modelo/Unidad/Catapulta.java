package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Jugador.Bando;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;


public class Catapulta extends Unidad {
	
	// Atributos.
	
    private TipoAtaque tipoAtaque = new AtaqueALargaDistancia(20);

    
    // Metodos.
    
    /*
     * PRE:  ...
     * POST: ... 
     */
    public Catapulta(Bando bando) {
    	
        super(bando);
        this.vida = 50;
        this.costo = 5;
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
//    }
//        return true;
//    }
    
    
    /*
     * 
     */
	@Override
	public void serCurado(int curacion) {
	
		throw new CatapultaNoPuedeSerCuradaException();
	}


	@Override
	public void realizarAccionSobre(Unidad otraUnidad) {

		super.realizarAccionSobre(otraUnidad);
		this.bando.interactuarConUnEnemigo(otraUnidad.getBando());
		this.tipoAtaque.atacarA(otraUnidad);
	}
}
