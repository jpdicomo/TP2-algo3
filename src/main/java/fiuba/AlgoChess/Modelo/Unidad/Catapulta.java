package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero.Casillero;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;

public class Catapulta extends Unidad implements Atacante {
    private TipoAtaque tipoAtaque = new AtaqueALargaDistancia(20);

    public Catapulta(Casillero casillero) {
        super(casillero);
        this.vida = 50;
        this.costo = 5;
    }

    @Override
    public boolean atacarA(Unidad unidad) {
        try{
            this.bando.atacarA(unidad,tipoAtaque);
        }catch(MismoBandoExeption e){
            return false;
    }
        return true;
    }
    
	@Override
	public void serCurado(int curacion) {
	
		throw new CatapultaNoPuedeSerCuradaException();
	}
}
