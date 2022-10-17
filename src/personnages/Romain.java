package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[][] equipement;
	private int nbEquipement = 0;

	private enum Equipement {
		CASQUE("casque"), BOUCLIER("bouclier");

		private String nom;

		private Equipement(String nom) {
			this.nom = nom;
		}

		@Override
		public String toString() {
			return this.nom;
		}
	};

	public void equipement() {
		System.out.println("Les �quipement disponibles: ");
		for (Equipement equipement : Equipement.values()) {
			System.out.println("-" + equipement);
		}
	}

	public Romain(String nom, int force) {
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
			this.parler("A�e");
			assert this.force > force2;

		} else {
			this.parler("J'abandonne...");
		}
	}

	@Override
	public String toString() {
		return "Romain [nom=" + this.nom + ", force=" + this.force + "]";
	}

	public static void main(String[] arg) {
		Romain mercurius;
		mercurius = new Romain("Mercurius", 6);
		mercurius.equipement();
		mercurius.parler("me frappe pas!");
		mercurius.recevoirCoup(3);

	}

}
