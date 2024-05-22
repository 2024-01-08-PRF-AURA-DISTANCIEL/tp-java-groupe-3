package main.java;

import main.java.PokemonUtils.SpecieType;

public class Attack {
	
	private String name;
	public SpecieType  type;
	private int damage;
	
	public Attack(final String name,SpecieType  type, final int damage) {
		super();
		this.name = name;
		this.damage = damage;
		this.type = type;
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
