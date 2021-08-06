package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoDestruir implements Objetivo{

	private Jugador jugadorADestruir;
	private Jugador jugadorAlternativa;

	public ObjetivoDestruir(Jugador unJugador, Jugador otroJugador) {
		jugadorADestruir = unJugador;
		jugadorAlternativa = otroJugador;
	}

	@Override
	public boolean cumplido(ArrayList<Pais> paisesOcupados, Jugador jugador) {
		if (jugadorADestruir == jugador){
			return jugadorAlternativa.getPaisesOcupados().isEmpty();
		}
		return jugadorADestruir.getPaisesOcupados().isEmpty();
	}

	@Override
	public String mostrarse() {
		String mensaje;
		mensaje = "Destruir a jugador: " + jugadorADestruir.getNombre() + "\n";
		mensaje += "De no ser posible destruir a : " + jugadorAlternativa.getNombre();
		return mensaje;
	}
}
