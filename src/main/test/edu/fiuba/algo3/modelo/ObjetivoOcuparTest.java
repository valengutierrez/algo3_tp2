package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ObjetivoOcuparTest {
	
	@Test
	public void test01SeCreaUnObjetivoOcupar() {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		cantidades.add(5);
		cantidades.add(0);
		cantidades.add(6);
		cantidades.add(0);
		cantidades.add(4);
		cantidades.add(0);
		ArrayList<Continente> continentes = new ArrayList<Continente>();
		for(int i =0; i<6;i++){
			continentes.add(new Continente("nombre"));
		}
		ObjetivoOcupar unObjetivo = new ObjetivoOcupar(cantidades, continentes);
	
		// assertTrue(mensaje.equals(unObjetivo.mostrarse()));
		String mensaje = "Ocupar: \n";
		mensaje+= "5 paises de america del norte\n";
		mensaje+= "0 paises de america del sur\n";
		mensaje+= "6 paises de africa\n";
		mensaje+= "0 paises de asia\n";
		mensaje+= "4 paises de europa\n";
		mensaje+= "0 paises de oceania\n";
		
		assertTrue(mensaje.equals(unObjetivo.mostrarse()));
	}

	@Test
	public void test02SeCumpleUnObjetivoOcupar() {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		cantidades.add(2);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		ArrayList<Continente> continentes = new ArrayList<Continente>();
		Continente c1 = new Continente("nombre");
		Continente c2 = new Continente("nombre");
		Continente c3 = new Continente("nombre");
		Continente c4 = new Continente("nombre");
		Continente c5 = new Continente("nombre");
		Continente c6 = new Continente("nombre");
		continentes.add(c1);
		continentes.add(c2);
		continentes.add(c3);
		continentes.add(c4);
		continentes.add(c5);
		continentes.add(c6);

		ObjetivoOcupar unObjetivo = new ObjetivoOcupar(cantidades, continentes);

		Jugador jugador = new Jugador();
		Pais unPais = new Pais(jugador);
		Pais otroPais = new Pais(jugador);
		c1.poblarContinente(unPais);
		c1.poblarContinente(otroPais);

		assertTrue(unObjetivo.cumplido(jugador.getPaisesOcupados(),jugador));
	}

	@Test
	public void test03NoSeCumpleUnObjetivoOcupar() {
		ArrayList<Integer> cantidades = new ArrayList<Integer>();
		cantidades.add(2);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		cantidades.add(0);
		ArrayList<Continente> continentes = new ArrayList<Continente>();
		Continente c1 = new Continente("nombre");
		Continente c2 = new Continente("nombre");
		Continente c3 = new Continente("nombre");
		Continente c4 = new Continente("nombre");
		Continente c5 = new Continente("nombre");
		Continente c6 = new Continente("nombre");
		continentes.add(c1);
		continentes.add(c2);
		continentes.add(c3);
		continentes.add(c4);
		continentes.add(c5);
		continentes.add(c6);
		ObjetivoOcupar unObjetivo = new ObjetivoOcupar(cantidades, continentes);

		Jugador jugador = new Jugador();
		Pais unPais = new Pais(jugador);
		Pais otroPais = new Pais();
		c1.poblarContinente(unPais);
		c1.poblarContinente(otroPais);

		assertFalse(unObjetivo.cumplido(jugador.getPaisesOcupados(),jugador));
	}
}
