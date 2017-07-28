import java.util.ArrayList;

public class Circle {
	
	Point center; 
	Double radius;
	
	public Circle(Point center, Double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public Double getRadius() {
		return radius;
	}
	public void setRadius(Double radius) {
		this.radius = radius;
	} 
	
	
	/*public ArrayList<Point> circlePoints()
	{
		ArrayList<Point> res = new ArrayList<>();
		double x,y;
		double radians;
		for(int i=0;i<=360;i++)
		{
			radians = Math.toRadians(i);
			x = this.center.x + this.radius*Math.cos(radians);
			y = this.center.y + this.radius*Math.sin(radians);
			res.add(new Point(x, y));
		}
		return res ; 	
	}*/
	
	
	
	

}
