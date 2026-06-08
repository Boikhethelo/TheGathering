package manager.mapper;

public class LandMapper {

    public static String classify(String type, String subtypes, String text, String keywords, String layout) {
        // Pathways - modal double faced cards
        if ("modal_dfc".equals(layout))         return "pathway";

        // Basic lands - have "Basic" supertype
        if (type.contains("Basic Land"))        return "land";

        // Triomes - produce 3 colours and have Cycling
        if (keywords.contains("Cycling")
                && subtypes.split(",").length >= 3) return "triomes";

        // Guildgates / Taplands - have "Gate" subtype
        if (subtypes.contains("Gate"))          return "tap";

        // Fetch lands - sacrifice to search
        if (text.contains("Search your library")) return "fetch";

        // Shock lands - pay 2 life or enters tapped, have basic land subtypes
        if (text.contains("pay 2 life"))        return "shock";

        // Pain lands - deal 1 damage for coloured mana
        if (text.contains("deals 1 damage"))    return "pain";

        // Fast lands - two or fewer other lands
        if (text.contains("two or fewer"))      return "fast";

        // Slow lands - two or more other lands
        if (text.contains("two or more"))       return "slow";

        // Creature lands - can become a creature
        if (text.contains("becomes a")
                && text.contains("creature"))       return "creature";

        // Check lands / Scry lands / etc - catch remaining dual lands
        if (text.contains("enters tapped"))     return "tap";

        return "utility"; // fallback
    }
}
