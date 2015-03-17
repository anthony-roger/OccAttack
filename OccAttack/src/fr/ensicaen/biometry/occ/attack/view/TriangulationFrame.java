package fr.ensicaen.biometry.occ.attack.view;

import java.awt.Color;
import java.util.Set;

import javax.swing.JFrame;

import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.Triangle;

public class TriangulationFrame extends JFrame {
	
	private TrianglulationPanel panel = new TrianglulationPanel();
	
	public TriangulationFrame() {
		super();
		super.add(panel);
	}
	
	public void addAllTriangles(String label, Set<Triangle> t){
		panel.addAllTriangles(label, t);
	}
	
	public void addTriangle(String label, Triangle t){
		panel.addTriangle(label, t);
	}
	
	public void setLabelColor(String label, Color c){
		panel.setLabelColor(label, c);	
	}
	
	
	@Override
	public void setVisible(boolean b) {
		super.setMinimumSize(panel.getMinimumSize());
		super.setVisible(b);
	}
	
	public TrianglulationPanel getPanel() {
		return panel;
	}
	
	public void setPanel(TrianglulationPanel panel) {
		super.removeAll();
		this.panel = panel;
		super.add(panel);
	}
}
