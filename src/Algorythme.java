import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorythme {

	static List<Historique> historique = new ArrayList<Historique>(),//liste qui va contenir tous les points en attente d'�tre test�s
			historiqueSelectionne = new ArrayList<Historique>();//liste qui va contenir tous les points selectionnes, d'o� ils viennent, leur poids total
	static List<String> pointsDejaFaits = new ArrayList<String>();//liste qui va contenir le nom des points qu'on a d�ja test�s

	public static void main(String[] args) {
		String x, z = null, pointArrivee, pointDepart;
		int y = 0, plusPetit;

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le point de d�part:");
		pointDepart = sc.next();
		System.out.println("Entrer le point d'arriv�e:");
		pointArrivee = sc.next();
		x = pointDepart;
		do {
			System.out.println("Test�: " + x);
			pointsDejaFaits.add(x); //on ajoute le point � la liste des points deja test�s
			AddToMap.calcLiaisons(x); //on lance le calcul des points reli�s
			String[] pointsConnectes = AddToMap.getConnectedPointsTo(); //on recup�re le nom des points reli�s
			int[] poidsLiaisons = AddToMap.getPoidsLiaisonTo(); //et leur distance du point x
			for (int i = 0; i < poidsLiaisons.length; i++) { //on ajoute le poids de x, pour avoir leur poids total par rapport au tout premier point
				poidsLiaisons[i] = poidsLiaisons[i] + y;
			}
			for (int i = 0; i < pointsConnectes.length; i++) { //pour le nombre de points connect�s � x
				boolean found = false;
				for (int j = 0; j < historique.size(); j++) { //on compare � chacun des points en attente de traitement
					if (historique.get(j).getPoint().equals(pointsConnectes[i])) { //si le point est le m�me
						found = true; //le point est d�j� dans la liste
						if (historique.get(j).getPoids() > poidsLiaisons[i]) //si le nouveau point pr�sente un chemin plus court
							historique.set(j, new Historique(
									pointsConnectes[i], x, poidsLiaisons[i])); //on remplace d'o� il vient et le poids total par les nouveaux trouv�s
					}
				}
				if (!found) //si le point est pas d�j� dans la liste
					historique.add(new Historique(pointsConnectes[i], x,
							poidsLiaisons[i])); //on le rajoute
			}
			
			do { //on cherche le points le moins loin du tout premier point dans la liste de points � traiter
				plusPetit = 0; //par d�fault, le premier numero de la liste
				for (int i = 0; i < historique.size(); i++) { //on teste tous les point � traiter un par un
					if (historique.get(plusPetit).getPoids() > historique
							.get(i).getPoids()) //si on en trouve un plus Petit
						plusPetit = i; //on stocke son numero
				}
			} while (testDejaFait(plusPetit)); //on appelle la fonction testDejaFait, et on lui envoie le numero trouv�. Si d�ja fait, on boucle

			x = historique.get(plusPetit).getPoint(); //on stocke les param�tres du nouveau point
			z = historique.get(plusPetit).getPointPrecedent();
			y = historique.get(plusPetit).getPoids();

			historiqueSelectionne.add(new Historique(x, z, y)); //on ajoute le point � l'historique des selectionn�s
		} while (!x.equals(pointArrivee)); //on boucle tant que le point selectionn� n'est pas celui de fin
		
		List<String> cheminInverse = new ArrayList<String>();
		while(!x.equals(pointDepart)) { //on recherche le chemin (cette liste est invers�e, on remonte les donn�es jusqu'� la source)
			cheminInverse.add(x); //on ajoute le point au chemin
			String trouve = null;
			for (int i = 0; i < historiqueSelectionne.size(); i++) {
				if (historiqueSelectionne.get(i).getPoint().equals(x)) {
					trouve = historiqueSelectionne.get(i).getPointPrecedent(); //on note le point pr�c�dent au point recherch�
				}
			}
			x = trouve; //on remonte la source, nouveau x = le point precedent de l'ancien x
		}
		cheminInverse.add(x); //on ajoute le dernier point (non ajout� par la boucle au dessus)
		String[] chemin = new String[cheminInverse.size()]; //on cr�e la variable finale
		
		for (int i = 0; i < cheminInverse.size(); i++) //on inverse toutes les lettres (fin au d�but, d�but � la fin)
			chemin[i] = cheminInverse.get(cheminInverse.size() - 1 - i);
		for (int i = 0; i < chemin.length; i++) //on affiche PPCM (plus petit chemin) trouv� dans la console
			System.out.print(chemin[i] + " ");
	}

	public static boolean testDejaFait(int plusPetit) {
		boolean retour = false;
		if (pointsDejaFaits.contains(historique.get(plusPetit).getPoint())) { //si le point se trouve dans la liste des d�ja faits
			historique.remove(plusPetit); //on le supprime de la liste
			retour = true; //le point �tait d�ja fait
			;
		}
		return retour;
	}
}