package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaisTest {

    @Test
    public void test01JugadorUnoAgregaTresEjercitosEnUnPais() {
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais(unJugador);
        argentina.incrementarEjercito(3);

        assertEquals(4, argentina.obtenerEjercito());
    }

    @Test
    public void test02UnPaisSeLeAsignaDuenio(){
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais(unJugador);
        
        assertEquals(unJugador, argentina.obtenerDuenio());
    }

    @Test
    public void test03UnPaisAtacaAOtroConElDefensorComoGanador() {
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        Ejercito ejercitoAtacante = mock(Ejercito.class);
        when(ejercitoAtacante.tirarDadosAtacantes(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        ejercitoAtacante.incrementar(1);

        Pais argentina = new Pais(jugadorAzul);
        argentina.agregarEjercito(ejercitoAtacante);

        Pais brasil = new Pais(jugadorVerde);
        brasil.incrementarEjercito(3);

        argentina.setPaisLimitrofe(brasil);
        argentina.atacar(brasil);

        assertEquals(jugadorVerde, brasil.obtenerDuenio());
    }

    @Test
    public void test04UnPaisAtacaAOtroConElAtacanteComoGanador() {
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        Ejercito ejercitoDefensor = mock(Ejercito.class);
        when(ejercitoDefensor.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});

        Pais argentina = new Pais(jugadorAzul);
        argentina.incrementarEjercito(4);
        
        Pais brasil = new Pais(jugadorVerde);
        brasil.agregarEjercito(ejercitoDefensor);
        
        argentina.setPaisLimitrofe(brasil);
        argentina.atacar(brasil);

        assertEquals(jugadorAzul, brasil.obtenerDuenio());
    }

    @Test
    public void test05UnPaisEsOcupadoPorUnJugador(){
        Jugador otroJugador = new Jugador();
        Pais unPais = new Pais(otroJugador);
        Jugador unJugador = new Jugador();

        unPais.serOcupadoPor(unJugador);
        assertEquals(unJugador, unPais.obtenerDuenio());
        
    }

    @Test
    public void test06LeoUnArchivoYCreoUnPais(){
        Parser unParser = new Parser("src/main/resources/Teg - Cartas.csv");
        ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = unParser.parsePaises();
        Pais unPais= new Pais(datos.get(0)[0]);
        assertEquals("Francia", unPais.getNombre());
    }

    @Test
    public void test07LeoUnArchivoYCreoTodosLosPaises(){
        Parser unParser = new Parser("src/main/resources/Teg - Cartas.csv");
        ArrayList<String[]> datos = new ArrayList<String[]>();
        ArrayList<Pais> paises = new ArrayList<Pais>();
		datos = unParser.parsePaises();

        String nombrePais;

        for(String[] dupla: datos){
            nombrePais = dupla[0];
            Pais unPais= new Pais(nombrePais);
            paises.add(unPais);
        }
        for(Pais i : paises){
            System.out.println(i.getNombre());
        }
    }

}