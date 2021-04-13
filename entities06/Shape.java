package entities06;

import entities_enums06.Color;

public abstract class Shape {
	private Color color;

	public Shape() {
	}
	public Shape(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract double area();
}
