import java.util.ArrayList;

public class Line {
	
	public ArrayList<Point> coordonnees; 
	
	public Line ( ArrayList<Point> coordonnees)
	{
		this.coordonnees = coordonnees ;
	}

	public static  Double distance (Point p1,Point p2) // Cette méthode retourne la longeur d'un segment définit par deux points 
	{		
		 return Math.sqrt((p2.y - p1.y)*(p2.y - p1.y) + (p2.x - p1.x)*(p2.x - p1.x));
	}
	
	public Double Slope(Point p1,Point p2)
	{
		Double m;
		m = (p2.y - p1.y) / (p2.x - p1.x) ;
		return m;
	}
	
	public static Double Slope2(Point p1,Point p2)
	{
		Double m;
		m = (p2.y - p1.y) / (p2.x - p1.x) ;
		return m;
	}
	
	public Double longeur () //Cette méthode calcule la somme des longeurs des segments formant la ligne
	{
		Double res = 0.0;
		for(int i=0;i<this.coordonnees.size()-1;i++)
		{
			res = res + distance(coordonnees.get(i),coordonnees.get(i+1));
		}
		return res;		
	}
	
	public ArrayList<lineInfo>  informations () 
	{
		ArrayList<lineInfo> infoTab = new ArrayList<lineInfo>();
		 
		
		for(int i=0;i<this.coordonnees.size()-1;i++)
		{
			lineInfo segInfo = new lineInfo(); 
			ArrayList<Point> segCoordinate = new ArrayList<Point>();
			segCoordinate.add(coordonnees.get(i));
			segCoordinate.add(coordonnees.get(i+1));
			Line seg = new Line(segCoordinate);
			segInfo.setSegment(seg);
			//segInfo.setLongeurSegement(segInfo.getSegment().distance(segInfo.getSegment().coordonnees.get(0), segInfo.getSegment().coordonnees.get(1)));
			segInfo.setLongeurSegement(Line.distance(segInfo.getSegment().coordonnees.get(0), segInfo.getSegment().coordonnees.get(1)));
			infoTab.add(segInfo);
		}
		return infoTab ;
	}
	
	public void DisplayInfo(ArrayList<lineInfo>  informations) 
	{
		System.out.println("Segment:                          Longeur du semgent           ");
		for(int i=0;i<informations.size();i++)
		{
			System.out.print(informations.get(i).segment.coordonnees.get(0).x+" @ "+informations.get(i).segment.coordonnees.get(0).y+"     ");
			System.out.print(informations.get(i).segment.coordonnees.get(1).x+" @ "+informations.get(i).segment.coordonnees.get(1).y+"     ");
			System.out.println(informations.get(i).longeurSegement);
		}
		
	}
	public ArrayList<Point> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(ArrayList<Point> coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	/*public ArrayList<Point> Equation(Line l, Double slope)
	{
		ArrayList<Point> LinePoints = new ArrayList<Point>();
		//Trouver l'équation d'un segement à parti de la pente et un point connu 
		Point p1 = l.coordonnees.get(0); //
		Point p2 = l.coordonnees.get(1); // 
		
		System.out.println("**"+Math.max(p1.x, p2.x));
		
		for(Double X2=p1.x;X2<p2.x;X2++)
		{
			for(Double Y2=p1.y;Y2<p2.y;Y2++)
			{
				if(-Y2+p1.y+slope*(X2-p1.x) == 0)
				{				
					LinePoints.add(new Point(X2,Y2));
					System.out.println("un point a été ajouté !");
				}
				else 
				{
					System.out.println("!!!");
				}
			}
		}
			
		return LinePoints;
	}*/
	


}
