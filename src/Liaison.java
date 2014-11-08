
public class Liaison {
	
	private String point1, point2; private int poids;

	public Liaison(String p1, String p2, int poids) {
		// TODO Auto-generated constructor stub
		this.point1 = p1;
		this.point2 = p2;
		this.poids = poids;
	}
	
	public String getPoint1() {
		return this.point1;
	}
	
	public String getPoint2() {
		return this.point2;
	}
	
	public int getPoids() {
		return this.poids;
	}

}
