package es.florida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class MemberCreator implements Runnable {

    public void run() {
        crearCorreos();
    }

    public static void crearCorreos() {
        Random rand = new Random();

        try {
            File file = new File("./FicheroCorreos.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            while (true) {
                int rand_int1 = rand.nextInt(10000);
                bw.write(rand_int1 + "@gmail.com\n");
                Thread.sleep(3000);
                bw.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }

}