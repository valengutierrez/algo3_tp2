package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private Ejercito ejercitoNacional;
    private ArrayList<Pais> paisesLimitrofes;
    private estadoOcupacion estado;
    private String nombre;

    public Pais(){
        estado = new estadoDesocupado();
        ejercitoNacional = new Ejercito();
        paisesLimitrofes = new ArrayList<Pais>();
    }

    public Pais(String unNombre){
        estado = new estadoDesocupado();
        ejercitoNacional = new Ejercito();
        paisesLimitrofes = new ArrayList<Pais>();
        nombre = unNombre;
    }

    public Pais(Jugador unJugador){
        estado = new estadoDesocupado();
        estado = estado.cambiarAOcupado(unJugador, this);
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
        if(paisesLimitrofes.contains(unPais)){
            ejercitoNacional.atacar(unPais);
            unPais.serOcupadoPor(estado.obtenerDuenio());
            if (this.obtenerDuenio() == unPais.obtenerDuenio())
                ejercitoNacional.ocupar(unPais, 1);
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
            estado = estado.cambiarAOcupado(unJugador, this);
    }

    public void moverEjercito(Pais paisDestino, int cantidadEjercito){
        ejercitoNacional.moverEjercito(paisDestino, cantidadEjercito);
    }

    public void setPaisLimitrofe(Pais unPais){
        paisesLimitrofes.add(unPais);
    }
    
    public ArrayList<Pais> getPaisesLimitrofes(){
        return paisesLimitrofes;
    }

	public String getNombre() {
		return nombre;
	}
    
}
