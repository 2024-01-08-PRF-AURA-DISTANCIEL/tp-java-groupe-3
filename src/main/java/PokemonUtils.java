package main.java;

public class PokemonUtils {

    public static enum SpecieType {
        AIR, EAU, INSECTE, PLANTE
    };

    public static enum Location {
        Plage, Jungle, Jardin, Desert
    };

    public static PokemonUtils.Location convertLocationByInt(int location) {
        switch (location) {
            case 1:
                return PokemonUtils.Location.Plage;
            case 2:
                return PokemonUtils.Location.Jungle;
            case 3:
                return PokemonUtils.Location.Jardin;
            case 4:
                return PokemonUtils.Location.Desert;
            default:
                return null;
        }
    }

}
