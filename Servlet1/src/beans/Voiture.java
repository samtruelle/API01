package beans;

public class Voiture {

	private String marque;
	private String plaque;
	private String couleur;
	private Proprietaire p;
	private Adresse adr;
	static int nbre = 0;
	
	public Voiture(String marque, String plaque){
		this.setMarque(marque);
		this.setPlaque(plaque);
		this.nbre++;
	}
	
	public Voiture(String marque, String plaque, String couleur){
		this.setMarque(marque);
		this.setPlaque(plaque);
		this.setCouleur(couleur);
		this.nbre++;
	}
	
	public Voiture(String marque, String plaque, String couleur, Proprietaire P){
		this.setMarque(marque);
		this.setPlaque(plaque);
		this.setCouleur(couleur);
		this.setP(P);
		this.nbre++;
	}
	
	public Voiture(String marque, String plaque, String couleur, Proprietaire P, Adresse adr){
		this.setMarque(marque);
		this.setPlaque(plaque);
		this.setCouleur(couleur);
		this.setP(P);
		this.nbre++;
		this.setAdr(adr);
	}
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public Proprietaire getP() {
		return p;
	}

	public void setP(Proprietaire p) {
		this.p = p;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
}
