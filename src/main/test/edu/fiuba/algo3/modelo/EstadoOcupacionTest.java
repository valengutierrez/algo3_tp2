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
	public void test02UnEstadoDesocupadoCambiaAOcupado() {
		estadoOcupacion unEstado = new estadoDesocupado();
		Jugador unJugador = new Jugador();

		unEstado = unEstado.cambiarAOcupado(unJugador, new Pais());

		assertEquals(estadoOcupado.class, unEstado.getClass());
	}
	
	@Test
	public void test03UnEstadoOcupadoCambiaADesocupado() {
		Jugador unJugador = new Jugador();
		estadoOcupacion unEstado = new estadoOcupado(unJugador);
		
		unEstado = unEstado.cambiarADesocupado();
		
		assertEquals(estadoDesocupado.class, unEstado.getClass());
	}
	
	@Test
	public void test04UnEstadoDesocupadoSeLeAsignaJugadorYDevuelveElJugador() {
		estadoOcupacion unEstado = new estadoDesocupado();
		Jugador unJugador = new Jugador();
	
		unEstado = unEstado.cambiarAOcupado(unJugador, new Pais());
	
		assertEquals(unJugador, unEstado.obtenerDuenio());
	}

	@Test
	public void test05EstadoDesocupadoNoDevuelveDuenio(){
		estadoOcupacion unEstado = new estadoDesocupado();
		assertEquals(null, unEstado.obtenerDuenio());
	}

	@Test
	public void test06EstadoDesocupadoNoDevuelveDuenio(){
		estadoOcupacion unEstado = new estadoDesocupado();
		assertEquals(unEstado, unEstado.cambiarADesocupado());
	}
}
