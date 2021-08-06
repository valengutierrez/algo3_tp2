package edu.fiuba.algo3.modelo;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Jugador {

	private ArrayList<Pais> paisesOcupados;
	private ArrayList<TarjetaPais> mazoJugador;
	private int fichasDisponibles;
	private int fichasMinimas = 3;
	private Color color;
	private String nombre;
	private String nombreColor;
	private Objetivo objetivoParticular;
	private Objetivo objetivoComun;
	private GestorDeCanjes unGestorCanjes;
	

	public Jugador(){
		paisesOcupados = new ArrayList<Pais>();
		mazoJugador = new ArrayList<TarjetaPais>();
		fichasDisponibles = 5;
		// objetivoComun = new ObjetivoComun();
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {return nombre; }

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor(){
		return color;
	}

	public ArrayList<TarjetaPais> obtenerTarjetas(){
		return mazoJugador;
	}

	public void ocupar(Pais unPais) {
		paisesOcupados.add(unPais);
	}

	public ArrayList<Pais> getPaisesOcupados() {
		return paisesOcupados;
	}
	
	public void desocupar(Pais unPais){
		paisesOcupados.remove(unPais);
	}

	public void colocarEjercitos(Pais unPais, int i) {
		if(paisesOcupados.contains(unPais) && fichasDisponibles >= i){
			unPais.incrementarEjercito(i);
			fichasDisponibles -= i;
		}
	}

	public void atacar(Pais paisAtacante, Pais paisAtacado){
		if(paisesOcupados.contains(paisAtacante) && !(paisesOcupados.contains(paisAtacado)))
			paisAtacante.atacar(paisAtacado);
		// Else excepcion?
	}

	public void reagrupar(Pais paisOrigen, Pais paisDestino, int cantidadDeEjercitos){
		if(paisesOcupados.contains(paisOrigen) && paisesOcupados.contains(paisDestino))
			paisOrigen.moverEjercito(paisDestino, cantidadDeEjercitos);
		// Else excepcion?
	}

	public void recibirTarjetaPais(TarjetaPais unaTarjetaPais){
		mazoJugador.add(unaTarjetaPais);
	}

	public int fichasDisponibles(){
		return fichasDisponibles;
	}

	public void fichasPorPais(){
		fichasDisponibles = Math.max(paisesOcupados.size() / 2, fichasMinimas);
	}

	public void incrementarFichasDisponibles(int fichasAIncrementar){
		fichasDisponibles += fichasAIncrementar;
	}

	public void activarTarjeta(String nombreTarjeta) {
		for (TarjetaPais tarjetaPais : mazoJugador){
			if (tarjetaPais.getNombre().equals(nombreTarjeta)) {
				tarjetaPais.activar(paisesOcupados);
			}
		}
	}
	public boolean cumplido() {
		return objetivoComun.cumplido(paisesOcupados)|objetivoParticular.cumplido(paisesOcupados);
	}
	public void asignarObjetivoParticular(Objetivo unObjetivo) {
		objetivoParticular = unObjetivo;
	}
	public void asignarObjetivoComun(Objetivo otroObjetivo) {
		objetivoComun = otroObjetivo;
	}
	public void canjear(String t1, String t2, String t3 ) {
		TarjetaPais tarjeta1,tarjeta2,tarjeta3;
		int fichasDisponiblesInicial = fichasDisponibles;
		tarjeta1 = this.buscarTarjeta(t1);
		tarjeta2 = this.buscarTarjeta(t2);
		tarjeta3 = this.buscarTarjeta(t3);

		fichasDisponibles += unGestorCanjes.canjear(tarjeta1,tarjeta2,tarjeta3);
		if(fichasDisponibles>fichasDisponiblesInicial){
			mazoJugador.remove(tarjeta1);
			mazoJugador.remove(tarjeta2);
			mazoJugador.remove(tarjeta3);
		}
	}
	private TarjetaPais buscarTarjeta(String t1) {
		for (TarjetaPais tarjetaPais : mazoJugador){
			if (tarjetaPais.getNombre().equals(t1)) {
				return tarjetaPais;
			}
		}
		return null;
	}

	public String textoObjetivo() {
		return objetivoParticular.mostrarse();
	}
}
