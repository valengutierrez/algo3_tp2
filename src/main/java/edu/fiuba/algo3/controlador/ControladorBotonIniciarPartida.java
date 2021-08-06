package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.VentanaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class ControladorBotonIniciarPartida implements EventHandler<ActionEvent> {
    Juego modelo;
    VentanaJuego vista;
    Map<String, Color> mapaDeJugadores;
    Map<String, Color> mapaDeColores;
    public ControladorBotonIniciarPartida(Juego modelo, VentanaJuego vista){
        this.modelo = modelo;
        this.vista = vista;
        mapaDeJugadores = new HashMap<>();
        mapaDeColores = new HashMap<>();
        mapaDeColores.put( "Azul", Color.BLUE);
        mapaDeColores.put( "Rojo", Color.RED);
        mapaDeColores.put( "Amarillo", Color.YELLOW);
        mapaDeColores.put( "Verde", Color.GREEN);
        mapaDeColores.put( "Rosa", Color.PINK);
        mapaDeColores.put( "Negro", Color.BLACK);

    }

    @Override
    public void handle(ActionEvent actionEvent){
        VBox listaDeJugadoresInicial = vista.getJugadores();
        for (int i = 0; i < 6; i ++) {
            HBox fila = (HBox) listaDeJugadoresInicial.getChildren().get(i);
            TextField nombre = (TextField) fila.getChildren().get(0);
            String nombreDelJugador = nombre.getText();
            if(nombreDelJugador == "")
                continue;
            for (int j = 1; j < 7; j ++) {
                RadioButton boton = (RadioButton) fila.getChildren().get(j);
                if(boton.isSelected()){
                    mapaDeJugadores.put(nombreDelJugador, mapaDeColores.get(boton.getText()));
                }
            }
        }
        modelo.crearModelo(mapaDeJugadores);

    }
}

