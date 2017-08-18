import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Principal {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		Point p1 = new Point(3.0,10.0);
		Point p2 = new Point(5.0,8.0);
		Point p3 = new Point(10.0,12.0);
		Point p4 = new Point(18.0,12.0);
		Point p5 = new Point(20.0,10.0);
		Point p6 = new Point(22.0,10.0);
		Point p7 = new Point(24.0,9.0);   
		Point p8 = new Point(30.0,12.0);  
		
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p2, p3);
		Segment s3 = new Segment(p3, p4);
		Segment s4 = new Segment(p4, p5);
		Segment s5 = new Segment(p5, p6);
		Segment s6 = new Segment(p6, p7);
		Segment s7 = new Segment(p7, p8);
		
			// TEST segmentLength() et Slope() de la classe Segment
			System.out.println("longueur p1,p2 : " +s1.segmentLength());
			System.out.println("longueur p2,p3 : " +s2.segmentLength());
			System.out.println("longueur p3,p4 : " +s3.segmentLength());
			System.out.println("longueur p4,p5 : " +s4.segmentLength());
			System.out.println("longueur p5,p6 : " +s5.segmentLength());
			System.out.println("longueur p6,p7 : " +s6.segmentLength());
		
			System.out.println("Slope s1 : "+s1.Slope());
			System.out.println("Slope s2 : "+s2.Slope());
			System.out.println("Slope s3 : "+s3.Slope());
			System.out.println("Slope s4 : "+s4.Slope());
			System.out.println("Slope s5 : "+s5.Slope());
			System.out.println("Slope s6 : "+s6.Slope());
		
			// TEST lineLength() de la classe Line
			ArrayList<Segment> segments = new ArrayList<Segment>();
			segments.add(s1);
			segments.add(s2);
			segments.add(s3);
			segments.add(s4);
			segments.add(s5);
			segments.add(s6);
			segments.add(s7);
			
			Line reference = new Line(segments);
			System.out.println( "Longueur de la ligne de référene : " + reference.lineLength());
			
			
			
			 

			
				
			// TEST GetRadPoints(Segment segment,Double distance) de la classe Radial
			Radial rad = new Radial(4.0,2.0,true);
			ArrayList<Point> radPoints = rad.GetRadPoints(s1, 2.0);
			for (int i = 0 ; i<radPoints.size();i++)
			{
				radPoints.get(i).DisplayCoordinates();
			}
			System.out.println("*************************************************************************************");
		
		Point point1 = new Point(2.0, 3.0);
		Point point2 = new Point(7.0, 3.0);
		Radial radial = new Radial(4.0,4.0,true);
		Segment parallelSegment = new Segment(point1, point2);
		ArrayList<Point> result = radial.GetRadPoints(parallelSegment, 4.0);
		ArrayList<Point> result2 = radial.GetRadPoints(parallelSegment, 5.0);
		
			// TEST  GetRadPoints(Segment segment,Double distance) de la classe Radial //Segment parallèl à l'axe des abscisses
			
			for (int i = 0 ; i<result.size();i++)
			{
				result.get(i).DisplayCoordinates();
			}
			
			
			for (int i = 0 ; i<result2.size();i++)
			{
				result2.get(i).DisplayCoordinates();
			}
		
		Radial rad2 = new Radial(5.0,2.0,false);
		
			// TEST RadialsFirstPointCoordinates de la classe Radial
			ArrayList<Segment> res = rad2.RadialsFirstPointCoordinates (reference);
			for (int i = 0 ; i<res.size();i++)
			{
				System.out.print("Point 1 : ");
				res.get(i).getStartPoint().DisplayCoordinates();
				System.out.print("Point 2 : ");
				res.get(i).getEndPoint().DisplayCoordinates();	
			}
			
			JCanvas myPanel = new JCanvas(segments,res);
			myPanel.setBackground(Color.WHITE);
			myPanel.setPreferredSize(new Dimension(800,800));
			GUIHelper.showOnFrame(myPanel,"myPanel");
		
			
		
		
		//TEST GetRadPoints(Segment segment,Double distance) de la classe Radial
		
//		Point p100 = new Point(2.0,1.0);
//		Point p110 = new Point(3.5,3.0);
//		Segment s100 = new Segment(p100, p110);
//		Radial rad3 = new Radial(3.0,3.0,false);
//
//		ArrayList<Point> pointsRad = rad3.GetRadPoints(s100, 1.0);
//		pointsRad.get(0).DisplayCoordinates();
//		pointsRad.get(1).DisplayCoordinates();
		
		//TEST 
