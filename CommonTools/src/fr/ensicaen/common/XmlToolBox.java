package fr.ensicaen.common;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlToolBox {
	
	public static Element getRootElement(String path){
		return getRootElement(new File(path));
	}
	
	public static Element getRootElement(File src){
		Element root = null;
		SAXBuilder builder = new SAXBuilder();
		Document document;
		try {
			document = builder.build(src);
			root = document.getRootElement();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
		return root;
	}
	
	public static void save(String path){
		
	}
}
