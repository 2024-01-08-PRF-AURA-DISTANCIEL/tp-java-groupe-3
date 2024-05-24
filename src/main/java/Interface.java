package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import main.java.PokemonUtils.Location;
import main.java.PokemonUtils.SpecieType;

public class Interface {

    public static List<Pokemon> pokemons = new ArrayList<>();

    public static void getAllPokemons() {
        System.out.println("Liste des pokemons : ");
        pokemons.stream().forEach((pokemon) -> System.out.println(pokemon.getId() + " : " + pokemon.getName() + " - " + pokemon.getSpecie().getType()
        + " - Niv " + pokemon.getLevel() + " - Exp " + pokemon.getExperience() + " - Life " + pokemon.getCurrentLifePoints()));
        System.out.println(" ");
    }

    public static void getAllPokemonsDecroissant() {
        System.out.println("Liste des pokemons (ordre niveau décroissant) : ");
        pokemons.stream()
			.sorted((a1, a2) -> a2.getLevel() - a1.getLevel())
            .sorted((a1, a2) -> a2.getExperience() - a1.getExperience())
			.forEach((pokemon) -> System.out.println(pokemon.getId() + " : " + pokemon.getName() + " - " + pokemon.getSpecie().getType()
        + " - Niv " + pokemon.getLevel() + " - Exp " + pokemon.getExperience() + " - Life " + pokemon.getCurrentLifePoints()));
		System.out.println(" ");
    }

