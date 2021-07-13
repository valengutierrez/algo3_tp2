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

    public Pais atacar(Pais unPais){
        //TODO Validar si el pais es limitrofe
        return unEjercito.atacar(unPais);
    }

    public void serAtacadoPor(Ejercito unEjercitoAtacante){
    }
}
