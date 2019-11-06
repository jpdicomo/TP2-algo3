package fiuba.AlgoChess.Modelo.Unidad;


import fiuba.AlgoChess.Modelo.Tablero.Casillero;

public class Jinete extends Entidad implements Atacante{

    private TipoAtaque tipoAtaque;
    private int danioDistancia = 15;

    public Jinete(Casillero casillero){
        super(casillero);
        this.tipoAtaque = new AtaqueMelee(5);
        this.vida = 100;

    }

    @Override
    public void atacarA(Entidad entidad) {
        tipoAtaque.atacarA(entidad);
    }

    public void setAtaqueADistancia() {
        this.tipoAtaque = new AtaqueADistancia(15);
    }
}