package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private Ejercito ejercitoNacional;
    private ArrayList<Pais> paisesLimitrofes;
    private estadoOcupacion estado;

    public Pais(){
        estado = new estadoDesocupado();
        ejercitoNacional = new Ejercito();
        paisesLimitrofes = new ArrayList<Pais>();
    }
    public Pais(Jugador unJugador){
        estado = new estadoDesocupado();
        estado = estado.cambiarAOcupado(unJugador);
        unJugador.ocupar(this);
        ejercitoNacional = new Ejercito();
        paisesLimitrofes = new ArrayList<Pais>();
    }

    public void incrementarEjercito(int tamanio){
        ejercitoNacional.incrementar(tamanio);
    }

    public int obtenerEjercito(){
        return ejercitoNacional.tamanio();
    }

    public void agregarEjercito(Ejercito unEjercito){
        ejercitoNacional = unEjercito;
    }

    public Jugador obtenerDuenio(){
        return estado.obtenerDuenio();
    }

    public Ejercito getEjercito() { return ejercitoNacional; }

    public void atacar(Pais unPais){
        //TODO: Si el pais no es limitrofe tirar una excepcion
        
        if(paisesLimitrofes.contains(unPais)){
            ejercitoNacional.atacar(unPais);
            unPais.serOcupadoPor(estado.obtenerDuenio());
            // TODO: Preguntar al usuario cuantos ejercitos quiere pasar
            ejercitoNacional.ocupar(unPais,1); 
        }
    }

    public void serAtacadoPor(Ejercito ejercito) {
        ejercitoNacional.defenderseDe(ejercito);
        if(ejercitoNacional.tamanio() == 0) {
            estado.obtenerDuenio().desocupar(this);
            estado = estado.cambiarADesocupado();
        }
    }

    public void serOcupadoPor(Jugador unJugador){
        //TODO: Delegar el comportamiento de saber si esta ocupado o no a un estadoOcupacion
        // estado.cambiarAOcupado(unJugador);
            estado = estado.cambiarAOcupado(unJugador);
    }

    public void setPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
    }
    
    public ArrayList<Pais> getPaisesLimitrofes(){
        return paisesLimitrofes;
    }
    
}
