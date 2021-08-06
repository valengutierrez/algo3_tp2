package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GestorCanjeTest {

    @Test
    public void test01JugadorActivaTresTarjetasConMismoSimbolo(){
        GestorDeCanjes gestor = new GestorDeCanjes();
        Pais argentina = new Pais("argentina");
        TarjetaPais t1 = new TarjetaPais(argentina, "canion");
        Pais brasil = new Pais("brasil");
        TarjetaPais t2 = new TarjetaPais(brasil, "canion");
        Pais canada = new Pais("canada");
        TarjetaPais t3 = new TarjetaPais(canada, "canion");

        assertEquals(4, gestor.canjear(t1, t2, t3));
        assertEquals(7, gestor.canjear(t1, t2, t3));
        assertEquals(10, gestor.canjear(t1, t2, t3));
        assertEquals(15, gestor.canjear(t1, t2, t3));
        assertEquals(20, gestor.canjear(t1, t2, t3));
    }

    @Test
    public void test02JugadorActivaTresTarjetasConDistintoSimbolo(){
        GestorDeCanjes gestor = new GestorDeCanjes();
        Pais argentina = new Pais("argentina");
        TarjetaPais t1 = new TarjetaPais(argentina, "canion");
        Pais brasil = new Pais("brasil");
        TarjetaPais t2 = new TarjetaPais(brasil, "avion");
        Pais canada = new Pais("canada");
        TarjetaPais t3 = new TarjetaPais(canada, "barco");

        assertEquals(4, gestor.canjear(t1, t2, t3));
        assertEquals(7, gestor.canjear(t1, t2, t3));
        assertEquals(10, gestor.canjear(t1, t2, t3));
        assertEquals(15, gestor.canjear(t1, t2, t3));
        assertEquals(20, gestor.canjear(t1, t2, t3));
    }
    @Test
    public void test03JugadorActivaTresTarjetasInvalidas(){
        GestorDeCanjes gestor = new GestorDeCanjes();
        Pais argentina = new Pais("argentina");
        TarjetaPais t1 = new TarjetaPais(argentina, "canion");
        Pais brasil = new Pais("brasil");
        TarjetaPais t2 = new TarjetaPais(brasil, "avion");
        Pais canada = new Pais("canada");
        TarjetaPais t3 = new TarjetaPais(canada, "avion");

        assertEquals(0, gestor.canjear(t1, t2, t3));
        assertEquals(0, gestor.canjear(t1, t2, t3));
    }
}
