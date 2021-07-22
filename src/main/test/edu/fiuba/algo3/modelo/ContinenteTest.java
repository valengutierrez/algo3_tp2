package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void test01SiJugadorTieneTodosLosPaisesDeOceaniaAgregaDosEjercitos(){
        Jugador unJugador = new Jugador();

        Pais Australia = new Pais(unJugador);
        Pais Java = new Pais(unJugador);
        Pais Sumatra = new Pais(unJugador);
        Pais Borneo = new Pais(unJugador);

        ArrayList<Pais> paisesDeOceania = new ArrayList<Pais>();
        paisesDeOceania.add(Australia);
        paisesDeOceania.add(Java);
        paisesDeOceania.add(Sumatra);
        paisesDeOceania.add(Borneo);

        Continente Oceania = new Continente(paisesDeOceania, 2);

        ArrayList<Pais> paisesDelJugador = unJugador.getPaisesOcupados();

        assertEquals(2, Oceania.ejercitoPorContinente(paisesDelJugador));
    }

    @Test
    public void test01SiJugadorNoTieneTodosLosPaisesDeOceaniaNoAgregaEjercitos(){
        Jugador unJugador = new Jugador();

        Pais Australia = new Pais(unJugador);
        Pais Java = new Pais(unJugador);
        Pais Sumatra = new Pais(unJugador);
        Pais Borneo = new Pais();

        ArrayList<Pais> paisesDeOceania = new ArrayList<Pais>();
        paisesDeOceania.add(Australia);
        paisesDeOceania.add(Java);
        paisesDeOceania.add(Sumatra);
        paisesDeOceania.add(Borneo);

        Continente Oceania = new Continente(paisesDeOceania, 2);

        ArrayList<Pais> paisesDelJugador = unJugador.getPaisesOcupados();

        assertEquals(0, Oceania.ejercitoPorContinente(paisesDelJugador));
    }
}
