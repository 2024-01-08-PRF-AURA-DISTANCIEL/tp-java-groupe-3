package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PokemonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Init des attaques
        Attack attaqueEau = new Attack("Aqua-Jet", PokemonUtils.SpecieType.EAU, 20);
        Attack attaqueFeu = new Attack("incendiaire", PokemonUtils.SpecieType.FEU, 15);
        Attack attaqueAir = new Attack("Tornade", PokemonUtils.SpecieType.AIR, 10);
        Attack attaqueInsecte = new Attack("Piqûre", PokemonUtils.SpecieType.INSECTE, 12);

        //Init des espèces de Pokémon
        PokemonSpecie especeEau = new PokemonSpecie("Carapuce", PokemonUtils.SpecieType.EAU, 100, attaqueEau);
        PokemonSpecie especePlante = new PokemonSpecie("Bulbizarre", PokemonUtils.SpecieType.FEU, 90, attaqueFeu);
        PokemonSpecie especeAir = new PokemonSpecie("Roucool", PokemonUtils.SpecieType.AIR, 80, attaqueAir);
        PokemonSpecie especeInsecte = new PokemonSpecie("Chenipan", PokemonUtils.SpecieType.INSECTE, 70, attaqueInsecte);

        //Initdes Pokémon
        Pokemon pokemon1 = new Pokemon(1, "Carapuce1", especeEau);
        Pokemon pokemon2 = new Pokemon(2, "Bulbizarre1", especePlante);
        Pokemon pokemon3 = new Pokemon(3, "Roucool1", especeAir);
        Pokemon pokemon4 = new Pokemon(4, "Chenipan1", especeInsecte);

        // Liste des Pokémon
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        pokemons.add(pokemon4);

        // Lancement de la discussion
        discuter(pokemons);
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
