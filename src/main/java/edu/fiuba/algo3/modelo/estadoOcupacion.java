package edu.fiuba.algo3.modelo;

public abstract class estadoOcupacion {

	protected Jugador duenio;
	abstract estadoOcupacion cambiarAOcupado(Jugador unJugador, Pais unPais);
	abstract public Jugador obtenerDuenio();
	abstract public estadoOcupacion cambiarADesocupado();	
}
