import java.util.ArrayList;

public class Radial {
	
	Double longueur;

	public Radial(Double pas) {
		this.longueur = pas;
	}

	public Double getPas() {
		return longueur;
	}

	public void setPas(Double pas) {
		this.longueur = pas;
	} 
	
	public ArrayList<Point> verifIntersection (Circle c,Line l)
	{
		
		Point startPoint = l.coordonnees.get(0);
		System.out.println("StartX -> "+startPoint.x);
		System.out.println("StartY -> "+startPoint.y);
		Point endPoint   = l.coordonnees.get(1);
		System.out.println("EndX -> "+endPoint.x);
		System.out.println("EndY -> "+endPoint.y);
		Double radius = c.radius;
		System.out.println("radius -> "+radius);
		
		Double dx = endPoint.x - startPoint.x ; 
		Double dy = endPoint.y - startPoint.y ; 
		Double dr = Math.sqrt((Math.pow(dx, 2) +Math.pow(dy, 2)));
		Double D = (startPoint.x * endPoint.y) - (endPoint.x*startPoint.y);
		Double delta = (Math.pow(radius, 2)*Math.pow(dr, 2))-Math.pow(D,2);//radius*radius*dr*dr-D*D;
		
		ArrayList<Point> intersection = new  ArrayList<Point>();
		Double x1,y1,x2,y2 ; 
		x1 = ((D*dy)+((Math.signum(dy))*dx*(Math.sqrt(((Math.pow(radius, 2))*(Math.pow(dr, 2)))-(Math.pow(D, 2))))))/(Math.pow(dr, 2));
		y1 = ((-D*dx)+((Math.abs(dy))*(Math.sqrt(((Math.pow(radius, 2))*(Math.pow(dr, 2)))-(Math.pow(D, 2))))))/(Math.pow(dr, 2));

		y2 = ((-D*dx)-((Math.abs(dy))*(Math.sqrt((Math.pow(radius, 2)*Math.pow(dr, 2))-(Math.pow(D, 2))))))/(Math.pow(dr, 2));
		x2 = ((D*dy)-((Math.signum(dy))*dx*(Math.sqrt(((Math.pow(radius, 2))*(Math.pow(dr, 2)))-(Math.pow(D, 2))))))/(Math.pow(dr, 2)) ;
		if ((delta>0)||(delta == 0))
		{
			System.out.println("delta --> "+ delta);
			
			//return true; 
		}
		intersection.add(new Point(x1,y1));
		intersection.add(new Point(x2,y2));
		System.out.println(Math.signum(-15.0));
		return intersection;
	}
	
	public ArrayList<Point> IntersectionPoint (Circle c,Line l)//Intersection Cercle/ligne, La ligne ne doit pas être composé de plusieurs segment
	{
		ArrayList<Point> Intersection = new ArrayList<Point>();
		Point startPoint = l.coordonnees.get(0);
		System.out.println("StartX -> "+startPoint.x);
		System.out.println("StartY -> "+startPoint.y);
		Point endPoint   = l.coordonnees.get(1);
		System.out.println("EndX -> "+endPoint.x);
		System.out.println("EndY -> "+endPoint.y);
		Point center = c.center;
		Double radius = c.radius;
		Double lineSlope = l.Slope(startPoint, endPoint);
		
		System.out.println("radius -> " + radius);
		System.out.println("lineSlope -> "+lineSlope);
		
		// L'équation d'une ligne à partir: d'un point connu et de la pente de la ligne est y-y0=lineSlope*(x-x0) ou (x0,y0) sont les coordonnées d'un des deux point définissant le segment passé en parametre 
		// Et nous savon que l'équation générale d'un circle est sous la forme (x−a)*(x−a)+(y−b)*(y−b)=r*r  ou (a,b) sont les coordonées du centre du cercle 
		// Ce qui nous interesse c'est les coordonnées du point d'intersecton entre la ligne et le circle, ce point la si il existe il doit satisfaire les deux équations(ligne,circle)
		// A partir de l'équation du segment on obtient y = y0+lineSlope*(x-x0)
		// En le remplacant dans l'equation du cercle on obtient 	(x−a)*(x−a)+((y0+lineSlope*(x-x0))−b)*((y0+lineSlope*(x-x0))−b)=r*r 
		// Ce qui donne (x−x0)*(x−x0)+lineSlope*lineSlope*(x−x0)*(x-x0)=r*r 
		// Ce qui donne x = a+r/Math.sqrt(1+lineSlope*lineSlope)
		
		double temp = startPoint.y - center.y;
		
				
//	    double x1=startPoint.x + ((radius)/(Math.sqrt(1+(lineSlope*lineSlope)))) ;
//		double x2=startPoint.x - ((radius)/(Math.sqrt(1+(lineSlope*lineSlope)))) ;
//	    double y1 =startPoint.y+((lineSlope)*(x1-startPoint.x));
//		double y2 =startPoint.y+((lineSlope)*(x2-startPoint.x));
//		double y1 =center.y+((lineSlope)*(x1-center.x));
//		double y2 =center.y+((lineSlope)*(x2-center.x));
		double x1 = center.x + ((radius)/(Math.sqrt(1+(lineSlope*lineSlope)))) ;
		double x2 = center.x - ((radius)/(Math.sqrt(1+(lineSlope*lineSlope)))) ;
		double y1 =center.y+((lineSlope)*(x1-center.x));
		double y2 =center.y+((lineSlope)*(x2-center.x));
		Intersection.add(new Point(x1,y1));
		Intersection.add(new Point(x2,y2));				
		return Intersection ;
	}
	public ArrayList<Point> IntersectionPoint2 (Line l)//la ligne ici est une ligne composée de plusieurs segements
	{
		ArrayList<Point> Intersection = new ArrayList<Point>();
		//ArrayList<Point> segmentCoordinate = new ArrayList<Point>();
		//segmentCoordinate.add(l.coordonnees.get(0));
		//segmentCoordinate.add(l.coordonnees.get(1));
		Point firstPoint = l.coordonnees.get(0);
		System.out.println("FirstPoint: "+firstPoint.x+"@"+firstPoint.y);
		//Dessiner un cercle à partir de ce point qui a un rayon correspondant au pas de temps 
		Circle c = new Circle(firstPoint, this.longueur);
		System.out.println("pas -> " + this.longueur);
		//Verification si le point d'intersection est avec le 1er segment 
		ArrayList<lineInfo> informations = l.informations(); 
		if(c.radius>l.informations().get(0).longeurSegement)
		{
			System.out.println("la longeur du rayon est plus grande que la longeur du segment, donc le cercle coupe le segment suivant");
			Line seg = l.informations().get(1).segment;
			System.out.println("information sur le segment suivant");
			System.out.println("longeur : " + Line.distance(seg.coordonnees.get(0),seg.coordonnees.get(1)));
			System.out.println("longeur : " +seg.longeur());
			System.out.println("first point : " + seg.getCoordonnees().get(0).x+"@"+seg.getCoordonnees().get(0).y);
			System.out.println("end point : "   + seg.getCoordonnees().get(1).x+"@"+seg.getCoordonnees().get(1).y);
			System.out.println("Pente du segment : "+seg.Slope(seg.coordonnees.get(0),seg.coordonnees.get(1)));
			Intersection = this.IntersectionPoint(c, seg);
		}
		return Intersection;
	}
	
	
	//
	
