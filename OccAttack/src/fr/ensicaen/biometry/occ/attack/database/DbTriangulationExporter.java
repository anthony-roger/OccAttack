package fr.ensicaen.biometry.occ.attack.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.jdom2.Element;

import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.FingerprintTriangulation;
import fr.ensicaen.biometry.occ.attack.fingerprints.Fingerprint;
import fr.ensicaen.biometry.occ.attack.fingerprints.Individual;
import fr.ensicaen.biometry.occ.attack.fingerprints.Minutia;
import fr.ensicaen.common.XmlToolBox;

public class DbTriangulationExporter {
	
	private FingerprintTriangulation fpt;
	
	private final Map<String, Individual> db = new HashMap<>();
	public DbTriangulationExporter(FingerprintTriangulation fpt, Map<String, Individual> db) {
		this.fpt = fpt;
		this.db.putAll(db);
	}
	
	public void export(String path){
		Element root = new Element("Individuals");
		for (String individualName : db.keySet()) {
			Element individualElt = parseIndividual(individualName);
			root.addContent(individualElt);
		}
		XmlToolBox.save(root, path);
	}
	
	private Element parseIndividual(String name){
		Element individualElt = new Element("Individual");
		individualElt.setAttribute("name", name);
		Individual individual = db.get(name);
		
		Element fps = new Element("Fingerprints");
		Collection<Fingerprint> samples = individual.getSamples();
		for (Fingerprint fingerprint : samples) {
			Element fp = parseFingerprint(fingerprint);
			fps.addContent(fp);
		}
		individualElt.addContent(fps);
		return individualElt;
	}

	private Element parseFingerprint(Fingerprint fingerprint) {
		Element dt = new Element("Triangulation");
		
		return dt;
	}
}
