package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.java.PokemonUtils.SpecieType;

public class Interface {

    public static List<Pokemon> pokemons = new ArrayList<>();
    public static Attack attackPlante = new Attack("attackPlante", PokemonUtils.SpecieType.PLANTE, Double.valueOf(30));
    public static Attack attackAir = new Attack("attackAir", PokemonUtils.SpecieType.AIR, Double.valueOf(60));
    public static Attack attackEau = new Attack("attackEau", PokemonUtils.SpecieType.EAU, Double.valueOf(45));
    public static Attack attackInsecte = new Attack("attackInsecte", PokemonUtils.SpecieType.INSECTE, Double.valueOf(15));
    public static PokemonSpecie especePlante = new PokemonSpecie("especePlante", PokemonUtils.SpecieType.PLANTE, Double.valueOf(100), attackPlante);
    public static PokemonSpecie especeAir = new PokemonSpecie("especeAir", PokemonUtils.SpecieType.AIR, Double.valueOf(100), attackAir);
    public static PokemonSpecie especeEau = new PokemonSpecie("especeEau", PokemonUtils.SpecieType.EAU, Double.valueOf(100), attackEau);
    public static PokemonSpecie especeInsecte = new PokemonSpecie("especeInsecte", PokemonUtils.SpecieType.INSECTE, Double.valueOf(100), attackInsecte);

    public static void creerPokemon(String nom, SpecieType type) {
        PokemonSpecie espece = null;
        switch (type) {
            case PokemonUtils.SpecieType.AIR:
                espece = especeAir;
                break;
            case PokemonUtils.SpecieType.EAU:
                espece = especeEau;
                break;
            case PokemonUtils.SpecieType.PLANTE:
                espece = especePlante;
                break;
            case PokemonUtils.SpecieType.INSECTE:
                espece = especeInsecte;
                break;
            default:
                break;
        }
        Pokemon nouveauPokemon = new Pokemon(pokemons.size() +1 , nom, espece);
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
                Pokemon.getAllPokemons(pokemons);
                Interface.afficherMenu();
                break;
            case "2":
                System.out.println("Entrez l'id du pokemon : ");
                int id = scanner.nextInt();
                Pokemon.getDetailsPokemonById(pokemons, id);
                Interface.afficherMenu();
                break;
            case "3":
                System.out.println("Entrez l'id du pokemon 1 : ");
                int id1 = scanner.nextInt();
                System.out.println("Entrez l'id du pokemon 2 : ");
                int id2 = scanner.nextInt();
                System.out.println("Entrez le choix de l'arene (1:CHAMP, 2:VILLE, 3:VOLCAN, 4:MARAIS_TOXIQUE) : ");
                int arene = scanner.nextInt();
                Combat combat = new Combat(Pokemon.getPokemonById(pokemons, id1), Pokemon.getPokemonById(pokemons, id2), PokemonUtils.convertAreneByInt(arene));
                int idVainqueur = combat.fight();
                int idPerdant = (idVainqueur == id1) ? id2 : id1;
                int exp = Pokemon.getPokemonById(pokemons, idPerdant).getLevel() * 4;
                Pokemon pokemonWinner =  Pokemon.getPokemonById(pokemons, idVainqueur);
                Pokemon.getPokemonById(pokemons, idVainqueur).setExperience(Pokemon.getPokemonById(pokemons, idVainqueur).getExperience() + exp);
                Combat.announcement(pokemonWinner);
                Interface.afficherMenu();
                break;
            case "4":
                Pokemon.discuter(pokemons);
                Interface.afficherMenu();
                break;
            case "5":
                System.out.println("Entrez l'id du pokemon à promener : ");
                int id3 = scanner.nextInt();
                System.out.println("Entrez l'endroit de la promenade (1:PLAGE, 2:JUNGLE, 3:JARDIN, 4:DESERT) : ");
                int lieu = scanner.nextInt();
                Pokemon.walk(Pokemon.getPokemonById(pokemons, id3),PokemonUtils.convertLocationByInt(lieu));
                Interface.afficherMenu();
                break;
            case "6":
                System.out.println("Entrez l'id du pokemon à soigner : ");
                int id4  = scanner.nextInt();
                Pokemon.getPokemonById(pokemons, id4).setCurrentLifePoints(Pokemon.getPokemonById(pokemons, id4).getMaxLifePoints());
                System.out.println(Pokemon.getPokemonById(pokemons, id4).getName() + " " + "est complétement guéri");
                System.out.println(" ");
                Interface.afficherMenu();
                break;
            case "7":
                Pokemon.getAllPokemonsDecroissant(pokemons);
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