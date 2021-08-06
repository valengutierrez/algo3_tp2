package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoOcupar implements Objetivo {

	private ArrayList<Continente> continentes;
	private ArrayList<Integer> cantidadAOcupar;

	public ObjetivoOcupar(ArrayList<Integer> cantidades, ArrayList<Continente> lista) {
		int i;
		for(i=0;i<lista.size();i++){
			continentes.add(lista.get(i));
			cantidadAOcupar.add(cantidades.get(i));
		}
	}

	@Override
	public boolean cumplido(ArrayList<Pais> paisesOcupados) {
		for(int j=0;j<continentes.size();j++){
			int cantidadOcupada=0;
			Continente c = continentes.get(j);
			for(int i=0;i<c.getPaises().size();i++){
				if(paisesOcupados.contains(c.getPaises().get(i))){
					cantidadOcupada++;
				}
			}
			if(cantidadOcupada<cantidadAOcupar.get(j)){
				return false;
			}
		}
		return true;
	}
}
