package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class DadosTest {

    @Test
    public void test01ArrojarTresDadosDevuelveUnaColeccionConTresElementos(){
        Dados dados = new Dados(6);

        assertEquals(3, dados.arrojar(3).size());
    }
    
    
        @Test
        public void test02AlArrojarLosDadosElResultadoSeDevuelveOrdenado(){
            Dados dados = new Dados(6);
            int unaCantidad = 30;
            Integer resultadoPrevio = 6;
            ArrayList<Integer> resultado = dados.arrojar(unaCantidad);
            System.out.println("Tirada de dados: " + resultado);
            for(Integer i : resultado){
                System.out.println("anterior vs actual: " +resultadoPrevio + ','+ i);
                assertTrue(i<=resultadoPrevio);
                resultadoPrevio = i;
            }
        }


}