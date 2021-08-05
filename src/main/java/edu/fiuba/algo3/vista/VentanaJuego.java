package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VentanaJuego {
    public static void crearVentana(Stage primaryStage, Juego modelo){
        primaryStage.setTitle("AlgoTEG");
        Image icon = new Image("tableroTEG.png");
        primaryStage.getIcons().add(icon);
        ImageView imageView = new ImageView(icon);

        VistaFicha fichaCanada = new VistaFicha("canada", modelo);
        fichaCanada.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 20px; " +
                        "-fx-min-height: 20px; " +
                        "-fx-max-width: 20px; " +
                        "-fx-max-height: 20px;" +
                        "-fx-background-color: RED"
        );

        VistaFicha fichaArgentina = new VistaFicha("argentina", modelo);
        fichaArgentina.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 20px; " +
                        "-fx-min-height: 20px; " +
                        "-fx-max-width: 20px; " +
                        "-fx-max-height: 20px;" +
                        "-fx-background-color: BLUE"
        );
        VistaFicha fichaBrasil = new VistaFicha("brasil", modelo);
        fichaBrasil.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 20px; " +
                        "-fx-min-height: 20px; " +
                        "-fx-max-width: 20px; " +
                        "-fx-max-height: 20px;" +
                        "-fx-background-color: GREEN"
        );


        StackPane mapaMundo = new StackPane();
        mapaMundo.getChildren().addAll(imageView, fichaArgentina, fichaBrasil, fichaCanada);
        mapaMundo.getChildren().get(1).setTranslateX(-130);
        mapaMundo.getChildren().get(1).setTranslateY(150);
        mapaMundo.getChildren().get(2).setTranslateX(-100);
        mapaMundo.getChildren().get(2).setTranslateY(100);
        mapaMundo.getChildren().get(3).setTranslateX(-290);
        mapaMundo.getChildren().get(3).setTranslateY(-165);

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
        fichasDisponibles.setText("50");
        fichasDisponibles.setMaxWidth(30);
        TextField cantidadFichas = new TextField();
        cantidadFichas.setMaxWidth(30);

        Button botonAccion = new Button();
        botonAccion.setText("Atacar!");

        Button botonEtapaReagrupar = new Button();
        botonEtapaReagrupar.setText("Etapa Reagrupar");

        Button botonPasarTurno = new Button();
        botonPasarTurno.setText("Pasar Turno");

        //fichaArgentina.setOnAction(new ControladorFichaPais(modelo));

        VBox tarjetasJugador = new VBox();

        VistaContenedorOrigenDestino contenedorOrigenDestino = new VistaContenedorOrigenDestino(modelo, origen, paisOrigen, destino, paisDestino, fichasDisponiblesLabel, fichasDisponibles, cantidadFichasLabel, cantidadFichas, botonAccion, botonEtapaReagrupar, botonPasarTurno);
        contenedorOrigenDestino.setAlignment(Pos.BASELINE_CENTER);

        HBox contenedorPrincipal = new HBox(mapaMundo, contenedorOrigenDestino);
        contenedorPrincipal.getChildren().get(1).setTranslateX(150);

        Scene escena = new Scene(contenedorPrincipal, 1280, 720);

        primaryStage.setScene(escena);
        primaryStage.sizeToScene();
    }
}

