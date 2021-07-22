package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarjetaPaisTest {

    @Test
    public void test01ActivarTarjetaDePaisPertenecienteAlJugadorAumentaSuEjercitoEnDos(){
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais(unJugador);
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        tarjetaArgentina.activar(unJugador.getPaisesOcupados());

        assertEquals(3, argentina.obtenerEjercito());
    }

    @Test
    public void test02ActivarTarjetaDePaisPertenecienteAlJugadorDosVecesAumentaSuEjercitoUnaSolaVez(){
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais(unJugador);
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        tarjetaArgentina.activar(unJugador.getPaisesOcupados());
        tarjetaArgentina.activar(unJugador.getPaisesOcupados());

        assertEquals(3, argentina.obtenerEjercito());
    }

    @Test
    public void test03ActivarTarjetaDePaisNoPertenecienteAlJugadorNoAumentaSuEjercito(){
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais();
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        tarjetaArgentina.activar(unJugador.getPaisesOcupados());

        assertEquals(1, argentina.obtenerEjercito());
    }
}
