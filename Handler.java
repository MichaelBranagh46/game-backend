package me.pebranagh.backend;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick() {
		
		
		
	}
	
	public void render(Graphics g) {
		
		for(GameObject obj : objects) {
			
			obj.render(g);
			
		}
		
	}
	
	public void addObject(GameObject obj) {
		
		objects.add(obj);
		
	}
	
	public void removeObject(GameObject obj) {
		
		if(objects.contains(obj)) {
			
			objects.remove(obj);
			
		}
		
	}
	
}
