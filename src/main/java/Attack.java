package main.java;

public class Attack {
	
	private String name;
	public enum Type {AIR, EAU, INSECTE, PLANTE};
	private int damage;
	
	public Attack(final String name, final int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(final int damage) {
		this.damage = damage;
	}

}
