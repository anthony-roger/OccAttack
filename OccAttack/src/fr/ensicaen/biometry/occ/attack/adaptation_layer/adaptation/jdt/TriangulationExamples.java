package fr.ensicaen.biometry.occ.attack.adaptation_layer.adaptation.jdt;

import java.util.Set;

import javax.swing.JFrame;

import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.DelaunayTriangulation;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.ShapePanel;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.Triangle;

public class TriangulationExamples {
	public static void main(String[] args) {
		DelaunayTriangulation dt = new JdtDelaunayTriangulation();
		dt.addPoint(1.0, 1.0);
		dt.addPoint(1.0, 2.0);
		dt.addPoint(3.0, 1.0);
		dt.addPoint(3.0, 2.0);
		dt.process();
		Set<Triangle> triangles = dt.getTriangles();
		ShapePanel panel = new ShapePanel();
		
		for (Triangle triangle : triangles) {
			panel.addShape(triangle);
		}
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setVisible(true);		
	}
}
