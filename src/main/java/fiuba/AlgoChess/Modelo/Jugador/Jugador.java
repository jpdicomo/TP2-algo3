package fiuba.AlgoChess.Modelo.Jugador;

import fiuba.AlgoChess.Modelo.Errores.PuntosInsuficientesException;
import fiuba.AlgoChess.Modelo.Unidad.Unidad;

import java.util.ArrayList;
import java.util.Iterator;


public class Jugador {

	private String nombre;
	private int puntos;
	private ArrayList<Unidad> unidades;
	private final Bando bando;


	public Jugador(String nombre, Bando bando) {

		this.nombre = nombre;
		this.puntos = 20;
		this.unidades = new ArrayList<Unidad>();
		this.bando = bando;
	}


	public void agregarUnidad(Unidad unaUnidad) {

		if (this.puntos >= unaUnidad.getCosto()) {

			this.puntos -= unaUnidad.getCosto();
			this.unidades.add(unaUnidad);

		} else {

			throw new PuntosInsuficientesException();
		}
	}

	
	private void quitarUnidadesMuertas() {

		Iterator<Unidad> i = this.unidades.iterator();
		
		while (i.hasNext()) {

			Unidad unidad = i.next();

			if(!unidad.sigoViva()) {

				i.remove();
			}
		}
	}


	public boolean sigueJugando() {

		this.quitarUnidadesMuertas();
		return (!this.unidades.isEmpty());
	}

	
	public void elegirUnidad(Unidad unidad) {

		this.bando.interactuarConUnAliado(unidad);
	}


	public int getPuntos() {

		return this.puntos;
	}


	public String getNombre() {

		return this.nombre;
	}

	
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	
	public ArrayList<Unidad> getUnidades() {
		

		return this.unidades;
	}
}
