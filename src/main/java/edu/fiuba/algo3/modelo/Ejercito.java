package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ejercito {
    private int tamanio;

    public Ejercito (){
        tamanio = 1;
    }

    public void incrementar(int cantidadIncremento){
        tamanio += cantidadIncremento;
    }

    public int tamanio(){
        return tamanio;
    }

    public Pais atacar(Pais unPais){
        unPais.serAtacadoPor(this);

        return null;
    }

    private int ejercitosDefensores() {
        return Math.min(tamanio, 3);
    }

    private int ejercitosAtacantes() {
        return Math.min(tamanio-1, 3);
    }

    public void defenderseDe(Ejercito unEjercito){
        Dados dados = new Dados(6);

        ArrayList<Integer> resultadoDefensor = dados.arrojar(this.ejercitosDefensores());
        ArrayList<Integer> resultadoAtacante = dados.arrojar(unEjercito.ejercitosAtacantes());

    }
}
