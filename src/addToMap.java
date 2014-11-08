import java.util.ArrayList;
import java.util.List;

public class addToMap {

	private static String liaisons1[] = { "A", "A", "B", "C", "C", "D" };
	private static String liaisons2[] = { "B", "C", "C", "D", "E", "E" };
	private static int poids[] = { 3, 8, 10, 7, 5, 10 };

	private static List<String> pointsConnectes = new ArrayList<String>();
	private static List<Number> poidsConnections = new ArrayList<Number>();

	public static int dim() {
		return poids.length;
	}

	public static String addLiaison1(int i) {
		return liaisons1[i];
	}

	public static String addLiaison2(int i) {
		return liaisons2[i];
	}

	public static int addPoids(int i) {
		return poids[i];
	}

	public static void calcLiaisons(String point) {
		pointsConnectes.clear();
		poidsConnections.clear();
		for (int i = 0; i < liaisons1.length; i++) {
			if (liaisons1[i].equals(point)) {
				pointsConnectes.add(liaisons2[i]);
				poidsConnections.add(poids[i]);
			}
		}
		for (int i = 0; i < liaisons2.length; i++) {
			if (liaisons2[i].equals(point)) {
				pointsConnectes.add(liaisons1[i]);
				poidsConnections.add(poids[i]);
			}
		}
	}

	public static List<String> getConnectedPointsTo() {
		return pointsConnectes;
	}

	public static List<Number> getPoidsLiaisonTo() {
		return poidsConnections;
	}
}