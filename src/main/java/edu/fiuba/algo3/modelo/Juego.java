package edu.fiuba.algo3.modelo;

import javafx.scene.paint.Color;

import java.util.*;


public class Juego extends Observable {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pais> paises;
    private Pais paisOrigen;
    private Pais paisDestino;
    private ArrayList<Continente> continentes;
    private ArrayList<Objetivo> objetivos;
    private Jugador jugadorEnTurno;
    private boolean jugadorConquisto;
    private ArrayList<TarjetaPais> mazoTarjetasPais;
    private Etapa etapa;
    private HashMap<String, Integer> ejerecitosContinente = new HashMap<String, Integer>(){{
        put("America del Sur", 3);
        put("America del Norte", 5);
        put("Oceania", 2);
        put("Africa", 3);
        put("Europa", 5);
        put("Asia", 7);
    }};
    private boolean jugadorGano;

    public Juego(){
        jugadores = new ArrayList<Jugador>();
        continentes = new ArrayList<Continente>();
        paises = new ArrayList<Pais>();
        etapa = Etapa.COLOCACION_INICIAL;
        objetivos = new ArrayList<Objetivo>();
        jugadorGano = false;
    }

    public boolean getJugadorGano(){
        return jugadorGano;
    }

    public void setearEtapa(Etapa etapa){
        this.etapa = etapa;
    }

    public Etapa obtenerEtapa() {
        return etapa;
    }

