package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Dealer dealer;

	public Dealer getDealer() {
		return dealer;
	}

	public void cargarValores() {
		 ArrayList<Carta> naipe = dealer.getNaipe();

		    for (Carta c : naipe) {
		        if (c.getValor().equals("A")) {
		            c.setValorJuego(11);
		        } else if (c.getValor().equals("J")
		                || c.getValor().equals("Q")
		                || c.getValor().equals("K")) {
		            c.setValorJuego(10);
		        } else {
		            c.setValorJuego(
		                Integer.parseInt(c.getValor())
		            );
		        }
		    }
	}

	public void inicializar() {
		dealer = new Dealer();
		cargarValores();
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public void repartirCarta(Jugador jugador) {
		jugador.recibirCarta(dealer.entregarCarta());
	}

	public void repartirRonda() {
		for (Jugador j : jugadores) {
			repartirCarta(j);
		}
		CalcularToral();
	}

	public void CalcularToral() {
		for (Jugador jugador : jugadores) {
			int total = 0;

			for (Carta carta : jugador.getCartas()) {
				total += carta.getValorJuego();
			}

			jugador.setPuntajeCartas(total);
		}
	}

	public ArrayList<Jugador> validarGanador() {
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		for (Jugador j : jugadores) {
			if (j.getPuntajeCartas() == 21) {
				ganadores.add(j);
			}
		}
		return ganadores;
	}

	public ArrayList<Jugador> jugar() {
		inicializar();

        // Reiniciar las cartas y los puntos para una nueva partida.
        for (Jugador j : jugadores) {
            j.getCartas().clear();
            j.setPuntajeCartas(0);
        }

        ArrayList<Jugador> ganadores =
                new ArrayList<Jugador>();

        for (int ronda = 1; ronda <= 3; ronda++) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            repartirRonda();

            for (Jugador j : jugadores) {
                j.imprimir();
                System.out.println(
                    "Puntaje total: " + j.getPuntajeCartas()
                );
            }

            ganadores = validarGanador();

            if (ganadores.size() > 0) {
                System.out.println("¡Tenemos ganador!");
                break;
            }
        }

        if (ganadores.isEmpty()) {
            System.out.println("No hubo ganadores en esta partida.");
        }

        return ganadores;
    }
}
