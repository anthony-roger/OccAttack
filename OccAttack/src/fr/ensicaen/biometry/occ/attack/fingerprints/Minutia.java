package fr.ensicaen.biometry.occ.attack.fingerprints;

public class Minutia {
	private double x;
	private double y;
	private double angle;
	private double type;
	
	public Minutia(double x,  double y) {
		this.x = x;
		this.y = y;
	}
	
	public Minutia(double x,  double y, double angle, double type) {
		this(x,y);
		this.angle = angle;
		this.type = type;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public double getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean areEqual = false;
		if(o instanceof Minutia){
			Minutia m = (Minutia) o;
			areEqual = this.equals(m);
		}else{
			areEqual = false;
		}
		
		return areEqual;
	}
	
	public boolean equals(Minutia m) {
		boolean areEqual = this.getX() ==  m.getX();
		areEqual = areEqual && this.getY() ==  m.getY();
		areEqual = areEqual && this.getAngle() ==  m.getAngle();
		areEqual = areEqual && this.getType() ==  m.getType();
		return areEqual;
	}
}
