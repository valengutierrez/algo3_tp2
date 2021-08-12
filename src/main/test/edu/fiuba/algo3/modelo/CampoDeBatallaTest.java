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
		Ejercito ejercitoBrasilero = mock(Ejercito.class);
		Ejercito ejercitoArgentino = new Ejercito();


		when(ejercitoBrasilero.tirarDadosAtacantes(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        ejercitoBrasilero.incrementar(1);

		unCampo.iniciarBatalla(ejercitoBrasilero, ejercitoArgentino);
		
		assertNotEquals(0, ejercitoArgentino.tamanio());
	}
	
	@Test
	public void test04SeObtieneUnaBatallaDondeSiempreGanaAtacante(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Ejercito ejercitoArgentino = mock(Ejercito.class);
		Ejercito ejercitoBrasilero = new Ejercito();
		
		when(ejercitoArgentino.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
		unCampo.iniciarBatalla(ejercitoBrasilero, ejercitoArgentino);

		assertEquals(0, ejercitoArgentino.tamanio());
	}
}
