package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonAccion;
import edu.fiuba.algo3.controlador.ControladorBotonActivarTarjeta;
import edu.fiuba.algo3.controlador.ControladorBotonEtapaReagrupar;
import edu.fiuba.algo3.controlador.ControladorPasarTurno;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.TarjetaPais;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VistaActivarTarjeta extends VBox {

    private Juego modelo;

    public VistaActivarTarjeta(Juego modelo){
        this.modelo = modelo;
        Label labelTarjetas = new Label("tarjetas:");
        this.getChildren().add(labelTarjetas);
        for (TarjetaPais tarjetaPais : modelo.getJugadorEnTurno().obtenerTarjetas()){
            String nombreTarjeta = tarjetaPais.getNombre();
            String simbolo = tarjetaPais.getSimbolo();

            Label tarjeta = new Label(nombreTarjeta + " " + simbolo);
            this.getChildren().add(tarjeta);
        }
        TextField tarjetaSeleccionada = new TextField();
        tarjetaSeleccionada.setText("Ingrese tarjeta");

        Button botonActviarTarjeta = new Button();
        botonActviarTarjeta.setOnAction(new ControladorBotonActivarTarjeta(modelo, this));
        botonActviarTarjeta.setText("Activar");

        this.getChildren().add(tarjetaSeleccionada);
        this.getChildren().add(botonActviarTarjeta);
    }


}
