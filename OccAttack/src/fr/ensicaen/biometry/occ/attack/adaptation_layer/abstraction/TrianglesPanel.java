package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class TrianglesPanel extends JPanel {
	
	public static final Color BLACK = Color.decode("#444444");
	public static final Color RED = Color.decode("#8d0719");
	
	private static final int defaultDrawingStep = 100;
	private int drawingStep = defaultDrawingStep;
	
	public void setDrawingStep(int drawingStep) {
		this.drawingStep = drawingStep;
	}
	
	private static final long serialVersionUID = 78090219990145158L;

	private final HashMap<String, Set<TrianglePath>> triangulation = new HashMap<>();
	private final HashMap<String, Color> colors = new HashMap<>();
	
	private int xMax = 250;
	private int yMax = 250;
	
	public TrianglesPanel() {
		setDimension(xMax,yMax);
	}
	
	public void setDimension(int xMax, int yMax) {
		this.setMinimumSize(new Dimension(xMax * drawingStep, yMax * drawingStep));
	}
	
	public boolean setLabelColor(String label, Color c){
		colors.put(label, c);
		return true;
	}
	
	public boolean addTriangle(String label, Triangle t){
		if( triangulation.get(label) == null ){
			triangulation.put(label, new HashSet<TrianglePath>());
		}
		return triangulation.get(label).add(new TrianglePath(t));	
	}
	
	public boolean addAllTriangles(String label, Set<Triangle> t){
		boolean success = true;
		for (Triangle triangle : t) {
			success = addTriangle(label, triangle);
			if( success == false ){
				break;
			}
		}
		return success;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (String label : triangulation.keySet()) {
			for (TrianglePath t : triangulation.get(label)) {
				Color color = colors.get(label);
				g2d.setColor(color);
				g2d.draw(t);	
			}
		}
	}
	
	
	private class TrianglePath extends Path2D.Double {

		private static final long serialVersionUID = -3113860665710674958L;

		public TrianglePath(Triangle t) {
			super();
			pathSetOrigin(t.getPoint(0));
			pathNextPoint(t.getPoint(1));
			pathNextPoint(t.getPoint(2));
			pathNextPoint(t.getPoint(0));
		}
		
		
		
		private void pathSetOrigin(Point2D.Double p){
			this.moveTo(p.getX() * drawingStep, p.getY() * drawingStep);
		}
		
		private void pathNextPoint(Point2D.Double p){
			this.lineTo(p.getX() * drawingStep, p.getY() * drawingStep);
		}
	}
}
