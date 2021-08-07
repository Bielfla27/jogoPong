package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Jogo extends Canvas implements Runnable, KeyListener {
	
	public static int WIDTH = 640;
	public static int HEIGHT = 420; 
	
	public Jogador jogador = new Jogador(270,420-10);
	
	public Jogo() {
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.addKeyListener(this);
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
		new Thread(jogo).start();
	}
	
	public void tick() {
		jogador.tick();
	}
	
	public void renderizar() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		jogador.renderizar(g);
		bs.show(); //mostra o jogador na tela
	}
	
	@Override
	public void run() {
		while(true){
			tick();
			renderizar();
			try {
				Thread.sleep(1000/150); //Define a velocidade do jogo 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jogador.rigth = true;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){ 
			jogador.left = true;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jogador.rigth = false;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){ 
			jogador.left = false;
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
}
