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
        unPais.serAtacadoPor(this);
    }

    private int ejercitosDefensores() {
        return Math.min(tamanio, 3);
    }

    private int ejercitosAtacantes() {
        return Math.min(tamanio-1, 3);
    }

    public void defenderseDe(Ejercito unEjercito){
        CampoDeBatalla unCampo = new CampoDeBatalla();
        unCampo.iniciarBatalla(unEjercito, this);
    }

	public void reducir(int i) {
        //TODO: Validar que el tamanio no sea negativo
        tamanio-=i;
	}

    public ArrayList<Integer> tirarDados(Dados unosDados) {
        return unosDados.arrojar(tamanio);
    }
    
    public void ocupar(Pais unPais,int unaCantidad) {
        reducir(unaCantidad);
        unPais.incrementarEjercito(unaCantidad);
    }
    /*******Only Testing Purposes*******/

    public Pais atacarYGanar(Pais unPais){
        unPais.serAtacadoPor(this);

        return unPais;
    }

}
