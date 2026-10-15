package com.krakedev.juegos.entidades;

import java.util.ArrayList;

public class Jugador {
	private String nickname;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	private int puntajeCartas;

	public int getPuntajeCartas() {
		return puntajeCartas;
	}

	public void setPuntajeCartas(int puntajeCartas) {
		this.puntajeCartas = puntajeCartas;
	}

	public Jugador(String nickname) {
		super();
		this.nickname = nickname;
	}

	public Jugador() {
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public void recibirCarta(Carta cartaRecivida) {
		cartas.add(cartaRecivida);
	}

	public void imprimir() {
		System.out.println();
		System.out.println("nickName: " + nickname);
		for (Carta c : cartas) {
			System.out.println("_____________________");
			c.imprimir();
			System.out.println("_____________________");
		}
		System.out.println();
	}
}
