package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.paint.Color;

// TODO: < REFACTOR > Usar polimorfismo
public class Parser {
	
	private String filepath;
	private ArrayList<ArrayList<Integer>> values;
	private ArrayList<String[]> valuesPais;
	private ArrayList<String[]> valuesFronteras;
	private ArrayList<Color> valuesColores;
	private HashMap<String,Color> dictJugadores;
	private BufferedReader reader;
	private String line;

	public Parser(String path){
		filepath = path;
		values = new ArrayList<>();
		valuesPais = new ArrayList<>();
		valuesFronteras = new ArrayList<>();
		valuesColores = new ArrayList<Color>();
		line = "";
	}
	public ArrayList<ArrayList<Integer>> parse() {

		try {
			reader = new BufferedReader(new FileReader(filepath));
			reader.readLine();
			while((line = reader.readLine())!= null){
				ArrayList<Integer> data = new ArrayList<Integer>();
				String[] row = line.split(",");
				for(String i : row){
					data.add(Integer.parseInt(i));
				}
				values.add(data);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Archivo " + filepath + " no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return values;
	}
	
	public ArrayList<String[]> parsePaises() {
		try {
			String[] row;
			reader = new BufferedReader(new FileReader(filepath));
			reader.readLine();
			while((line = reader.readLine())!= null){
				row = line.split(",");
				valuesPais.add(row);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Archivo " + filepath + " no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valuesPais;
	}

	public ArrayList<String[]> parseFronteras() {
		try {
			String[] row;
			reader = new BufferedReader(new FileReader(filepath));
			reader.readLine();
			while((line = reader.readLine())!= null){
				row = line.split(",");
				valuesFronteras.add(row);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Archivo " + filepath + " no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valuesFronteras;
	}
	public ArrayList<Color> parseJugadores() {
		dictJugadores = new HashMap<String,Color>();
		dictJugadores.put("azul",Color.BLUE);
		dictJugadores.put("rojo",Color.RED);
		dictJugadores.put("negro",Color.BLACK);
		dictJugadores.put("amarillo",Color.YELLOW);
		dictJugadores.put("verde",Color.GREEN);
		dictJugadores.put("rosa",Color.PINK);
		try {
			reader = new BufferedReader(new FileReader(filepath));
			reader.readLine();
			while((line = reader.readLine())!= null){
				valuesColores.add(dictJugadores.get(line));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Archivo " + filepath + " no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valuesColores;
	}
}
