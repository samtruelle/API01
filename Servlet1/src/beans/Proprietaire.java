package beans;

public class Proprietaire {
	
	private String nom;	
	
	public Proprietaire(String nom){
		this.setNom(nom);		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
