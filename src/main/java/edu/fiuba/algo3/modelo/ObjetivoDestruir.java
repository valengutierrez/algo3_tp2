package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoDestruir implements Objetivo{

	private Jugador jugadorADestruir;

	public ObjetivoDestruir(Jugador unJugador) {
		jugadorADestruir = unJugador;
	}

	@Override
	public boolean cumplido(ArrayList<Pais> paisesOcupados) {
		return jugadorADestruir.getPaisesOcupados().isEmpty();
	}
	
}
