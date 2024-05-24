package main.java;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
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
		int expTemp = experience - ((this.getLevel() * 5) - 5);
		while(expTemp >= 5){
			System.out.println("dans le while");
			this.setLevel(this.getLevel() + 1);
			expTemp = expTemp - 5;
		}
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
	
	public static void getAllPokemons(List<Pokemon> pokemons) {
        System.out.println("Liste des pokemons : ");
        pokemons.stream().forEach((pokemon) -> System.out.println(pokemon.getId() + " : " + pokemon.getName() + " - " + pokemon.getSpecie().getType()
        + " - Niv " + pokemon.getLevel() + " - Exp " + pokemon.getExperience() + " - Life " + pokemon.getCurrentLifePoints()));
        System.out.println(" ");
    }

	public static void getAllPokemonsDecroissant(List<Pokemon> pokemons) {
        System.out.println("Liste des pokemons (ordre niveau décroissant) : ");
        pokemons.stream()
			.sorted((a1, a2) -> a2.getLevel() - a1.getLevel())
            .sorted((a1, a2) -> a2.getExperience() - a1.getExperience())
			.forEach((pokemon) -> System.out.println(pokemon.getId() + " : " + pokemon.getName() + " - " + pokemon.getSpecie().getType()
        + " - Niv " + pokemon.getLevel() + " - Exp " + pokemon.getExperience() + " - Life " + pokemon.getCurrentLifePoints()));
		System.out.println(" ");
    }

	public static void getDetailsPokemonById(List<Pokemon> pokemons, int id) {
        pokemons.stream()
        .filter(a -> a.getId() == id)
        .forEach((pokemon) -> {System.out.println("Détails du pokemon : ");
        System.out.println("Id : " + pokemon.getId());
        System.out.println("Name : " + pokemon.getName());
        System.out.println("Level : " + pokemon.getLevel());
        System.out.println("Experience : " + pokemon.getExperience());
        System.out.println("Specie : " + pokemon.getSpecie().getType());
        System.out.println("Current Life Points : " + pokemon.getCurrentLifePoints());
        System.out.println("Max Life Points : " + pokemon.getMaxLifePoints());
        System.out.println("Attack : " + pokemon.getAttack().getName());
        System.out.println(" ");});
    }

    public static Pokemon getPokemonById(List<Pokemon> pokemons, int id) {
        Optional<Pokemon> pok = pokemons.stream()
        .filter(a -> a.getId() == id)
        .findFirst();
        return pok.get();
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
		String messageAttack = (attackModifier >1) ? "Attaque super efficace" : "Ce n'est pas trés efficace";
		System.out.println("Attaque : " + this.getCurrentLifePoints() + " - " + pokemon.getCurrentLifePoints() + " : " + messageAttack);
	}

	public static void walk(Pokemon pokemon, Location location) {
        System.out.println("Promenade de " + pokemon.getName() + " : ");
		boolean retourPromenade = false;
		if((pokemon.getSpecie().getType() == PokemonUtils.SpecieType.EAU && location == PokemonUtils.Location.PLAGE)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.INSECTE && location == PokemonUtils.Location.JUNGLE)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.PLANTE && location == PokemonUtils.Location.JARDIN)
		|| (pokemon.getSpecie().getType() == PokemonUtils.SpecieType.AIR && location == PokemonUtils.Location.DESERT)){
			pokemon.setExperience(pokemon.getExperience()+2);
			retourPromenade = true;
		}
        if (retourPromenade) {
            System.out.println(pokemon.getName() + " a apprécié la promenade : " + location.toString());
            System.out.println("Expérience de " + pokemon.getName() + " : " + pokemon.getExperience());
        } else {
            System.out.println(pokemon.getName() + " n'a pas apprécié la promenade : " + location.toString());
        }
        System.out.println(" ");
    }

	public static void discuter(List<Pokemon> pokemons) {
	        Collections.shuffle(pokemons);
	        Random random = new Random();
	        int count = 0;
	        while (count < 5 && count < pokemons.size()) {
	            Pokemon pokemon = pokemons.get(count);
	            String phrase = genererPhrase(pokemon.getspecie().getName(), random);
	            System.out.println(pokemon.getName() + " dit : " + phrase);
	            count++;
	        }
			System.out.println(" ");
	 }
	 
	 public static String genererPhrase(String especeNom, Random random) {
	        int repetitions = random.nextInt(3) + 1; 
	        StringBuilder phrase = new StringBuilder();
	        for (int i = 0; i < repetitions; i++) {
	            if (i > 0) {
	                phrase.append(" ");
	            }
	            phrase.append(especeNom);
	        }
	        char ponctuation = genererPonctuation(random);
	        phrase.append(ponctuation);
	        return phrase.toString();
	 }

	 public static char genererPonctuation(Random random) {
	        char[] ponctuations = {'.', '!', '?'};
	        return ponctuations[random.nextInt(ponctuations.length)];
	 }

     

}
