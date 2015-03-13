package fr.ensicaen.biometry.occ.attack.database;

import java.io.InputStream;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import fr.ensicaen.biometry.occ.attack.fingerprints.Fingerprint;
import fr.ensicaen.biometry.occ.attack.fingerprints.Minutia;

public class DbLoader_tests {

	@Test
	public void loadFile() {
		String label = "Test1";
		Fingerprint expected = new Fingerprint(label);
		expected.add(new Minutia(7, 81, 4, 1));
		expected.add(new Minutia(7, 166, 4, 1));
		expected.add(new Minutia(8, 143, 6, 2));
		
		URL path = getClass().getResource("rsc/Test1_S1.xyt");
		Fingerprint fp = DbLoader.loadFile("Test1", path.getPath());
		
		Assert.assertEquals("Minutiae extraction failed", expected, fp);
		
	}

}

