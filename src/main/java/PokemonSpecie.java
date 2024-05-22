package main.java;

import main.java.PokemonUtils.SpecieType;

public class PokemonSpecie {

	private String  name;
	private SpecieType type;
	private int initialpv;
	private Attack initialAttack;

	public PokemonSpecie(String name, SpecieType type, int initialpv, Attack initialAttack) {
		super();
		this.setName(name);
		this.setType(type);
		this.type = type;
		this.initialpv = initialpv;
		this.initialAttack = initialAttack;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpecieType getType() {
		return type;
	}

	public void setType(SpecieType type) {
		this.type = type;
	}
	
	public int getInitialpv() {
		return this.initialpv;
	}
	public Attack getInitialAttack() {
		return this.initialAttack;
	}

}
