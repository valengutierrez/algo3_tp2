package edu.fiuba.algo3.modelo;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ObjetivoTest {

	@Test
	public void test01SeCreaUnObjetivoAPartirDeUnaLista() {
		ArrayList<Integer> datos = new ArrayList<Integer>();
		datos.add(5);
		datos.add(4);
		datos.add(3);
		datos.add(2);
		datos.add(1);
		datos.add(0);
		Objetivo unObjetivo = new Objetivo(datos);
		// TODO: Poner un assert
		unObjetivo.imprimirObjetivo();
	}
	
	@Test
	public void test02SeCreanObjetivosAPartirDeUnArchivo() {
		Parser unParser = new Parser("src/main/resources/Objetivos.csv");
		ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
		ArrayList<ArrayList<Integer>> datos = new ArrayList<ArrayList<Integer>>();
		datos = unParser.parse();
		for(ArrayList<Integer> linea : datos){
			objetivos.add(new Objetivo(linea));
		}
		for(Objetivo i : objetivos){
			i.imprimirObjetivo();
		}
		// TODO: Poner un assert
	}
	
}
