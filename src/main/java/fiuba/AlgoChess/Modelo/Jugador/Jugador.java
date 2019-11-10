package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Unidad.Entidad;
import java.util.Scanner;

public class Jugador {

    // Atributos.

    private String nombre;
    private int puntos;
    private int cantidadEntidades;
    Scanner consola = new Scanner(System.in);


    // Metodos.

    /*
     * POST: Crea un nuevo Jugador al cual se le ha asignado un nombre y
     * una cierta cantidad de puntos para jugar.
     */
    public Jugador(String nombre){

        this.nombre = nombre;
        this.puntos = 20;
        this.cantidadEntidades = 0;
    }


    /*
     * PRE:  El Jugador cuenta con puntos suficientes para colocar una nueva Entidad en el Tablero.
     * POST: Se agrega una nueva Entidad al Tablero y al Jugador.
     *
     * NOTA: Revisar este metodo a ver si puedo mejorarlo.
     */
    public boolean agregarEntidad(Entidad unaEntidad){

        if(this.puntos >= unaEntidad.getCosto()){ //precioentidad

            this.puntos-= unaEntidad.getCosto();
            this.cantidadEntidades ++;
            return true;

        }else{
            return false;
        }
    }


    /*
     * POST: Indica si el Jugador aun tiene fichas para continuar jugando.
     */
    public boolean sigueJugando() {

        return(this.cantidadEntidades > 0);
    }


    /*
     * PRE:  -...
     * POST: -...
     */
    public int[] elegirCasillero(){

        int[] array = new int[2];

        System.out.println("Ingresa fila: ");
        array[0] = consola.nextInt();

        System.out.println("Ingresa columna: ");
        array[1] = consola.nextInt();

        return array;
    }


    /*
     * POST: Devuelve los puntos del jugador.
     */
    public void setPuntos(int puntos) {

        this.puntos = puntos;
    }
}