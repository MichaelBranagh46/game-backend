package me.pebranagh.backend;

public class Location {

	private int x, y;
	
	public Location(int x, int y) {
		
		this.setX(x);
		this.setY(y);
		
	}

	public int getX() {
		
		return x;
		
	}

	public void setX(int x) {
		
		this.x = x;
		
	}

	public int getY() {
		
		return y;
		
	}

	public void setY(int y) {
		
		this.y = y;
		
	}
	
	public static Location addLocations(Location loc1, Location loc2) {
		
		Location newLoc = new Location(loc1.getX(), loc1.getY());
		
		newLoc.setX(loc2.getX() + newLoc.getX());
		newLoc.setY(loc2.getY() + newLoc.getY());
		
		return newLoc;
		
	}
	
}
