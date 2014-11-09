public class Liaison {
	
	//chaque objet Liaison comprend une extremit� 1 (un point), une extr�mit� 2 (un point), et un poids caract�risant la distance entre les 2 extr�mit�s

	private String point1, point2;
	private int poids;

	public Liaison(String p1, String p2, int poids) { //C'est un constructeur. A chaque fois qu'on l'appelle, il va cr�er une nouvelle variable de type Liaison (comme String, par exemple)
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
