package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Etapa;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonEtapaReagrupar implements EventHandler<ActionEvent> {
    Juego modelo;
    VistaContenedorOrigenDestino vista;

    public ControladorBotonEtapaReagrupar(Juego modelo, VistaContenedorOrigenDestino vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        modelo.setearEtapa(Etapa.REAGRUPACION);
    }
}
