package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ObjetivoDestruirTest {

	@Test
	public void test01SeCreaUnObjetivoDestruir() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		String mensaje = "Destruir a jugador: Ejercito azul\n";
		mensaje += "De no ser posible destruir a : Ejercito rojo";

		assertTrue(mensaje.equals(unObjetivo.mostrarse()));
	}

	@Test
	public void test02SeCumpleObjetivoDestruirConJugadorAlternativo() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		ArrayList<Pais> paisesOcupados = new ArrayList<>();

		// Al no tener ningun pais asignado se lo considera destruido
		assertTrue(unObjetivo.cumplido(paisesOcupados, unJugador));
	}

	@Test
	public void test03SeCumpleObjetivoDestruirConJugadorPrincipal(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		ArrayList<Pais> paisesOcupados = new ArrayList<>();

		// Al no tener ningun pais asignado se lo considera destruido
		assertTrue(unObjetivo.cumplido(paisesOcupados, otroJugador));
	}

	@Test
	public void test04NoSeCumpleObjetivoDestruirConJugadorAlternativo() {
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais otroPais = new Pais(otroJugador);
		Pais unPais = new Pais(unJugador);
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		ArrayList<Pais> paisesOcupados = new ArrayList<>();

		// Al no tener ningun pais asignado se lo considera destruido
		assertFalse(unObjetivo.cumplido(paisesOcupados, unJugador));
	}

	@Test
	public void test05NoSeCumpleObjetivoDestruirConJugadorPrincipal(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais unPais = new Pais(unJugador);
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		ArrayList<Pais> paisesOcupados = new ArrayList<>();

		// Al no tener ningun pais asignado se lo considera destruido
		assertFalse(unObjetivo.cumplido(paisesOcupados, otroJugador));
	}
}
