package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.TarjetaPais;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaActivarTarjeta extends VBox {

    private Juego modelo;
    private TextField fichasDisponibles;

    public VistaActivarTarjeta(Juego modelo, TextField fichasDisponibles){
        this.modelo = modelo;
        this.fichasDisponibles = fichasDisponibles;
        VBox contenedorTarjetas = new VBox();
        Label labelTarjetas = new Label("tarjetas:");
        this.getChildren().add(labelTarjetas);
        for (TarjetaPais tarjetaPais : modelo.getJugadorEnTurno().obtenerTarjetas()){
            String nombreTarjeta = tarjetaPais.getNombre();
            String simbolo = tarjetaPais.getSimbolo();

            CheckBox tarjetaCheck = new CheckBox();
            tarjetaCheck.setText(nombreTarjeta + " - " + simbolo);
            contenedorTarjetas.getChildren().add(tarjetaCheck);
        }
        this.getChildren().add(contenedorTarjetas);

        Button botonActviarTarjeta = new Button();
        botonActviarTarjeta.setOnAction(new ControladorBotonActivarTarjeta(modelo, this));
        botonActviarTarjeta.setText("Activar");

        Button botonCanjearTarjetas = new Button();
        botonCanjearTarjetas.setOnAction(new ControladorBotonCanjearTarjetas(modelo, this));
        botonCanjearTarjetas.setText("Canjear");

        this.getChildren().add(botonActviarTarjeta);
        this.getChildren().add(botonCanjearTarjetas);
    }

    public void actualizaFichasDisponibles(String cantidadFichas){
        fichasDisponibles.setText(cantidadFichas);
    }
}
