package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Ubicacion.Posicion;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

import java.util.ArrayList;
import java.util.Scanner;


public class Jugador {

	private String nombre;
	private int puntos;
	private ArrayList<Unidad> unidades;
	private final Bando bando;
	Scanner consola = new Scanner(System.in);

	
	public Jugador(String nombre, Bando bando) {

		this.nombre = nombre;
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
		this.bando = bando;
	}
	

	public String getNombre() {

		return this.nombre;
	}
	

	public void agregarUnidad(Unidad unaUnidad) {

		if (this.puntos >= unaUnidad.getCosto()) {

			this.puntos -= unaUnidad.getCosto();
			this.unidades.add(unaUnidad);

		} else {

			throw new PuntosInsuficientesException();
		}
	}

	
	public boolean sigueJugando() {

		return (!this.unidades.isEmpty());
	}


    public Posicion elegirCasillero() {

		System.out.print("Ingresa fila: ");
		int y = consola.nextInt();
		
		System.out.print("\nIngresa columna: ");
		int x = consola.nextInt();
		
		return new Posicion(x,y);
    }


	public int getPuntos() {
		// TODO Auto-generated method stub
		return this.puntos;
	}
}
