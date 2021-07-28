package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

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

        // Agregar un icono
        Image icon = new Image("icon.png");
        primaryStage.getIcons().add(icon);

        // Pantalla completa
        primaryStage.setFullScreen(true);
        // primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        // primaryStage.setFullScreenExitHint("q para salir de full screen");


        // Agregar Texto
        // Text aText = new Text("Hola TEG");
        // aText.setX(50);
        // aText.setY(50);
        // aText.setFont(Font.font("Verdana",50));
        // aText.setFill(Color.BLACK);
        // root.getChildren().add(aText);
        
        // // Agregar Lineas
        // Line line = new Line();
        // line.setStartX(200);
        // line.setStartY(200);
        // line.setEndX(500);
        // line.setEndY(200);
        // line.setStrokeWidth(5);
        // line.setStroke(Color.RED);
        // line.setOpacity(0.5);
        // root.getChildren().add(line);

        ImageView imageView = new ImageView(icon);
        imageView.setX(400);
        imageView.setY(400);
        root.getChildren().add(imageView);
        
        
        
        Scene s = new Scene(root, width, height,Color.YELLOWGREEN);
        primaryStage.setScene(s);
        primaryStage.show();
    }

}