import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddToMap {

	private static List<String> pointsConnectes = new ArrayList<String>(); //liste dynamique, on peut faire varier sa taille
	private static List<Integer> poidsLiaisons = new ArrayList<Integer>();

	static Liaison liaison[] = { new Liaison("A", "B", 3),
			new Liaison("A", "C", 8), new Liaison("B", "C", 10),
			new Liaison("C", "D", 4), new Liaison("C", "E", 5),
			new Liaison("D", "E", 10), new Liaison("B", "D", 4) }; //tableau de type Liaison contenant les liaisons, le numero de la case caracterise le nom de l'objet Liaison

	public static void calcLiaisons(String point) {
		pointsConnectes.clear(); //on vide la liste, pour ne pas avoir d'anciens points residuels
		poidsLiaisons.clear();
		for (int i = 0; i < liaison.length; i++) { //on teste le point 1 de toutes les variables Liaison du tableau
			if (liaison[i].getPoint1().equals(point)) { //si le point est celui entré en paramètre
				pointsConnectes.add(liaison[i].getPoint2()); //on ajoute le point 2 de la variable Liaison
				poidsLiaisons.add(liaison[i].getPoids()); //on ajoute le poids de la variable Liaison
			}
		}
		for (int i = 0; i < liaison.length; i++) { //on recommence en inversant les points 1 et 2 (comme ça on définit une seule liaison qui fait 2 sens, au lieu de 2 qui font un sens chacune)
			if (liaison[i].getPoint2().equals(point)) {
				pointsConnectes.add(liaison[i].getPoint1());
				poidsLiaisons.add(liaison[i].getPoids());
			}
		}
	}

	public static String[] getConnectedPointsTo() {
		String[] tableau = (String[]) pointsConnectes.toArray();
		return tableau; //on retourne le tableau
	}

	public static int[] getPoidsLiaisonTo() {
		//Array.getInt(array, index);
		int[] tableau = new int[poidsLiaisons.size()];
		for (int i = 0; i < poidsLiaisons.size(); i++) {
			tableau[i] = Array.getInt(poidsLiaisons, i);
		}
		return tableau;
	}
}