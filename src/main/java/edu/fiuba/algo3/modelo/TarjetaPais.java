package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TarjetaPais {
    Pais pais;
    String simbolo;
    //EstadoTarjeta estado;
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
}