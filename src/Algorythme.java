import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorythme {

	static List<Historique> historique = new ArrayList<Historique>(),//liste qui va contenir tous les points en attente d'être testés
			historiqueSelectionne = new ArrayList<Historique>();//liste qui va contenir tous les points selectionnes, d'où ils viennent, leur poids total
	static List<String> pointsDejaFaits = new ArrayList<String>();//liste qui va contenir le nom des points qu'on a déja testés

	public static void main(String[] args) {
		String x, z = null, pointArrivee, pointDepart;
		int y = 0, plusPetit;

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le point de départ:");
		pointDepart = sc.next();
		System.out.println("Entrer le point d'arrivée:");
		pointArrivee = sc.next();
		x = pointDepart;
		do {
			System.out.println("Testé: " + x);
			pointsDejaFaits.add(x); //on ajoute le point à la liste des points deja testés
			AddToMap.calcLiaisons(x); //on lance le calcul des points reliés
			String[] pointsConnectes = AddToMap.getConnectedPointsTo(); //on recupère le nom des points reliés
			int[] poidsLiaisons = AddToMap.getPoidsLiaisonTo(); //et leur distance du point x
			for (int i = 0; i < poidsLiaisons.length; i++) { //on ajoute le poids de x, pour avoir leur poids total par rapport au tout premier point
				poidsLiaisons[i] = poidsLiaisons[i] + y;
			}
			for (int i = 0; i < pointsConnectes.length; i++) { //pour le nombre de points connectés à x
				boolean found = false;
				for (int j = 0; j < historique.size(); j++) { //on compare à chacun des points en attente de traitement
					if (historique.get(j).getPoint().equals(pointsConnectes[i])) { //si le point est le même
						found = true; //le point est déjà dans la liste
						if (historique.get(j).getPoids() > poidsLiaisons[i]) //si le nouveau point présente un chemin plus court
							historique.set(j, new Historique(
									pointsConnectes[i], x, poidsLiaisons[i])); //on remplace d'où il vient et le poids total par les nouveaux trouvés
					}
				}
				if (!found) //si le point est pas déjà dans la liste
					historique.add(new Historique(pointsConnectes[i], x,
							poidsLiaisons[i])); //on le rajoute
			}
			
			do { //on cherche le points le moins loin du tout premier point dans la liste de points à traiter
				plusPetit = 0; //par défault, le premier numero de la liste
				for (int i = 0; i < historique.size(); i++) { //on teste tous les point à traiter un par un
					if (historique.get(plusPetit).getPoids() > historique
							.get(i).getPoids()) //si on en trouve un plus Petit
						plusPetit = i; //on stocke son numero
				}
			} while (testDejaFait(plusPetit)); //on appelle la fonction testDejaFait, et on lui envoie le numero trouvé. Si déja fait, on boucle

			x = historique.get(plusPetit).getPoint(); //on stocke les paramètres du nouveau point
			z = historique.get(plusPetit).getPointPrecedent();
			y = historique.get(plusPetit).getPoids();

			historiqueSelectionne.add(new Historique(x, z, y)); //on ajoute le point à l'historique des selectionnés
		} while (!x.equals(pointArrivee)); //on boucle tant que le point selectionné n'est pas celui de fin
		
		List<String> cheminInverse = new ArrayList<String>();
		while(!x.equals(pointDepart)) { //on recherche le chemin (cette liste est inversée, on remonte les données jusqu'à la source)
			cheminInverse.add(x); //on ajoute le point au chemin
			String trouve = null;
			for (int i = 0; i < historiqueSelectionne.size(); i++) {
				if (historiqueSelectionne.get(i).getPoint().equals(x)) {
					trouve = historiqueSelectionne.get(i).getPointPrecedent(); //on note le point précédent au point recherché
				}
			}
			x = trouve; //on remonte la source, nouveau x = le point precedent de l'ancien x
		}
		cheminInverse.add(x); //on ajoute le dernier point (non ajouté par la boucle au dessus)
		String[] chemin = new String[cheminInverse.size()]; //on crée la variable finale
		
		for (int i = 0; i < cheminInverse.size(); i++) //on inverse toutes les lettres (fin au début, début à la fin)
			chemin[i] = cheminInverse.get(cheminInverse.size() - 1 - i);
		for (int i = 0; i < chemin.length; i++) //on affiche PPCM (plus petit chemin) trouvé dans la console
			System.out.print(chemin[i] + " ");
	}

	public static boolean testDejaFait(int plusPetit) {
		boolean retour = false;
		if (pointsDejaFaits.contains(historique.get(plusPetit).getPoint())) { //si le point se trouve dans la liste des déja faits
			historique.remove(plusPetit); //on le supprime de la liste
			retour = true; //le point était déja fait
			;
		}
		return retour;
	}
}