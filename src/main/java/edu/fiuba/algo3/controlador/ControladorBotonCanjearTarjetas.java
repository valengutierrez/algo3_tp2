package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaActivarTarjeta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ControladorBotonCanjearTarjetas implements EventHandler<ActionEvent> {

    Juego modelo;
    VistaActivarTarjeta vista;

    public ControladorBotonCanjearTarjetas(Juego modelo, VistaActivarTarjeta vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int posicionContenedorTarjetas = vista.getChildren().size() - 3;

        VBox contenedorTarjetas = (VBox) vista.getChildren().get(posicionContenedorTarjetas);
        String[] tarjetasSeleccionadas = new String[3];
        int contador = 0;

        for (Node nodo : contenedorTarjetas.getChildren()){
            CheckBox tarjeta = (CheckBox) nodo;
            if (tarjeta.isSelected()){
                String[] infoTarjeta = tarjeta.getText().split(" - ");
                String nombreTarjeta = infoTarjeta[0];
                tarjetasSeleccionadas[contador] = nombreTarjeta;
                contador++;
            }
        }
        if (contador != 3) return;

        modelo.jugadorEnTurnoCanjea(tarjetasSeleccionadas[0], tarjetasSeleccionadas[1], tarjetasSeleccionadas[2]);
        int fichasDisponibles = modelo.fichasDisponiblesJugador();
        vista.actualizaFichasDisponibles(String.valueOf(fichasDisponibles));
    }
}
