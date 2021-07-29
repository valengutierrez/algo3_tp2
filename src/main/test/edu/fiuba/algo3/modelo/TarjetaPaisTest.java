package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

    @Test
    public void test06LeoUnArchivoYCreoUnaTarjeta(){
        Parser unParser = new Parser("src/main/resources/Teg - Cartas.csv");
        ArrayList<String[]> datos = new ArrayList<String[]>();
		datos = unParser.parsePaises();
        Pais unPais= new Pais(datos.get(0)[0]);
        TarjetaPais unaTarjeta = new TarjetaPais(unPais, datos.get(0)[1]);
        assertEquals("Globo", unaTarjeta.getSimbolo());
    }

    
    @Test
    public void test07LeoUnArchivoYCreoTodasLasTarjetas(){
        Parser unParser = new Parser("src/main/resources/Teg - Cartas.csv");
        ArrayList<String[]> datos = new ArrayList<String[]>();
        ArrayList<TarjetaPais> tarjetas = new ArrayList<TarjetaPais>();
		datos = unParser.parsePaises();

        for(int i = 0; i<datos.size(); i++){
            Pais unPais = new Pais(datos.get(i)[0]);
            TarjetaPais unaTarjeta = new TarjetaPais(unPais,datos.get(i)[1]);
            tarjetas.add(unaTarjeta);
        }

        assertEquals(50, tarjetas.size());
    
    }
}
