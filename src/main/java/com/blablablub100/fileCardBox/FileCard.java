package com.blablablub100.fileCardBox;

public class FileCard {

    private byte complexity;
    private byte tray;
    private String front;
    private String back;
    private int counter;

    public FileCard(byte complexity, byte tray, String front, String back) {
        this.complexity = complexity;
        this.tray = tray;
        this.front = front;
        this.back = back;
        counter = 0;
    }

    // getters and setters

    public byte getComplexity() {
        return complexity;
    }

    public void setComplexity(byte complexity) {
        this.complexity = complexity;
    }

    public byte getTray() {
        return tray;
    }

    public void setTray(byte tray) {
        this.tray = tray;
    }

    public String getFront() {
        counter++;
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getCounter() {
        return counter;
    }
}
