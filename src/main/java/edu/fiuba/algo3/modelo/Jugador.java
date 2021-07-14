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
	

}
