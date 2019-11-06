package fiuba.AlgoChess.Modelo.Jugador;

public class Jugador {

    private int puntos = 20;
    private int cantidadEntidades = 0; 

    public bool colocarEntidad(Entidad unaEntidad){

        if(this.puntos > 0){
            retrun true;
            cantidadEntidades++;
        }else false;

    }

}
