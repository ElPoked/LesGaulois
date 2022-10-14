package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois [] villageois;
	
	public Village(String nom, Chef chef, int nbVillageoisMax, Gaulois [] villageois) {
		super();
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois [nbVillageoisMax];
	}
	 
	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]= gaulois;
		nbVillageois+=1;
		
	}
}
