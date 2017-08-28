import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Demo5 {

	public static void main(String[] args) {
		
		Point p1 = new Point(2.0,1.0);
		Point p2 = new Point(3.5,3.0);
		Point p3 = new Point(8.0,6.0);
		Point p4 = new Point(11.5,5.5);
		Point p5 = new Point(13.0,9.0);
		Point p6 = new Point(17.0,9.0);
		Point p7 = new Point(19.0,2.0);   
		
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p2, p3);
		Segment s3 = new Segment(p3, p4);
		Segment s4 = new Segment(p4, p5);
		Segment s5 = new Segment(p5, p6);
		Segment s6 = new Segment(p6, p7);

		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(s1);
		segments.add(s2);
		segments.add(s3);
		segments.add(s4);
		segments.add(s5);
		segments.add(s6);

		Line reference = new Line(segments);
		Radial rad = new Radial(0.5,6.0,false); //pas,longeur et sens
		ArrayList<Segment> Radials = new ArrayList<Segment>();
		Radials = rad.RadialsFirstPointCoordinates (reference);
		JCanvas myPanel = new JCanvas(reference.getSegments(),Radials);
		myPanel.setBackground(Color.WHITE);
		myPanel.setPreferredSize(new Dimension(800,800));
		GUIHelper.showOnFrame(myPanel,"myPanel");
	}

}
