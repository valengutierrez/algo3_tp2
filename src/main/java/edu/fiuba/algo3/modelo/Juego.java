package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorEnTurno;
    private boolean jugadorConquisto;
    private ArrayList<TarjetaPais> mazoTarjetasPais;

    public Juego(){
        jugadores = new ArrayList<Jugador>();
    }

    public void agregarMazo(ArrayList<TarjetaPais> mazo){
        mazoTarjetasPais = mazo;
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
        if(jugadorEnTurno == null)
            jugadorEnTurno = jugador;
    }

    public void jugadorEnTurnoAtaca(Pais paisAtacante, Pais paisDefensor){
        int paisesIniciales = jugadorEnTurno.getPaisesOcupados().size();
        jugadorEnTurno.atacar(paisAtacante, paisDefensor);
        int paisesFinales = jugadorEnTurno.getPaisesOcupados().size();
        if (paisesFinales > paisesIniciales){
            jugadorConquisto = true;
        }
    }

    public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidad){
        jugadorEnTurno.reagrupar(paisOrigen, paisDestino, cantidad);
    }

    public void pasarTurno(){
        if (jugadorConquisto) {
            TarjetaPais tarjetaParaElJugador = mazoTarjetasPais.remove(0);
            jugadorEnTurno.recibirTarjetaPais(tarjetaParaElJugador);
        }
        int indiceDeProximoJugador = jugadores.indexOf(jugadorEnTurno) + 1;
        if(indiceDeProximoJugador == jugadores.size()) {
            indiceDeProximoJugador = 0;
            // faseDeJuego = rondaDeAtaque;
            //return;
        }
        jugadorEnTurno = jugadores.get(indiceDeProximoJugador);
        jugadorConquisto = false;
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
