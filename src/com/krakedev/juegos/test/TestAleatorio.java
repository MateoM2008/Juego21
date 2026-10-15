package com.krakedev.juegos.test;

import com.krakedev.juegos.servicios.Dealer;

public class TestAleatorio {

	public static void main(String[] args) {
		Dealer d=new Dealer();
		for(int i=0;i<=100;i++) {		
			System.out.println("Numero: "+d.generarAleatorio(30));
		}
	}

}
