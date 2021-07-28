package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.TarjetaPais;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {

    public static int width;
    public static int height;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {


        // Instanciar ventana del juego
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        width = ((int) (primaryScreenBounds.getWidth() / 32)) * 32;
        height = ((int) (primaryScreenBounds.getHeight() / 32) - 1) * 32;
        primaryStage.setTitle("AlgoTEG");
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);

        Group root = new Group();
        root.autoSizeChildrenProperty();



        // Pantalla completa
        primaryStage.setFullScreen(false);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        // primaryStage.setFullScreenExitHint("q para salir de full screen");


        // Agregar Texto
        // Text aText = new Text("Hola TEG");
        // aText.setX(50);
        // aText.setY(50);
        // aText.setFont(Font.font("Verdana",50));
        // aText.setFill(Color.BLACK);
        // root.getChildren().add(aText);




        // Agregar un icono
        Image icon = new Image("icon.png");
        primaryStage.getIcons().add(icon);


        ImageView imageView = new ImageView(icon);
        imageView.setX(0);
        imageView.setY(0);
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());
        imageView.fitWidthProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(imageView);

        Rectangle ataqueRect = new Rectangle(100,100);
        //ataqueRect.setX(imageView.getFitWidth()-ataqueRect.getWidth());
        //ataqueRect.setY(imageView.getFitHeight()-ataqueRect.getHeight());
        //ataqueRect.setX();

        //Drawing a Circle
        Circle circleCanada = new Circle();
        //Setting the position of the circle
        circleCanada.setCenterX(200.0f);
        circleCanada.setCenterY(300);
        //Setting the radius of the circle
        circleCanada.setRadius(25.0f);
        //Setting the color of the circle
        circleCanada.setFill(Color.BROWN);
        //Setting the stroke width of the circle
        circleCanada.setStrokeWidth(20);
        root.getChildren().add(circleCanada);

        Circle circleArgentina = new Circle();
        //Setting the position of the circle
        circleArgentina.setCenterX(300.0f);
        circleArgentina.setCenterY(800);
        //Setting the radius of the circle
        circleArgentina.setRadius(25.0f);
        //Setting the color of the circle
        circleArgentina.setFill(Color.BROWN);
        //Setting the stroke width of the circle
        circleArgentina.setStrokeWidth(20);
        root.getChildren().add(circleArgentina);

        Circle circleBrasil = new Circle();
        //Setting the position of the circle
        circleBrasil.setCenterX(400.0f);
        circleBrasil.setCenterY(800);
        //Setting the radius of the circle
        circleBrasil.setRadius(25.0f);
        //Setting the color of the circle
        circleBrasil.setFill(Color.BROWN);
        //Setting the stroke width of the circle
        circleBrasil.setStrokeWidth(20);
        root.getChildren().add(circleBrasil);
        circleArgentina.setId("Argentina");
        circleCanada.setId("Canada");
        circleBrasil.setId("Brasil");
        System.out.println(circleCanada.getId());
        System.out.println(circleArgentina.getId());
        System.out.println(circleBrasil.getId());



        Map<String, String> paises = new HashMap<String, String>();


        paises.put(circleCanada.getId(), "Canada");
        paises.put(circleArgentina.getId(), "Argentina");
        paises.put(circleBrasil.getId(), "Brasil");

        Text textCanada = new Text("Canada");
        root.getChildren().add(textCanada);

        //Setting the font of the text
        textCanada.setFont(Font.font(null, FontWeight.BOLD, 15));

        //Setting the color of the text
        textCanada.setFill(Color.BLUE);

        //setting the position of the text
        textCanada.setX(200);
        textCanada.setY(300);
        /////////////////////////////////////////
        Text textOrigen = new Text();
        textOrigen.setX(1100);
        textOrigen.setY(1000);
        //Setting the font of the text
        textOrigen.setFont(Font.font(null, FontWeight.BOLD, 15));
        //Setting the color of the text
        //textOrigen.setFill(Color.BLUE);
        root.getChildren().add(textOrigen);
        ////////////////////////////////////////
        Text textDestino = new Text();
        textDestino.setX(1200);
        textDestino.setY(1000);
        //Setting the font of the text
        textDestino.setFont(Font.font(null, FontWeight.BOLD, 15));

        //Setting the color of the text
        //textOrigen.setFill(Color.BLUE);
        root.getChildren().add(textDestino);
        ////////////////////////////
        root.getChildren().add(ataqueRect);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Inicializacion del juego

        Juego TEG = new Juego();
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorVerde = new Jugador();

        TEG.añadirJugador(jugadorAzul);
        TEG.añadirJugador(jugadorVerde);

        Pais argentina = new Pais(jugadorAzul);
        TarjetaPais tarjetaArgentina = new TarjetaPais(argentina, "globo");
        argentina.incrementarEjercito(9);

        Pais brasil = new Pais(jugadorVerde);
        TarjetaPais tarjetaBrasil = new TarjetaPais(brasil, "canion");
        Pais canada = new Pais(jugadorVerde);
        TarjetaPais tarjetaChile = new TarjetaPais(canada, "barco");

        Map<String, Pais> mapaDePaises = new HashMap<>();
        mapaDePaises.put(circleBrasil.getId(), brasil);
        mapaDePaises.put(circleBrasil.getId(), argentina);
        mapaDePaises.put(circleBrasil.getId(), canada);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Manejo de eventos


        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
                imageView.setImage(new Image("tableroTEG.png"));
            }
        };
        //Creating the mouse event handler
        EventHandler<MouseEvent> circleCanadaEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //textOrigen.setText(String.valueOf(Integer.parseInt(textO.getText())+1));
                if(textOrigen.getText().length() == 0)
                    textOrigen.setText(paises.get(circleCanada.getId()));
                else
                    textDestino.setText(paises.get(circleCanada.getId()));
                System.out.println(paises.get(circleCanada.getId()));
            }
        };
        circleCanada.addEventFilter(MouseEvent.MOUSE_CLICKED, circleCanadaEventHandler);

        //Creating the mouse event handler
        EventHandler<MouseEvent> circleArgentinaEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //textOrigen.setText(String.valueOf(Integer.parseInt(textO.getText())+1));
                if(textOrigen.getText().length() == 0)
                    textOrigen.setText(paises.get(circleArgentina.getId()));
                else
                    textDestino.setText(paises.get(circleArgentina.getId()));

                System.out.println(paises.get(circleArgentina.getId()));
            }
        };
        circleArgentina.addEventFilter(MouseEvent.MOUSE_CLICKED, circleArgentinaEventHandler);


        //Creating the mouse event handler
        EventHandler<MouseEvent> circleBrasilEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //textOrigen.setText(String.valueOf(Integer.parseInt(textO.getText())+1));
                if(textOrigen.getText().length() == 0)
                    textOrigen.setText(paises.get(circleBrasil.getId()));
                else
                    textDestino.setText(paises.get(circleBrasil.getId()));

                System.out.println(paises.get(circleBrasil.getId()));
            }
        };
        circleBrasil.addEventFilter(MouseEvent.MOUSE_CLICKED, circleBrasilEventHandler);

        //Creating the mouse event handler
        EventHandler<MouseEvent> ataqueEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                //textOrigen.setText(String.valueOf(Integer.parseInt(textO.getText())+1));
                if(textOrigen.getText().length() != 0 && textDestino.getText().length() != 0) {
                    System.out.println("Se ataco desde" + textOrigen.getText() + "hacia" + textDestino.getText());
                    textOrigen.setText("");
                    textDestino.setText("");
                }
            }
        };
        ataqueRect.addEventFilter(MouseEvent.MOUSE_CLICKED, ataqueEventHandler);

        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        Scene s = new Scene(root, width, height,Color.IVORY);
        primaryStage.setScene(s);
        primaryStage.show();
    }

}