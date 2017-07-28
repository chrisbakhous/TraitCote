
import java.util.ArrayList;

public class Principal {

	public static Double distance (Point p1,Point p2)
	{		
		 return Math.sqrt((p2.y - p1.y)*(p2.y - p1.y) + (p2.x - p1.x)*(p2.x - p1.x));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Test Intersection Segment/Cercle 
		System.out.println("*******************Test Intersection ligne Cercle*******************");
		Circle c1 = new Circle(new Point(0.0, 0.0),2.0);
		Radial rad = new Radial(100.0);
		ArrayList<Point> coordonnees3 = new ArrayList<Point>();
		coordonnees3.add(new Point(3.0,1.0));
		coordonnees3.add(new Point(4.0,2.0));
		Line segment = new Line(coordonnees3);
		ArrayList<Point> intersection = rad.IntersectionPoint(c1, segment);
		for(int i=0;i<intersection.size();i++)
		{
			System.out.println("x ->"+intersection.get(i).x+"  y ->"+intersection.get(i).y);
		}
		
		//Test longeur ligne/segment
		System.out.println("*********************Test longeur ligne/segment*********************");
		Point p1 = new Point(2.0,3.0);
		Point p2 = new Point(5.0,2.0);
		Point p3 = new Point(11.0,8.0);
		Point p4 = new Point(19.0,8.0);
		ArrayList<Point> coordonnees= new ArrayList<Point>();
		coordonnees.add(p1);
		coordonnees.add(p2);
		coordonnees.add(p3);
		coordonnees.add(p4);
		Line MyLine = new Line(coordonnees);
		Double length = MyLine.longeur();
		System.out.println("La longeur de la ligne est : "+length);
		ArrayList<lineInfo> informations = MyLine.informations();
		MyLine.DisplayInfo(informations);
		
		//Test récupétation de l'ensemble de points formant le perimetre du cercle 
//		System.out.println("***********************Test Points Cercles***************************");
//		Point center = new Point(5.0, 3.0);
//		Double radius = 2.0;
//		Circle c2 = new Circle(center,radius);
//		ArrayList<Point> circlePoints = c2.circlePoints();
//		for(Point p : circlePoints)
//		{
//			
//			if(Line.distance(center, p) != radius)
//			{
//				System.out.println(p.x+"@"+p.y+"       distance: "+Line.distance(center, p));
//			}
//			
//		}
		
		//Test verification d'intersection 
		System.out.println("*********************Test verification d'intersection*********************");
		Circle c3 = new Circle(new Point(0.0, 0.0),2.0);
		Radial radial = new Radial(100.0);
		ArrayList<Point> coordonnees4 = new ArrayList<Point>();
		coordonnees4.add(new Point(3.0,1.0));
		coordonnees4.add(new Point(4.0,2.0));
		Line seg = new Line(coordonnees4);
		
		ArrayList<Point> intersection2 = radial.verifIntersection(c3, seg);
		
		System.out.println("x->"+intersection2.get(0).x); //pb
		System.out.println("y->"+intersection2.get(0).y);
		System.out.println("x->"+intersection2.get(1).x);
		System.out.println("y->"+intersection2.get(1).y);
		
		//Test Radial IntersectionPoint2 
		
		/*System.out.println("*******************************************************************************");
		Point p5 = new Point(2.0,3.0);
		Point p6 = new Point(5.0,2.0);
		Point p7 = new Point(11.0,8.0);
		Point p8 = new Point(19.0,8.0);
		ArrayList<Point> coordonnees4= new ArrayList<Point>();
		coordonnees4.add(p5);
		coordonnees4.add(p6);
		coordonnees4.add(p7);
		coordonnees4.add(p8);
		Line MyLine2 = new Line(coordonnees4);
		Radial rad2 = new Radial(4.0);
		ArrayList<Point> intersection2 = rad2.IntersectionPoint2(MyLine2);
		for( Point p : intersection2 )
		{
			System.out.println("points d'intersection");
			System.out.println(p.x+"@"+p.y);
			
		}*/
		
		
		
		
		
	}

}
