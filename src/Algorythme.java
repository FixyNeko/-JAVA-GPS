import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorythme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<String> liaisons = new ArrayList<String>();
		// String liste[] = { "A", "B", "C", "D", "E" };
		// for (int i = 0; i < liste.length; i++) {
		// liaisons.add(liste[i]);
		// }
		//
		// liaisons.set(3, 4);
		//
		// for (int i = 0; i < liaisons.size(); i++) {
		// System.out.println(liaisons.get(i));
		// }
		//
		// for (int i = 0; i < addToMap.dim(); i++) {
		// if (addToMap.addLiaison1(i).equals("A"))
		// System.out.println("La chaine à l'emplacement " + i
		// + " est un A");
		// else
		// System.out.println("La chaine à l'emplacement " + i
		// + " n'est pas un A");
		// }
		String x,z;
		int y = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le point de départ:");
		x = sc.next();
		System.out.println("Entrer le point d'arrivée:");
		String pointArrivee = sc.next();
		do {
			addToMap.calcLiaisons(x);
			List<String> pointsConnectes = addToMap.getConnectedPointsTo();
			List<Number> poidsLiaisons   = addToMap.getPoidsLiaisonTo();
			poidsLiaisons = poidsLiaisons.;
		} while (x != pointArrivee);

	}
}