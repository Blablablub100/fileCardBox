package com.blablablub100.fileCardBox;

public class MainClass {


    public static void main(String[] args) {
        FileCardBox cardBox = new FileCardBox();
        UI ui = new UI(cardBox);
        ui.printUILoop();
    }
}
