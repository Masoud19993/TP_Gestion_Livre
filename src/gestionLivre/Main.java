package gestionLivre;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		GestionnaireLivre monGL = new GestionnaireLivre();
		String path = "bibliotheque.txt";
		monGL.chargerLivres(path);
		
		Scanner Input = new Scanner(System.in);
		
		int choix;
		do {
			
			System.out.println("Bienvenue à notre bibliothèqe. Entrer\n"+
			"1 pour ajouter un nouveau livre\n"+
			"2 pour consulter la liste de tous les livres\n"+
			"3 pour rechercher un livre par son titre\n"+
			"4 pour modifier un livre existant\n"+
			"5 pour supprimer un livre\n"+
			"6 pour sauvgarder les livres dans le fichier bibliotheque.txt\n"+
			"7 pour quitter");
			
			choix = Input.nextInt();
			Input.nextLine(); // consomme le \n
			
			
			if (choix == 1) {
				Livre l = new Livre();
				System.out.println("Quel est le titre du livre?");
				l.setTitre(Input.nextLine());
				System.out.println("Qui est l'auteur du livre?");
				l.setAuteur(Input.nextLine());
				System.out.println("Quel est le ISBN du livre?");
				l.setIsbn(Input.nextLine());
				System.out.println("Quel est l'année de publication du livre?");
				l.setAnneDePublication(Input.nextInt());
				Input.nextLine(); // consomme le \n
				System.out.println("Quel est le genre du livre?");
				l.setGenre(Input.nextLine());
				
				monGL.ajoutLivre(l);
				monGL.sauvgarderLivres(path);
			}
			
			
			else if (choix == 2) {
				monGL.affiche();
			}
			
			else if (choix == 3) {
				System.out.println("Quel est le titre du livre que vous chercher?");
				String titre = Input.nextLine();
				Livre livre = monGL.recherch(titre);
				if(livre != null) {
					System.out.println("Voici le resultat de recherche : " + livre);
				}
				else {
					System.out.println("Il n'y a pas de livre avec ce titer!");
				}
				
			}
			
			else if (choix == 4) {
				monGL.modifierLivre(Input);
				monGL.sauvgarderLivres(path);
			}
			
			else if (choix == 5) {
				monGL.supprimerLivre(Input);
				monGL.sauvgarderLivres(path);
			}
			
			else if (choix == 6) {
				monGL.sauvgarderLivres(path);
			}
			
			else if (choix == 7) {
				break;
			}
			
			else {
				System.out.println("Votre choix n'est pas valide");
			}
		

		}while(choix!=7);
		Input.close();
	}
}
