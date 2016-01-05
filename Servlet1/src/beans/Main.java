package beans;

public class Main {
	
	public static int minimum(int[] tab){
		int tmp = 0;
		for(int i = 0;i<10;i++){
			if(tmp > tab[i])
				tmp = tab[i];
		}
		return tmp;
	}
	
	public static int maximum(int[] tab){
		int tmp = 0;
		for(int i = 0;i<10;i++){
			if(tmp < tab[i])
				tmp = tab[i];
		}
		return tmp;
	}
	
	public static int moyenne(int[] tab){
		int tmp=0;
		for(int i=0;i<10;i++){
			tmp+=tab[i];
		}
		return tmp/10;
	}
	
	public static double ecartType(int[] tab){
		int tmp = 0;
		int moy = moyenne(tab);
		for(int i=0;i<10;i++){
			tmp += (tab[i] - moy)^2;  
		}
		return (Math.sqrt(tmp/10));
	}
	
	public static void main(String[] args){
		
		/*Création et initialisation tableau*/
		int[] tab = new int[10];
		for(int i=0;i<10;i++){
			tab[i] = i;
		}
		/**/
		
		/*test des méthode de calcul mathématique sur un tableau*/
		System.out.println("minimum " + minimum(tab));
		System.out.println("maximum " + maximum(tab));
		System.out.println("moyenne " + moyenne(tab));
		System.out.println("ecart_type " + ecartType(tab));
		/**/
		
		/*Création de deux voitures*/
		Voiture v1 = new Voiture("marque", "plaque");
		Voiture v2 = new Voiture("golf", "plaque");
		/**/
		
		/*Création de voitures avec proprietaire et adresse*/
		Adresse adr1 = new Adresse("323", "rue colet", "ville", "CP");
		Proprietaire p1 = new Proprietaire("Charles");
		Voiture v3 = new Voiture("Renault", "AA 966 89", "rouge", p1, adr1);
		/**/
		
		/*Instanciation d'une ville et levée d'une exception*/
		Ville ville;				
		try{
			ville = new Ville("Ville_Test_Exception", -2);
		}
		catch(NombreHabitantException e){
			System.out.println(e.getEx());
		}
		finally{
		}
		/**/
	}
}
