package com.blablablub100.fileCardBox;

import java.lang.reflect.Array;
import java.util.Scanner;

public class UI {
    private FileCardBox cardBox;
    private Scanner sc;

    public UI(FileCardBox cardBox) {
        this.cardBox = cardBox;
    }

    public void printUILoop() {
        sc = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("FileCardBox");
            System.out.println("===========");
            System.out.println("1 - go through 10 random cards");
            System.out.println("2 - go through specific tray");
            System.out.println("3 - go through all cards");
            System.out.println("4 - Display how many cards are in which tray");
            System.out.println("5 - save");
            System.out.println("0 - exit");
            input = sc.nextInt();
            switch(input) {
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2();
                    break;
                case 3:
                    menu3();
                    break;
                case 4:
                    menu4();
                    break;
                case 5:
                    menu5();
                    break;
                default:
                    System.out.println("Invalid Input  \n");
            }
        } while (input != 0);
        cardBox.saveCardBox();
        sc.close();
    }

    private boolean displayCard(FileCard card) {
        if (card == null) return false;
        System.out.println("FileCard |TRAY:"+card.getTray()+" | COUNT:"+card.getCounter()+"|");
        System.out.println("========");
        System.out.println(card.getFront());
        sc.next();
        System.out.println(card.getBack());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Got it right? [y/n]");
        if (sc.next().equals("y")) cardBox.moveCardDown(card);
        else cardBox.moveCardUp(card);
        return true;
    }

    private void menu1() {
        for (int i=0; i < 10; i++) {
            displayCard(cardBox.pickRandom());
        }
        System.out.println("Finished");
        System.out.println("----------------------------------------------------------------");
    }

    private void menu2() {
        int input = 0;
        System.out.println("Type in tray (1-5)");
        input = sc.nextInt();
        while (displayCard(cardBox.pickNext(input)));
        System.out.println("Tray empty");
        System.out.println("----------------------------------------------------------------");

    }

    private void menu3() {
        FileCard temp = cardBox.pickNext();
        FileCard temp2;
        do {
            temp2 = cardBox.pickNext();
            displayCard(temp2);
        } while (!temp.equals(temp2));
        System.out.println("Finished");
        System.out.println("----------------------------------------------------------------");
    }

    private void menu4() {
        // Array for Counting
        int[] cardCount = new int[5];
        for (int i=0; i<5; i++) cardCount[i] = 0;
        // Looping through all Cards
        FileCard temp = cardBox.pickNext();
        FileCard temp2;
        do {
            temp2 = cardBox.pickNext();
            cardCount[temp2.getTray()-1]++;
        } while (!temp.equals(temp2));
        System.out.println("Tray:  \t1\t2\t3\t4\t5");
        System.out.println("Cards: \t"+cardCount[0]+"\t"
                        +cardCount[1]+"\t"
                        +cardCount[2]+"\t"
                        +cardCount[3]+"\t"
                        +cardCount[4]);
    }

    private void menu5() {
        cardBox.saveCardBox();
    }
}
