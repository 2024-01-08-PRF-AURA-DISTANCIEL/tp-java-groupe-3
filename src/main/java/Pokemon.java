package main.java;

import main.java.Attack;
import main.java.PokemonSpecie;
import main.java.PokemonUtils.Location;
import main.java.Combat;

public class Pokemon {
	
	private int id;
	private String name;
	private int level;
	private int experience;
	private PokemonSpecie specie;
	private int currentLifePoints;
	private int maxLifePoints;
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
	public int getCurrentLifePoints() {
		return currentLifePoints;
	}
	public void setCurrentLifePoints(int currentLifePoints) {
		this.currentLifePoints = currentLifePoints;
	}
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(int maxLifePoints) {
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
	
	public void launchAttack(Pokemon pokemon) {
		Attack attack = this.getAttack();
		int damage = attack.getDamage();
		pokemon.setCurrentLifePoints(pokemon.getCurrentLifePoints()- damage);
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
