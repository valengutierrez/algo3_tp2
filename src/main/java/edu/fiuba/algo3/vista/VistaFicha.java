package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorFichaPais;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;

import java.util.Observable;
import java.util.Observer;

public class VistaFicha extends Button implements Observer{

    protected Juego modelo;

    public VistaFicha(String id, Juego modelo){
        setId(id);
        this.modelo = modelo;
        this.modelo.addObserver(this);
        setOnAction(new ControladorFichaPais(modelo, this));
    }


    @Override
    public void update(Observable o, Object arg) {

    }

}
