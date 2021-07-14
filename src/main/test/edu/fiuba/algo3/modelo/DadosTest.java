package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DadosTest {

    @Test
    public void test01ArrojarTresDadosDevuelveUnaColeccionConTresElementos(){
        Dados dados = new Dados(6);

        assertEquals(3, dados.arrojar(3).size());
    }

}