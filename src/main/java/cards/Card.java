package cards;

import abilities.Ability;
import engine.GameState;

import java.util.Collections;
import java.util.List;

/**
 * Root interface for every card in the engine.
 *
 * The {@link #abilities()} method is a {@code default} that returns an empty
 * list, so existing abstract-class implementations compile without changes.
 * Each abstract class can override it to expose the card's populated ability list.
 */
public interface Card {

    String name();

    String description();

    Status status();

    void placeCard(GameState game);

    /**
     * The abilities this card currently has.
     *
     * For a basic land this will include its mana ability (a {@link abilities.types.ManaAbility}).
     * For a creature it will include its keyword abilities (e.g. {@link abilities.keyword.Keyword#FLYING}).
     * For a complex permanent it may include triggered and static abilities too.
     *
     * The list is ordered: keyword abilities first, then static, triggered, activated.
     *
     * @return an unmodifiable view of this card's abilities; never null
     */
    default List<Ability> abilities() {
        return Collections.emptyList();
    }
}