package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorFichaPais;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class VistaFicha extends Button implements Observer{

    protected Juego modelo;
    private String nombre;
    private Map<Color, String> colores = new HashMap<Color, String>() {{
        put(Color.BLUE, "BLUE");
        put(Color.GREEN, "GREEN");
    }};

    public VistaFicha(String id, Juego modelo){
        setId(id);
        nombre = id;
        this.modelo = modelo;
        this.modelo.addObserver(this);
        setOnAction(new ControladorFichaPais(modelo, this));
    }


    @Override
    public void update(Observable o, Object arg) {
        int cantidadFichas = modelo.buscarPais(nombre).getEjercito().tamanio();
        Color color = modelo.buscarPais(nombre).obtenerDuenio().getColor();
        String nombreColor = this.colores.get(color);
        String bstyle=String.format("-fx-text-fill: white;"+
                "-fx-font-size:13;" +
                "-fx-background-radius: 10em; " +
                "-fx-min-width: 25px; " +
                "-fx-min-height: 25px; " +
                "-fx-max-width: 25px; " +
                "-fx-max-height: 25px;" +
                "-fx-background-color: %s;", nombreColor);
        this.setStyle(bstyle);
        this.setText(String.valueOf(cantidadFichas));
    }


}
