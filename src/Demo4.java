import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Demo4 {

	public static void main(String[] args) {
		
		Point p1 = new Point(152058.46,6863511.5);
		Point p2 = new Point(152062.39,6863502.37);
//		Point p3 = new Point(152062.62,6863485.26);
//		Point p4 = new Point(152056.26,6863463.84);
//		Point p5 = new Point(152044.39,6863435.91);
//		Point p6 = new Point(152018.66,6863404.25);
//		Point p7 = new Point(151958.31,6863354.76);   
//		Point p8 = new Point(151883.74,6863313.96);  
		
		Segment s1 = new Segment(p1, p2);
//		Segment s2 = new Segment(p2, p3);
//		Segment s3 = new Segment(p3, p4);
//		Segment s4 = new Segment(p4, p5);
//		Segment s5 = new Segment(p5, p6);
//		Segment s6 = new Segment(p6, p7);
//		Segment s7 = new Segment(p7, p8);
//		
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(s1);
//		segments.add(s2);
//		segments.add(s3);
//		segments.add(s4);
//		segments.add(s5);
//		segments.add(s6);
//		segments.add(s7);
		
		Line reference = new Line(segments);
		Radial rad = new Radial(4.0,2.0,true);
		ArrayList<Segment> Radials = new ArrayList<Segment>();
		JCanvas myPanel = new JCanvas(reference.getSegments(),Radials);
		myPanel.setBackground(Color.WHITE);
		myPanel.setPreferredSize(new Dimension(800,800));
		GUIHelper.showOnFrame(myPanel,"myPanel");
		

	}

}
