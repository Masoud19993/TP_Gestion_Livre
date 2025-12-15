package gestionnaireDeLivres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireLivre {
	
	// Les proprieté
	private ArrayList<Livre> listeDeLivres = new ArrayList<>();
	
	// Les methods
	public void ajoutLivre(Livre l) {
		this.listeDeLivres.add(l);
	}
	
	public void affiche() {
		System.out.println("****************");
		for(Livre livre : this.listeDeLivres) {
			System.out.println(livre);
			System.out.println("****************");
		}
	}
	
	public Livre recherch(String titre) {
		for(Livre livre : this.listeDeLivres) {
			if (titre.equals(livre.getTitre())) {
				return livre;
			}
			
		}
		return null;
		
	}
	
	public void modifierLivre(Scanner Input) {
		int flag = 0;
		int livre_index = -1;
		int choix = -1;
		
		do {
			System.out.println("Quel est le titre du livre que vous voulez modifier?\nTapper \"e\" pour arreter");
			String titre = Input.nextLine();
			if (titre.equals("e")) {
				return;
			}
			
			Livre livre = this.recherch(titre);
			if (livre == null) {
				System.out.println("Ce livre n'exist pas dans notre gestionnaire de livre. Voici la list des livres: \n"+ this.listeDeLivres);
			}
			else {
				System.out.println("Voici le livre trouvé :\n"+livre);
				livre_index = this.listeDeLivres.indexOf(livre);
				flag = 1;
			}
					

		}while(flag == 0);
		
		
		do{
			System.out.println("Que est-ce que vous voulez modifier? Entrer\n1 pour changer le titre\n2 pour changer l'auteur\n3 pour changer ISBN\n4 pour changer année de publication\n5 pour changer le genre\n0 pour sortir.");
			choix = Input.nextInt();
			Input.nextLine(); // consomme le \n
			Livre livre = this.listeDeLivres.get(livre_index);
			if (choix==0)
				return;
			
			else if (choix==1) {
				System.out.println("Entrer le nouveau titre :");
				String nouveauTitre = Input.nextLine();
				livre.setTitre(nouveauTitre);
				System.out.println("Le changement est fait!");
			}
			
			else if (choix==2) {
				System.out.println("Entrer le nouveau auteur :");
				String nouveauAuteur = Input.nextLine();
				livre.setAuteur(nouveauAuteur);
				System.out.println("Le changement est fait!");
			}
			
			else if (choix==3) {
				System.out.println("Entrer le nouveau ISBN :");
				String nouveauISBN = Input.nextLine();
				livre.setIsbn(nouveauISBN);
				System.out.println("Le changement est fait!");
			}
			
			else if (choix==4) {
				System.out.println("Entrer la nouvelle année de publication :");
				int nouveauAnneDePublication = Input.nextInt();
				Input.nextLine(); // consomme le \n
				livre.setAnneDePublication(nouveauAnneDePublication);
				System.out.println("Le changement est fait!");
			}
			
			else if (choix==5) {
				System.out.println("Entrer le nouveau genre :");
				String nouveauGenre = Input.nextLine();
				livre.setGenre(nouveauGenre);
				System.out.println("Le changement est fait!");
			}
			
			else
				System.out.println("Votre choix n'est pas valable!");
		}while(choix!=0);
		
		
	}
	
	
	public void supprimerLivre(Scanner Input) {
		
		int flag = 0;
		
		do {
			System.out.println("Quel est le titre du livre que vous voulez supprimer?\nTapper \"e\" pour arreter");
			String titre = Input.nextLine();
			if (titre.equals("e")) {
				return;
			}
			
			Livre livre = this.recherch(titre);
			if (livre == null) {
				System.out.println("Ce livre n'exist pas dans notre gestionnaire de livre. Voici la list des livres: \n"+ this.listeDeLivres);
			}
			else {
				int livre_index = this.listeDeLivres.indexOf(livre);
				System.out.println("Voice le livre trouvé :\n"+livre+ "\nEst-ce que vous êtes sûr?");
				String reponse = Input.nextLine();
				if(reponse.equals("Oui") || reponse.equals("oui")) {
					this.listeDeLivres.remove(livre_index);
					System.out.println("Le liver a été supprimé!");
				}
				flag = 1;
				
			}
					

		}while(flag == 0);
		
	}
	
	
	public void sauvgarderLivres(String path) {
		
		try {
			FileWriter Writer = new FileWriter(path);
			for (Livre l : this.listeDeLivres) {
				Writer.write(l.getTitre() + "," + l.getAuteur() + "," + l.getIsbn() + "," + l.getAnneDePublication() + "," +l.getGenre() + "\n");
			}
			
			Writer.close();
			System.out.println("Sauvgard est terminé!");
		}catch(Exception e) {
			System.out.println("Error lors de sauvgarde les livres : " + e.getMessage());
		}
	}
	
	
	public void chargerLivres(String path) {
		try{
			this.listeDeLivres.clear();
			BufferedReader Reader = new BufferedReader(new FileReader(path));
			
			String ligne = Reader.readLine();
			while(ligne != null) {
				String[] parties = ligne.split(",");
				
				Livre l = new Livre();
				l.setTitre(parties[0]);
				l.setAuteur(parties[1]);
				l.setIsbn(parties[2]);
				l.setAnneDePublication(Integer.parseInt(parties[3]));
				l.setGenre(parties[4]);
				
				this.listeDeLivres.add(l);
				ligne = Reader.readLine();
			}
			
			Reader.close();
			System.out.println("Tous les livres ont été chargés");
		}catch(Exception e) {
			System.out.println("Error lors de chargement du fichier : " + e.getMessage());
		}
	}

}