	public Point findFirstPointRad(Point startPoint,Point endPoint,Double distance) //Pour trouver les coordoonées d'un point situé sur un segment et a une distance donnée 
	{	
		Double x,y;
		Double slope = Line.Slope2(startPoint, endPoint);
		System.out.println("slope : " +slope);
		//System.out.println("slope2 : " +slope2);		
		//(1) pr.y-startPoint.y = slope*(pr.x-startPoint.x); equation du segment 
		//(2) Math.pow((pr.y-startPoint.y ), 2)+Math.pow((pr.x-startPoint.x ),2) = distance ; la distance entre le point du début de segement et le point de la radial		
		//Les coordonnées du point de radiale doit satisfaire les deux equations 
		//De 1) 
		//pr.y = startPoint.y+slope*(pr.x-startPoint.x); En remplacant pr.y dans l'équation (2) on obtient : 		
		x = Math.sqrt((Math.pow(distance,2))/(Math.pow(slope, 2)+1))+startPoint.x;
		y = (slope*(Math.sqrt((Math.pow(distance, 2))/(Math.pow(slope, 2)+1))))+startPoint.y;

		return new Point(x,y);
	}
	public Point findSecondePointRad(Point FirstPointRad, Double slope)
	{
		Double x,y;  	
		x = FirstPointRad.x-Math.sqrt((Math.pow(longueur,2))/(Math.pow(slope, 2)+1));
		y = FirstPointRad.y-(slope*(Math.sqrt((Math.pow(longueur, 2))/(Math.pow(slope, 2)+1))));
		return new Point(x,y);
	}
	
	public ArrayList<Point> RadialCoordinate(Point startPoint,Point endPoint,Double distance) //cette fonction renvoie les coordonnes des deux points définissant la radiale
	{
		
		Double x0,y0,x1,y1;
		ArrayList<Point> res = new ArrayList<Point>();
		Double slope = Line.Slope2(startPoint, endPoint);
		Double slope2 = -1.0/slope;
		System.out.println("Slope : " +slope);    // La pente du segment de la ligne de référence.
		System.out.println("Slope2 : " +slope2);  // La pente du segment perpendiculaire  formant la radiale.
		
		//(1) pr.y-startPoint.y = slope*(pr.x-startPoint.x); equation du segment 
		//(2) Math.pow((pr.y-startPoint.y ), 2)+Math.pow((pr.x-startPoint.x ),2) = distance ; la distance entre le point du début de segement et le point du radial		
		//Les coordonnées du point de radiale doit satisfaire les deux equations 
		//De 1) 
		//pr.y = startPoint.y+slope*(pr.x-startPoint.x); En remplacant pr.y dans l'équation (2) on obtient : 	
		
		x0 = Math.sqrt((Math.pow(distance,2))/(Math.pow(slope, 2)+1))+startPoint.x;
		y0 = (slope*(Math.sqrt((Math.pow(distance, 2))/(Math.pow(slope, 2)+1))))+startPoint.y;
		res.add(new Point(x0,y0));
		x1 = x0-Math.sqrt((Math.pow(longueur,2))/(Math.pow(slope2, 2)+1));
		y1 = y0-(slope2*(Math.sqrt((Math.pow(longueur, 2))/(Math.pow(slope2, 2)+1))));
		res.add(new Point(x1,y1));
		return res;
	}

}
