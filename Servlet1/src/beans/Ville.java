package beans;

public class Ville {
	private String nomVille;
	private int nmbreHabitants;
	
	public Ville(String nomville, int nmbreHabitant) throws NombreHabitantException{
		if(nmbreHabitant < 0){
			throw new NombreHabitantException("Nombre d'habitant inférieur à zéro");
		};
		this.setNomVille(nomville);
		this.setNmbreHabitants(nmbreHabitant);
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public int getNmbreHabitants() {
		return nmbreHabitants;
	}

	public void setNmbreHabitants(int nmbreHabitant) {
		this.nmbreHabitants = nmbreHabitant;
	}
}
