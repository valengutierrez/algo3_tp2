package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private Ejercito ejercitoNacional;
    private Jugador duenio;
    private ArrayList<Pais> paisesLimitrofes;

    public Pais(){
        duenio = new Jugador();
        ejercitoNacional = new Ejercito();
        paisesLimitrofes = new ArrayList<Pais>();
    }
    public Pais(Jugador unJugador){
        duenio = unJugador;
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
        return duenio;
    }

    public Ejercito getEjercito() { return ejercitoNacional; }

    public void atacar(Pais unPais){
        //TODO: Si el pais no es limitrofe tirar una excepcion
        
        if(paisesLimitrofes.contains(unPais)){
            ejercitoNacional.atacar(unPais);
            unPais.serOcupadoPor(duenio);
            // TODO: Preguntar al usuario cuantos ejercitos quiere pasar
            ejercitoNacional.ocupar(unPais,1); 
        }
    }

    public void serAtacadoPor(Ejercito ejercito) {
        ejercitoNacional.defenderseDe(ejercito);
        if(ejercitoNacional.tamanio() == 0) {
            duenio.desocupar(this);
            desocupar();
        }
    }

    public void serOcupadoPor(Jugador unJugador){
        //TODO: Si ya esta ocupado tirar una excepcion
        if (duenio == null)
            duenio = unJugador;
    }

    private void desocupar(){
        duenio = null;
    }
    
    
    public boolean esOcupable(){
        return duenio == null;
    }
    
    public void setPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
    }
    
    public ArrayList<Pais> getPaisesLimitrofes(){
        return paisesLimitrofes;
    }
	public Jugador getDuenio() {
        return duenio;
	}
    
    
}
