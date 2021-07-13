package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjercitoTest {
    @Test
    public void test01UnEjercitoIncrementaSuTamanio(){
        Ejercito ejercitoArgentino = new Ejercito();
        ejercitoArgentino.incrementar(3);

        assertEquals(4,ejercitoArgentino.tamanio());
    }
}
