import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Demo3 {

	public static void main(String[] args) {

		
		Point p2 = new Point(10.0,10.0); 
		Point p1 = new Point(15.0,15.0);
		

		Point p4 = new Point(20.0,10.0);
		Point p3 = new Point(15.0,15.0); 
		
		Point p5 = new Point(15.0,5.0);
		Point p6 = new Point(10.0,10.0); 
		
		Point p7 = new Point(20.0,10.0);
		Point p8 = new Point(15.0,5.0); 
		
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p3, p4);
		Segment s3 = new Segment(p5, p6);
		Segment s4 = new Segment(p7, p8);
		
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(s1);
		segments.add(s2);
		segments.add(s3);
		segments.add(s4);
		
		Radial rad = new Radial(2.0,3.0,false); //pas,longeur et sens
		ArrayList<Point> radPointsS1 = rad.GetRadPoints(s1, 2.0);
		ArrayList<Point> radPointsS2 = rad.GetRadPoints(s2, 2.0);
		ArrayList<Point> radPointsS3 = rad.GetRadPoints(s3, 2.0);
		ArrayList<Point> radPointsS4 = rad.GetRadPoints(s4, 2.0);
		ArrayList<Segment> Radials = new ArrayList<Segment>();
		for (int i = 0 ; i<radPointsS1.size()-1;i++)
		{
				Segment s = new Segment(radPointsS1.get(i),radPointsS1.get(i+1));
				Radials.add(s);
				i++;		
		}
		for (int i = 0 ; i<radPointsS2.size()-1;i++)
		{
				Segment s = new Segment(radPointsS2.get(i),radPointsS2.get(i+1));
				Radials.add(s);
				i++;		
		}
		for (int i = 0 ; i<radPointsS3.size()-1;i++)
		{
				Segment s = new Segment(radPointsS3.get(i),radPointsS3.get(i+1));
				Radials.add(s);
				i++;		
		}
		for (int i = 0 ; i<radPointsS4.size()-1;i++)
		{
				Segment s = new Segment(radPointsS4.get(i),radPointsS4.get(i+1));
				Radials.add(s);
				i++;		
		}
		
		
		JCanvas myPanel = new JCanvas(segments,Radials);
		myPanel.setBackground(Color.WHITE);
		myPanel.setPreferredSize(new Dimension(800,800));
		GUIHelper.showOnFrame(myPanel,"myPanel");

	}

}
