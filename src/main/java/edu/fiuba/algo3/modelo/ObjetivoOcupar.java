package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoOcupar implements Objetivo {

	private ArrayList<Continente> continentes;
	private ArrayList<Integer> cantidadAOcupar;

	public ObjetivoOcupar(ArrayList<Integer> cantidades, ArrayList<Continente> lista) {
		continentes = new ArrayList<Continente>();
		cantidadAOcupar = new ArrayList<Integer>();
		int i;
		for(i=0;i<lista.size();i++){
			continentes.add(lista.get(i));
			cantidadAOcupar.add(cantidades.get(i));
		}
	}

	@Override
	public boolean cumplido(ArrayList<Pais> paisesOcupados, Jugador jugador) {
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

	@Override
	public String mostrarse() {
		String mensaje,americaDelNorte,americaDelSur,Africa,Asia,Europa,Oceania;
		americaDelNorte = cantidadAOcupar.get(0) + "paises de america del norte\n";
		americaDelSur = cantidadAOcupar.get(1) + "paises de america del sur\n";
		Africa = cantidadAOcupar.get(2) + "paises de africa\n";
		Asia= cantidadAOcupar.get(3) + "paises de asia\n";
		Europa = cantidadAOcupar.get(4) + "paises de europa\n";
		Oceania = cantidadAOcupar.get(5) + "paises de oceania\n";
		mensaje = americaDelNorte+americaDelSur+Africa+Asia+Europa+Oceania;
		return mensaje;
	}
}
