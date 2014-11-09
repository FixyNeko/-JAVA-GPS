import java.util.Scanner;

public class Algorythme {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le point de départ:");
		String pointDepart = sc.next();
		System.out.println("Entrer le point d'arrivée:");
		String pointArrivee = sc.next();

		PathFinder.calcPath(pointDepart, pointArrivee);
		String[] chemin = new String[PathFinder.getPathSize()];
		chemin = PathFinder.getPath();
		for (int i = 0; i < chemin.length; i++)
			System.out.print("->" + chemin[i]);
	}
}