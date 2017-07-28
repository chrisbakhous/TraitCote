import java.util.ArrayList;

public class Principal2 {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point p1 = new Point(3.0,10.0);
		Point p2 = new Point(5.0,8.0);
		Point p3 = new Point(10.0,12.0);
		Point p4 = new Point(18.0,12.0);
		Point p5 = new Point(20.0,10.0);
		Point p6 = new Point(22.0,10.0);
		Point p7 = new Point(24.0,9.0);
		
		System.out.println("longeur p1,p2 : " +Line.distance(p1, p2));
		System.out.println("longeur p2,p3 : " +Line.distance(p2, p3));
		System.out.println("longeur p3,p4 : " +Line.distance(p3, p4));
		System.out.println("longeur p4,p5 : " +Line.distance(p4, p5));
		System.out.println("longeur p5,p6 : " +Line.distance(p5, p6));
		System.out.println("longeur p6,p7 : " +Line.distance(p6, p7));
		
		System.out.println("Slope p2,p3 : "+Line.Slope2(p2, p3));
		
		Radial r = new Radial(4.0);
		Point FirstPointRad = r.findFirstPointRad(p2, p3, 1.2);
		System.out.println("FirstPointRad.x = " +FirstPointRad.x);
		System.out.println("FirstPointRad.y = " +FirstPointRad.y);
		Point SecondePointRad = r.findSecondePointRad(FirstPointRad, -1.0/0.8);
		System.out.println("SecondePointRad.x = " +SecondePointRad.x);
		System.out.println("SecondePointRad.y = " +SecondePointRad.y);
		
		System.out.println("******************** TEST : findFirstPointRad / findSecondePointRad **********************");
		
		Point p11 = new Point(2.0,3.0);
		Point p12 = new Point(13.0,14.0);
		System.out.println("longeur p11,p12 : " +Line.distance(p11, p12));
		Point pointTest = r.findFirstPointRad(p11, p12, 5.6);
		System.out.println("pointTest.x = " +pointTest.x);
		System.out.println("pointTest.y = " +pointTest.y);
		Point pointTest2 = r.findSecondePointRad(pointTest, -1.0/1.0);
		System.out.println("pointTest.x = " +pointTest2.x);
		System.out.println("pointTest.y = " +pointTest2.y);
		
		System.out.println("******************** TEST : findFirstPointRad / findSecondePointRad **********************");
		Point p13 = new Point(2.0,3.0);
		Point p14 = new Point(13.0,10.0);
		System.out.println("longeur p13,p14 : " +Line.distance(p13, p14));
		Point pointRad = r.findFirstPointRad(p13, p14, 5.6);
		System.out.println("pointRad.x = " +pointRad.x);
		System.out.println("pointRad.y = " +pointRad.y);
		Point pointRad2 = r.findSecondePointRad(pointRad, -1.0/0.6);
		System.out.println("pointRad2.x = " +pointRad2.x);
		System.out.println("pointRad2.y = " +pointRad2.y);
		
		System.out.println("******************************* TEST : RadialCoordinate **********************************");
		ArrayList<Point> res = r.RadialCoordinate(p13, p14, 5.6);
		for(Point e : res )
		{
			System.out.println(e.getX());
			System.out.println(e.getY());
		}
	}

}
