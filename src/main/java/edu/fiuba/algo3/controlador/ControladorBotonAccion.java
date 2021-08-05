package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaContenedorOrigenDestino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

        System.out.println(modelo.obtenerEtapa());
        switch (modelo.obtenerEtapa()){
            case ATAQUE: {
                if (!PaisOrigen.isEmpty() && !PaisDestino.isEmpty()){
                    modelo.jugadorEnTurnoAtaca(PaisOrigen, PaisDestino);
                }
                return;
            }
            case REAGRUPACION: {
                if (!PaisOrigen.isEmpty() && !PaisDestino.isEmpty()){
                    TextField ejercitosText = (TextField) vista.getChildren().get(7);
                    int cantidadEjercitos = Integer.parseInt(ejercitosText.getText());
                    modelo.reagrupar(PaisOrigen, PaisDestino, cantidadEjercitos);
                }
                return;
            }
            case INCORPORACION_EJERCITOS: {
                if (!PaisOrigen.isEmpty()){
                    TextField ejercitosText = (TextField) vista.getChildren().get(7);
                    int cantidadEjercitos = Integer.parseInt(ejercitosText.getText());
                    modelo.colocarEjercitos(PaisOrigen, cantidadEjercitos);
                    System.out.println("-------------ControladorBotonAccion----------");
                    int fichasDisponibles = modelo.fichasDisponiblesJugador();
                    TextField fichasDisponiblesField = (TextField) vista.getChildren().get(5);
                    fichasDisponiblesField.setText(String.valueOf(fichasDisponibles));
                }
            }
        }


    }
}
