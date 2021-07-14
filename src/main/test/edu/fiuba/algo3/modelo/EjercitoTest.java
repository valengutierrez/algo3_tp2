package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void test03UnEjercitoAtacaAUnPaisYGana(){
        Pais brasilMock = mock(Pais.class);
        Ejercito ejercitoArgentino = new Ejercito();

        when(brasilMock.esOcupable()).thenReturn(false);

        ejercitoArgentino.atacar(brasilMock);

        when(brasilMock.esOcupable()).thenReturn(true);

        assertEquals(true, brasilMock.esOcupable());
    }
}
