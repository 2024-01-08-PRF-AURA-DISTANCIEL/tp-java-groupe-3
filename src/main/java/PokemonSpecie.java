package main.java;

import main.java.PokemonUtils.SpecieType;

public class PokemonSpecie {

	private String  name;
	private SpecieType type;

	public PokemonSpecie(String name, SpecieType type) {
		super();
		this.setName(name);
		this.setType(type);
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

}
