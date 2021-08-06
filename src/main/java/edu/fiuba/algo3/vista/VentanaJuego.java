package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonIniciarPartida;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.*;


public class VentanaJuego implements Observer {
    Stage stage;
    Scene escena;
    Juego modelo;
    VBox jugadores = new VBox();

    public VentanaJuego(Stage primaryStage, Juego modelo){
        this.stage = primaryStage;
        this.modelo = modelo;
        this.modelo.addObserver(this);
        primaryStage.setTitle("AlgoTEG");
        Image icon = new Image("icon.png");
        primaryStage.getIcons().add(icon);
        ImageView imageView = new ImageView(icon);

        Map<String, Color> listaJugadores = new HashMap<>();
        for (int i = 0; i < 6; i ++) {
            TextField nombreJugador = new TextField();

            ToggleGroup grupoColores = new ToggleGroup();

            RadioButton botonColorAzul = new RadioButton();
            RadioButton botonColorRojo = new RadioButton();
            RadioButton botonColorAmarillo = new RadioButton();
            RadioButton botonColorVerde = new RadioButton();
            RadioButton botonColorRosa = new RadioButton();
            RadioButton botonColorNegro = new RadioButton();

            botonColorAzul.setText("Azul");
            botonColorRojo.setText("Rojo");
            botonColorAmarillo.setText("Amarillo");
            botonColorVerde.setText("Verde");
            botonColorRosa.setText("Rosa");
            botonColorNegro.setText("Negro");

            botonColorAzul.setToggleGroup(grupoColores);
            botonColorRojo.setToggleGroup(grupoColores);
            botonColorAmarillo.setToggleGroup(grupoColores);
            botonColorVerde.setToggleGroup(grupoColores);
            botonColorRosa.setToggleGroup(grupoColores);
            botonColorNegro.setToggleGroup(grupoColores);

            HBox jugador = new HBox();

            jugador.getChildren().add(nombreJugador);
            jugador.getChildren().add(botonColorAzul);
            jugador.getChildren().add(botonColorRojo);
            jugador.getChildren().add(botonColorAmarillo);
            jugador.getChildren().add(botonColorVerde);
            jugador.getChildren().add(botonColorRosa);
            jugador.getChildren().add(botonColorNegro);

            jugador.setAlignment(Pos.CENTER);
            jugadores.getChildren().add(jugador);
        }

        Button botonIniciarPartida = new Button();
        botonIniciarPartida.setText("Iniciar partida");
        botonIniciarPartida.setOnAction(new ControladorBotonIniciarPartida(modelo, this));
        jugadores.getChildren().add(botonIniciarPartida);

        jugadores.setAlignment(Pos.CENTER);

        HBox contenedorPrincipal = new HBox(imageView);
        escena = new Scene(jugadores,1280, 720);
        primaryStage.setScene(escena);
        primaryStage.sizeToScene();
    }

    public VBox getJugadores(){
        return jugadores;
    }

    @Override
    public void update(Observable o, Object arg){
        if(arg == null)
            return;
        String argumento = (String) arg;
        if(!argumento.equals("iniciar partida"))
            return;
        Image icon = new Image("tableroTEG.png");
        stage.getIcons().add(icon);
        ImageView imageView = new ImageView(icon);
        ArrayList<VistaFicha> fichas = ParserFichas.crearFicha(modelo);

        StackPane mapaMundo = new StackPane();
        mapaMundo.getChildren().add(imageView);

        for (VistaFicha ficha : fichas) {
            mapaMundo.getChildren().add(ficha);
        }

        Label origen = new Label();
        origen.setText("Pais origen: ");

        Label destino = new Label();
        destino.setText("Pais destino: ");

        Label paisOrigen = new Label();
        Label paisDestino = new Label();

        Label fichasDisponiblesLabel = new Label();
        fichasDisponiblesLabel.setText("Fichas Disponibles: ");
        Label cantidadFichasLabel = new Label();
        cantidadFichasLabel.setText("Cantidad de Fichas: ");

        TextField fichasDisponibles = new TextField();
        fichasDisponibles.setEditable(false);
        fichasDisponibles.setText("5");
        fichasDisponibles.setMaxWidth(30);
        TextField cantidadFichas = new TextField();
        cantidadFichas.setMaxWidth(30);

        Button botonAccion = new Button();
        botonAccion.setText("Colocar");

        Button botonEtapaReagrupar = new Button();
        botonEtapaReagrupar.setText("Etapa Reagrupar");

        Button botonPasarTurno = new Button();
        botonPasarTurno.setText("Pasar Turno");

        Label jugadorEnTurno = new Label();

        TextArea objetivo = new TextArea();
        objetivo.setEditable(false);
        objetivo.setWrapText(true);
        objetivo.setMaxWidth(200);

        VistaContenedorOrigenDestino contenedorOrigenDestino = new VistaContenedorOrigenDestino(
                modelo, origen, paisOrigen, destino, paisDestino,
                fichasDisponiblesLabel, fichasDisponibles, cantidadFichasLabel, cantidadFichas, botonAccion,
                botonEtapaReagrupar, botonPasarTurno, jugadorEnTurno, objetivo);

        contenedorOrigenDestino.setAlignment(Pos.TOP_CENTER);

        HBox contenedorPrincipal = new HBox(mapaMundo, contenedorOrigenDestino);
        contenedorPrincipal.getChildren().get(1).setTranslateX(100);

        Scene escena = new Scene(contenedorPrincipal, 1280, 720);

        stage.setScene(escena);
        stage.sizeToScene();
    }
}

