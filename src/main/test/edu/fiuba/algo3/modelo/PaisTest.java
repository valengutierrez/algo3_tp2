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
    public void test02UnPaisAtacaAOtroConElDefensorComoGanador() {
        Pais argentina = new Pais();
        argentina.incrementarEjercito(4);

        Pais brasil = new Pais();
        brasil.incrementarEjercito(3);

        assertNull(argentina.atacar(brasil));
    }

    @Test
    public void test03UnPaisAtacaAOtroConElAtacanteComoGanador() {
		// TODO
    }


}