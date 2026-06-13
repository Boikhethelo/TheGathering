package abilities.types;

import abilities.Ability;
import events.GameEvent;
import cards.Card;
import engine.GameState;

/**
 * A triggered ability watches for a specific game event and automatically
 * puts itself on the stack when that event occurs.
 *
 * Triggered abilities always start with "When", "Whenever", or "At".
 *
 * Examples:
 * <ul>
 *   <li>"When ~ enters the battlefield, draw a card."</li>
 *   <li>"Whenever a creature you control dies, gain 1 life."</li>
 *   <li>"At the beginning of your upkeep, you may pay {1}{W}."</li>
 * </ul>
 *
 * The engine's event bus calls {@link #triggers} on every registered triggered
 * ability each time an event fires. If it returns true, the ability is added
 * to the triggered-ability queue to be put on the stack.
 */
public interface TriggeredAbility extends Ability {

    /**
     * Determines whether this ability triggers on the given game event.
     *
     * @param event  the game event that just occurred
     * @param game   current game state (for condition checking)
     * @return true if this ability should be placed on the stack
     */
    boolean triggers(GameEvent event, GameState game);

    /**
     * Resolves this ability when it reaches the top of the stack.
     * The engine calls this after all players have had priority.
     *
     * @param game   current game state (mutable — this method changes it)
     * @param source the card that is the source of this ability
     */
    void resolve(GameState game, Card source);
}