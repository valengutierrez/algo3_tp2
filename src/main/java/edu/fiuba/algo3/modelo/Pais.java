package edu.fiuba.algo3.modelo;

public class Pais {
    private Ejercito ejercitoNacional;

    public Pais(){
        ejercitoNacional = new Ejercito();
    }

    public void incrementarEjercito(int tamanio){
        ejercitoNacional.incrementar(tamanio);
    }

    public int obtenerEjercito(){
        return ejercitoNacional.tamanio();
    }

    public Pais atacar(Pais unPais){
        //TODO Validar si el pais es limitrofe
        return ejercitoNacional.atacar(unPais);
        
    }

    public void serAtacadoPor(Ejercito ejercito) {
        
    }
}
