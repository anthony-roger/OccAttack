package fr.ensicaen.biometry.occ.attack.fingerprints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Fingerprint extends HashSet<Minutia>{
	private String id;
	private final Map<String, Object> information = new HashMap<>();
	
	public Fingerprint(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void putInformation(String label, Object information){
		this.information.put(label, information);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean areEqual = false;
		if(o instanceof Fingerprint){
			Fingerprint fp = (Fingerprint) o;
			areEqual = this.equals(fp);
		}else{
			areEqual = false;
		}
		
		return areEqual;
	}
	
	public boolean equals(Fingerprint fp) {
		boolean areEqual = false;
		if( this.size() == fp.size() ){
			for (Minutia minutia : fp) {
				areEqual = this.contains(minutia);
				if(areEqual == false){
					break;
				}
			}
		}else{
			areEqual = false;
		}
		
		return areEqual;
	}
	
	public boolean contains(Minutia o) {
		boolean contains = false;
		for (Minutia m : this) {
			contains = m.equals(o);
			if( contains == true ){
				break;
			}
		}
		return contains;
	}
}
 