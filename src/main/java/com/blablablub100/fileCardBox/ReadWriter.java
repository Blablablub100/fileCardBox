package com.blablablub100.fileCardBox;

import java.io.*;

public class ReadWriter implements Serializable {

    FileCardBox cardBox;

    public ReadWriter(FileCardBox cardBox) {
        this.cardBox = cardBox;
    }
    
    public FileCardBox readCardBoxData() {
        FileCardBox result = null;
        try {
            FileInputStream fis = new FileInputStream("FileCardBox.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (FileCardBox) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean writeCardBoxData() {
        try {
            FileOutputStream fos = new FileOutputStream("FileCardBox.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cardBox);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
