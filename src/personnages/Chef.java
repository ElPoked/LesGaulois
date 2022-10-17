package personnages;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Chef(String nom, int force, int effetPotion) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;

	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le chef" + this.nom + "du village" + this.village.getNom() + ":";
	}

	public void frapper(Romain romain) {
		System.out.println(this.nom + "envoie un grand coup dans la m�choire de" + romain.getNom());
		romain.recevoirCoup(this.force / 3);
	}
}