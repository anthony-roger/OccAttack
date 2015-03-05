package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

public class Triangle implements Shape, Iterable<Point2D.Double> {

	private static final int defaultDrawingStep = 100;
	private int drawingStep = defaultDrawingStep;
	
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
		getPath().moveTo(p.getX() * drawingStep, p.getY() * drawingStep);
	}
	
	private void pathNextPoint(Point2D.Double p){
		getPath().lineTo(p.getX() * drawingStep, p.getY() * drawingStep);
	}
	
	public void setDrawingStep(int drawingStep) {
		this.drawingStep = drawingStep;
	}
	
	@Override
	public boolean contains(Point2D p) {
		return getPath().contains(p);
	}

	@Override
	public boolean contains(Rectangle2D r) {
		return getPath().contains(r);
	}

	@Override
	public boolean contains(double x, double y) {
		return getPath().contains(x * drawingStep,y * drawingStep);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		return getPath().contains(x*drawingStep,y*drawingStep,w*drawingStep,h*drawingStep);
	}

	@Override
	public Rectangle getBounds() {
		return getPath().getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		return getPath().getBounds2D();
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return getPath().getPathIterator(at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return getPath().getPathIterator(at, flatness);
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		return getPath().intersects(r);
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return getPath().intersects(x*drawingStep,y*drawingStep,w*drawingStep,h*drawingStep);
	}

	public Path2D.Double getPath() {
		if(path == null){
			path = new Path2D.Double();
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
	
	public static Point2D.Double getPoint(double x, double y){
		return new Point2D.Double(x, y);
	}
	
	public static void main(String[] args) {
		Point2D.Double p1 = Triangle.getPoint(1, 1);
		Point2D.Double p2 = Triangle.getPoint(1, 2);
		Point2D.Double p3 = Triangle.getPoint(2, 1);
		Triangle t = new Triangle(p1, p2, p3);
		
		JFrame f = new JFrame();
		ShapePanel panel = new ShapePanel();
		panel.addShape(t);
		f.add(panel);	
		f.setSize(panel.getMinimumSize());
		f.setVisible(true);
	}
}
