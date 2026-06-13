package services.mappers;

public class ArtifactMapper {

    /**
     * Classifies an Artifact card.
     *
     * Token artifact subtypes (Food, Treasure, Clue, Blood, Map, etc.) are
     * identified via the {@code subtypes} column, which is populated reliably
     * by MTGJSON. Using {@code text.contains("sacrifice")} was far too broad —
     * Sagas, Clues, Treasures, and many non-sacrifice-themed artifacts all
     * mention the word sacrifice in their rules text.
     */
    public static String classify(String subtypes, String keywords) {

        // ── Keyword-identified artifact types ─────────────────────────────
        if (keywords.contains("Equip"))             return "equipment";
        if (keywords.contains("Fortify"))           return "fortification";
        if (keywords.contains("Crew"))              return "vehicle";

        // ── Token artifact subtypes (use DB subtype, not rules text) ──────
        if (subtypes.contains("Food"))              return "food";
        if (subtypes.contains("Treasure"))          return "treasure";
        if (subtypes.contains("Clue"))              return "clue";
        if (subtypes.contains("Blood"))             return "blood";
        if (subtypes.contains("Map"))               return "map";
        if (subtypes.contains("Powerstone"))        return "powerstone";
        if (subtypes.contains("Incubator"))         return "incubator";

        return "artifact";
    }
}