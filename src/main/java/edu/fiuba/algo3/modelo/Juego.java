package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.VentanaJuego;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Observable;


public class Juego extends Observable {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pais> paises;
    private Pais paisOrigen;
    private Pais paisDestino;
    private ArrayList<Continente> continentes;
    private ArrayList<Objetivo> objetivos;
    private Jugador jugadorEnTurno;
    private boolean jugadorConquisto;
    private ArrayList<TarjetaPais> mazoTarjetasPais; // TODO: Cambiar aca a List, interfaz mas general
    private Etapa etapa;

    public Juego(){
        jugadores = new ArrayList<Jugador>();
        continentes = new ArrayList<Continente>();
    }

    public void crearVentana(Stage primaryStage){
        VentanaJuego.crearVentana(primaryStage, this);
    }

    public void setearEtapa(Etapa etapa){
        this.etapa = etapa;
    }

    public Etapa obtenerEtapa() {
        return etapa;
    }

    public void crearModelo(){
        Jugador jugadorAzul = new Jugador();
        jugadorAzul.setColor(Color.BLUE);
        Jugador jugadorVerde = new Jugador();
        jugadorVerde.setColor(Color.GREEN);


        Pais argentina = new Pais("argentina");
        Pais brasil = new Pais("brasil");
        Pais canada = new Pais("canada");

        ArrayList<Pais> paisesAmericaDelSur = new ArrayList<Pais>();
        paisesAmericaDelSur.add(argentina);
        paisesAmericaDelSur.add(brasil);

        Continente AmericaDelSur = new Continente(paisesAmericaDelSur, 5);
        this.continentes.add(AmericaDelSur);

        argentina.serOcupadoPor(jugadorAzul);
        brasil.serOcupadoPor(jugadorVerde);
        canada.serOcupadoPor(jugadorVerde);

        argentina.incrementarEjercito(5);
        argentina.setPaisLimitrofe(brasil);

        canada.incrementarEjercito(5);
        canada.setPaisLimitrofe(brasil);

        añadirJugador(jugadorAzul);
        añadirJugador(jugadorVerde);

        agregarPais(argentina);
        agregarPais(brasil);
        agregarPais(canada);

        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        TarjetaPais tarjetaBrasil = new TarjetaPais(brasil, "canion");
        TarjetaPais tarjetaCanada = new TarjetaPais(canada, "barco");

        ArrayList<TarjetaPais> mazo = new ArrayList<TarjetaPais>();
        mazo.add(tarjetaArgentina);
        mazo.add(tarjetaBrasil);
        mazo.add(tarjetaCanada);

        this.agregarMazo(mazo);

        System.out.println(jugadorAzul.getColor());
        System.out.println(jugadorVerde.getColor().toString());

        setearEtapa(Etapa.ATAQUE);
    }

    public void seleccionarPais(String nombrePais) {
        if (paisOrigen == null){
            paisOrigen = this.buscarPais(nombrePais);
        } else if (paisDestino == null){
            paisDestino = this.buscarPais(nombrePais);
        }
        setChanged();
        notifyObservers(nombrePais);
    }

    public void agregarMazo(ArrayList<TarjetaPais> mazo){
        mazoTarjetasPais = mazo;
    }

    public void añadirJugador(Jugador jugador) {
        jugadores.add(jugador);
        if(jugadorEnTurno == null)
            jugadorEnTurno = jugador;
    }

    public void jugadorEnTurnoAtaca(String paisOrigen, String paisDestino){
        Pais paisAtacante = this.buscarPais(paisOrigen);
        Pais paisDefensor = this.buscarPais(paisDestino);
        System.out.println("Jugador en turno: " + jugadorEnTurno);
        int paisesIniciales = jugadorEnTurno.getPaisesOcupados().size();
        // Mover validacion de conquista al metodo de ataque del jugador
        jugadorEnTurno.atacar(paisAtacante, paisDefensor);
        int paisesFinales = jugadorEnTurno.getPaisesOcupados().size();
        if (paisesFinales > paisesIniciales){
            jugadorConquisto = true;
        }
        this.paisOrigen = null;
        this.paisDestino = null;
        setChanged();
        notifyObservers("borrar paises");
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

    public void reagrupar(String paisOrigen, String paisDestino, int cantidad){
        Pais paisPartida = this.buscarPais(paisOrigen);
        Pais paisLlegada = this.buscarPais(paisDestino);
        System.out.println("Jugador en turno: " + jugadorEnTurno);
        System.out.println("ejercito antes de reagrupar origen: " + paisPartida.obtenerEjercito());
        System.out.println("ejercito antes de reagrupar destino: " + paisLlegada.obtenerEjercito());

        this.reagrupar(paisPartida, paisLlegada, cantidad);

        System.out.println("ejercito antes de reagrupar origen: " + paisPartida.obtenerEjercito());
        System.out.println("ejercito antes de reagrupar destino: " + paisLlegada.obtenerEjercito());
        this.paisOrigen = null;
        this.paisDestino = null;
        System.out.println("----------fin reagrupacion----------");
        setChanged();
        notifyObservers("borrar paises");
    }

    public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidad){
        jugadorEnTurno.reagrupar(paisOrigen, paisDestino, cantidad);
    }

