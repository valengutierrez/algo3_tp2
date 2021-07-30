package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonAccion;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VistaContenedorOrigenDestino extends VBox implements Observer {

    private Juego modelo;

    public VistaContenedorOrigenDestino(Juego modelo, Node... var1){
        super(var1);
        this.modelo = modelo;
        this.modelo.addObserver(this);
        Button botonAccion = (Button) getChildren().get(4);
        botonAccion.setOnAction(new ControladorBotonAccion(modelo, this));
    }

    @Override
    public void update(Observable o, Object arg) {
        VistaFicha vista = (VistaFicha) arg;
        String nombrePais = vista.getId();

        Label paisOrigen = (Label) getChildren().get(1);
        Label paisDestino = (Label) getChildren().get(3);

        if (paisOrigen.getText().isEmpty()){
            paisOrigen.setText(nombrePais);
        } else if (paisDestino.getText().isEmpty()){
            paisDestino.setText(nombrePais);
        }
    }
}

