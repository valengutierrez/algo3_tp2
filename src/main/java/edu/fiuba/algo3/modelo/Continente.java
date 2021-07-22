package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    private ArrayList<Pais> paises;
    private int ejercitosAAgregar;

    public Continente(ArrayList<Pais> paisesDelContinente, int ejercitos){
        paises = paisesDelContinente;
        ejercitosAAgregar = ejercitos;
    }

    public int ejercitoPorContinente(ArrayList<Pais> paisesDelJugador) {
        for (Pais p : paises) {
            if (!paisesDelJugador.contains(p)) {
                return 0;
            }
        }
        return ejercitosAAgregar;
    }
}
