package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuegoTest {
    @Test
    public void unJugadorPasaYLeTocaAlSiguiente(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        Jugador jugadorTres = new Jugador();
        Juego juego = new Juego();

        juego.añadirJugador(jugadorUno);
        juego.añadirJugador(jugadorDos);
        juego.añadirJugador(jugadorTres);

        assertEquals(jugadorUno, juego.turnoDe());
        juego.pasarTurno();
        assertEquals (jugadorDos, juego.turnoDe());
        juego.pasarTurno();
        assertEquals (jugadorTres, juego.turnoDe());
        juego.pasarTurno();
        assertEquals (jugadorUno, juego.turnoDe());
    }

    @Test
    public void test02UnJugadorAtacaADosPaisesYLosConquista() {
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        Ejercito ejercitoAtacante = mock(Ejercito.class);
        when(ejercitoAtacante.tirarDadosAtacantes(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(7);}});
        ejercitoAtacante.incrementar(3);

        Pais argentina = new Pais(jugadorAzul);
        //argentina.agregarEjercito(ejercitoAtacante);

        Pais brasil = new Pais(jugadorVerde);
        Pais chile = new Pais(jugadorVerde);

        Ejercito ejercitoDefensor = mock(Ejercito.class);
        when(ejercitoDefensor.tirarDadosAtacantes(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        //brasil.agregarEjercito(ejercitoDefensor);

        argentina.setPaisLimitrofe(brasil);
        argentina.setPaisLimitrofe(chile);
        jugadorAzul.atacar(argentina, brasil);
        jugadorAzul.atacar(argentina, chile);

        assertEquals(jugadorAzul, brasil.obtenerDuenio());
        //assertEquals(jugadorAzul, chile.obtenerDuenio());
    }

}
