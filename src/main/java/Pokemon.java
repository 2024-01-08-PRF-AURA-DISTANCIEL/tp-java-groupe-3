package main.java;

import java.util.Map;
import main.java.PokemonUtils.Location;

public class Pokemon {
	
	private int id;
	private String name;
	private int level;
	private int experience;
	private PokemonSpecie specie;
	private Double currentLifePoints;
	private Double maxLifePoints;
	private Attack attack;

	public Pokemon(int id, String name, PokemonSpecie specie) {
		this.id = id;
		this.name = name;
		this.level = 1;
		this.experience = 0;
		this.specie = specie;
		this.currentLifePoints = specie.getInitialpv();
		this.maxLifePoints = specie.getInitialpv();
		this.attack = specie.getInitialAttack();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public PokemonSpecie getSpecie() {
		return specie;
	}
	public void setSpecie(PokemonSpecie specie) {
		this.specie = specie;
	}
	public Double getCurrentLifePoints() {
		return currentLifePoints;
	}
	public void setCurrentLifePoints(Double currentLifePoints) {
		this.currentLifePoints = currentLifePoints;
	}
	public Double getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(Double maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	public Attack getAttack() {
		return attack;
	}
	
	public PokemonSpecie getspecie() {
		return specie;
	}
	
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	
	@SuppressWarnings("unchecked")
	public void launchAttack(Pokemon pokemon) {
		Map<String, Object> mapAttack = PokemonUtils.initMapAttack();
		Attack attack = this.getAttack();
		Map<String,Double> map = (Map<String,Double>) mapAttack.get(attack.getType().toString());
		Double attackModifier = Double.valueOf(map.get(pokemon.getSpecie().getType().toString()));
		Double damage = Double.valueOf(pokemon.getLevel()) / Double.valueOf(10) * Double.valueOf(attack.getDamage()) * attackModifier;
		//System.out.println("damage = " + damage);
		pokemon.setCurrentLifePoints(pokemon.getCurrentLifePoints() - damage);
		if(pokemon.getCurrentLifePoints() < 0){
			pokemon.setCurrentLifePoints(Double.valueOf("0"));
		}
		if(attackModifier >1) {System.out.println("Attaque super efficace");}
		else if(attackModifier <1) {System.out.println("Ce n'est pas très efficace");}
		System.out.println("Attaque : " + this.getCurrentLifePoints() + "-" + pokemon.getCurrentLifePoints());
	}

	public static boolean promenade(Pokemon pokemon, Location endroit){
		if((pokemon.getSpecie().getType() == PokemonUtils.SpecieType.EAU && endroit == PokemonUtils.Location.Plage)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.INSECTE && endroit == PokemonUtils.Location.Jungle)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.PLANTE && endroit == PokemonUtils.Location.Jardin)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.AIR && endroit == PokemonUtils.Location.Desert)){
			pokemon.setExperience(pokemon.getExperience()+2);
			return true;
		}
		return false;
	}

}
