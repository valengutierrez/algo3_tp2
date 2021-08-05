package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaActivarTarjeta;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class ControladorBotonActivarTarjeta implements EventHandler<ActionEvent> {

    Juego modelo;
    VistaActivarTarjeta vista;

    public ControladorBotonActivarTarjeta(Juego modelo, VistaActivarTarjeta vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int posicionNombreTarjeta = vista.getChildren().size() - 2;
        TextField nombreTarjetaField = (TextField) vista.getChildren().get(posicionNombreTarjeta);
        String nombreTarjeta = nombreTarjetaField.getText();

        modelo.jugadorActivaTarjeta(nombreTarjeta);
    }
}
