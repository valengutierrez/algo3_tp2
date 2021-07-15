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

    @Test
    public void test03UnEjercitoAtacaAUnPais(){
        Pais brasil = new Pais();
        Ejercito ejercitoArgentino = new Ejercito();
        ejercitoArgentino.incrementar(2);
        
        // Si hay una batalla, seguro que hay bajas
        int sumaEjercitosInicial = ejercitoArgentino.tamanio()+brasil.obtenerEjercito();
        ejercitoArgentino.atacar(brasil);
        int sumaEjercitosFinal = ejercitoArgentino.tamanio()+brasil.obtenerEjercito();
        
        assertTrue(sumaEjercitosFinal<sumaEjercitosInicial);
    }
    
    @Test
    public void test04UnEjercitoSeDefiendeDeOtro(){
        Ejercito ejercitoBrasilero = new Ejercito();
        Ejercito ejercitoArgentino = new Ejercito();
        ejercitoArgentino.incrementar(2);
        
        // Si hay una batalla, seguro que hay bajas
        int sumaEjercitosInicial = ejercitoArgentino.tamanio()+ejercitoBrasilero.tamanio();
        ejercitoBrasilero.defenderseDe(ejercitoArgentino);
        int sumaEjercitosFinal = ejercitoArgentino.tamanio()+ejercitoBrasilero.tamanio();
        
        assertTrue(sumaEjercitosFinal<sumaEjercitosInicial);
    }
    
    @Test
    public void test05UnEjercitoNoPuedeAtacarConTamanioUno(){
        Pais brasil = new Pais();
        Ejercito ejercitoArgentino = new Ejercito();
        
        // Si no hay una batalla, seguro que no hay bajas
        int sumaEjercitosInicial = ejercitoArgentino.tamanio()+brasil.obtenerEjercito();
        ejercitoArgentino.atacar(brasil);
        int sumaEjercitosFinal = ejercitoArgentino.tamanio()+brasil.obtenerEjercito();

        assertEquals(sumaEjercitosFinal, sumaEjercitosInicial);
    }
}
