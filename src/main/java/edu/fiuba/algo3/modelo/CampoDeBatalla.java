package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CampoDeBatalla {
	
	private Dados unosDados;
	private ArrayList<Integer> resultadoAtacante;
	private ArrayList<Integer> resultadoDefensor;
	private int bajasDefensoras=0;
	private int bajasAtacantes=0;

	public CampoDeBatalla(){
		unosDados = new Dados(6);
		resultadoAtacante = new ArrayList<Integer>();
		resultadoDefensor = new ArrayList<Integer>();
	}

	public void iniciarBatalla(Ejercito ejercitoAtacante, Ejercito ejercitoDefensor){
		
		resultadoAtacante = ejercitoAtacante.tirarDados(unosDados);
		resultadoDefensor = ejercitoDefensor.tirarDados(unosDados);
	
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

	public void iniciarBatallaYQueGaneElDefensor(Ejercito unEjercitoAtacante, Ejercito unEjercitoDefensor){
		setResultadoAtacante(unosDados.tiroPerdedor()); // [5]
		setResultadoDefensor(unosDados.tiroGanador()); // [6,4,1]
		comparar(); //[bajas atacantes = 1 ; bajas defensoras = 0]
		unEjercitoAtacante.reducir(getBajasAtacantes());
		unEjercitoDefensor.reducir(getBajasDefensoras());
	}

	public void iniciarBatallaYQueGaneElAtacante(Ejercito unEjercitoAtacante, Ejercito unEjercitoDefensor){
		setResultadoAtacante(unosDados.tiroGanador()); // [5]
		setResultadoDefensor(unosDados.tiroPerdedor()); // [6,4,1]
		comparar(); //[bajas atacantes = 1 ; bajas defensoras = 0]
		unEjercitoAtacante.reducir(getBajasAtacantes());
		unEjercitoDefensor.reducir(getBajasDefensoras());
	}
}
