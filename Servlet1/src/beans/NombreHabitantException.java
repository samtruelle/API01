package beans;

public class NombreHabitantException extends Exception{
	
	private String ex;
	
	NombreHabitantException(String ex){
		super(ex);
		//on prefere passer par notre variable de contenu, plutôt que celle de la classe Exception pour l'entrainement
		this.setEx(ex);
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}
}
