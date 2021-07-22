package edu.fiuba.algo3.modelo;

public class estadoDesocupado extends estadoOcupacion{

	@Override
	estadoOcupacion cambiarAOcupado(Jugador unJugador) {
		//unJugador.ocupar(unPais);
		return new estadoOcupado(unJugador);
	}

	@Override
	public Jugador obtenerDuenio() {
		return null;
	}

	@Override
	public estadoOcupacion cambiarADesocupado() {
		return this;
	}

	
}
