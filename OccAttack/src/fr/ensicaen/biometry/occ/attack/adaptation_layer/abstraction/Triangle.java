package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.util.Iterator;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Triangle implements Shape, Iterable<Point2D.Double> {

	private Path2D.Double path = null;
	private final List<Point2D.Double> points = new ArrayList<>();
	
	public Triangle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) {
		super();
		if( p1.equals(p2) == true || p2.equals(p3) == true || p3.equals(p1) == true ){
			throw new RuntimeException("[Triangle] Identical points: Too few points for a triangle!");
		}else{
			points.add(p1);
			points.add(p2);
			points.add(p3);
		}
	}

	private void pathSetOrigin(Point2D.Double p){
		path.moveTo(p.getX(), p.getY());
	}
	
	private void pathNextPoint(Point2D.Double p){
		path.lineTo(p.getX(), p.getY());
	}
	
	@Override
	public boolean contains(Point2D p) {
		return path.contains(p);
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return path.contains(r);
	}

	@Override
	public boolean contains(double x, double y) {
		return path.contains(x,y);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return path.contains(x,y,w,h);
	}

	@Override
	public Rectangle getBounds() {
		return path.getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		return path.getBounds2D();
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return path.getPathIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return path.getPathIterator(at, flatness);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return path.intersects(r);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return path.intersects(x, y, w, h);
	}

	public Path2D.Double getPath() {
		if(path == null){
			pathSetOrigin(points.get(0));
			pathNextPoint(points.get(1));
			pathNextPoint(points.get(2));
			pathNextPoint(points.get(0));
		}
		return path;
	}

	@Override
	public Iterator<Double> iterator() {
		return points.iterator();
	}
	
	/**
	 * 
	 * @param i [0-2]
	 * @return
	 */
	public Point2D.Double getPoint(int i){
		Point2D.Double p = null;
		if(i < 3 == true){
			p = points.get(i);
		}else{
			throw new RuntimeException("[Triangle] Only three points in a triangle: request for ("+i+")");
		}
		return p;
	}
	
}
