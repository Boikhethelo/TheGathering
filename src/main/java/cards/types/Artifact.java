package cards.types;

import cards.Card;

/**
 * Represents an artifact card.
 * permanent that represents a magical object, machine, weapon, relic, or construct.
 * Grants abilities or bonuses
 */

public interface Artifact extends Card {

    /**
     * A description of the cards ability
     * @return {@code String}
     */
    String ability();

}
