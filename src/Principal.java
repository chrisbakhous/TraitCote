import java.util.ArrayList;

public class Principal {

	public static Double distance (Point p1,Point p2)
	{		
		 return Math.sqrt((p2.y - p1.y)*(p2.y - p1.y) + (p2.x - p1.x)*(p2.x - p1.x));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(100.0,100.0);
		Point p2 = new Point(150.0,70.0);
		Point p3 = new Point(200.0,70.0);
		Point p4 = new Point(250.0,40.0);
		Point p5 = new Point(300.0,150.0);
		
		Point p6 = new Point(4.0,3.0);
		Point p7 = new Point(2.0,1.0);
		
		ArrayList<Point> coordonnees= new ArrayList<Point>();
		coordonnees.add(p1);
		coordonnees.add(p2);
		coordonnees.add(p3);
		coordonnees.add(p4);
		coordonnees.add(p5);
		
		Line MyLine = new Line(coordonnees);
		System.out.println(distance(p6,p7));		
		
		ArrayList<Point> coordonnees2= new ArrayList<Point>();
		coordonnees2.add(p6);
		coordonnees2.add(p7);

		Line lineTest = new Line(coordonnees2);
		System.out.println(lineTest.longeur());
		
		ArrayList<lineInfo> info = MyLine.informations();
		MyLine.DisplayInfo(info);
		
		
		
	}

}
