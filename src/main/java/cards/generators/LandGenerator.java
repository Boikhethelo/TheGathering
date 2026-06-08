package cards.generators;

import cards.Mana;
import cards.lands.*;

import java.util.ArrayList;


public class LandGenerator {


public static Basic loadCard(String type , String name , String description , ArrayList<Mana> mana){

    return switch(type.toLowerCase().trim()){

        case "land" -> new Land(name , description , mana );
        case "creature" -> new CreatureLand(name , description , mana);
        case "fast" -> new FastLands(name , description , mana);
        case "fetch" -> new FetchLands(name , description , mana);
        case "pain" -> new PainLands(name , description , mana);
        case "shock" -> new ShockLand(name , description , mana);
        case "slow" -> new SlowLands(name , description , mana);
        case "tap" -> new Taplands(name , description , mana);
        case "triomes" -> new Triomes(name , description , mana);
        case "duel" -> new TrueDual(name , description , mana);
        case "utility" -> new UtilityLand(name , description , mana);
        default ->throw new IllegalArgumentException("Cannot find land type");
    };
}
}
