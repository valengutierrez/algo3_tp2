package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EjercitoTest {
    @Test
    public void test01UnEjercitoIncrementaSuTamanio(){
        Ejercito ejercitoArgentino = new Ejercito();
        ejercitoArgentino.incrementar(3);

        assertEquals(4,ejercitoArgentino.tamanio());
    }

    @Test
    public void test02UnEjercitoReduceSuTamanio(){
        Ejercito ejercitoArgentino = new Ejercito();
        ejercitoArgentino.reducir(1);

        assertEquals(0,ejercitoArgentino.tamanio());
    }

 
}
