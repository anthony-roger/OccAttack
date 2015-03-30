package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.geom.Point2D;
import java.util.Set;

public interface DelaunayTriangulation {
	public boolean addPoint(Point2D.Double p);
	public boolean addAllPoints(Set<Point2D.Double> p);
	public boolean addPoint(double x, double y);
	public boolean process();
	public Set<Triangle> getTriangles();
	public void clear();
}
