package edu.fiuba.algo3.modelo;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObjetivoComunTest {

    @Test
    public void test01ObjetivoComunDevuelveDescripcion(){
        ObjetivoComun objetivo = new ObjetivoComun();
        assertEquals("Ocupar 30 paises", objetivo.mostrarse());
    }
}
