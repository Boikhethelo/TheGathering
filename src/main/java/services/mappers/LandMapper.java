package services.mappers;

public class LandMapper {

    /**
     * Classifies a Land card into one of the engine's land subtypes.
     *
     * ORDERING IS CRITICAL here — more specific checks must precede
     * broader ones that share overlapping text patterns.
     *
     * Key ordering rules enforced:
     *  - "two or more basic lands" (BattleLand) BEFORE "two or more" (SlowLand)
     *  - Surveil/Scry/Check lands identified by their bonus BEFORE the
     *    generic "enters tapped" catch-all
     *  - Bounce/Horizon/Filter identified before utility fallback
     */
    public static String classify(String type, String subtypes, String text, String keywords, String layout) {

        // ── Structural / layout checks first ──────────────────────────────
        if ("modal_dfc".equals(layout))                                     return "pathway";
        if (type.contains("Basic Land"))                                    return "land";

        // ── Three-colour / cycling lands ──────────────────────────────────
        if (keywords.contains("Cycling") && subtypes.split(",").length >= 3) return "triomes";

        // ── Gate taplands (explicit subtype) ──────────────────────────────
        if (subtypes.contains("Gate"))                                      return "tap";

        // ── Fetch lands ───────────────────────────────────────────────────
        if (text.contains("Search your library"))                           return "fetch";

        // ── Shock lands ───────────────────────────────────────────────────
        if (text.contains("pay 2 life"))                                    return "shock";

        // ── Pain lands ────────────────────────────────────────────────────
        if (text.contains("deals 1 damage"))                                return "pain";

        // ── Fast lands (≤2 other lands) ───────────────────────────────────
        if (text.contains("two or fewer"))                                  return "fast";

        // ── Battle / Tango lands — MUST come before SlowLand ─────────────
        // Both contain "two or more"; "two or more basic lands" is more specific.
        if (text.contains("two or more basic lands"))                       return "battle";

        // ── Slow lands (≥2 other lands, any type) ─────────────────────────
        if (text.contains("two or more"))                                   return "slow";

        // ── Creature lands ────────────────────────────────────────────────
        if (text.contains("becomes a") && text.contains("creature"))       return "creature";

        // ── Tapped-entry lands — ordered by bonus (specific → generic) ────
        // Surveil lands: enter tapped + surveil 1
        if (text.contains("tapped") && text.contains("surveil"))           return "surveil";

        // Scry lands (Temples): enter tapped + scry 1
        if (text.contains("tapped") && text.contains("scry"))              return "scry";

        // Check lands: enter tapped UNLESS you control a basic of a specific type
        // The "unless" + basic-type subtype check distinguishes from plain taplands
        if (text.contains("unless you control") && subtypes.split(",").length >= 2) return "check";

        // Bounce / Karoo lands: return a land to your hand on entry
        if (text.contains("return") && text.contains("land") && text.contains("hand")) return "bounce";

        // Horizon lands: can sacrifice to draw a card (at the cost of 1 life)
        if (text.contains("sacrifice") && text.contains("draw a card") && text.contains("life")) return "horizon";

        // Filter lands: convert one mana into two of another colour
        if (text.contains("two mana of any combination") || text.contains("one mana of any")) return "filter";

        // Generic tapland fallback (Guildgates not already caught, etc.)
        if (text.contains("tapped"))                                        return "tap";

        // ── Utility / colourless lands ────────────────────────────────────
        return "utility";
    }
}