package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 10);
		Romain brutus = new Romain("Brutus", 5);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion(panoramix);
		panoramix.booster(obelix, panoramix);
		asterix.parler("Par Bénélosn ce n'est pas juste !");
		panoramix.booster(asterix, panoramix);
		asterix.parler("Bonjour");
		brutus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(brutus);
		asterix.frapper(brutus);
		asterix.frapper(brutus);
	}

}
