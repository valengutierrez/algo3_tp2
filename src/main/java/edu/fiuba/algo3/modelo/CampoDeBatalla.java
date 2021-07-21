package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CampoDeBatalla {
	
	private Dados unosDados;
	private ArrayList<Integer> resultadoAtacante;
	private ArrayList<Integer> resultadoDefensor;
	private int bajasDefensoras=0;
	private int bajasAtacantes=0;
	private int caras=6;

	public CampoDeBatalla(){
		unosDados = new Dados(caras);
		resultadoAtacante = new ArrayList<Integer>();
		resultadoDefensor = new ArrayList<Integer>();
	}

	public void iniciarBatalla(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
		
		resultadoDefensor = ejercitoDefensor.tirarDadosDefensores(unosDados);
		resultadoAtacante = ejercitoAtacante.tirarDadosAtacantes(unosDados);
	
		//Comparacion
		comparar();
		ejercitoDefensor.reducir(bajasDefensoras);
		ejercitoAtacante.reducir(bajasAtacantes);
	}
	
	
	public void comparar(){
		int i;
		for(i = 0; i < Math.min(resultadoAtacante.size(),resultadoDefensor.size()); i++){
			if(resultadoAtacante.get(i)>resultadoDefensor.get(i)){
				bajasDefensoras++;
			}
			else bajasAtacantes++;
		}
	}

	
	public int getBajasAtacantes() {
		return bajasAtacantes;
	}
	
	public int getBajasDefensoras() {
		return bajasDefensoras;
	}
	
	public void setResultadoAtacante(ArrayList<Integer> unTiroDeDados) {
		resultadoAtacante = unTiroDeDados;
	}
	
	public void setResultadoDefensor(ArrayList<Integer> unTiroDeDados) {
		resultadoDefensor = unTiroDeDados;
	}
}
