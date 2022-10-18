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

////	public void recevoirCoup(int forceCoup) {
////		int force2;
////		assert this.force > 0;
////		force2 = this.force - forceCoup;
////		if (this.force > 0) {
////			this.parler("Aïe");
////			assert this.force > force2;
////
////		} else {
////			this.parler("J'abandonne...");
////		}
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert this.force > 0;
		int oldForce = this.force;
		forceCoup = this.CalculResistanceEquipement(forceCoup);
		this.force -= forceCoup;
		if (this.force > 0) {
			this.parler("Aïe");
		} else {
			equipementEjecte = this.ejecterEquipement();
			this.parler("J'abandonne...");
		}
		if (this.force == 0) {
			this.parler("Aïe");
		} else {
			equipementEjecte = this.ejecterEquipement();
			this.parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert this.force < oldForce;
		return equipementEjecte;
	}

	private int CalculResistanceEquipement(int forceCoup) {
		this.texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(this.nbEquipement == 0)) {
			this.texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < this.nbEquipement;) {
				if ((this.equipements[i] != null && this.equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			this.texte = +resistanceEquipement + "!";
		}
		this.parler(this.texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[this.nbEquipement];
		System.out.println("L'équipement de " + this.nom.toString() + "s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < this.nbEquipement; i++) {
			if (this.equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = this.equipements[i];
				nbEquipementEjecte++;
				this.equipements[i] = null;
			}
			return equipementEjecte;
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
