package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaFicha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorFichaPais implements EventHandler<ActionEvent> {
    Juego modelo;
    VistaFicha vista;

    public ControladorFichaPais(Juego modelo, VistaFicha vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombrePais = vista.getId();
        modelo.seleccionarPais(nombrePais);
    }
}
