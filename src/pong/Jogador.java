package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador {
	
	public boolean rigth, left;
	
	public int x,y, width, height;
	
	public Jogador(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 150;
		this.height = 50;
	}
	
	public void tick() {
		if(rigth) {
			x++;
		}else if(left) {
			x--;
		}
		if(x+width > Jogo.WIDTH) {
			x = Jogo.WIDTH - width;
		}else if(x < 0 ) {
		    x = 0;	
		}
	}
	
	public void renderizar(Graphics g){
		g.setColor(Color.red); //definindo a cor do jogador 
		g.fillRect(x, y, width, height);
		
	}

}