    public void colocarEjercitos(String nombrePais, int cantidadDeFichas){
        Pais pais = this.buscarPais(nombrePais);

        System.out.println("ejercito inicial: " + pais.obtenerEjercito());

        jugadorEnTurno.colocarEjercitos(pais, cantidadDeFichas);

        System.out.println("ejercito final: " + pais.obtenerEjercito());
        setChanged();
        notifyObservers("borrar paises");
    }

    public void pasarTurno(){
        if (jugadorConquisto) {
            System.out.println("saco carta");
            TarjetaPais tarjetaParaElJugador = mazoTarjetasPais.remove(0);
            jugadorEnTurno.recibirTarjetaPais(tarjetaParaElJugador);
        }
        jugadorConquisto = false;

        if (this.etapa == Etapa.REAGRUPACION) this.etapa = Etapa.ATAQUE;

        if (this.etapa == Etapa.INCORPORACION_EJERCITOS && fichasDisponiblesJugador() != 0) return;

        System.out.println("Paso turno");
        int indiceDeProximoJugador = jugadores.indexOf(jugadorEnTurno) + 1;
        if(indiceDeProximoJugador == jugadores.size()) {
            indiceDeProximoJugador = 0;
            this.cambiarEtapaDeJuego();
        }
        jugadorEnTurno = jugadores.get(indiceDeProximoJugador);

        if (this.etapa == Etapa.INCORPORACION_EJERCITOS) {
            System.out.println("calcula fichas a colocar");
            jugadorEnTurno.fichasPorPais();
            for (Continente continente : continentes) {
                int ejercitosContiente = continente.ejercitoPorContinente(jugadorEnTurno.getPaisesOcupados());
                jugadorEnTurno.incrementarFichasDisponibles(ejercitosContiente);
            }
            System.out.println("fichas a colocar: " + fichasDisponiblesJugador());
        }

        setChanged();
        notifyObservers("borrar paises");
    }

    public void cambiarEtapaDeJuego(){
        if (this.etapa == Etapa.INCORPORACION_EJERCITOS) {
            this.etapa = Etapa.ATAQUE;
        } else {
            this.etapa = Etapa.INCORPORACION_EJERCITOS;
        }
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

    public void crearContinentes(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<String[]> datos = new ArrayList<String[]>();
        continentes = new ArrayList<Continente>();
		datos = unParser.parsePaises();

        for(int i = 0; i<datos.size(); i++){
            String nombreContinente = datos.get(i)[1];
            String nombrePais = datos.get(i)[0];
            if(!continentes.contains(this.buscarContinente(nombreContinente))){
                Continente unContinente = new Continente(nombreContinente);
                continentes.add(unContinente);
            }
            //Continentes cargados, falta poblarlos
            Continente unContinente = this.buscarContinente(nombreContinente);
            Pais unPais = this.buscarPais(nombrePais);
            unContinente.poblarContinente(unPais);
        }
    }

    public Continente buscarContinente(String nombre) {
        for(Continente i: continentes){
            if(i.getNombre().equals(nombre)){
                return i;
            }
        }
        return null;
    }

	public ArrayList<Continente> getContinentes() {
		return continentes;
	}

    public void crearObjetivos(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<ArrayList<Integer>> datos = new ArrayList<ArrayList<Integer>>();
		datos = unParser.parse();
        objetivos = new ArrayList<Objetivo>();

        for(ArrayList<Integer> linea : datos){
			objetivos.add(new Objetivo(linea));
		}
    }

	public ArrayList<Objetivo> getObjetivos() {
		return objetivos;
	}

    public void etapaReagrupar() {
        this.etapa = Etapa.REAGRUPACION;
        setChanged();
        notifyObservers();
    }

    public int fichasDisponiblesJugador() {
        return jugadorEnTurno.fichasDisponibles();
    }

    public Jugador getJugadorEnTurno() {
        return jugadorEnTurno;
    }

    public void jugadorActivaTarjeta(String nombreTarjeta) {
        jugadorEnTurno.activarTarjeta(nombreTarjeta);
        setChanged();
        notifyObservers();
    }
}
