package fr.ensicaen.biometry.occ.attack.database;

import java.util.HashMap;
import java.util.Map;

import org.jdom2.Element;

import fr.ensicaen.biometry.occ.attack.fingerprints.Individual;
import fr.ensicaen.common.XmlToolBox;

public class DbExporter {
	private final Map<String, Individual> db = new HashMap<>();
	public DbExporter(Map<String, Individual> db) {
		this.db.putAll(db);
	}
	
	public void export(String path){
		Element root = XmlToolBox.getRootElement(path);
	}
}
