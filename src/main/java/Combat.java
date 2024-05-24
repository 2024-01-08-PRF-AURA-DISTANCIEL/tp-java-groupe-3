package main.java;

import java.util.Random;

public class Combat {

	Pokemon combatantA;
	Pokemon combatantB;

	public Combat(Pokemon pokemon1, Pokemon pokemon2) 
	{
		
		if(pokemon1.getCurrentLifePoints() == 0 || pokemon2.getCurrentLifePoints() == 0) {
			System.out.println("All pokemons fighting need to have pv > 0");
			endCombat();
			
			
			
		}
		this.combatantA = pokemon2;
		this.combatantB = pokemon1;
		Random rand = new Random();
		int rand_int1 = rand.nextInt(10);
		int rand_int2 = rand.nextInt(10);
		if (rand_int1 > rand_int2) {
			this.combatantA = pokemon1;
			this.combatantB = pokemon2;
		}
	}

	public int fight() {
		while (combatantA.getCurrentLifePoints() > 0 && combatantB.getCurrentLifePoints() > 0) {
			//System.out.println(combatantA.getCurrentLifePoints() + "-" + combatantB.getCurrentLifePoints());
			if(combatantA.getCurrentLifePoints() > 0){
				combatantA.launchAttack(combatantB);
			}
			if(combatantB.getCurrentLifePoints() > 0){
				combatantB.launchAttack(combatantA);
			}
			
			
		}
		return combatantA.getCurrentLifePoints() > 0 ? combatantA.getId() : combatantB.getId();
	}
	
	public void endCombat() {
		return;
	}

}
