package fr.ensicaen.biometry.occ.attack.database;

import java.util.Map;
import java.util.Set;

import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.DelaunayTriangulation;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.FingerprintTriangulation;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.Triangle;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.adaptation.jdt.JdtDelaunayTriangulation;
import fr.ensicaen.biometry.occ.attack.fingerprints.Fingerprint;
import fr.ensicaen.biometry.occ.attack.fingerprints.Individual;
import fr.ensicaen.biometry.occ.attack.view.TrianglulationPanel;
import fr.ensicaen.biometry.occ.attack.view.TriangulationFrame;

public class DbOverview {
	public static void main(String[] args) {
		String path = "C:/Users/aroger.ECOLE/Desktop/Eclipse/rsc/dbFingerprints";
		DbLoader loader = new DbLoader(path);
		Map<String, Individual> load = loader.load();
		
		Fingerprint i3s8 = load.get("I3").getSample("S8");
		
		DelaunayTriangulation dt = new JdtDelaunayTriangulation();
		FingerprintTriangulation fpt = new FingerprintTriangulation(dt);
		fpt.addFingerprint(i3s8);
		fpt.process();
		Set<Triangle> i3s8Triangles = fpt.getTriangles();
		
		Fingerprint i3s5 = load.get("I3").getSample("S5");
		
		dt = new JdtDelaunayTriangulation();
		fpt = new FingerprintTriangulation(dt);
		fpt.addFingerprint(i3s5);
		fpt.process();
		Set<Triangle> i3s5Triangles = fpt.getTriangles();
		
		
		TriangulationFrame frame = new TriangulationFrame();
		frame.addAllTriangles("I3_S8", i3s8Triangles);
		frame.setLabelColor("I3_S8", TrianglulationPanel.BLACK);
		frame.addAllTriangles("I3_S5", i3s5Triangles);
		frame.setLabelColor("I3_S5", TrianglulationPanel.GREEN);
		frame.setVisible(true);
		
	}
}
