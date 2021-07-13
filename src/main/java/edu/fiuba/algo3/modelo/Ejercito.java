package edu.fiuba.algo3.modelo;

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
}
