package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public interface Objetivo {

	public boolean cumplido(ArrayList<Pais> paisesOcupados);
	public String mostrarse();
}
