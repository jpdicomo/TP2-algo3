package fiuba.AlgoChess.Modelo.Jugador;


import main.java.fiuba.AlgoChess.Modelo.Unidad.Entidad;


public class Jugador {

    private int puntos = 20;

    public boolean colocarEntidad(){


        if(this.puntos > 0){ //precioentidad
            return true;

        }else{
            return false;
        }

    }

}
