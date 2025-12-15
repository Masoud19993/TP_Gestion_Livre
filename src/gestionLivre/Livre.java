package gestionLivre;

public class Livre {
	
	// declarer les proprité de la classe
	private String titre;
	private String auteur;
	private String isbn;
	private int anneDePublication;
	private String genre;
	
	// constructeur
	public Livre() {}
	
	
	// Les getters
	public String getTitre() {
		return this.titre;
	}
	
	public String getAuteur() {
		return this.auteur;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public int getAnneDePublication() {
		return this.anneDePublication;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	// les setters
	public void setTitre(String titre){
		this.titre = titre;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setAnneDePublication(int anneDePublication) {
		this.anneDePublication = anneDePublication;
	}
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	
	// redefinition la méthode toString()
	@Override
	public String toString() {
		return "Titre : " + this.titre + "\n" +
				"Auteur : " + this.auteur + "\n" +
				"ISBN : " + this.isbn + "\n" +
				"Année de publication : " + this.anneDePublication + "\n" +
				"Genre : " + this.genre;
	}
	

}
