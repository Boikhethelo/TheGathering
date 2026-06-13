package cards.generators;

import model.Mana;
import cards.lands.*;

import java.util.Collection;

public class LandGenerator {

    public static AbstractLand loadCard(String type, String name, String description, Collection<Mana> mana) {
        return switch (type.toLowerCase().trim()) {
            case "land"         -> new BasicLand(name, description, mana);
            case "creature"     -> new CreatureLand(name, description, mana); // creature-land (animates)
            case "creature_land"-> new CreatureLand(name, description, mana); // token from CardMapper multi-type check
            case "fast"         -> new FastLands(name, description, mana);
            case "fetch"        -> new FetchLands(name, description, mana);
            case "pain"         -> new PainLands(name, description, mana);
            case "shock"        -> new ShockLand(name, description, mana);
            case "slow"         -> new SlowLands(name, description, mana);
            case "tap"          -> new Taplands(name, description, mana);
            case "triomes"      -> new Triomes(name, description, mana);
            case "dual"         -> new TrueDual(name, description, mana); // was "duel" — typo fixed
            case "utility"      -> new UtilityLand(name, description, mana);
            case "surveil"      -> new SurveilLand(name, description, mana);
            case "battle"       -> new BattleLand(name, description, mana);
            case "pathway"      -> new PathwayLand(name, description, mana);
            case "filter"       -> new FilterLand(name, description, mana);
            case "horizon"      -> new HorizonLand(name, description, mana);
            case "bounce"       -> new BounceLand(name, description, mana);
            case "scry"         -> new ScryLand(name, description, mana);
            case "check"        -> new CheckLand(name, description, mana);
            default             -> throw new IllegalArgumentException("Unknown land type: " + type);
        };
    }
}