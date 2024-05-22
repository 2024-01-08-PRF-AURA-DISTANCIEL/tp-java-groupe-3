package main.java;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, Object> initMapAttack() {
        Map<String, Double> mapAirAttack = new HashMap<>();
        mapAirAttack.put("AIR", Double.valueOf(1));
        mapAirAttack.put("EAU", 1.3);
        mapAirAttack.put("INSECTE", Double.valueOf(1));
        mapAirAttack.put("PLANTE", 0.7);
        Map<String, Double> mapEauAttack = new HashMap<>();
        mapEauAttack.put("AIR", 0.7);
        mapEauAttack.put("EAU", Double.valueOf(1));
        mapEauAttack.put("INSECTE", 1.3);
        mapEauAttack.put("PLANTE", Double.valueOf(1));
        Map<String, Double> mapInsecteAttack = new HashMap<>();
        mapInsecteAttack.put("AIR", Double.valueOf(1));
        mapInsecteAttack.put("EAU", 0.7);
        mapInsecteAttack.put("INSECTE", Double.valueOf(1));
        mapInsecteAttack.put("PLANTE", 1.3);
        Map<String, Double> mapPlanteAttack = new HashMap<>();
        mapPlanteAttack.put("AIR", 1.3);
        mapPlanteAttack.put("EAU", Double.valueOf(1));
        mapPlanteAttack.put("INSECTE", 0.7);
        mapPlanteAttack.put("PLANTE", Double.valueOf(1));
        Map<String, Object> mapGeneralAttack = new HashMap<String, Object>();
        mapGeneralAttack.put("AIR", mapAirAttack);
        mapGeneralAttack.put("EAU", mapEauAttack);
        mapGeneralAttack.put("INSECTE", mapInsecteAttack);
        mapGeneralAttack.put("PLANTE", mapPlanteAttack);
        return mapGeneralAttack;
    }
}
