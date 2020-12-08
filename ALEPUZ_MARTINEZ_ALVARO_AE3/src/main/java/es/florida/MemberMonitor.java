package es.florida;

import java.io.*;

public class MemberMonitor {


    public static String getUltimaLinea(String filePath) {
        String ultima = "";

        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(filePath, "r");
            String readLine = "";
            while ((readLine = raf.readLine()) != null) {
                ultima = readLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (Exception e) {
                }
            }
        }
        return ultima;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(getUltimaLinea("./FicheroCorreos.txt"));
    }
}