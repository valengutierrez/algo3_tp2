package edu.fiuba.algo3.modelo;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuegoTest {
    @Test
    public void unJugadorPasaYLeTocaAlSiguiente(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        Jugador jugadorTres = new Jugador();
        Juego juego = new Juego();
        Pais brasil = new Pais();
        Pais argentina = new Pais();
        Pais canada = new Pais();
        brasil.serOcupadoPor(jugadorDos);
        argentina.serOcupadoPor(jugadorUno);
        canada.serOcupadoPor(jugadorTres);
        juego.añadirJugador(jugadorUno);
        juego.añadirJugador(jugadorDos);
        juego.añadirJugador(jugadorTres);

        // Se agregan ejercitos porque al comenzar el juego
        // se encuentra en fase de colocacion inicial de 5 ejercitos.
        assertEquals(jugadorUno, juego.turnoDe());
        jugadorUno.colocarEjercitos(argentina, 5);
        juego.pasarTurno();
        assertEquals (jugadorDos, juego.turnoDe());
        jugadorDos.colocarEjercitos(brasil, 5);
        juego.pasarTurno();
        assertEquals (jugadorTres, juego.turnoDe());
        jugadorTres.colocarEjercitos(canada, 5);
        juego.pasarTurno();
        assertEquals (jugadorUno, juego.turnoDe());
    }

    @Test
    public void test02UnJugadorAtacaADosPaisesYLosConquista() {
        Juego TEG = new Juego();
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        TEG.añadirJugador(jugadorAzul);
        TEG.añadirJugador(jugadorVerde);

        Pais argentina = new Pais(jugadorAzul);
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        argentina.incrementarEjercito(9);

        Pais brasil = new Pais(jugadorVerde);
        TarjetaPais tarjetaBrasil = new TarjetaPais(brasil, "canion");
        Pais chile = new Pais(jugadorVerde);
        TarjetaPais tarjetaChile = new TarjetaPais(chile, "barco");

        Ejercito ejercitoDefensorBrasil = mock(Ejercito.class);
        when(ejercitoDefensorBrasil.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        brasil.agregarEjercito(ejercitoDefensorBrasil);

        Ejercito ejercitoDefensorChile = mock(Ejercito.class);
        when(ejercitoDefensorChile.tirarDadosDefensores(new Dados(6))).thenReturn(new ArrayList<Integer>() {{add(0);}});
        chile.agregarEjercito(ejercitoDefensorChile);

        argentina.setPaisLimitrofe(brasil);
        argentina.setPaisLimitrofe(chile);

        ArrayList<TarjetaPais> mazo = new ArrayList<TarjetaPais>();
        mazo.add(tarjetaArgentina);
        mazo.add(tarjetaBrasil);
        mazo.add(tarjetaChile);

        TEG.agregarMazo(mazo);

        TEG.jugadorEnTurnoAtaca(argentina, brasil);
        TEG.jugadorEnTurnoAtaca(argentina, chile);

        TEG.reagrupar(argentina, brasil, 2);

        TEG.pasarTurno();

        assertEquals(jugadorAzul, brasil.obtenerDuenio());
        assertEquals(jugadorAzul, chile.obtenerDuenio());

        assertEquals(1, jugadorAzul.obtenerTarjetas().size());
    }

    @Test
    public void test03RondaDeColocacionDeUnJugadorQueControlaOceania(){
        Jugador jugadorAzul = new Jugador();
        
        Pais Australia = new Pais(jugadorAzul);
        Pais Java = new Pais(jugadorAzul);
        Pais Sumatra = new Pais(jugadorAzul);
        Pais Borneo = new Pais(jugadorAzul);

        ArrayList<Pais> paisesDeOceania = new ArrayList<Pais>();
        paisesDeOceania.add(Australia);
        paisesDeOceania.add(Java);
        paisesDeOceania.add(Sumatra);
        paisesDeOceania.add(Borneo);
        
        Continente Oceania = new Continente(paisesDeOceania, 2);

        int ejercitosPorContinente = Oceania.ejercitoPorContinente(jugadorAzul.getPaisesOcupados());
        
        jugadorAzul.fichasPorPais();
        jugadorAzul.incrementarFichasDisponibles(ejercitosPorContinente);
        
        jugadorAzul.colocarEjercitos(Australia, 4);
        jugadorAzul.colocarEjercitos(Australia, 5);
        
        assertEquals(5, Australia.obtenerEjercito());
    }
    
    @Test
    public void test04UnJuegoEncuentraUnPaisYLoDevuelve(){
        Pais argentina = new Pais("Argentina");
        Juego unJuego = new Juego();
        unJuego.agregarPais(argentina);

        assertEquals(argentina, unJuego.buscarPais("Argentina"));
    }

    @Test
    public void test05UnJuegoCargaLosPaises() {
        Juego TEG = new Juego();
        TEG.crearPaises("src/main/resources/Teg - Cartas.csv");
        
        assertEquals(50,TEG.getPaises().size());
    }

    @Test
    public void test05UnJuegoCargaLasFronteras() {
        Juego TEG = new Juego();
        TEG.crearPaises("src/main/resources/Teg - Cartas.csv");
        TEG.cargarFronteras("src/main/resources/Teg - Fronteras.csv");
        
        assertEquals(4,TEG.buscarPais("Argentina").getPaisesLimitrofes().size());
    }

    @Test
    public void test06UnJuegoCargaLasTarjetas() {
        Juego TEG = new Juego();
        TEG.crearPaises("src/main/resources/Teg - Cartas.csv");
        TEG.cargarTarjetas("src/main/resources/Teg - Cartas.csv");

        assertEquals(50, TEG.getTarjetas().size());
        
    }

    @Test
    public void test06UnJuegoCargaLosContinentes() {
        Juego TEG = new Juego();
        TEG.crearPaises("src/main/resources/Teg - Cartas.csv");
        TEG.crearContinentes("src/main/resources/Teg - Fronteras.csv");
        assertEquals(6, TEG.getContinentes().size());
        assertEquals(15, TEG.buscarContinente("Asia").tamanio());
    }
    
    @Test
    public void test06UnJuegoCargaLosObjetivos() {
        Juego TEG = new Juego();
        TEG.crearObjetivosOcupar("src/main/resources/Objetivos.csv");
        
        ArrayList<Integer> objetivo1 = new ArrayList<Integer>();
		objetivo1.add(5);
		objetivo1.add(0);
		objetivo1.add(6);
		objetivo1.add(0);
		objetivo1.add(4);
		objetivo1.add(0);
        
        // TODO: Fix
        // assertTrue(objetivo1.equals(TEG.getObjetivos().get(0).getCantidades()));
        
        
    }

    @Test
    public void test07JuegoSeteaEtapa(){
        Juego TEG = new Juego();
        assertEquals(Etapa.COLOCACION_INICIAL, TEG.obtenerEtapa());
        TEG.setearEtapa(Etapa.ATAQUE);
        assertEquals(Etapa.ATAQUE, TEG.obtenerEtapa());
    }

    @Test
    public void test08CambiosDeEtapa(){
        Juego TEG = new Juego();
        assertEquals(Etapa.COLOCACION_INICIAL, TEG.obtenerEtapa());
        TEG.cambiarEtapaDeJuego();
        assertEquals(Etapa.COLOCACION_SECUNDARIA, TEG.obtenerEtapa());
        TEG.cambiarEtapaDeJuego();
        assertEquals(Etapa.ATAQUE, TEG.obtenerEtapa());
        TEG.cambiarEtapaDeJuego();
        assertEquals(Etapa.INCORPORACION_EJERCITOS, TEG.obtenerEtapa());
        TEG.cambiarEtapaDeJuego();
        assertEquals(Etapa.ATAQUE, TEG.obtenerEtapa());
    }

    @Test
    public void test09ColocacionDeEjercitosEnUnPais(){
        Juego TEG = new Juego();
        Jugador unJugador = new Jugador();
        Pais argentina = new Pais("argentina");
        argentina.serOcupadoPor(unJugador);
        TEG.agregarPais(argentina);
        TEG.añadirJugador(unJugador);
        assertEquals(1, argentina.getEjercito().tamanio());
        TEG.colocarEjercitos("argentina", 3);
        assertEquals(4, argentina.getEjercito().tamanio());
    }

    @Test
    public void test10CuandoEmpiezaElJuegoNadieGanoTodavia(){
        Juego TEG = new Juego();
        assertFalse(TEG.getJugadorGano());
    }

    @Test
    public void test11UnJugadorGanoCuandoCumpleSuObjetivo(){
        Juego TEG = new Juego();
        Jugador jugador = new Jugador();
        TEG.añadirJugador(jugador);
        ObjetivoComun objetivoComun = new ObjetivoComun();
        ArrayList<Integer> cantidades = new ArrayList<Integer>();
        cantidades.add(2);
        cantidades.add(0);
        cantidades.add(0);
        cantidades.add(0);
        cantidades.add(0);
        cantidades.add(0);
        ArrayList<Continente> continentes = new ArrayList<Continente>();
        Continente c1 = new Continente("nombre");
        Continente c2 = new Continente("nombre");
        Continente c3 = new Continente("nombre");
        Continente c4 = new Continente("nombre");
        Continente c5 = new Continente("nombre");
        Continente c6 = new Continente("nombre");
        continentes.add(c1);
        continentes.add(c2);
        continentes.add(c3);
        continentes.add(c4);
        continentes.add(c5);
        continentes.add(c6);

        ObjetivoOcupar objetivoOcupar = new ObjetivoOcupar(cantidades, continentes);
        jugador.asignarObjetivoComun(objetivoComun);
        jugador.asignarObjetivoParticular(objetivoOcupar);
        assertFalse(jugador.cumplido());

        Pais unPais = new Pais(jugador);
        Pais otroPais = new Pais(jugador);
        c1.poblarContinente(unPais);
        c1.poblarContinente(otroPais);

        assertTrue(jugador.cumplido());
    }

    @Test
    public void test12JugadorEnTurnoDevuelveDescripcionDeSuObjetivo(){
        Juego TEG = new Juego();

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        TEG.añadirJugador(unJugador);
        TEG.añadirJugador(otroJugador);
        ObjetivoDestruir unObjetivo = new ObjetivoDestruir(unJugador, otroJugador);
        unJugador.setNombre("Ejercito azul");
        otroJugador.setNombre("Ejercito rojo");
        unJugador.asignarObjetivoParticular(unObjetivo);
        String mensaje = "Destruir a jugador: Ejercito azul\n";
        mensaje += "De no ser posible destruir a : Ejercito rojo";

        assertTrue(mensaje.equals(TEG.textoObjetivo()));
    }

    @Test
    public void test13TEGDevuelveElJugadorEnTUrno(){
        Juego TEG = new Juego();
        Jugador unJugador = new Jugador();
        TEG.añadirJugador(unJugador);
        assertEquals(unJugador,TEG.getJugadorEnTurno());
    }

    @Test
    public void test14JugadorCanjeaTarjeta(){
        Juego TEG = new Juego();
        Jugador unJugador = new Jugador();
        TEG.añadirJugador(unJugador);
        Pais argentina = new Pais("argentina");
        argentina.serOcupadoPor(unJugador);
        TarjetaPais tarjetaPais = new TarjetaPais(argentina, "canion");
        assertEquals(1, argentina.getEjercito().tamanio());
        unJugador.recibirTarjetaPais(tarjetaPais);
        TEG.jugadorActivaTarjeta("argentina");
        assertEquals(3, argentina.getEjercito().tamanio());
    }
}
