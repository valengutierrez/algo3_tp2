package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EtapaTest {

    @Test
    public void test01RetornosDeEtapas() {
        Etapa etapa = Etapa.COLOCACION_INICIAL;
        assertEquals("Colocar", etapa.toString());
        etapa = Etapa.INCORPORACION_EJERCITOS;
        assertEquals("Colocar", etapa.toString());
        etapa = Etapa.ATAQUE;
        assertEquals("Atacar!", etapa.toString());
        etapa = Etapa.REAGRUPACION;
        assertEquals("Reagrupar", etapa.toString());
    }

}
