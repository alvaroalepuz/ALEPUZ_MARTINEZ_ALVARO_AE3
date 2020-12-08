package es.florida;

import java.util.ArrayList;
import java.io.*;

public class MailSender implements Runnable {

    public void run() {
        guardarCorreos(MemberMonitor.getUltimaLinea("./FicheroCorreos.txt"));
    }

    public static void guardarCorreos(String lastMail) {
        ArrayList<String> lineas = new ArrayList<String>();
        File archivo = null;
        FileReader fr = null;
        try {

            archivo = new File("./FicheroCorreos.txt");
            String linea;
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            for (int j = 0; j < lineas.size(); j++) {
                linea = lineas.get(j);
                System.out.print("Al correo" + linea + " Se le ha enviado: Se a añadido el correo " + lastMail + "\n");
            }

        }//FIN DEL TRY
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

    }
}
