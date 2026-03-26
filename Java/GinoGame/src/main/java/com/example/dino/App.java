package com.example.dino;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//Vogliamo scrivere delle classi che ci semplificano il lavoro. La prima che vogliamo scrivere è
//Sprite : rappresenta qualsiasi oggetto 2d che vediamo nel gioco
//Deve contenere degli attributi per gestire:
// - posizione: x , y
// - dimensioni su schermo: width , height
// - velocità: vx , vy
// - immagine: Image
//E i metodi:
// - update aggiorna la posizione in base alla velocità
// - render disegna l'immagine nella posizione corrente

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);

        Image img = new Image(getClass().getResourceAsStream("/assets/rocks.png"));
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.rgb(20, 20, 35));
                gc.fillRect(0, 0, 800, 600); // Cancella tutto
                gc.drawImage(img,24,24,24,24,752,276,50,50);
            }
        };
        timer.start();
        System.out.println(timer.toString());
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Gino Roccia");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
