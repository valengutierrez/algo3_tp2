package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Objetivo {
	
	private int America_del_norte;
	private int America_del_Sur;
	private int Africa;
	private int Asia;
	private int Europa;
	private int Oceania;

	public Objetivo (ArrayList<Integer> unaLista){
		America_del_norte = unaLista.get(0);
		America_del_Sur = unaLista.get(1);
		Africa = unaLista.get(2);
		Asia = unaLista.get(3);
		Europa = unaLista.get(4);
		Oceania = unaLista.get(5);
	}

	public void imprimirObjetivo() {
		System.out.println(America_del_norte 
							+ " " + America_del_Sur
							+ " " + Africa
							+ " " + Asia
							+ " " + Europa
							+ " " + Oceania);
	}

	public ArrayList<Integer> getCantidades() {
		ArrayList<Integer> retval = new ArrayList<Integer>();

		retval.add(America_del_norte);
		retval.add(America_del_Sur);
		retval.add(Africa);
		retval.add(Asia);
		retval.add(Europa);
		retval.add(Oceania);
		return retval;
	}
}
