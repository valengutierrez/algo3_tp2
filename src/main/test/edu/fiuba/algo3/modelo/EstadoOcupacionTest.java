package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EstadoOcupacionTest {
	
	@Test
	public void test01UnEstadoOcupadoDevuelveSuDuenio() {
		Jugador unJugador = new Jugador();
		estadoOcupacion unEstado = new estadoOcupado(unJugador);
		assertEquals(unJugador, unEstado.obtenerDuenio());
	}
	
	@Test
	public void test02UnEstadoDesocupadoDevuelveUnaExcepcionAlObtenerUnEstado() {
		// Jugador unJugador = new Jugador();
		// estadoOcupacion unEstado = new estadoDesocupado();
		// assertEquals(unJugador, unEstado.obtenerDuenio());
		// assertThrows(expectedType, executable)
		//TODO: PREGUNTAR
		// Un estado desocupado levanta una excepcion cuando le piden
		// su duenio
	}
	
	@Test
	public void test03UnEstadoDesocupadoCambiaAOcupado() {
		estadoOcupacion unEstado = new estadoDesocupado();
		Jugador unJugador = new Jugador();

		unEstado = unEstado.cambiarAOcupado(unJugador);

		assertEquals(estadoOcupado.class, unEstado.getClass());
	}
	
	@Test
	public void test04UnEstadoOcupadoCambiaADesocupado() {
		Jugador unJugador = new Jugador();
		estadoOcupacion unEstado = new estadoOcupado(unJugador);
		
		unEstado = unEstado.cambiarADesocupado();
		
		assertEquals(estadoDesocupado.class, unEstado.getClass());
	}
	
	@Test
	public void test05UnEstadoDesocupadoSeLeAsignaJugadorYDevuelveElJugador() {
		estadoOcupacion unEstado = new estadoDesocupado();
		Jugador unJugador = new Jugador();
	
		unEstado = unEstado.cambiarAOcupado(unJugador);
	
		assertEquals(unJugador, unEstado.obtenerDuenio());
	}
}
