package main.java;

import java.util.ArrayList;
import java.util.List;

public class Interface {
    List<Pokemon> pokemons = new ArrayList<>();

    public static void main(String[] args) {


    PokemonSpecie especeFeu = new PokemonSpecie("especeFeu", PokemonUtils.SpecieType.FEU);
    Attack attackCoupDePoing = new Attack("coup de poing", 10);
    Pokemon pikachu = new Pokemon(1, "pikachu", 10, 50, especeFeu, 100, 50, attackCoupDePoing);

    Pokemon.promenade(pikachu, PokemonUtils.Location.Volcan);
    
    
    PokemonSpecie especeEau = new PokemonSpecie("especeEau", PokemonUtils.SpecieType.EAU);
    Attack ouragan = new Attack("ouragan", 10);
    Pokemon leviator = new Pokemon(1, "leviator", 10, 50, especeEau, 100, 50, ouragan);
    
    


    }

}
