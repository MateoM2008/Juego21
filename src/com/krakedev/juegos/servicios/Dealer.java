package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {
	private ArrayList<Carta> naipe=new ArrayList<Carta>();

	public ArrayList<Carta> getNaipe() {
		return naipe;
	}

	public Dealer() {
		generarNaipe();
	}

	public void generarNaipe() {

		String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		String[] palos = { "T", "CN", "D", "CR" };

		for (String palo : palos) {
			for (String valor : valores) {
				Carta carta = new Carta(valor, palo);
				naipe.add(carta);
			}
		}
	}

	public void imprimriNaipe() {
		for (Carta c : naipe) {
			c.imprimir();
		}
	}

	public int generarAleatorio(int maximo) {
		int numero = (int) (Math.random() * (maximo + 1));
		return numero;
	}

	public Carta entregarCarta() {
		int numero = generarAleatorio(naipe.size() - 1);
		Carta encontrada = naipe.get(numero);
		naipe.remove(numero);
		return encontrada;
	}
}