//		System.out.println("************************************** EXEMPLE 2 **************************************");
//		Point p10 = new Point(2.0,1.0);
//		Point p11 = new Point(3.5,3.0);
//		Point p12 = new Point(8.0,6.0);
//		Point p13 = new Point(11.5,5.5);
//		Point p14 = new Point(13.0,9.0);
//		Point p15 = new Point(17.0,9.0);
//		Point p16 = new Point(19.0,2.0);
//		
//		
//		Segment s10 = new Segment(p10, p11);
//		Segment s11 = new Segment(p11, p12);
//		Segment s12 = new Segment(p12, p13);
//		Segment s13 = new Segment(p13, p14);
//		Segment s14 = new Segment(p14, p15);
//		Segment s15 = new Segment(p15, p16);
//		
//		ArrayList<Segment> segments2 = new ArrayList<Segment>();
//		segments2.add(s10);
//		segments2.add(s11);
//		segments2.add(s12);
//		segments2.add(s13);
//		segments2.add(s14);
//		segments2 .add(s15);
//		
//		Line reference2 = new Line(segments2);
//		System.out.println( "Longueur de la ligne de référene : " + reference2.lineLength());
//		 
//
//		Radial rad2 = new Radial(3.0,3.0,false);
//		
//		
//		ArrayList<Segment> res2 = rad2.RadialsFirstPointCoordinates (reference2);
//		System.out.println("*************");
//		for (int i = 0 ; i<res2.size();i++)
//		{
//			System.out.println("Les points de départs des radiales ");
//			res2.get(i).getStartPoint().DisplayCoordinates();
//			System.out.println("Les secondes points des radiales ");
//			res2.get(i).getEndPoint().DisplayCoordinates();
//		}
		
		
		
//		Point firstPointRad = rad.findFirstPointRad(s1, 2.0);
//		Point SecondePointRad = rad.findSecondePointRad(firstPointRad, -1/-1.0);
//		firstPointRad.DisplayCoordinates();
//		SecondePointRad.DisplayCoordinates();
		
		

		
		
//		Radial r = new Radial(4.0);
//		Point FirstPointRad = r.findFirstPointRad(p2, p3, 1.2);
//		System.out.println("FirstPointRad.x = " +FirstPointRad.x);
//		System.out.println("FirstPointRad.y = " +FirstPointRad.y);
//		Point SecondePointRad = r.findSecondePointRad(FirstPointRad, -1.0/0.8);
//		System.out.println("SecondePointRad.x = " +SecondePointRad.x);
//		System.out.println("SecondePointRad.y = " +SecondePointRad.y);
//		
//		System.out.println("******************** TEST : findFirstPointRad / findSecondePointRad **********************");
//		
//		Point p11 = new Point(2.0,3.0);
//		Point p12 = new Point(13.0,14.0);
//		System.out.println("longeur p11,p12 : " +Line.distance(p11, p12));
//		Point pointTest = r.findFirstPointRad(p11, p12, 5.6);
//		System.out.println("pointTest.x = " +pointTest.x);
//		System.out.println("pointTest.y = " +pointTest.y);
//		Point pointTest2 = r.findSecondePointRad(pointTest, -1.0/1.0);
//		System.out.println("pointTest.x = " +pointTest2.x);
//		System.out.println("pointTest.y = " +pointTest2.y);
//		
//		System.out.println("******************** TEST : findFirstPointRad / findSecondePointRad **********************");
//		Point p13 = new Point(2.0,3.0);
//		Point p14 = new Point(13.0,10.0);
//		System.out.println("longeur p13,p14 : " +Line.distance(p13, p14));
//		Point pointRad = r.findFirstPointRad(p13, p14, 5.6);
//		System.out.println("pointRad.x = " +pointRad.x);
//		System.out.println("pointRad.y = " +pointRad.y);
//		Point pointRad2 = r.findSecondePointRad(pointRad, -1.0/0.6);
//		System.out.println("pointRad2.x = " +pointRad2.x);
//		System.out.println("pointRad2.y = " +pointRad2.y);
//		
//		System.out.println("******************************* TEST : RadialCoordinate slope > 0 **********************************");
//		ArrayList<Point> res = r.RadialCoordinate(p13, p14, 5.6);
//		for(Point e : res )
//		{
//			System.out.println(e.getX());
//			System.out.println(e.getY());
//		}
//
//		System.out.println("******************************* TEST : RadialCoordinate slope = 0 **********************************");
//		Point p15 = new Point(2.0,4.0);
//		Point p16 = new Point(7.0,4.0);
//		ArrayList<Point> res2 = r.RadialCoordinate(p15, p16, 2.0);
//		for(Point e : res2 )
//		{
//			System.out.println(e.getX());
//			System.out.println(e.getY());
//		}
//		System.out.println("************************************* TEST : PointsRadiale ******************************************");
//		ArrayList<Point> ReferencePoints = new ArrayList<Point>();
//		ReferencePoints.add(p1);
//		ReferencePoints.add(p2);
//		ReferencePoints.add(p3);
//		ReferencePoints.add(p4);
//		ReferencePoints.add(p5);
//		ReferencePoints.add(p6);
//		ReferencePoints.add(p7);
//		Line lineReference = new Line(ReferencePoints);
//		Radial rad = new Radial(5.0);
//		rad.PointsRadiale(lineReference);
	}

}
