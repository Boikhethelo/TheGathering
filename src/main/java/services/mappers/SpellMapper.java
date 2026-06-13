package services.mappers;

public class SpellMapper {

    /**
     * Classifies an instant or sorcery.
     * {@code spellType} will be either "instant" or "sorcery" — provided
     * by CardMapper so this doesn't need to re-derive it.
     * Expand classification logic here when Adventure, Split, and other
     * spell variants are modelled.
     */
    public static String classify(String spellType, String text) {
        // Adventure spells have both a creature and a spell half
        if (text.contains("Adventure"))     return "adventure_spell";

        // Split cards have two independent halves
        if (text.contains("//"))            return "split_spell";

        return spellType; // "instant" or "sorcery"
    }
}