    public static void getDetailsPokemonById(int id) {
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

    public static Pokemon getPokemonById(int id) {
        Optional<Pokemon> pok = pokemons.stream()
        .filter(a -> a.getId() == id)
        .findFirst();
        return pok.get();
    }

    public static void walk(Pokemon pokemon, Location location) {
        System.out.println("Promenade de " + pokemon.getName() + " : ");
        boolean retourPromenade = Pokemon.promenade(pokemon, location);
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

     public static void creerPokemon(String nom, SpecieType type) {
        PokemonSpecie nouvelleEspece = new PokemonSpecie("espece" + nom, type, Double.valueOf(100), null);
        Pokemon nouveauPokemon = new Pokemon(pokemons.size() +1 , nom, nouvelleEspece);
        pokemons.add(nouveauPokemon);
        System.out.println("Pokémon créé avec succès!");
    }

     @SuppressWarnings("resource")
    public static void afficherMenu(){
        System.out.println("Menu : ");
        System.out.println("Tapez 1 : pour afficher la liste des pokemons.");
        System.out.println("Tapez 2 : pour afficher le détail d'un pokemon.");
        System.out.println("Tapez 3 : pour déclencher un combat.");
        System.out.println("Tapez 4 : pour lancer une discussion.");
        System.out.println("Tapez 5 : pour promener un pokemon.");
        System.out.println("Tapez 6 : pour soigner un pokemon.");
        System.out.println("Tapez 7 : pour afficher la liste des pokemons (ordre niveau décroissant).");
        System.out.println("Tapez 8 : pour créer un pokemon.");
        System.out.println("Tapez 9 : pour supprimer un pokemon.");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                Interface.getAllPokemons();
                Interface.afficherMenu();
                break;
            case "2":
                System.out.println("Entrez l'id du pokemon : ");
                int id = scanner.nextInt();
                Interface.getDetailsPokemonById(id);
                Interface.afficherMenu();
                break;
            case "3":
                System.out.println("Entrez l'id du pokemon 1 : ");
                int id1 = scanner.nextInt();
                System.out.println("Entrez l'id du pokemon 2 : ");
                int id2 = scanner.nextInt();
                System.out.println("Entrez le choix de l'arene (1:CHAMP, 2:VILLE, 3:VOLCAN, 4:MARAIS_TOXIQUE) : ");
                int arene = scanner.nextInt();
                Combat combat = new Combat(Interface.getPokemonById(id1), Interface.getPokemonById(id2), PokemonUtils.convertAreneByInt(arene));
                int idVainqueur = combat.fight();
                //System.out.println("Vainqueur : " + idVainqueur);
                int idPerdant = (idVainqueur == id1) ? id2 : id1;
                int exp = Interface.getPokemonById(idPerdant).getLevel() * 4;
                Interface.getPokemonById(idVainqueur).setExperience(Interface.getPokemonById(idVainqueur).getExperience() + exp);
                Interface.getAllPokemons();
                Interface.afficherMenu();
                break;
            case "4":
                Interface.discuter(pokemons);
                Interface.afficherMenu();
                break;
            case "5":
                System.out.println("Entrez l'id du pokemon à promener : ");
                int id3 = scanner.nextInt();
                System.out.println("Entrez l'endroit de la promenade (1:PLAGE, 2:JUNGLE, 3:JARDIN, 4:DESERT) : ");
                int lieu = scanner.nextInt();
                Interface.walk(Interface.getPokemonById(id3),PokemonUtils.convertLocationByInt(lieu));
                Interface.afficherMenu();
                break;
            case "6":
           
                System.out.println("Entrez l'id du pokemon à soigner : ");
                int id4  = scanner.nextInt();
                Interface.getPokemonById(id4).setCurrentLifePoints(Interface.getPokemonById(id4).getMaxLifePoints());
                System.out.println(Interface.getPokemonById(id4).getName() + " " + "is now fully healed");
                Interface.afficherMenu();
                break;
            case "7":
                Interface.getAllPokemonsDecroissant();
                Interface.afficherMenu();
                break;
            case "8":
                System.out.print("Entrez le nom du Pokémon : ");
                String nom = scanner.nextLine();
                System.out.println("Choisissez l'espèce du Pokémon : (1:AIR, 2:EAU, 3:INSECTE, 4:PLANTE)");
                int esp = scanner.nextInt();
                Interface.creerPokemon(nom, PokemonUtils.convertSpecieByInt(esp));
                Interface.afficherMenu();
                break;
            default:
                System.out.println("FIN");
                break;
        }
     }

    public static void main(String[] args) {

        Attack attackPlante = new Attack("attackPlante", PokemonUtils.SpecieType.PLANTE, Double.valueOf(30));
        Attack attackAir = new Attack("attackAir", PokemonUtils.SpecieType.AIR, Double.valueOf(60));
        Attack attackEau = new Attack("attackEau", PokemonUtils.SpecieType.EAU, Double.valueOf(45));
        Attack attackInsecte = new Attack("attackInsecte", PokemonUtils.SpecieType.INSECTE, Double.valueOf(15));
        PokemonSpecie especePlante = new PokemonSpecie("especePlante", PokemonUtils.SpecieType.PLANTE, Double.valueOf(100), attackPlante);
        PokemonSpecie especeAir = new PokemonSpecie("especeAir", PokemonUtils.SpecieType.AIR, Double.valueOf(100), attackAir);
        PokemonSpecie especeEau = new PokemonSpecie("especeEau", PokemonUtils.SpecieType.EAU, Double.valueOf(100), attackEau);
        PokemonSpecie especeInsecte = new PokemonSpecie("especeInsecte", PokemonUtils.SpecieType.INSECTE, Double.valueOf(100), attackInsecte);
        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", especePlante);
        Pokemon rondoudou = new Pokemon(2, "Rondoudou", especeAir);
        Pokemon pikachu = new Pokemon(3, "Pikachu", especeEau);
        Pokemon aspicot = new Pokemon(4, "Aspicot", especeInsecte);
        Pokemon carapuce = new Pokemon(5, "Carapuce", especeEau);
        Pokemon roucool = new Pokemon(6, "Roucool", especeAir);
        Pokemon chenipan = new Pokemon(7, "Chenipan", especeInsecte);
        pokemons.add(bulbizarre);
        pokemons.add(rondoudou);
        pokemons.add(pikachu);
        pokemons.add(aspicot);
        pokemons.add(carapuce);
        pokemons.add(roucool);
        pokemons.add(chenipan);

        Interface.afficherMenu();
    }
}