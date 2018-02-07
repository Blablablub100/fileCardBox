package com.blablablub100.fileCardBox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileCardBox implements Serializable {
    private List<FileCard> fileCards = new ArrayList();
    private Random rng;
    private int lastCard = -1;
    private ReadWriter rw;

    public FileCardBox() {
        rng = new Random();
        rw = new ReadWriter(this);
        FileCardBox readCardBox = rw.readCardBoxData();
        if (readCardBox == null) {
            System.out.println("No save found - creating new cardbox");
            fileCards.add(new FileCard(1, 5, "test", "test"));
        } else {
            System.out.println("Initializing savefile");
            this.fileCards = readCardBox.fileCards;
            this.lastCard = readCardBox.lastCard;
        }
    }


    // requires saving
    public boolean moveCardUp(FileCard card) {
        if (card.getTray() == 5) return false;
        // Typecast because byte + byte = int
        card.setTray((byte) (card.getTray() + 1));
        return true;
    }

    public boolean moveCardDown(FileCard card) {
        if (card.getTray() == 1) return false;
        // Typecast because byte + byte = int
        card.setTray((byte) (card.getTray() - 1));
        return true;
    }

    // no saving required
    public FileCard pickNext() {
        lastCard++; // lastCard turns to current card
        if (lastCard == fileCards.size()) lastCard = 0;
        return (fileCards.get(lastCard));
    }

    public FileCard pickNext(int tray) {
        int temp = lastCard;
        FileCard card;
        do {
            card = pickNext();
            if (lastCard == temp) return null;
        } while (card.getTray() != tray);
        return card;
    }

    public FileCard pickRandom() {
        int size = fileCards.size();
        int index = rng.nextInt(fileCards.size());
        return fileCards.get(index);
    }

    public FileCard pickRandom(byte tray) {
        List<Integer> trayIndexes = new ArrayList();
        for (int i = 0; i < fileCards.size(); i++) {
            if (fileCards.get(i).getTray() == tray) {
                trayIndexes.add(i);
            }
        }
        int index = rng.nextInt(trayIndexes.size()-1);
        return fileCards.get(trayIndexes.get(index));
    }

    public FileCard pickCard(int index) {
        return fileCards.get(index);
    }

    public void saveCardBox() {
        if (rw.writeCardBoxData()) System.out.println("Save successfull");
        else System.out.println("Save unsuccessfull");
    }
}
