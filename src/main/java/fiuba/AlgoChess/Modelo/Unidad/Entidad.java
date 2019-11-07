package fiuba.AlgoChess.Modelo.Unidad;

import fiuba.AlgoChess.Modelo.Errores.DistintoBandoException;
import fiuba.AlgoChess.Modelo.Tablero.Casillero;


public abstract class Entidad {

    protected Casillero casillero;
    protected int vida;
    protected int costo;
    protected Bando bando;

    public Entidad(Casillero casillero) {

        this.setCasillero(casillero);
    }

    public void setCasillero(Casillero casillero){

        this.casillero = casillero;
    }

    public void recibirDanio(int danio){

        this.vida -= danio;
    }

    public int getVida(){
        return this.vida;
    }

    protected void serCurado(int curacion){

        this.vida += curacion;
    }

    public int getCosto(){

        return this.costo;
    }

    public void setBandoAliado(){
        this.bando = new Aliada();
    }
    public void setBandoEnemigo(){
        this.bando = new Enemiga();
    }

    public void serCuradoPorAliado(int curacion){

        this.bando.serCuradoPorAliado(this,curacion);
    }

    public void serCuradoPorEnemigo(int curacion){

        this.bando.serCuradoPorEnemigo(this,curacion);
    }

    public void serAtacadaPorAliado(TipoAtaque tipoAtaque){

        this.bando.serAtacadaPorAliado(this,tipoAtaque);
    }

    public void serAtacadaPorEnemigo(TipoAtaque tipoAtaque){

        this.bando.serAtacadaPorEnemigo(this,tipoAtaque);
    }

    /*
     * Esto falla porque estas comparando objetos de direcciones distintas.
     */
    public boolean serColocadaEnCasilleroDeBando(Bando bando){

        if(this.bando == bando){
            return true;
        } else {
            throw new DistintoBandoException();
        }
    }
}