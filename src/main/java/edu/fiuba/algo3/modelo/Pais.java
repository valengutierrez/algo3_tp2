package edu.fiuba.algo3.modelo;

public class Pais {
    private Ejercito ejercitoNacional;
    private Jugador duenio;
    public Pais(){
        ejercitoNacional = new Ejercito();
    }

    public void incrementarEjercito(int tamanio){
        ejercitoNacional.incrementar(tamanio);
    }

    public int obtenerEjercito(){
        return ejercitoNacional.tamanio();
    }

    public Ejercito getEjercito() { return ejercitoNacional; }

    public Pais atacar(Pais unPais){
        //TODO Validar si el pais es limitrofe
        return ejercitoNacional.atacar(unPais);
    }

    public void serAtacadoPor(Ejercito ejercito) {
        ejercitoNacional.defenderseDe(ejercito);
        if(ejercitoNacional.tamanio() == 0) {
            duenio.desocupar(this);
            desocupar();
        }
    }

    public void serOcupadoPor(Jugador unJugador){
        duenio = unJugador;
    }

    public void desocupar(){
        duenio = null;
    }

    public boolean esOcupable(){
        if(duenio == null)
            return true;
        else
            return false;
    }
}
