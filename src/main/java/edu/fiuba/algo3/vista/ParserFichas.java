package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParserFichas {

    final static String path = "src/main/resources/Coordenadas.csv";

    public static ArrayList<VistaFicha> crearFicha(Juego modelo) {

        ArrayList<VistaFicha> fichas = new ArrayList<VistaFicha>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            String line;
            while((line = reader.readLine())!= null){
                String[] row = line.split(",");

                String nombreFicha = row[0];
                int TraslacionX = Integer.parseInt(row[1]);
                int TraslacionY = Integer.parseInt(row[2]);


                VistaFicha ficha = new VistaFicha(nombreFicha, modelo);
                ficha.setTranslateX(TraslacionX);
                ficha.setTranslateY(TraslacionY);

                fichas.add(ficha);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo " + path + " no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fichas;
    }
}
