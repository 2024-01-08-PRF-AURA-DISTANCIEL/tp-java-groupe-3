package main.java;

import java.util.Random;

public class Combat {

	private Pokemon combatantA;
	private Pokemon combatantB;
	private PokemonUtils.Arene arene;

	public Combat(Pokemon pokemon1, Pokemon pokemon2, PokemonUtils.Arene arene) {
		this.combatantA = pokemon2;
		this.combatantB = pokemon1;
		Random rand = new Random();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		if (rand_int1 > rand_int2) {
			this.combatantA = pokemon1;
			this.combatantB = pokemon2;
		}
		this.arene = arene;
	}

	public int fight() {
		if(this.arene.equals(PokemonUtils.Arene.VOLCAN)){
			combatantA.setCurrentLifePoints(combatantA.getCurrentLifePoints() - 5);
			combatantB.setCurrentLifePoints(combatantB.getCurrentLifePoints() - 5);
		}
		while (combatantA.getCurrentLifePoints() > 0 && combatantB.getCurrentLifePoints() > 0) {
			//System.out.println(combatantA.getCurrentLifePoints() + "-" + combatantB.getCurrentLifePoints());
			if(this.arene.equals(PokemonUtils.Arene.MARAIS_TOXIQUE)){
				combatantA.setCurrentLifePoints(combatantA.getCurrentLifePoints() - 1);
				combatantB.setCurrentLifePoints(combatantB.getCurrentLifePoints() - 1);
			}
			if(combatantA.getCurrentLifePoints() > 0){
				combatantA.launchAttack(combatantB);
			}
			if(combatantB.getCurrentLifePoints() > 0){
				combatantB.launchAttack(combatantA);
			}
		}
		return combatantA.getCurrentLifePoints() > 0 ? combatantA.getId() : combatantB.getId();
	}

	public Pokemon getCombatantA() {
		return combatantA;
	}

	public Pokemon getCombatantB() {
		return combatantB;
	}

	public PokemonUtils.Arene getArene() {
		return arene;
	}

}
