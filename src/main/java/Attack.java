package main.java;

public class Attack {
	
	private String name;
	public static   enum Type {AIR, EAU, INSECTE, PLANTE};
	private int damage;
	
	public Attack(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
