package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Pais> paisesOcupados;
	private ArrayList<TarjetaPais> mazoJugador;
	private int fichasDisponibles;
	private int fichasMinimas = 3;

	public Jugador(){
		paisesOcupados = new ArrayList<Pais>();
		mazoJugador = new ArrayList<TarjetaPais>();
		fichasDisponibles = 0;
	}

	public ArrayList<TarjetaPais> obtenerTarjetas(){
		return mazoJugador;
	}

	public void ocupar(Pais unPais) {
		paisesOcupados.add(unPais);
	}

	public ArrayList<Pais> getPaisesOcupados() {
		return paisesOcupados;
	}
	
	public void desocupar(Pais unPais){
		paisesOcupados.remove(unPais);
	}

	public void colocarEjercitos(Pais unPais, int i) {
		if(paisesOcupados.contains(unPais) && fichasDisponibles >= i){
			unPais.incrementarEjercito(i);
			fichasDisponibles -= i;
		}
	}

	public void atacar(Pais paisAtacante, Pais paisAtacado){
		if(paisesOcupados.contains(paisAtacante) && !(paisesOcupados.contains(paisAtacado)))
			paisAtacante.atacar(paisAtacado);
		// Else excepcion?
	}

	public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidadDeEjercitos){
		if(paisesOcupados.contains(paisOrigen) && paisesOcupados.contains(paisDestino))
			paisOrigen.moverEjercito(paisDestino, cantidadDeEjercitos);
		// Else excepcion?
	}

	public void recibirTarjetaPais(TarjetaPais unaTarjetaPais){
		mazoJugador.add(unaTarjetaPais);
	}

	public void fichasPorPais(){
		fichasDisponibles += Math.max(paisesOcupados.size() / 2, fichasMinimas) ;
	}

	public void incrementarFichasDisponibles(int fichasAIncrementar){
		fichasDisponibles += fichasAIncrementar;
	}

}
