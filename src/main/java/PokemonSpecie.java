package main.java;

public class PokemonSpecie {
	
	 private String name;
	 public PokemonSpecie(String name) {
		super();
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public enum Type {AIR, EAU, INSECTE, PLANTE};
	 
	
	

}


  