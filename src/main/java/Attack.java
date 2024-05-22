package main.java;

import main.java.PokemonUtils.SpecieType;

public class Attack {
	
	private String name;
	public SpecieType type;
	private Double damage;
	
	public Attack(final String name, SpecieType type, final Double damage) {
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

	public Double getDamage() {
		return damage;
	}

	public void setDamage(final Double damage) {
		this.damage = damage;
	}

	public SpecieType getType() {
		return type;
	}

}
