package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ejercito {
    private int tamanio;

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
        //TODO: Validar que el tamanio no sea negativo
        tamanio-=i;
	}

    public ArrayList<Integer> tirarDadosDefensores(Dados unosDados) {
        return unosDados.arrojar(Math.min(tamanio, 3));
    }

    public ArrayList<Integer> tirarDadosAtacantes(Dados unosDados) {
        return unosDados.arrojar(Math.min(tamanio-1, 3));
    }
    
    public void ocupar(Pais unPais,int unaCantidad) {
        reducir(unaCantidad);
        unPais.incrementarEjercito(unaCantidad);
    }
}
