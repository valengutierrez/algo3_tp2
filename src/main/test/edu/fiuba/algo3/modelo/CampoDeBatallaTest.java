package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CampoDeBatallaTest {

	@Test
	public void test01ElCampoDeBatallaComparaResultadosYCalculaBajasDefensoras(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Dados unosDados = new Dados(6);
		unCampo.setResultadoAtacante(unosDados.tiroGanador()); // [6,4,1]
		unCampo.setResultadoDefensor(unosDados.tiroPerdedor()); // [5]
		unCampo.comparar(); //[bajas atacantes = 0 ; bajas defensoras = 1]

		assertEquals(1, unCampo.getBajasDefensoras());
		assertEquals(0, unCampo.getBajasAtacantes());

	}

	@Test
	public void test02ElCampoDeBatallaComparaResultadosYCalculaBajasAtacantes(){
		CampoDeBatalla unCampo = new CampoDeBatalla();
		Dados unosDados = new Dados(6);
		unCampo.setResultadoAtacante(unosDados.tiroPerdedor()); // [5]
		unCampo.setResultadoDefensor(unosDados.tiroGanador()); // [6,4,1]
		unCampo.comparar(); //[bajas atacantes = 1 ; bajas defensoras = 0]

		assertEquals(0, unCampo.getBajasDefensoras());
		assertEquals(1, unCampo.getBajasAtacantes());

	}

	// TODO: Probar todo tipo de batallas
}
