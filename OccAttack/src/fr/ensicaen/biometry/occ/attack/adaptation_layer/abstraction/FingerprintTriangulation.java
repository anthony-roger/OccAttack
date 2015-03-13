package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.geom.Point2D;
import java.util.Set;

import fr.ensicaen.biometry.occ.attack.fingerprints.Fingerprint;
import fr.ensicaen.biometry.occ.attack.fingerprints.Minutia;

public class FingerprintTriangulation implements DelaunayTriangulation {

	private DelaunayTriangulation dt;

	public FingerprintTriangulation(DelaunayTriangulation dt) {
		this.dt = dt;
	}
	
	public boolean addFingerprint(Fingerprint fp){
		boolean success = false;
		for (Minutia minutia : fp) {
			success = addMinutia(minutia);
			if(success == false){
				break;
			}
		}
		return success;
	}
	
	public boolean addMinutia(Minutia m ){
		Point2D.Double p = new Point2D.Double(m.getX(), m.getY());
		return dt.addPoint(p);
	}
	
	@Override
	public boolean addPoint(Point2D.Double p) {
		return dt.addPoint(p);
	}

	@Override
	public boolean addAllPoints(Set<Point2D.Double> p) {
		return dt.addAllPoints(p);
	}

	@Override
	public boolean addPoint(double x, double y) {
		return dt.addPoint(x, y);
	}

	@Override
	public boolean process() {
		return dt.process();
	}

	@Override
	public Set<Triangle> getTriangles() {
		return dt.getTriangles();
	}

}
