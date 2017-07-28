
public  class lineInfo { //Cette classe a pour but de donner des informations sur un segment de la ligne.
	
	Line segment;    //Le segment 
	Double longeurSegement; //La longeur du segment

	public lineInfo() {		
		this.segment = null;
		this.longeurSegement =null;
	}
	
	public Line getSegment() {
		return segment;
	}
	public Double getLongeurSegement() {
		return longeurSegement;
	}

	public void setSegment(Line segment) {
		this.segment = segment;
	}
	
	public void setLongeurSegement(Double longeurSegement) {
		this.longeurSegement = longeurSegement;
	}
	

	
}
