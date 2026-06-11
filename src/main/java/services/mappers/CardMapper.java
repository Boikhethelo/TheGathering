package services.mappers;

import model.Mana;

import java.util.EnumSet;
import java.util.Map;

public class CardMapper {

    private static final Map<String, Mana> MANA_CODES = Map.of(
            "W", Mana.WHITE,
            "U", Mana.BLUE,
            "B", Mana.BLACK,
            "R", Mana.RED,
            "G", Mana.GREEN,
            "C", Mana.COLORLESS
    );


    public static EnumSet<Mana> mapMana(String producedManaJson) {
        // producedManaJson looks like: ["W","U"]
        // parse it and convert each code
        EnumSet<Mana> result = EnumSet.noneOf(Mana.class);
        // strip brackets and quotes, split on comma
        String stripped = producedManaJson.replaceAll("[\\[\\]\"\\s]", "");
        if (stripped.isEmpty()) return result;
        for (String code : stripped.split(",")) {
            Mana m = MANA_CODES.get(code.toUpperCase());
            if (m != null) result.add(m);
        }
        return result;
    }

    public static String safe(String value) {
        return value == null ? "" : value.trim();
    }

    public static String classifyCard(String type, String layout, String subtypes, String text, String keywords) {


        type = safe(type);
        layout = safe(layout);
        subtypes = safe(subtypes);
        text = safe(text);
        keywords = safe(keywords);

        // Multi-type check first — order matters here
        if (type.contains("Land") && type.contains("Creature")) return "creature_land";

        if (type.contains("Land")) return LandMapper.classify(type, subtypes, text, keywords, layout);
        if (type.contains("Creature")) return CreatureMapper.classify(subtypes, text, keywords);
        if (type.contains("Planeswalker")) return PlaneswalkerMapper.classify(text);
        if (type.contains("Artifact")) return ArtifactMapper.classify(subtypes, text, keywords);
        if (type.contains("Enchantment")) return EnchantmentMapper.classify(subtypes, text, keywords);
        if (type.contains("Instant")) return SpellMapper.classify("instant", text, keywords);
        if (type.contains("Sorcery")) return SpellMapper.classify("sorcery", text, keywords);

        return "unknown";


    }
}
