package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dados {

    private final int caras;

    public Dados(int cantidadCaras){
        caras = cantidadCaras;
    }

    public ArrayList<Integer> arrojar(int unaCantidad) {

        ArrayList<Integer> resultado = new ArrayList<Integer>();
        
        for(int i = 0; i < unaCantidad; i++){
            Random random = new Random();
            int valor = random.nextInt(caras);
            resultado.add(valor);
        }
        
        // TODO ordenar array resultado.sort();
        
        return resultado;
    }
    
	public ArrayList<Integer> tiroGanador() {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        resultado.add(6);
        resultado.add(4);
        resultado.add(1);
        return resultado;
	}
    public ArrayList<Integer> tiroPerdedor() {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        resultado.add(5);
        return resultado;
    }
}
