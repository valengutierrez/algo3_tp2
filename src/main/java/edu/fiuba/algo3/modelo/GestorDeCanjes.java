package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class GestorDeCanjes {

	private ArrayList<Integer> cantidades;
	private int recompensa;
	private int n_canjes;

	public GestorDeCanjes(){
		n_canjes = 0;
		cantidades = new ArrayList<Integer>();
		cantidades.add(4);
		cantidades.add(7);
		cantidades.add(10);
	}

	public int canjear(TarjetaPais t1, TarjetaPais t2, TarjetaPais t3) {
		calcularRecompensa();
		if(t1.simbolo.equals(t2.simbolo)&&t2.simbolo.equals(t3.simbolo)){
			n_canjes++;
			return recompensa;
		}
		if(!(t1.simbolo.equals(t2.simbolo))&&!(t2.simbolo.equals(t3.simbolo))&&!(t1.simbolo.equals(t3.simbolo))){
			n_canjes++;
			return recompensa;
		}
		return 0;
		
	}

	private void calcularRecompensa() {
		if(n_canjes>=cantidades.size()){
			recompensa = (n_canjes)*5;
		}
		else{
			recompensa = cantidades.get(n_canjes);
		}
	}

}
