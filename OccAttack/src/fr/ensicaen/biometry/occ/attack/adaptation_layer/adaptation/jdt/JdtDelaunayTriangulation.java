package fr.ensicaen.biometry.occ.attack.adaptation_layer.adaptation.jdt;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import delaunay_triangulation.Delaunay_Triangulation;
import delaunay_triangulation.Point_dt;
import delaunay_triangulation.Triangle_dt;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.DelaunayTriangulation;
import fr.ensicaen.biometry.occ.attack.adaptation_layer.abstraction.Triangle;

public class JdtDelaunayTriangulation implements DelaunayTriangulation {

	private final Delaunay_Triangulation dt = new Delaunay_Triangulation();
	private final Set<Triangle> triangles = new HashSet<>();
	
	@Override
	public boolean addPoint(Point2D.Double p) {
		Point_dt pdt = pointToPoint_dt(p);
		dt.insertPoint(pdt);
		return true;
	}
	
	@Override
	public boolean addAllPoints(Set<Point2D.Double> ps) {
		boolean success = true;
		for (Point2D.Double p : ps) {
			success = addPoint(p);
			if( success == false ){
				break;
			}
		}
		return success;
	}
	
	@Override
	public boolean addPoint(double x, double y) {
		return addPoint(new Point2D.Double(x, y));
	}
	
	public boolean process(){
		triangles.clear();
		Iterator<Triangle_dt> iterator = dt.trianglesIterator();

		while (iterator.hasNext()) {
			Triangle_dt curr = iterator.next();
			if ( curr.isHalfplane() == false ) {
				Point2D.Double p1 = point_dtToPoint(curr.p1());
				Point2D.Double p2 = point_dtToPoint(curr.p2());
				Point2D.Double p3 = point_dtToPoint(curr.p3());
				Triangle t = new Triangle(p1, p2, p3);
				triangles.add(t);	
			}
			
		}
		return true;
	}
	
	public Set<Triangle> getTriangles(){
		return triangles;
	}
	
	private static Point2D.Double point_dtToPoint(Point_dt dtp ){
		return new Point2D.Double(dtp.x(), dtp.y()); 
	}
	
	private static Point_dt pointToPoint_dt(Point2D.Double t){
		return new Point_dt(t.getX(), t.getY()); 
	}

}
