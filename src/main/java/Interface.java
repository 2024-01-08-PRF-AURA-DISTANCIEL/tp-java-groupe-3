package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.PokemonUtils.Location;

public class Interface {

    public static List<Pokemon> pokemons = new ArrayList<>();

    public static void getAllPokemons() {
        System.out.println("Liste des pokemons : ");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getId() + " : " + pokemon.getName() + " - " + pokemon.getSpecie().getType()
                    + " - " + pokemon.getLevel() + " - " + pokemon.getCurrentLifePoints());
        }
        System.out.println(" ");
    }

    public static void getDetailsPokemonById(int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                System.out.println("Détails du pokemon : ");
                System.out.println("Id : " + pokemon.getId());
                System.out.println("Name : " + pokemon.getName());
                System.out.println("Level : " + pokemon.getLevel());
                System.out.println("Experience : " + pokemon.getExperience());
                System.out.println("Specie : " + pokemon.getSpecie().getType());
                System.out.println("Current Life Points : " + pokemon.getCurrentLifePoints());
                System.out.println("Max Life Points : " + pokemon.getMaxLifePoints());
                System.out.println("Attack : " + pokemon.getAttack().getName());
                System.out.println(" ");
            }
        }
    }

    public static Pokemon getPokemonById(int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
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

    public static void main(String[] args) {

        Attack attackPlante = new Attack("attackPlante", 10);
        Attack attackAir = new Attack("attackAir", 10);
        Attack attackEau = new Attack("attackEau", 10);
        Attack attackInsecte = new Attack("attackInsecte", 10);
        PokemonSpecie especePlante = new PokemonSpecie("especePlante", PokemonUtils.SpecieType.PLANTE);
        PokemonSpecie especeAir = new PokemonSpecie("especeAir", PokemonUtils.SpecieType.AIR);
        PokemonSpecie especeEau = new PokemonSpecie("especeEau", PokemonUtils.SpecieType.EAU);
        PokemonSpecie especeInsecte = new PokemonSpecie("especeInsecte", PokemonUtils.SpecieType.INSECTE);
        Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", 1, 0, especePlante, 100, 100, attackPlante);
        Pokemon rondoudou = new Pokemon(2, "Rondoudou", 1, 0, especeAir, 100, 100, attackAir);
        Pokemon pikachu = new Pokemon(3, "Pikachu", 1, 0, especeEau, 100, 100, attackEau);
        Pokemon aspicot = new Pokemon(4, "Aspicot", 1, 0, especeInsecte, 100, 100, attackInsecte);
        pokemons.add(bulbizarre);
        pokemons.add(rondoudou);
        pokemons.add(pikachu);
        pokemons.add(aspicot);

        System.out.println("Menu : ");
        System.out.println("Tapez 1 : pour afficher la liste de tous les pokemons.");
        System.out.println("Tapez 2 : pour afficher le détail d'un pokemon.");
        System.out.println("Tapez 3 : pour déclencher un combat.");
        System.out.println("Tapez 4 : pour lancer une discussion.");
        System.out.println("Tapez 5 : pour promener un pokemon.");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1":
                Interface.getAllPokemons();
                break;
            case "2":
                System.out.println("Entrez l'id du pokemon : ");
                int id = scanner.nextInt();
                Interface.getDetailsPokemonById(id);
                break;
            case "3":
                Combat combat1 = new Combat(pikachu, rondoudou);
                int idVainqueur = combat1.fight();
                System.out.println("Vainqueur : " + idVainqueur);
                Interface.getAllPokemons();
                break;
            case "4":
                break;
            case "5":
                System.out.println("Entrez l'id du pokemon à promener : ");
                int id2 = scanner.nextInt();
                System.out.println("Entrez l'endroit de la promenade (1:Plage, 2:Jungle, 3:Jardin, 4:Desert) : ");
                int lieu = scanner.nextInt();
                Interface.walk(Interface.getPokemonById(id2),PokemonUtils.convertLocationByInt(lieu));
                break;
            default:
                System.out.println("ERREUR");
                break;
        }
    }
}