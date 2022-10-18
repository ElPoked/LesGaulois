package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.equipements = new Equipement[2];
		this.nom = nom;
		this.force = force;
		assert force > 0;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + this.nom + ":";
	}

	public void recevoirCoup(int forceCoup) {
		int force2;
		assert this.force > 0;
		force2 = this.force - forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
			assert this.force > force2;

		} else {
			this.parler("J'abandonne...");
		}
	}

	@Override
	public String toString() {
		return "Romain [nom=" + this.nom + ", force=" + this.force + "]";
	}

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + this.nom + " est bien équiper");
			break;
		}
		case 1: {
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement);
				break;
			}
		}
		default:
			this.equipements[this.nbEquipement] = equipement;
			this.nbEquipement += 1;
			System.out.println("Le soldat " + this.nom + " s'équipe d'un " + equipement);
			break;
		}
	}

	public static void main(String[] arg) {
		Romain brutus;
		brutus = new Romain("Brutus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		brutus.parler("me frappe pas!");
		brutus.recevoirCoup(3);
		brutus.sEquiper(Equipement.CASQUE);
		brutus.sEquiper(Equipement.CASQUE);
		brutus.sEquiper(Equipement.BOUCLIER);
		brutus.sEquiper(Equipement.CASQUE);
	}

}
