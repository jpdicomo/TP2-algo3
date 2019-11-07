package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Errores.MismoBandoExeption;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Jinete extends Entidad implements Atacante{

    private TipoAtaque tipoAtaque;
    private int danioMelee = 5;

    public Jinete(Casillero casillero){
        super(casillero);
        this.tipoAtaque = new AtaqueMelee(this.danioMelee);
        this.vida = 100;
        this.costo = 3;
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