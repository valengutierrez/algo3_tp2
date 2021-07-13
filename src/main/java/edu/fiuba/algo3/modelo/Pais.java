package edu.fiuba.algo3.modelo;

public class Pais {
    private Ejercito unEjercito;

    public Pais(){
        unEjercito = new Ejercito();
    }

    public void incrementarEjercito(int tamanio){
        unEjercito.incrementar(tamanio);
    }

    public int obtenerEjercito(){
        return unEjercito.tamanio();
    }
}
