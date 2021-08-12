package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ejercito {
    private int tamanio;
    private int maximaTirada = 3;

    public Ejercito (){
        tamanio = 1;
    }

    public void incrementar(int cantidadIncremento){
        tamanio += cantidadIncremento;
    }

    public int tamanio(){
        return tamanio;
    }

    public void atacar(Pais unPais){
        if(tamanio>1){
            unPais.serAtacadoPor(this);
        }
    }
    public void defenderseDe(Ejercito unEjercito){
        CampoDeBatalla unCampo = new CampoDeBatalla();
        unCampo.iniciarBatalla(unEjercito, this);
    }

	public void reducir(int i) {
        if(tamanio >= i)
            tamanio-=i;
	}

    public ArrayList<Integer> tirarDadosDefensores(Dados unosDados) {
        return unosDados.arrojar(Math.min(tamanio, maximaTirada));
    }
    
    public ArrayList<Integer> tirarDadosAtacantes(Dados unosDados) {
        return unosDados.arrojar(Math.min(tamanio-1, maximaTirada));
    }
    
    public void ocupar(Pais unPais ,int unaCantidad) {
        reducir(unaCantidad);
        unPais.incrementarEjercito(unaCantidad);
    }

    public void moverEjercito(Pais paisDestino, int cantidadEjercito){
        if (cantidadEjercito < tamanio){
            paisDestino.incrementarEjercito(cantidadEjercito);
            reducir(cantidadEjercito);
        }
    }
}
