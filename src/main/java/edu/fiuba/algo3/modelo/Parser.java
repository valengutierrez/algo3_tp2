package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;

public class Parser {
	
	private String filepath;
	private ArrayList<ArrayList<Integer>> values;
	private BufferedReader reader;
	private String line;

	public Parser(String path){
		filepath = path;
		values = new ArrayList<>();
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
}
