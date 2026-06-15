package cards.types;

import cards.Card;
import model.Mana;

import java.util.EnumSet;

/**
 * Represents a land card that can produce mana when tapped.
 * Implementations define which mana colours they can generate.
 */
public interface Land extends Card {

    /**
     * Taps this land and produces one mana of the specified colour.
     *
     * @param colour the colour of mana to produce
     * @return {@code Mana} the mana produced by this land
     * @throws IllegalArgumentException if this land cannot produce the specified mana colour
     * @throws IllegalStateException if the land is already tapped
     */

    Mana tap(Mana colour);

    /**
     * Untaps this land, making it available to produce mana again.
     */

    void untap();

    /**
     * Returns the set of mana colours that this land is capable of producing.
     *
     * @return an {@code EnumSet} containing all mana colours this land can generate
     */
    EnumSet<Mana> producedManaTypes();
}