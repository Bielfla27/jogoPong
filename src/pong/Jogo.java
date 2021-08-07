package pong;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Jogo extends Canvas implements Runnable {
	
	public static int WIDTH = 640;
	public static int HEIGHT = 420;
	
	public Jogo() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}

	public static void main(String[] args){
		Jogo jogo = new Jogo();
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false); //usuário não pode modificar o tamanho da tela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Vai excerrar o projeto todo quando fecha
		frame.add(jogo);
		frame.pack();
		frame.setLocationRelativeTo(null); // vai deixar a tela no centro da tela
		frame.setVisible(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
