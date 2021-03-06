package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
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
            int valor = random.nextInt(caras)+1;
            resultado.add(valor);
        }

        Collections.sort(resultado,Collections.reverseOrder());
        
        return resultado;
    }
}
