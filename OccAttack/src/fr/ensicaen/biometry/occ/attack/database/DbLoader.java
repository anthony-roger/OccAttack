package fr.ensicaen.biometry.occ.attack.database;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.ensicaen.biometry.occ.attack.fingerprints.Fingerprint;
import fr.ensicaen.biometry.occ.attack.fingerprints.Individual;
import fr.ensicaen.biometry.occ.attack.fingerprints.Minutia;

public class DbLoader {
	private final String path;
	
	private static final FileFilter NO_FILE_FILTERING = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			return true;
		}
	};
	
	public DbLoader(String path) {
		this.path = path;
	}
	
	public Map<String, Individual> load(FileFilter ff){
		Map<String, Individual> individuals = new HashMap<>();
		for (File f : new File(path).listFiles(ff)) {
			String filename = f.getName();
			int indexMiddle = filename.indexOf("_");
			int indexEnd = filename.indexOf(".");
			String id = filename.substring(0, indexMiddle);
			String sample = filename.substring(indexMiddle+1,indexEnd);
			Individual individual = individuals.get(id);
			if( individual == null ){
				individual = new Individual(id);
				individuals.put(id, individual);
			}
			Fingerprint fpSample = loadFile(sample, f);
			individual.putSample(sample, fpSample);
		}
		return individuals;
	}
	
	public Map<String, Individual> load(){
		return load(NO_FILE_FILTERING);
	}
	
	public static Fingerprint loadFile(String id, String path){
		return loadFile(id, new File(path));
	}
	
	public static Fingerprint loadFile(String id, File path){
		Fingerprint fp = new Fingerprint(id);
		Scanner sc;
		try {
			sc = new Scanner(path);
			while(sc.hasNext()){
				Double x = sc.nextDouble();
				Double y = sc.nextDouble();
				Double angle = sc.nextDouble();
				Double type = sc.nextDouble();
				Minutia m = new Minutia(x, y, angle, type);
				fp.add(m);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fp;
	}
	
}
