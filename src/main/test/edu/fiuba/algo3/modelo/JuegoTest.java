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
        Juego TEG = new Juego();
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        TEG.añadirJugador(jugadorAzul);
        TEG.añadirJugador(jugadorVerde);

        Pais argentina = new Pais(jugadorAzul);
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        argentina.incrementarEjercito(9);

        Pais brasil = new Pais(jugadorVerde);
        TarjetaPais tarjetaBrasil = new TarjetaPais(brasil, "canion");
        Pais chile = new Pais(jugadorVerde);
        TarjetaPais tarjetaChile = new TarjetaPais(chile, "barco");

        Ejercito ejercitoDefensorBrasil = mock(Ejercito.class);
        when(ejercitoDefensorBrasil.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        brasil.agregarEjercito(ejercitoDefensorBrasil);

        Ejercito ejercitoDefensorChile = mock(Ejercito.class);
        when(ejercitoDefensorChile.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        brasil.agregarEjercito(ejercitoDefensorChile);

        argentina.setPaisLimitrofe(brasil);
        argentina.setPaisLimitrofe(chile);

        ArrayList<TarjetaPais> mazo = new ArrayList<TarjetaPais>();
        mazo.add(tarjetaArgentina);
        mazo.add(tarjetaBrasil);
        mazo.add(tarjetaChile);

        TEG.agregarMazo(mazo);

        TEG.jugadorEnTurnoAtaca(argentina, brasil);
        TEG.jugadorEnTurnoAtaca(argentina, chile);

        TEG.reagrupar(argentina, brasil, 2);

        TEG.pasarTurno();

        assertEquals(jugadorAzul, brasil.obtenerDuenio());
        assertEquals(jugadorAzul, chile.obtenerDuenio());

        assertEquals(1, jugadorAzul.obtenerTarjetas().size());
    }

    @Test
    public void test03RondaDeColocacionDeUnJugadorQueControlaOceania(){
        Jugador jugadorAzul = new Jugador();

        Pais Australia = new Pais(jugadorAzul);
        Pais Java = new Pais(jugadorAzul);
        Pais Sumatra = new Pais(jugadorAzul);
        Pais Borneo = new Pais(jugadorAzul);

        ArrayList<Pais> paisesDeOceania = new ArrayList<Pais>();
        paisesDeOceania.add(Australia);
        paisesDeOceania.add(Java);
        paisesDeOceania.add(Sumatra);
        paisesDeOceania.add(Borneo);

        Continente Oceania = new Continente(paisesDeOceania, 2);

        int ejercitosPorContinente = Oceania.ejercitoPorContinente(jugadorAzul.getPaisesOcupados());

        jugadorAzul.fichasPorPais();
        jugadorAzul.incrementarFichasDisponibles(ejercitosPorContinente);

        jugadorAzul.colocarEjercitos(Australia, 4);
        jugadorAzul.colocarEjercitos(Australia, 5);

        assertEquals(5, Australia.obtenerEjercito());
    }


}
