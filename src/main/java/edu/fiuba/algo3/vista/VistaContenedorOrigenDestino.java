package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonAccion;
import edu.fiuba.algo3.controlador.ControladorBotonEtapaReagrupar;
import edu.fiuba.algo3.controlador.ControladorPasarTurno;
import edu.fiuba.algo3.modelo.Etapa;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.TarjetaPais;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class VistaContenedorOrigenDestino extends VBox implements Observer {

    private Juego modelo;
    private Button botonAccion;
    private Button botonEtapaReagrupar;
    private Button botonPasarTurno;
    //private Map<String, String> coloresDeJugadores;
    VistaActivarTarjeta contenedorTarjetas;

    public VistaContenedorOrigenDestino(Juego modelo, Node... var1){
        super(var1);
        this.modelo = modelo;
        this.modelo.addObserver(this);
        botonAccion = (Button) getChildren().get(8);
        botonEtapaReagrupar = (Button) getChildren().get(9);
        botonPasarTurno = (Button) getChildren().get(10);
        botonAccion.setOnAction(new ControladorBotonAccion(modelo, this));
        botonPasarTurno.setOnAction(new ControladorPasarTurno(modelo, this));
        botonEtapaReagrupar.setOnAction(new ControladorBotonEtapaReagrupar(modelo, this));
        botonEtapaReagrupar.setDisable(true);
        //coloresDeJugadores = new HashMap<>();
        //coloresDeJugadores.put("0x008000ff", "Verde");
        //coloresDeJugadores.put("0x0000ffff", "Azul");
        actualizarTarjetas();
        actualizarJugadorEnTurno();
        actualizarObjetivo();
        //Label labelJugadorEnTurno = (Label) getChildren().get(11);
        //Jugador jugadorEnTurno = modelo.turnoDe();
        //labelJugadorEnTurno.setText("Turno de jugador " + (jugadorEnTurno.getNombre()));
    }

    @Override
    public void update(Observable o, Object arg) {

        if (modelo.getJugadorGano()) {
            this.getChildren().remove(0, this.getChildren().size());
            Label victoria = new Label();
            Jugador ganador = modelo.getJugadorEnTurno();
            victoria.setText("Ganador: " + ganador.getNombre());
            this.getChildren().add(victoria);
            return;
        }

        botonAccion.setText(modelo.obtenerEtapa().toString());
        botonEtapaReagrupar.setDisable(modelo.obtenerEtapa() != Etapa.ATAQUE);
        actualizarObjetivo();
        if (this.getChildren().size() == 14){
            this.getChildren().remove(13);
            actualizarTarjetas();
        }

        if (arg == null) return;

        String nombrePais = (String) arg;

        Label paisOrigen = (Label) getChildren().get(1);
        Label paisDestino = (Label) getChildren().get(3);
        TextField cantidadFichasSeleccionadas = (TextField) getChildren().get(7);

        actualizarJugadorEnTurno();
        //Label labelJugadorEnTurno = (Label) getChildren().get(11);
        //Jugador jugadorEnTurno = modelo.turnoDe();
        //labelJugadorEnTurno.setText("Turno de jugador " + (jugadorEnTurno.getNombre()));

        if (nombrePais.equals("borrar paises")) {
            paisOrigen.setText("");
            paisDestino.setText("");
            cantidadFichasSeleccionadas.setText("");
            return;
        }

        if (modelo.obtenerEtapa() == Etapa.INCORPORACION_EJERCITOS || modelo.obtenerEtapa() == Etapa.COLOCACION_INICIAL) {
            paisOrigen.setText(nombrePais);
            return;
        }

        if (paisOrigen.getText().isEmpty()){
            paisOrigen.setText(nombrePais);
        } else if (paisDestino.getText().isEmpty()){
            paisDestino.setText(nombrePais);
        }


    }

    private void actualizarTarjetas(){
        contenedorTarjetas = new VistaActivarTarjeta(modelo);
        Button boton = (Button) contenedorTarjetas.getChildren().get(contenedorTarjetas.getChildren().size()-1);
        boton.setDisable(modelo.obtenerEtapa() != Etapa.INCORPORACION_EJERCITOS);
        this.getChildren().add(contenedorTarjetas);
    }

    private void actualizarJugadorEnTurno(){
        Label labelJugadorEnTurno = (Label) getChildren().get(11);
        Jugador jugadorEnTurno = modelo.turnoDe();
        labelJugadorEnTurno.setText("Turno de jugador " + (jugadorEnTurno.getNombre()));
        labelJugadorEnTurno.setTextFill(jugadorEnTurno.getColor());
    }


    private void actualizarObjetivo(){
        TextArea objetivo = (TextArea) getChildren().get(12);
        Jugador jugadorEnTurno = modelo.turnoDe();
        objetivo.setText(modelo.textoObjetivo());
    }

}

