import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Demo1 {

	public static void main(String[] args) {
		
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
		Radial rad = new Radial(2.0,3.0,false); //pas,longeur et sens
		ArrayList<Point> radPoints = rad.GetRadPoints(s1, 2.0);
		System.out.println("Size radPoints -> 2 normalement :"+radPoints.size());
//		for (int i = 0 ; i<radPoints.size();i++)
//		{
//				radPoints.get(i).DisplayCoordinates();
//		}
		ArrayList<Segment> Radials = new ArrayList<Segment>();
		ArrayList<Segment> seg = new ArrayList<Segment>();
		seg.add(s1);
		for (int i = 0 ; i<radPoints.size()-1;i++)
		{
				Segment s = new Segment(radPoints.get(i),radPoints.get(i+1));
				Radials.add(s);
				i++;
				
		}
		Radials = rad.RadialsFirstPointCoordinates (reference);
		JCanvas myPanel = new JCanvas(reference.getSegments(),Radials);
		//JCanvas myPanel = new JCanvas(seg,Radials);
		myPanel.setBackground(Color.WHITE);
		myPanel.setPreferredSize(new Dimension(800,800));
		GUIHelper.showOnFrame(myPanel,"myPanel");
		
	

	}

}
