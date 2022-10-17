package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	static int nbVillageoisMaximum;

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return this.nom;
	}

	public Village(Chef chef, String nom, int nbVillageoisMaximum) {
		this.chef = chef;
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];

	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (this.nbVillageois < nbVillageoisMaximum) {
			this.villageois[this.nbVillageois] = gaulois;
			this.nbVillageois++;
		} else {
			System.out.println("Village complet");
		}
	}

	public void trouverHabitant(int number) {
		if (number < this.nbVillageois) {
			System.out.println(this.villageois[number].getNom());
		} else {
			System.out.println("Villageois non existant");
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans village du chef " + this.chef.getNom() + " vivent les l\ufffdgendaires gaulois :");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("-" + this.villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village;
		Gaulois asterix;
		Gaulois obelix;
		Chef abraracourcix;
		abraracourcix = new Chef("Abraracourcix", 5, 1);
		village = new Village(abraracourcix, "Village des Irr\ufffdductibles", 30);
		asterix = new Gaulois("Ast\ufffdrix", 8);
		obelix = new Gaulois("Ob\ufffdlix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
//        village.trouverHabitant(0);
		village.afficherVillageois();
//    System.out.println();
	}

}
