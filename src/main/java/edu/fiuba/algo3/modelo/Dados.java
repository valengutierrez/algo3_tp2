package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dados {

    private final int caras;

    public Dados(int cantidadCaras){
        caras = cantidadCaras;
    }

    public ArrayList<Integer> arrojar(int unaCantidad) {

        ArrayList<Integer> resultado = new ArrayList();

        for(int i = 0; i < unaCantidad; i++){
            Random random = new Random();
            int valor = random.nextInt(caras);
            resultado.add(valor);
        }

        // TODO ordenar array resultado.sort();

        return resultado;
    }
}
