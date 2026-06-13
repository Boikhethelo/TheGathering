package services.mappers;

import model.Mana;

import java.util.EnumSet;
import java.util.Map;

/**
 * Parses MTGJSON mana strings into {@link Mana} enum values.
 *
 * Extracted from {@link CardMapper} so that CardMapper's single
 * responsibility is card classification, not string parsing.
 */
public class ManaParser {

    private static final Map<String, Mana> MANA_CODES = Map.of(
            "W", Mana.WHITE,
            "U", Mana.BLUE,
            "B", Mana.BLACK,
            "R", Mana.RED,
            "G", Mana.GREEN,
            "C", Mana.COLORLESS
    );

    private ManaParser() {} // utility class — no instances

    /**
     * Converts a MTGJSON producedMana JSON array string (e.g. {@code ["W","U"]})
     * into an {@link EnumSet} of {@link Mana} values.
     *
     * Unknown or null codes are silently skipped — MTGJSON sometimes includes
     * special codes like "S" (snow) or "X" that are not yet modelled.
     *
     * @param producedManaJson the raw JSON string from the DB column, or null
     * @return an EnumSet of matched colours; never null, may be empty
     */
    public static EnumSet<Mana> parse(String producedManaJson) {
        EnumSet<Mana> result = EnumSet.noneOf(Mana.class);
        if (producedManaJson == null || producedManaJson.isBlank()) return result;

        String stripped = producedManaJson.replaceAll("[\\[\\]\"\\s]", "");
        if (stripped.isEmpty()) return result;

        for (String code : stripped.split(",")) {
            Mana m = MANA_CODES.get(code.toUpperCase());
            if (m != null) result.add(m);
        }
        return result;
    }
}