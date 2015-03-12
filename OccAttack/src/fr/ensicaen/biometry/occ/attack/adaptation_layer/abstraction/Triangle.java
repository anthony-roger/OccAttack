package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

public class Triangle implements Iterable<Point2D.Double> {

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
		TrianglesPanel panel = new TrianglesPanel();
		String label = "Data";
		panel.addTriangle(label, t);
		panel.setLabelColor(label, TrianglesPanel.RED);
		f.add(panel);	
		f.setSize(panel.getMinimumSize());
		f.setVisible(true);
	}
}
