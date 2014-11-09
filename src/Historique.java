public class Historique {

	private String point, pointPrecedent;
	private int poids;

	public Historique(String point, String pointPrecedent, int poids) {//On crée une variable de type Historique, qui contient un point, celui par qui on est venu, et le poids total à ce moment
		this.point = point;
		this.pointPrecedent = pointPrecedent;
		this.poids = poids;
	}

	public String getPoint() {
		return this.point;
	}

	public String getPointPrecedent() {
		return this.pointPrecedent;
	}

	public int getPoids() {
		return this.poids;
	}

}
