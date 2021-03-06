package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TarjetaPais {
    Pais pais;
    String simbolo;
    boolean activada;

    public TarjetaPais(Pais unPais, String unSimbolo){
        activada = false;
        pais = unPais;
        simbolo = unSimbolo;
    }

    public void activar(ArrayList<Pais> paisesDelJugador) {
        if (!activada && paisesDelJugador.contains(pais)){
            pais.incrementarEjercito(2);
            activada = true;
        }
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return pais.getNombre();
    }
}