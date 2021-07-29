package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pais> paises;
    private Jugador jugadorEnTurno;
    private boolean jugadorConquisto;
    private ArrayList<TarjetaPais> mazoTarjetasPais; // TODO: Cambiar aca a List, interfaz mas general

    public Juego(){
        jugadores = new ArrayList<Jugador>();
    }

    public void agregarMazo(ArrayList<TarjetaPais> mazo){
        mazoTarjetasPais = mazo;
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
        if(jugadorEnTurno == null)
            jugadorEnTurno = jugador;
    }

    public void jugadorEnTurnoAtaca(Pais paisAtacante, Pais paisDefensor){
        int paisesIniciales = jugadorEnTurno.getPaisesOcupados().size();
        // TODO: Mover validacion de conquista al metodo de ataque del jugador
        jugadorEnTurno.atacar(paisAtacante, paisDefensor);
        int paisesFinales = jugadorEnTurno.getPaisesOcupados().size();
        if (paisesFinales > paisesIniciales){
            jugadorConquisto = true;
        }
    }

    public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidad){
        jugadorEnTurno.reagrupar(paisOrigen, paisDestino, cantidad);
    }

    public void pasarTurno(){
        if (jugadorConquisto) {
            TarjetaPais tarjetaParaElJugador = mazoTarjetasPais.remove(0);
            jugadorEnTurno.recibirTarjetaPais(tarjetaParaElJugador);
        }
        int indiceDeProximoJugador = jugadores.indexOf(jugadorEnTurno) + 1;
        if(indiceDeProximoJugador == jugadores.size()) {
            indiceDeProximoJugador = 0;
            // faseDeJuego = rondaDeAtaque;
            //return;
        }
        jugadorEnTurno = jugadores.get(indiceDeProximoJugador);
        jugadorConquisto = false;
    }

    public Jugador turnoDe(){
        return jugadorEnTurno;
    }

	public void agregarPais(Pais unPais) {
        if(paises==null){
            paises = new ArrayList<Pais>();
        }
        paises.add(unPais);
	}

    public Pais buscarPais(String nombre) {
        for(Pais i: paises){
            if(i.getNombre().equals(nombre)){
                return i;
            }
        }
        return null;
    }

	public void crearPaises(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<String[]> datos = new ArrayList<String[]>();
        paises = new ArrayList<Pais>();
		datos = unParser.parsePaises();

        for(int i = 0; i<datos.size(); i++){
            Pais unPais = new Pais(datos.get(i)[0]);
            paises.add(unPais);
        }
	}

	public ArrayList<Pais> getPaises() {
		return paises;
	}

	public void cargarFronteras(String archivo) {
        Parser unParser= new Parser(archivo);
        ArrayList<String[]> datos = new ArrayList<String[]>();
        datos = unParser.parseFronteras();
        
        for(int j = 0; j<datos.size() ; j++){
            Pais paisAColocarleFronteras = this.buscarPais(datos.get(j)[0]);
            for(int k = 2 ; k<datos.get(j).length; k++){
                Pais paisFronterizo = this.buscarPais(datos.get(j)[k]);
                paisAColocarleFronteras.setPaisLimitrofe(paisFronterizo);
            }
        }

	}

	public void cargarTarjetas(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<String[]> datos = new ArrayList<String[]>();
        mazoTarjetasPais = new ArrayList<TarjetaPais>();
		datos = unParser.parsePaises();

        for(int i = 0; i<datos.size(); i++){
            TarjetaPais unaTarjeta = new TarjetaPais(this.buscarPais(datos.get(i)[0]),datos.get(i)[1]);
            mazoTarjetasPais.add(unaTarjeta);
        }
	}

    public ArrayList<TarjetaPais> getTarjetas() {
        return mazoTarjetasPais;
    }

}
/*
estadoAtaque.moverEjercitosDe(jugadorDeTruno,pais1,pais2){
    jugadorDeTurno.ataque(pais1,pais2)
}
estadoReagrupar.moverEj(jugadorDeTruno,pais1,pais2){
    jugadorDeTurno.reagrupar(pais1,pais2)
}*/
