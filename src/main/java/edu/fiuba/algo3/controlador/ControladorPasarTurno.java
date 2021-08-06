package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Etapa;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorPasarTurno implements EventHandler<ActionEvent> {
    Juego modelo;
    VistaContenedorOrigenDestino vista;

    public ControladorPasarTurno(Juego modelo, VistaContenedorOrigenDestino vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.pasarTurno();
        if (modelo.obtenerEtapa() == Etapa.INCORPORACION_EJERCITOS || modelo.obtenerEtapa() == Etapa.COLOCACION_INICIAL){
            System.out.println("-------------ControladorPasarTurno----------");
            int fichasDisponibles = modelo.fichasDisponiblesJugador();
            TextField fichasDisponiblesField = (TextField) vista.getChildren().get(5);
            fichasDisponiblesField.setText(String.valueOf(fichasDisponibles));
        }
        TextArea textoObjetivo = (TextArea) vista.getChildren().get(12);
        textoObjetivo.setText(modelo.textoObjetivo());
    }
}
