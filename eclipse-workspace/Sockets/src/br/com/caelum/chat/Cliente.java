package br.com.caelum.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor!");

		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		PrintStream arquivo = new PrintStream("arquivo.txt");
		saida.println(cliente.getOutputStream());

		while (teclado.hasNextLine()) {
			arquivo.println(teclado.nextLine());
		}
		arquivo.close();
		saida.close();
		teclado.close();
	}
	
}
