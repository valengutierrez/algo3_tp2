package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
    public static int width;
    public static int height;

    public static void main(String[] args) {
        launch(args);
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

        primaryStage.show();

        Scene s = new Scene(root, width, height);
        primaryStage.setScene(s);
    }
}
