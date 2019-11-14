package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Ataque.Atacante;
import fiuba.AlgoChess.Modelo.Ataque.AtaqueALargaDistancia;
import fiuba.AlgoChess.Modelo.Ataque.TipoAtaque;
import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;
import fiuba.AlgoChess.Modelo.Errores.CatapultaNoPuedeSerCuradaException;

public class Catapulta extends Entidad implements Atacante {
    private TipoAtaque tipoAtaque = new AtaqueALargaDistancia(20);

    public Catapulta(Casillero casillero) {
        super(casillero);
        this.vida = 50;
        this.costo = 5;
    }

    @Override
    public boolean atacarA(Entidad entidad) {
        try{
            this.bando.atacarA(entidad,tipoAtaque);
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
