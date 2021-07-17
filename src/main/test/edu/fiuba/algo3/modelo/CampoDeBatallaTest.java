package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CampoDeBatallaTest {

	@Test
	public void test01ElCampoDeBatallaComparaResultadosYCalculaBajasDefensoras(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Dados dadosMock = mock(Dados.class);
		
		when(dadosMock.arrojar(3)).thenReturn(new ArrayList<Integer>() {{add(6);add(4);add(1);}});
		when(dadosMock.arrojar(1)).thenReturn(new ArrayList<Integer>() {{add(5);}});
		
		unCampo.setResultadoAtacante(dadosMock.arrojar(3)); // [6,4,1]
		unCampo.setResultadoDefensor(dadosMock.arrojar(1)); // [5]
		unCampo.comparar(); //[bajas atacantes = 0 ; bajas defensoras = 1]
		
		assertEquals(1, unCampo.getBajasDefensoras());
		assertEquals(0, unCampo.getBajasAtacantes());
	}
	
	@Test
	public void test02ElCampoDeBatallaComparaResultadosYCalculaBajasAtacantes(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Dados dadosMock = mock(Dados.class);
		when(dadosMock.arrojar(3)).thenReturn(new ArrayList<Integer>() {{add(6);add(4);add(1);}});
		when(dadosMock.arrojar(1)).thenReturn(new ArrayList<Integer>() {{add(5);}});

		unCampo.setResultadoAtacante(dadosMock.arrojar(1)); // [5]
		unCampo.setResultadoDefensor(dadosMock.arrojar(3)); // [6,4,1]
		unCampo.comparar(); //[bajas atacantes = 1 ; bajas defensoras = 0]

		assertEquals(0, unCampo.getBajasDefensoras());
		assertEquals(1, unCampo.getBajasAtacantes());

	}

	@Test
	public void test03SeObtieneUnaBatallaDondeSiempreGanaDefensor(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Ejercito ejercitoArgentino = new Ejercito();
		Ejercito ejercitoBrasilero = new Ejercito();

		// Brasil ataca a Argentina

		//TODO: Mockear ejercito atacante para que siempre pierda
		// Mockear ejercito defensor para que gane
		unCampo.iniciarBatallaYQueGaneElDefensor(ejercitoBrasilero, ejercitoArgentino);
		
		assertNotEquals(0, ejercitoArgentino.tamanio());
	}
	
	@Test
	public void test04SeObtieneUnaBatallaDondeSiempreGanaAtacante(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Ejercito ejercitoArgentino = new Ejercito();
		Ejercito ejercitoBrasilero = new Ejercito();
		
		// Brasil ataca a Argentina

		//TODO: Mockear ejercito defensor para que siempre pierda
		// Mockear ejercito atacante para que gane
		unCampo.iniciarBatallaYQueGaneElAtacante(ejercitoBrasilero, ejercitoArgentino);

		assertEquals(0, ejercitoArgentino.tamanio());
	}

	// TODO: Probar todo tipo de batallas
}
