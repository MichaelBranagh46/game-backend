package me.pebranagh.backend;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1368218127599193453L;
	private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Handler handler;
	private Thread thread;
	private boolean running = false;
	
	public static void main(String[] args) {
		
		new Main("Test Game");
		
	}
	
	public Main(String name) {
		
		handler = new Handler();
		new GameWindow(name, WIDTH, HEIGHT, this);
		
	}
	
	public synchronized void start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop() {
		
		try {
			thread.join();
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void tick() {
		
		
		
	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				
				tick();
				delta--;
				
			}
			if(running) {
				
				render();
				
			}
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
		
		stop();
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		g.dispose();
		
		bs.show();
		
	}
	
}
