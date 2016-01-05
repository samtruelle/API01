package beans;

public class Adresse {
	
	private String num;
	private String rue;
	private String ville;
	private String codePostal;
	
	public Adresse(String num, String rue, String ville, String codePostal){
		this.setNum(num);
		this.setRue(rue);
		this.setVille(ville);
		this.setCodePostal(codePostal);
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}
