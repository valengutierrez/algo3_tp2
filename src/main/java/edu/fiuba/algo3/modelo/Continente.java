package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    private ArrayList<Pais> paises;
    private int ejercitosAAgregar;
    private String nombre;

    public Continente(String unNombre){
        nombre = unNombre;
    }

    public Continente(ArrayList<Pais> paisesDelContinente, int ejercitos){
        paises = paisesDelContinente;
        ejercitosAAgregar = ejercitos;
    }

    public int ejercitoPorContinente(ArrayList<Pais> paisesDelJugador) {
        for (Pais p : paises) {
            if (!paisesDelJugador.contains(p)) {
                return 0;
            }
        }
        return ejercitosAAgregar;
    }

	public String getNombre() {
		return nombre;
	}

    public void poblarContinente(Pais unPais) {
        if(paises == null){
            paises = new ArrayList<Pais>();
        }
        paises.add(unPais);
    }

	public Integer tamanio() {
		return paises.size();
	}

}
