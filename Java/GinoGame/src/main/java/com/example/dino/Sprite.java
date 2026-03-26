package com.example.dino;

import javafx.scene.image.Image;

import java.util.Objects;

//Sprite : rappresenta qualsiasi oggetto 2d che vediamo nel gioco
//Deve contenere degli attributi per gestire:
// - posizione: x , y
// - dimensioni su schermo: width , height
// - velocità: vx , vy
// - immagine: Image
//E i metodi:
// - update, aggiorna la posizione in base alla velocità
// - render, disegna l'immagine nella posizione corrente

public class Sprite {
    private double posX;    //Posizione sull'asse X
    private double posY;    //Posizione sull'asse Y
    private int width;      //Larghezza dello schermo
    private int height;     //Altezza dello schermo
    private double vx;      //Velocità orizzontale
    private double vy;      //Velocità verticale
    private String imgPath;
    private Image img;

    public Sprite(double posX, double posY, int width, int height, double vx, double vy, String imgPath) {
        this.posX = width - 24;
        this.posY = height - 24;
        this.width = width;
        this.height = height;
        if(vx > 0 && vy > 0){
            this.vx = vx;       //unita di misura = posX/s
            this.vy = vy;       //unita di misura posY/s
        }
        else System.out.println("La velocita deve essere positiva");
        this.img = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imgPath)));
    }

    public void update(){       //Aggiorna la posizione in base alla velocita
        //prendere velocita ----> attributo dell'oggetto
        //controllo velocità != 0
        //se velocita > 0 aggiorno
        double speedX = this.vx;
        double speedY = this.vy;
        if(speedX != 0) this.posX -= speedX;
    }

    public void setVx(double speed) {
        if(speed >= 24 && speed <= 120) this.vx = speed;
        else System.out.println("La Velocita non rientra nel range accettato");
    }

    public void setVy(double speed) {
        if(speed >= 24 && speed <= 120) this.vy = speed;
        else System.out.println("La Velocita non rientra nel range accettato");
    }


}
