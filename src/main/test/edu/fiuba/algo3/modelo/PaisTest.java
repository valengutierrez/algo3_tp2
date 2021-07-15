package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaisTest {

    @Test
    public void test01JugadorUnoAgregaTresEjercitosEnUnPais() {
        Pais argentina = new Pais();
        argentina.incrementarEjercito(3);

        assertEquals(4, argentina.obtenerEjercito());
    }

    @Test
    public void test02UnPaisSeLeAsignaDuenio(){
        Pais argentina = new Pais();
        assertFalse(argentina.esOcupable());
    }

}