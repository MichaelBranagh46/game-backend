package me.pebranagh.backend;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends Canvas {

	private static final long serialVersionUID = -1275603287023758472L;

	public GameWindow(String name, int width, int height, Main main) {
		
		JFrame frame = new JFrame(name);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(main);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		
		main.start();
		
	}
	
}
