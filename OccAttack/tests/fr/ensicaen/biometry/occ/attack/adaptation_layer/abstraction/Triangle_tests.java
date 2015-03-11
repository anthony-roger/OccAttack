package fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.Test;

public class Triangle_tests {

	@Test
	public void iterator() {
		Point2D.Double p1 = Triangle.getPoint(1.0, 1.0);
		Point2D.Double p2 = Triangle.getPoint(1.0, 2.0);
		Point2D.Double p3 = Triangle.getPoint(2.0, 1.0);
		Triangle t = new Triangle(p1, p2, p3);
		int i = 0;
		for (Point2D.Double point : t) {
			switch (i) {
				case 0:
					Assert.assertEquals("Wrong point p1: " + point, p1, point);
					break;
					
				case 1:
					Assert.assertEquals("Wrong point p2: " + point, p2, point);
					break;
					
				case 2:
					Assert.assertEquals("Wrong point p3: " + point, p3, point);
					break;
					
				default:
					Assert.fail("Too much points in a triangle: ("+i+")");
					break;
			}
			i++;
		}
	}
	
	@Test
	public void getTrianglePoints() {
		List<Point2D.Double> l = new ArrayList<>();
		l.add(Triangle.getPoint(2.0, 2.0));
		l.add(Triangle.getPoint(2.0, 3.0));
		l.add(Triangle.getPoint(3.0, 2.0));
		Triangle t = new Triangle(l.get(0), l.get(1), l.get(2));
		for (int i = 0; i < 3; i++) {
			Assert.assertEquals("Wrong point p"+i+": " + l.get(i), l.get(i), t.getPoint(i));
		}
	}

	@Test
	public void getPoint(){
		double x = 2.0;
		double y = 3.0;
		Point2D.Double point = Triangle.getPoint(x, y);
		Assert.assertEquals("Wrong x: " + point.getX(), x, point.getX(), 0);
		Assert.assertEquals("Wrong y: " + point.getY(), y, point.getY(), 0);
	}
}
