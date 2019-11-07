package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Soldado extends Entidad implements Atacante{

    private TipoAtaque tipoAtaque = new AtaqueMelee(10);

    public Soldado(Casillero casillero) {
        super(casillero);
        this.vida = 100;
        this.costo = 1;
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
}
