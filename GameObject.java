package me.pebranagh.backend;

import java.awt.Graphics;

public abstract class GameObject {

	private Location loc;
	private ObjectType type;
	
	public GameObject(Location loc, ObjectType type) {
		
		this.loc = loc;
		this.setType(type);
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}
	
}
