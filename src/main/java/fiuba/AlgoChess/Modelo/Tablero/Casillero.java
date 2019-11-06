package main.java.fiuba.AlgoChess.Modelo.Tablero;


import main.java.fiuba.AlgoChess.Modelo.Errores.CasilleroOcupadoException;
import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;

public class Casillero {

    private int x;
    private int y;
    private Estado estado;

    public Casillero(int x, int y){
        this.x = x;
        this.y = y;
        this.estado = new Libre();
    }
    public boolean agregarEntidad(Entidad entidad){
        try {
            estado.agregarEntidad(entidad, this);
            estado = new Ocupado();
        }
        catch(CasilleroOcupadoException error){
            return false;
        }
        return true;
    }
}
