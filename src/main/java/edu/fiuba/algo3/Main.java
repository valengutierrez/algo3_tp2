package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;

public class Main {
    public static void main(String[] args) {
        //App.main(args);
        Juego TEG = new Juego();
        Jugador jugadorVerde = new Jugador();
        Jugador jugadorAzul = new Jugador();

        Pais argentina = new Pais(jugadorAzul);
        Pais brasil = new Pais(jugadorVerde);

        argentina.incrementarEjercito(3);

        TEG.añadirJugador(jugadorAzul);
        TEG.añadirJugador(jugadorVerde);

        TEG.jugadorEnTurnoAtaca(argentina, brasil);
        TEG.reagrupar(argentina, brasil, 1);
        TEG.pasarTurno();
    }
}
