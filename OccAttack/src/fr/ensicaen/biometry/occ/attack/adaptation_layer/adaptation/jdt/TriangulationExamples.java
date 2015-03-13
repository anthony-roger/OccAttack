package fr.ensicaen.biometry.occ.attack.adaptation_layer.adaptation.jdt;

import java.util.Set;

import javax.swing.JFrame;

import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.DelaunayTriangulation;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.Triangle;
import fr.ensicaen.biometry.occ.attack.view.TrianglulationPanel;

public class TriangulationExamples {
	public static void main(String[] args) {
		DelaunayTriangulation dt = new JdtDelaunayTriangulation();

		dt.addPoint(1.5, 3.2);
		dt.addPoint(1.8, 3.3);
		dt.addPoint(3.7, 1.5);
		dt.addPoint(1.5, 1.3);
		
		dt.addPoint(0.8, 1.2);
		dt.addPoint(3.3, 1.5);
		dt.addPoint(4.0, 1.0);
		dt.addPoint(2.3, 0.7);
		
		dt.addPoint(0.0, 0.5);
		dt.addPoint(2.0, 1.5);
		dt.addPoint(3.7, 0.8);
		dt.addPoint(3.5, 2.9);
		
		dt.addPoint(0.9, 3.9);
		dt.addPoint(2.0, 3.5);
		dt.addPoint(3.5, 2.25);
		
		dt.process();
		
		Set<Triangle> triangles = dt.getTriangles();
		TrianglulationPanel panel = new TrianglulationPanel();
		panel.setDimension(5, 5);
		
		String label = "Data";
		panel.setLabelColor(label, TrianglulationPanel.RED);
		panel.addAllTriangles(label,triangles);
		
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setMinimumSize(panel.getMinimumSize());
		frame.setVisible(true);		
	}
}
