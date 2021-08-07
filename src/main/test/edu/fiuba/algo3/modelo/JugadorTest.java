package edu.fiuba.algo3.modelo;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class JugadorTest {
	@Test
	public void test01UnJugadorOcupaUnPais(){
		Jugador unJugador = new Jugador();
		Pais unPais = new Pais();

		unJugador.ocupar(unPais);

		assertTrue(unJugador.getPaisesOcupados().contains(unPais));
	}

	@Test
	public void test02UnJugadorDesocupaUnPais(){
		Jugador unJugador = new Jugador();
		Pais unPais = new Pais();

		unJugador.ocupar(unPais);

		assertTrue(unJugador.getPaisesOcupados().contains(unPais));

		unJugador.desocupar(unPais);
		assertFalse(unJugador.getPaisesOcupados().contains(unPais));
	}

	@Test
	public void test03UnJugadorAgregaEjercitosAUnPais(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		unJugador.colocarEjercitos(argentina,5);
		assertEquals(unJugador, argentina.obtenerDuenio());
	}

	@Test
	public void test04UnJugadorAtacaDeUnPaisAOtro(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais brasil = new Pais(otroJugador);
		argentina.setPaisLimitrofe(brasil);

		argentina.incrementarEjercito(1);
		brasil.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + brasil.obtenerEjercito();

		unJugador.atacar(argentina,brasil);
		int ejercitosFinales = argentina.obtenerEjercito() + brasil.obtenerEjercito();
		assertTrue(ejercitosIniciales > ejercitosFinales);
	}

	@Test
	public void test05UnJugadorAtacaDeUnPaisAOtroNoLimitrofeYNoSeEfectuaLaBatalla(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais espania = new Pais(otroJugador);

		argentina.incrementarEjercito(1);
		espania.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + espania.obtenerEjercito();

		unJugador.atacar(argentina,espania);
		int ejercitosFinales = argentina.obtenerEjercito() + espania.obtenerEjercito();
		assertTrue(ejercitosIniciales == ejercitosFinales);
	}

	@Test
	public void test06UnJugadorAtacaDeUnPaisAOtroPropioYNoSeEfectuaBatalla(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais(unJugador);
		Pais brasil = new Pais(unJugador);
		argentina.setPaisLimitrofe(brasil);

		argentina.incrementarEjercito(1);
		brasil.incrementarEjercito(1);
		int ejercitosIniciales = argentina.obtenerEjercito() + brasil.obtenerEjercito();

		unJugador.atacar(argentina,brasil);
		int ejercitosFinales = argentina.obtenerEjercito() + brasil.obtenerEjercito();
		assertTrue(ejercitosIniciales == ejercitosFinales);
	}

	@Test
	public void test07UnJugadorRespondeSiGano() {
		Jugador unJugador = new Jugador();
		Objetivo unObjetivo = mock(ObjetivoOcupar.class);
		Objetivo otroObjetivo = new ObjetivoComun();
		unJugador.asignarObjetivoParticular(unObjetivo);
		unJugador.asignarObjetivoComun(otroObjetivo);
		when(unObjetivo.cumplido(unJugador.getPaisesOcupados(), unJugador)).thenReturn(true);
		assertTrue(unJugador.cumplido());
	}

	@Test
	public void test08UnJugadorTieneUnObjetivoComun(){
		
	}

	@Test
	public void test09UnJugadorTieneUnObjetivoParticular(){

	}

	@Test
	public void test10SeAsignaUnNombreAUnJugador(){
		Jugador unJugador = new Jugador();
		unJugador.setNombre("Azul");

		assertEquals("Azul", unJugador.getNombre());
	}

	@Test
	public void test11SeAsignaUnColorAUnJugador(){
		Jugador unJugador = new Jugador();
		unJugador.setColor(Color.BLUE);

		assertEquals(Color.BLUE, unJugador.getColor());
	}

	@Test
	public void test12JugadorActivaTarjeta(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais("argentina");
		argentina.serOcupadoPor(unJugador);
		TarjetaPais tarjetaPais = new TarjetaPais(argentina, "canion");
		assertEquals(1, argentina.getEjercito().tamanio());
		unJugador.recibirTarjetaPais(tarjetaPais);
		unJugador.activarTarjeta("argentina");
		assertEquals(3, argentina.getEjercito().tamanio());
	}

	@Test
	public void test14JugadorCanjeaTarjeta(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais("argentina");
		TarjetaPais tarjetaPaisUno = new TarjetaPais(argentina, "canion");
		Pais brasil = new Pais("brasil");
		TarjetaPais tarjetaPaisDos = new TarjetaPais(brasil, "canion");
		Pais canada = new Pais("canada");
		TarjetaPais tarjetaPaisTres = new TarjetaPais(canada, "canion");
		unJugador.recibirTarjetaPais(tarjetaPaisUno);
		unJugador.recibirTarjetaPais(tarjetaPaisDos);
		unJugador.recibirTarjetaPais(tarjetaPaisTres);
		assertEquals(5, unJugador.fichasDisponibles());
		unJugador.canjear("argentina", "brasil", "canada");
		assertEquals(9, unJugador.fichasDisponibles());
	}

	@Test
	public void test15JugadorTrataDeActivarTarjetaQueNoTieneYNoPuede(){
		Jugador unJugador = new Jugador();
		Pais argentina = new Pais("argentina");
		argentina.serOcupadoPor(unJugador);
		TarjetaPais tarjetaPais = new TarjetaPais(argentina, "canion");
		assertEquals(1, argentina.getEjercito().tamanio());
		unJugador.activarTarjeta("argentina");
		assertEquals(1, argentina.getEjercito().tamanio());
	}

	@Test
	public void test16JugadorDevuelveDescripcionDeObjetivo(){
		Jugador unJugador = new Jugador();
		Jugador otroJugador = new Jugador();
		ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
		unJugador.setNombre("Ejercito azul");
		otroJugador.setNombre("Ejercito rojo");
		unJugador.asignarObjetivoParticular(unObjetivo);
		String mensaje = "Destruir a jugador: Ejercito azul\n";
		mensaje += "De no ser posible destruir a : Ejercito rojo";

		assertTrue(mensaje.equals(unJugador.textoObjetivo()));
	}
}
