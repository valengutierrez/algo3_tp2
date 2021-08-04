package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonAccion;
import edu.fiuba.algo3.controlador.ControladorBotonEtapaReagrupar;
import edu.fiuba.algo3.controlador.ControladorPasarTurno;
import edu.fiuba.algo3.modelo.Etapa;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class VistaContenedorOrigenDestino extends VBox implements Observer {

    private Juego modelo;
    private Button botonAccion;
    private Button botonEtapaReagrupar;
    private Button botonPasarTurno;

    public VistaContenedorOrigenDestino(Juego modelo, Node... var1){
        super(var1);
        this.modelo = modelo;
        this.modelo.addObserver(this);
        botonAccion = (Button) getChildren().get(8);
        botonEtapaReagrupar = (Button) getChildren().get(9);
        botonPasarTurno = (Button) getChildren().get(10);
        botonAccion.setOnAction(new ControladorBotonAccion(modelo, this));
        botonPasarTurno.setOnAction(new ControladorPasarTurno(modelo, this));
        botonEtapaReagrupar.setOnAction(new ControladorBotonEtapaReagrupar(modelo, this));
    }

    @Override
    public void update(Observable o, Object arg) {
        //VistaFicha vista = (VistaFicha) arg;
        //String nombrePais = vista.getId();
        botonAccion.setText(modelo.obtenerEtapa().toString());
        if (arg == null) return;

        String nombrePais = (String) arg;

        Label paisOrigen = (Label) getChildren().get(1);
        Label paisDestino = (Label) getChildren().get(3);

        if (nombrePais.equals("fin ataque")) {
            paisOrigen.setText("");
            paisDestino.setText("");
            return;
        }

        if (modelo.obtenerEtapa() == Etapa.INCORPORACION_EJERCITOS) {
            paisOrigen.setText(nombrePais);
            return;
        }

        if (paisOrigen.getText().isEmpty()){
            paisOrigen.setText(nombrePais);
        } else if (paisDestino.getText().isEmpty()){
            paisDestino.setText(nombrePais);
        }
    }
}

