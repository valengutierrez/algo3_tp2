package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ControladorBotonAccion implements EventHandler<ActionEvent> {

    Juego modelo;
    VistaContenedorOrigenDestino vista;

    public ControladorBotonAccion(Juego modelo, VistaContenedorOrigenDestino vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Label labelOrigen = (Label) vista.getChildren().get(1);
        String PaisOrigen = labelOrigen.getText();
        Label labelDestino = (Label) vista.getChildren().get(3);
        String PaisDestino = labelDestino.getText();

        if (!(PaisOrigen.isEmpty() && PaisDestino.isEmpty())) {
            modelo.jugadorEnTurnoAtaca(PaisOrigen, PaisDestino);
        }
        //modelo.notifyObservers(vista);
    }
}