    public void crearModelo(Map<String, Color> mapaDeJugadores){
        for(Map.Entry<String, Color> entry : mapaDeJugadores.entrySet()){
            Jugador j = new Jugador();
            j.setNombre(entry.getKey());
            j.setColor(entry.getValue());
            añadirJugador(j);
        }

        this.crearPaises("src/main/resources/Teg - Fronteras.csv");
        this.cargarFronteras("src/main/resources/Teg - Fronteras.csv");
        this.crearContinentes("src/main/resources/Teg - Fronteras.csv");
        this.cargarTarjetas("src/main/resources/Teg - Cartas.csv");
        this.crearObjetivosDestruir("src/main/resources/ObjetivoDestruir.csv");
        this.crearObjetivosOcupar("src/main/resources/Objetivos.csv");
        this.asignarObjetivos();

        this.repartirPaises();

        setChanged();
        notifyObservers("iniciar partida");
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
            System.out.println("Por ver si gane: ");
            jugadorGano = jugadorEnTurno.cumplido();
            System.out.println(jugadorEnTurno.cumplido());
        }
        this.paisOrigen = null;
        this.paisDestino = null;
        setChanged();
        notifyObservers("borrar paises");
    }

    public void jugadorEnTurnoAtaca(Pais paisAtacante, Pais paisDefensor){
        int paisesIniciales = jugadorEnTurno.getPaisesOcupados().size();
        jugadorEnTurno.atacar(paisAtacante, paisDefensor);
        int paisesFinales = jugadorEnTurno.getPaisesOcupados().size();
        if (paisesFinales > paisesIniciales){
            jugadorConquisto = true;
        }
    }

    public void reagrupar(String paisOrigen, String paisDestino, int cantidad){
        Pais paisPartida = this.buscarPais(paisOrigen);
        Pais paisLlegada = this.buscarPais(paisDestino);

        this.reagrupar(paisPartida, paisLlegada, cantidad);

        this.paisOrigen = null;
        this.paisDestino = null;
        setChanged();
        notifyObservers("borrar paises");
    }

    public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidad){
        jugadorEnTurno.reagrupar(paisOrigen, paisDestino, cantidad);
    }

    public void colocarEjercitos(String nombrePais, int cantidadDeFichas){
        Pais pais = this.buscarPais(nombrePais);

        jugadorEnTurno.colocarEjercitos(pais, cantidadDeFichas);

        setChanged();
        notifyObservers("borrar paises");
    }

    private void darTarjetaAJugador(){
        Random random = new Random();
        int indiceTarjeta = random.nextInt(mazoTarjetasPais.size());
        TarjetaPais tarjetaParaElJugador = mazoTarjetasPais.remove(indiceTarjeta);
        jugadorEnTurno.recibirTarjetaPais(tarjetaParaElJugador);
    }

    private void repartirPaises(){
        int i = 0;
        ArrayList<Pais> paisesAOcupar = (ArrayList<Pais>) paises.clone();
        while (!paisesAOcupar.isEmpty()) {
            Random random = new Random();
            int indicePais = random.nextInt(paisesAOcupar.size());
            Pais paisAOcupar = paisesAOcupar.remove(indicePais);
            paisAOcupar.serOcupadoPor(jugadores.get(i));
            i++;
            if (i == jugadores.size()) i = 0;
        }
    }

    public void pasarTurno(){
        if (jugadorConquisto) {
            darTarjetaAJugador();
        }
        jugadorConquisto = false;
        if (this.etapa == Etapa.REAGRUPACION) this.etapa = Etapa.ATAQUE;

        if ((this.etapa == Etapa.INCORPORACION_EJERCITOS || this.etapa == Etapa.COLOCACION_INICIAL || this.etapa == Etapa.COLOCACION_SECUNDARIA)
            && fichasDisponiblesJugador() != 0) return;

        int indiceDeProximoJugador = jugadores.indexOf(jugadorEnTurno) + 1;
        if(indiceDeProximoJugador == jugadores.size()) {
            indiceDeProximoJugador = 0;
            this.cambiarEtapaDeJuego();
        }
        jugadorEnTurno = jugadores.get(indiceDeProximoJugador);

        if (this.etapa == Etapa.INCORPORACION_EJERCITOS) {
            jugadorEnTurno.fichasPorPais();
            for (Continente continente : continentes) {
                int ejercitosContiente = continente.ejercitoPorContinente(jugadorEnTurno.getPaisesOcupados());
                jugadorEnTurno.incrementarFichasDisponibles(ejercitosContiente);
            }
        }
        if (this.etapa == Etapa.COLOCACION_SECUNDARIA) {
            jugadorEnTurno.incrementarFichasDisponibles(3);
        }
        setChanged();
        notifyObservers("borrar paises");
    }

    public void cambiarEtapaDeJuego(){
        if (this.etapa == Etapa.COLOCACION_INICIAL){
            this.etapa = Etapa.COLOCACION_SECUNDARIA;
        } else if (this.etapa == Etapa.INCORPORACION_EJERCITOS || this.etapa == Etapa.COLOCACION_SECUNDARIA) {
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
		datos = unParser.parsePaises();

        for(int i = 0; i<datos.size(); i++){
            String nombreContinente = datos.get(i)[1];
            String nombrePais = datos.get(i)[0];
            if(!continentes.contains(this.buscarContinente(nombreContinente))){
                Continente unContinente = new Continente(nombreContinente);
                continentes.add(unContinente);
            }

            Continente unContinente = this.buscarContinente(nombreContinente);
            Pais unPais = this.buscarPais(nombrePais);
            unContinente.poblarContinente(unPais);
        }

        for (Map.Entry<String, Integer> entry : ejerecitosContinente.entrySet()) {
            String nombreContinente = entry.getKey();
            int ejercitos = entry.getValue();
            Continente continente = this.buscarContinente(nombreContinente);
            continente.setEjercitosAAgregar(ejercitos);
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

    public void crearObjetivosOcupar(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<ArrayList<Integer>> datos;
		datos = unParser.parse();

        for(ArrayList<Integer> linea : datos){
			objetivos.add(new ObjetivoOcupar(linea,continentes));
		}
    }

    public void crearObjetivosDestruir(String archivo) {
        Parser unParser = new Parser(archivo);
        ArrayList<Color> colores;
		colores = unParser.parseJugadores();
        
        for(Color unColor : colores){
            for (Jugador j : jugadores){
                if (j.getColor() == unColor){
                    int indiceSiguienteJugador = jugadores.indexOf(j) + 1;
                    if (indiceSiguienteJugador == jugadores.size()) {
                        indiceSiguienteJugador = 0;
                    }
                    Jugador jugadorSiguiente = jugadores.get(indiceSiguienteJugador);
                    objetivos.add(new ObjetivoDestruir(this.buscarJugador(unColor), jugadorSiguiente));
                }
            }
		}
    }
    
    public void asignarObjetivos() {
        Random random = new Random();
        for(Jugador j : jugadores){
            int nroObjetivo = random.nextInt(objetivos.size());
            j.asignarObjetivoParticular(objetivos.get(nroObjetivo));
            j.asignarObjetivoComun(new ObjetivoComun());
            objetivos.remove(nroObjetivo);
        }
    }

	private Jugador buscarJugador(Color unColor) {
        for(Jugador j : jugadores){
            if(j.getColor().equals(unColor)){
                return j;
            }
        }
        return null;
    }

    public void etapaReagrupar() {
        this.etapa = Etapa.REAGRUPACION;
        setChanged();
        notifyObservers();
    }

    public int fichasDisponiblesJugador() {
        return jugadorEnTurno.fichasDisponibles();
    }

    public String textoObjetivo(){
        return jugadorEnTurno.textoObjetivo();
    }

    public Jugador getJugadorEnTurno() {
        return jugadorEnTurno;
    }

    public void jugadorActivaTarjeta(String nombreTarjeta) {
        jugadorEnTurno.activarTarjeta(nombreTarjeta);
        setChanged();
        notifyObservers();
    }

    public void jugadorEnTurnoCanjea(String t1,String t2,String t3) {
        jugadorEnTurno.canjear(t1,t2,t3);
    }

}
