package it.rtonini.javafx.cookieclicker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CookieClicker extends Application {

    private int biscotti = 0;
    private Label label;

    @Override
    public void start(Stage stage) {
        label = new Label("Biscotti: 0");
        label.setFont(Font.font(24));

        Button btn = new Button("Cliccami");
        btn.setFont(Font.font(18));
        btn.setOnAction(e -> onClicca(e));


        Button btn2 = new Button("Cliccami2");
        btn2.setFont(Font.font(18));
        btn2.setOnAction(this::onClicca2);
        btn2.setDisable(true);

        VBox root = new VBox(20);
        root.getChildren().add(label);
        root.getChildren().add(btn);
        root.getChildren().add(btn2);

        root.setAlignment(Pos.CENTER);
        // root.setPadding(new Insets(40));

        stage.setTitle("Cookie Clicker");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    private void onClicca(ActionEvent e) {
        biscotti++;
        label.setText("Biscotti: " + biscotti);
    }

    private void onClicca2(ActionEvent e) {
        System.out.println("Implementami!");
    }




    public static void main(String[] args) {
        launch(args);
    }
}