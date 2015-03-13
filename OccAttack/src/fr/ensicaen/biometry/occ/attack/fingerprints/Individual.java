package fr.ensicaen.biometry.occ.attack.fingerprints;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Individual {
	private String id;
	private final Map<String, Fingerprint> samples = new HashMap<>();
	
	public Individual(String id) {
		this.id = id;
	}
	
	public void putSample(String label, Fingerprint sample){
		samples.put(label, sample);
	}
	
	public Collection<Fingerprint> getSamples() {
		return samples.values();
	}
	
	public Fingerprint getSample(String label){
		return samples.get(label);
	}

}
