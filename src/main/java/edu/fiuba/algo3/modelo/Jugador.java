package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

	private ArrayList<Pais> paisesOcupados;

	public Jugador(){
		paisesOcupados = new ArrayList<Pais>();
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
		if(paisesOcupados.contains(unPais)){
			unPais.incrementarEjercito(i);
		}
	}

	public void atacar(Pais paisAtacante, Pais paisAtacado){
		if(paisesOcupados.contains(paisAtacante) && !(paisesOcupados.contains(paisAtacado)))
			paisAtacante.atacar(paisAtacado);
		// Else excepcion?
	}
/*
	public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidadDeEjercitos){
		if(paisesOcupados.contains(paisOrigen) && paisesOcupados.contains(paisDestino))
			paisOrigen.moverEjercito(paisDestino, cantidadDeEjercitos);
		// Else excepcion?
	}
	*/

}
