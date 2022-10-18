package personnages;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");

	private String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	public void equipement() {
		System.out.println("Les équipement disponibles: ");
		for (Equipement equipement : Equipement.values()) {
			System.out.println("-" + equipement);
		}
	}
}
