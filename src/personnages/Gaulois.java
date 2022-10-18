package personnages;

public class Gaulois {
	private int force;
	private String nom;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + this.nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(this.force / 3 * this.effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRecu = romain.recevoirCoup((this.force / 3) * this.effetPotion);
		for (int i = 0; this.trophees != null && i < this.trophees.length; i++, this.nbTrophees++) {
			this.trophees[this.nbTrophees] = tropheesRecu[i];
		}
	}

	public void boirePotion(int forcePotion, Gaulois gaulois) {
		this.effetPotion = forcePotion;
		gaulois.parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + this.nom + ", force=" + this.force + ", effetPotion=" + this.effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain brutus = new Romain("Brutus", 5);
		System.out.println(asterix.nom);
		System.out.println(asterix);
		asterix.parler("Obélix que fais-tu !?");
		asterix.frapper(brutus);
		asterix.boirePotion(5, asterix);
	}
}
