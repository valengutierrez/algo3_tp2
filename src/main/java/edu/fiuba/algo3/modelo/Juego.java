package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorEnTurno;

    public Juego(){
        jugadores = new ArrayList<Jugador>();
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
        if(jugadorEnTurno == null)
            jugadorEnTurno = jugador;
    }

    public void pasarTurno(){
        int indiceDeProximoJugador = jugadores.indexOf(jugadorEnTurno) + 1;
        if(indiceDeProximoJugador == jugadores.size()) {
            indiceDeProximoJugador = 0;
            // faseDeJuego = rondaDeAtaque;
            //return;
        }
        jugadorEnTurno = jugadores.get(indiceDeProximoJugador);
    }

    public Jugador turnoDe(){
        return jugadorEnTurno;
    }
}
/*
estadoAtaque.moverEjercitosDe(jugadorDeTruno,pais1,pais2){
    jugadorDeTurno.ataque(pais1,pais2)
}
estadoReagrupar.moverEj(jugadorDeTruno,pais1,pais2){
    jugadorDeTurno.reagrupar(pais1,pais2)
}*/
