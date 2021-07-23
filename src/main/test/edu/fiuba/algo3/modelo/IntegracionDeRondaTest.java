package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegracionDeRondaTest {

    @Test
    public void test01JugadorQueControlaOceaniaColocaEjercitos(){
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();
        Jugador jugadorAmarillo = new Jugador();

        Pais Australia = new Pais(jugadorAzul);
        Pais Java = new Pais(jugadorAzul);
        Pais Sumatra = new Pais(jugadorAzul);
        Pais Borneo = new Pais(jugadorAzul);

        Pais Argentina = new Pais(jugadorVerde);
        Pais Brasil = new Pais(jugadorVerde);
        Pais Chile = new Pais(jugadorVerde);
        Pais Francia = new Pais(jugadorVerde);
        Pais Colombia = new Pais(jugadorVerde);
        Pais Mexico = new Pais(jugadorVerde);
        Pais Canada = new Pais(jugadorVerde);
        Pais Egipto = new Pais(jugadorVerde);

        Pais Alemania = new Pais(jugadorAmarillo);
        Pais Espania = new Pais(jugadorAmarillo);

        ArrayList<Pais> paisesDeOceania = new ArrayList<Pais>();
        paisesDeOceania.add(Australia);
        paisesDeOceania.add(Java);
        paisesDeOceania.add(Sumatra);
        paisesDeOceania.add(Borneo);

        Continente Oceania = new Continente(paisesDeOceania, 2);

        //Truno jugadorAzul

        jugadorAzul.fichasPorPais();

        int ejercitosPorContinente = Oceania.ejercitoPorContinente(jugadorAzul.getPaisesOcupados());
        jugadorAzul.incrementarFichasDisponibles(ejercitosPorContinente);

        jugadorAzul.colocarEjercitos(Australia, 5);
        jugadorAzul.colocarEjercitos(Australia, 1);

        assertEquals(6, Australia.obtenerEjercito());

        //Truno jugadorAmarillo

        jugadorAmarillo.fichasPorPais();

        int ejercitosPorContinenteAmarillo = Oceania.ejercitoPorContinente(jugadorAmarillo.getPaisesOcupados());
        jugadorAmarillo.incrementarFichasDisponibles(ejercitosPorContinenteAmarillo);

        jugadorAmarillo.colocarEjercitos(Alemania, 3);
        jugadorAmarillo.colocarEjercitos(Alemania, 1);

        assertEquals(4, Alemania.obtenerEjercito());

        //Truno jugadorVerde

        jugadorVerde.fichasPorPais();

        int ejercitosPorContinenteVerde = Oceania.ejercitoPorContinente(jugadorVerde.getPaisesOcupados());
        jugadorVerde.incrementarFichasDisponibles(ejercitosPorContinenteVerde);

        jugadorVerde.colocarEjercitos(Brasil, 4);
        jugadorVerde.colocarEjercitos(Brasil, 1);

        assertEquals(5, Brasil.obtenerEjercito());
    }
}
