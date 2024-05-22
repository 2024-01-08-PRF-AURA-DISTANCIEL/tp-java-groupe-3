package main.java;

import java.util.Random;

public class Combat {
	
     Pokemon combatantA;
     Pokemon combatantB;
     
     
     public Combat(Pokemon pokemon1, Pokemon pokemon2) {
 		
 	
     

    	 
    	 Random rand = new Random();
    	 
    	 int rand_int1 = rand.nextInt(10);
    	 int rand_int2 = rand.nextInt(10);
    	 
    	 if(rand_int1 > rand_int2) {
    		 
    		 this.combatantA = pokemon1;
    		 this.combatantB = pokemon2;
    	 }
    	 else {
    		 this.combatantA = pokemon2;
    		 this.combatantB = pokemon1;
    	 }}
    	 
    		 
     
    	 
    	 
    
    	 
     
	  public int fight() {
		  while(combatantA.getCurrentLifePoints()>0 && combatantB.getCurrentLifePoints()>0) {
			  combatantA.launchAttack(combatantB);
			  combatantB.launchAttack(combatantA);
			  
		  }
		  return combatantA.getCurrentLifePoints() >0? combatantA.getId() : combatantB.getId();
	  }
	  

	  

}