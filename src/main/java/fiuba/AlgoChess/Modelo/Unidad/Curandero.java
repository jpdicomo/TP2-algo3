package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.CuranderoNoPuedeAtacarException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Curandero extends Entidad {

	// Atributos
	static private int costo = 2;
	private int curacion;
    
    
    // Metodos
    
    /*
     * PRE:  El casillero esta libre.
     * POST: Crea un nuevo curandero, ubicado en un casillero.
     */
    public Curandero(Casillero casillero){
    	
        super(casillero);
        this.vida = 75;
        this.curacion = 15;
    }
    
    
    /*
     * PRE:  La unidadAliada no es una catapulta.
     * POST: Aumenta la vida de la unidadAliada tanto como le permita
     * 		 su poder de curación.
     */
    public void curarA(Entidad unidadAliada) {
    	
    	unidadAliada.serCurado(this.curacion);
    }

    
    /*
     * PRE:  El curandero no puede atacar.
     * POST: Lanza una excepcion si trata de invocarse.
     */
	@Override
	public void atacarA(Entidad unidadEnemiga) {
		
		throw new CuranderoNoPuedeAtacarException();
	}
	
	
	/* METODO ESTATICO (De clase)
	 * 
	 * POST: Devuelve el costo de crear una nueva entidad de tipo Curandero.
	 * 
	 */
	static public int getCosto() {
		
		return costo;
	}
}