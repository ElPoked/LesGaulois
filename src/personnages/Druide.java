package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin
				+ " à " + effetPotionMax);
	}

	public String getNom() {
		return this.nom;
	}

	public void parler(String texte) {
		System.out.println(this.prendreParole() + "<<" + texte + ">>");

	}

	public String prendreParole() {
		return "Le druide " + this.nom + ":";
	}

	public void preparerPotion(Druide druide) {
		Random random = new Random();
		this.forcePotion = random.nextInt(this.effetPotionMin, this.effetPotionMax);
		if (this.forcePotion >= 7) {
			druide.parler("J'ai préparé une super potion de force: " + this.forcePotion);
		} else {
			druide.parler(
					"Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force: " + this.forcePotion);
		}
	}

	public void booster(Gaulois gaulois, Druide druide) {
		if (gaulois.getNom().equals("Obélix")) {
			druide.parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(this.forcePotion, gaulois);
		}

	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion(panoramix);
	}
}
