package br.com.caelum.chat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

		InputStream texto = new FileInputStream("arquivo.txt");
		int data = texto.read();
		PrintStream recebido = new PrintStream("recebido.txt");
		while (data != -1) {
			recebido.print((char) data);
			data = texto.read();

		}
		texto.close();
		recebido.close();
		servidor.close();
	}
}
