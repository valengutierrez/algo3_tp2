package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoComun implements Objetivo {

	private int cantidadObjetivo = 30;

	@Override
	public boolean cumplido(ArrayList<Pais> paisesOcupados) {
		return paisesOcupados.size() >= cantidadObjetivo;
	}

	@Override
	public String mostrarse() {
		return "Ocupar " + cantidadObjetivo + " paises";
	}
	
}
