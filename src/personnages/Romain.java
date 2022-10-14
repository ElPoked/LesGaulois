package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
		
	}
	
	public String prendreParole() {
		return "Le romain " + nom + ":";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois( "Astérix", 8); 
		Romain brutus= new Romain ("Brutus", 5);
		System.out.println(brutus.nom); 
		System.out.println(brutus);
		brutus.parler("Des Gau.. GauGau.. Gaulois !?");
		brutus.recevoirCoup(8);
	}
}
