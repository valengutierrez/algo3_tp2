package edu.fiuba.algo3.modelo;

public class estadoOcupado extends estadoOcupacion{

	public estadoOcupado(Jugador unJugador){
		duenio = unJugador;
	}

	@Override
	estadoOcupacion cambiarAOcupado(Jugador unJugador, Pais unPais) {
		return this;
	}

	@Override
	public Jugador obtenerDuenio() {
		return duenio;
	}

	@Override
	public estadoOcupacion cambiarADesocupado() {
		return new estadoDesocupado();
	}
	
}
