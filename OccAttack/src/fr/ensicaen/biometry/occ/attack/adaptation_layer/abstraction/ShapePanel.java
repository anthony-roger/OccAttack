package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class ShapePanel extends JPanel {
	private static final long serialVersionUID = 78090219990145158L;

	private final Set<Shape> set = new HashSet<>();
	
	private int rightMarge = 0;
	private int bottomMarge = 0;
	
	public boolean addShape(Shape s){
		boolean success = set.add(s);
		
		Rectangle2D rec = s.getBounds2D();
		rightMarge = (int) Math.max(rightMarge, rec.getX() + rec.getWidth() +100);
		bottomMarge = (int) Math.max(bottomMarge, rec.getY()+ rec.getHeight() +100);
		this.setMinimumSize(new Dimension(rightMarge, bottomMarge));
		
		return success;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Shape shape : set) {
			g2d.draw(shape);
		}
	}
	
}
