package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CampoDeBatalla {
	
	private Dados unosDados;
	private ArrayList<Integer> resultadoAtacante;
	private ArrayList<Integer> resultadoDefensor;
	private int bajasDefensoras=0;
	private int bajasAtacantes=0;
	ArrayList<Integer> bajas;

	public CampoDeBatalla(){
		Dados unosDados = new Dados(6);
		ArrayList<Integer> resultadoAtacante = new ArrayList<Integer>();
		ArrayList<Integer> resultadoDefensor = new ArrayList<Integer>();
	}

	public void iniciarBatalla(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
		
		resultadoAtacante = ejercitoAtacante.tirarDados(unosDados);
		resultadoDefensor = ejercitoDefensor.tirarDados(unosDados);
	
		//Comparacion
		bajas = comparar();
		ejercitoDefensor.reducir(bajas.get(0));
		ejercitoAtacante.reducir(bajas.get(1));

	}
	
	
	public ArrayList<Integer> comparar(){
		
		ArrayList<Integer> bajas = new ArrayList<Integer>();
		int i;
		for(i = 0; i < Math.min(resultadoAtacante.size(),resultadoDefensor.size()); i++){
			if(resultadoAtacante.get(i)>resultadoDefensor.get(i)){
				bajasDefensoras++;
			}
			else bajasAtacantes++;
		}
		bajas.add(bajasDefensoras);
		bajas.add(bajasAtacantes);
		return bajas;
	}

	/*******Only Testing Purposes*******/
	
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
