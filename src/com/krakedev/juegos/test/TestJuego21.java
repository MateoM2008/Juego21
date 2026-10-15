package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

	public static void main(String[] args) {
		Juego21 j21=new Juego21();
		
		Jugador j1=new Jugador("Calos");
		Jugador j2=new Jugador("Maria");
		Jugador j3=new Jugador("Ana");
		
		j21.agregarJugador(j1);
		j21.agregarJugador(j2);
		j21.agregarJugador(j3);
		ArrayList<Jugador> ganadores=new ArrayList<Jugador>();
		for(int i=0;i<10;i++) {
			ganadores=j21.jugar();
		}
		
		
		
		
		

		
	}

}
